package GUI;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import controle.ControladorPessoas;
import controle.ControladorVendas;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Cliente;
import models.Funcionario;
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
    private TableColumn<Cliente, Integer> colNumCompras;

    private ObservableList<Cliente> clientesList = FXCollections.observableArrayList();

    public void atualizarClientesList(ObservableList<Cliente> novaLista) {
        clientesList.setAll(novaLista);
    }

    public void initialize() {
        // Configurar as células das colunas
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colPremium.setCellValueFactory(new PropertyValueFactory<>("premium"));
        colNumCompras.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getNumeroCompras()));

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

}
