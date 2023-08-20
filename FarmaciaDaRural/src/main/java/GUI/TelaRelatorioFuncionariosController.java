package GUI;
import java.util.List;

import controle.ControladorPessoas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Funcionario;
import models.Pessoa;

public class TelaRelatorioFuncionariosController {

    @FXML
    private TableView<Funcionario> tableView;
    @FXML
    private TableColumn<Funcionario, String> colNome;
    @FXML
    private TableColumn<Funcionario, String> colCpf;
    @FXML
    private TableColumn<Funcionario, Double> colIdAcesso;

    private ObservableList<Funcionario> funcionarioList = FXCollections.observableArrayList();

    public void atualizarFuncionarioList(ObservableList<Funcionario> novaLista) {
        funcionarioList.setAll(novaLista);
    }

    public void initialize() {
        // Configurar as células das colunas
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colIdAcesso.setCellValueFactory(new PropertyValueFactory<>("idAcessoSistema"));
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

}


