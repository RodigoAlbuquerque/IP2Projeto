package GUI;
import java.util.List;
import java.util.stream.Collectors;

import controle.ControladorPessoas;
import controle.ControladorVendas;
import exceptions.PessoaInexistenteException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Funcionario;
import models.Pessoa;
import java.util.Map; 
import java.util.HashMap;


public class TelaRelatorioFuncionariosController {

    @FXML
    private TableView<Funcionario> tableView;
    @FXML
    private TableColumn<Funcionario, String> colNome;
    @FXML
    private TableColumn<Funcionario, String> colCpf;
    @FXML
    private TableColumn<Funcionario, Double> colIdAcesso;
    @FXML
    private TableColumn<Funcionario, Integer> colNumVendas;
    @FXML
    private TextField txtCpfFuncionario;


    private ObservableList<Funcionario> funcionarioList = FXCollections.observableArrayList();

    public void atualizarFuncionarioList(ObservableList<Funcionario> novaLista) {
        funcionarioList.setAll(novaLista);
    }

    public void initialize() {
        // Configurar as células das colunas
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colIdAcesso.setCellValueFactory(new PropertyValueFactory<>("idAcessoSistema"));
        colNumVendas.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Integer>(ControladorVendas.getInstanceControladorVendas().getNumeroVendas(cellData.getValue())));
        // Configurar a TableView para usar a lista de clientes
        tableView.setItems(funcionarioList);         
    }

    @FXML
    public void voltar(){
        ScreenManager.getInstance().changeScreen(6);
    }

    @FXML
    public void listarFuncionarios(){
        ObservableList<Funcionario> listaDeClientes = FXCollections.observableArrayList();
        List<Pessoa> listaDePessoas = ControladorPessoas.getInstanceControladorCadastro().listarPessoasPorTipo(Funcionario.class);
        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa instanceof Funcionario) {
                listaDeClientes.add((Funcionario) pessoa);
            }
        }
       atualizarFuncionarioList(listaDeClientes);
    }
    @FXML
    public void listarFuncionariosQueMaisVendem() {
        ObservableList<Funcionario> listaDeFuncionarios = FXCollections.observableArrayList();
        List<Pessoa> listaDePessoas = ControladorPessoas.getInstanceControladorCadastro().listarPessoasPorTipo(Funcionario.class);
        
        Map<Funcionario, Integer> vendasPorFuncionario = new HashMap<>();
        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                int numeroDeVendas = ControladorPessoas.getInstanceControladorCadastro().calcularVendas(funcionario, ControladorVendas.getInstanceControladorVendas().listarVendas());
                vendasPorFuncionario.put(funcionario, numeroDeVendas);
            }
        }
        List<Funcionario> funcionariosOrdenados = vendasPorFuncionario.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        listaDeFuncionarios.addAll(funcionariosOrdenados);
        atualizarFuncionarioList(listaDeFuncionarios);
    }
    @FXML
    public void descadastrar(){
        if(validarCampos()){
            try{
                ControladorPessoas.getInstanceControladorCadastro().removerPessoa(txtCpfFuncionario.getText());
                limparCampos();
                showMessage("FUNCIONÁRIO REMOVIDO COM SUCESSO", "Tudo Okay");
            }
            catch(PessoaInexistenteException e){
                limparCampos();
                showError(e);
            }
        }else{
            showMessage("PREENCHA OS CAMPOS CORRETAMENTE", "Campos Invalidos");
        }
    }

    private void showError(Exception exception){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Algo de errado");
        alert.setHeaderText(exception.getMessage());
        alert.show();
    }

    private void showMessage(String text,String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.show();
    }

    private Boolean validarCampos(){
        if(txtCpfFuncionario.getText().equals(null) || txtCpfFuncionario.getText().equals("")){
            return false;
        }  
        else{
            return true;
        }
    }

    private void limparCampos(){
        txtCpfFuncionario.setText("");
    }

}


