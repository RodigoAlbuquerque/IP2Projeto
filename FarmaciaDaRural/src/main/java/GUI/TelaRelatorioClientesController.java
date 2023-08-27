package GUI;

import java.util.List;
import controle.ControladorPessoas;
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
import models.Cliente;
import models.Pessoa;


public class TelaRelatorioClientesController {
    @FXML
    private TableView<Cliente> tableView;
    @FXML
    private TableColumn<Cliente, String> colNome;
    @FXML
    private TableColumn<Cliente, String> colCpf;
    @FXML
    private TableColumn<Cliente, Boolean> colPremium;
    @FXML
    private TextField txtCpfCliente;

    private ObservableList<Cliente> clientesList = FXCollections.observableArrayList();

    public void atualizarClientesList(ObservableList<Cliente> novaLista) {
        clientesList.setAll(novaLista);
    }

    public void initialize() {
        // Configurar as células das colunas
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colPremium.setCellValueFactory(new PropertyValueFactory<>("premium"));


         // Configurar a TableView para usar a lista de clientes
         tableView.setItems(clientesList);
         
    }

    @FXML
    public void voltar(){
        ScreenManager.getInstance().changeScreen(6);
    }

    @FXML
    public void listarClientesPremiuns(){
        atualizarClientesList((ObservableList<Cliente>) ControladorPessoas.getInstanceControladorCadastro().listarClientesQueMaisCompram());
    }

    @FXML
    public void listarClientes(){
        ObservableList<Cliente> listaDeClientes = FXCollections.observableArrayList();
        List<Pessoa> listaDePessoas = ControladorPessoas.getInstanceControladorCadastro().listarPessoasPorTipo(Cliente.class);
        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa instanceof Cliente) {
                listaDeClientes.add((Cliente) pessoa);
            }
        }
       atualizarClientesList(listaDeClientes);
    }

    @FXML
    public void listarClientesQueMaisCompram(){
        ObservableList<Cliente> listaDeClientes = FXCollections.observableArrayList();
        List<Cliente> listaDePessoas = ControladorPessoas.getInstanceControladorCadastro().listarClientesQueMaisCompram();
        for(Cliente clie: listaDePessoas){
            listaDeClientes.add(clie);
        }
        atualizarClientesList(listaDeClientes);
    }

    @FXML
    public void descadastrar(){
        if(validarCampos()){
            try{
                ControladorPessoas.getInstanceControladorCadastro().removerPessoa(txtCpfCliente.getText());
                limparCampos();
                showMessage("CLIENTE REMOVIDO COM SUCESSO", "Tudo Okay");
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
        if(txtCpfCliente.getText().equals(null) || txtCpfCliente.getText().equals("")){
            return false;
        }else{
            return true;
        }
    }

    private void limparCampos(){
        txtCpfCliente.setText("");
    }
}
