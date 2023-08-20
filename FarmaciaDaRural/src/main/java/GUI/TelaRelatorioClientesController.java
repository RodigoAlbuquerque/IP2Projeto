package GUI;

import java.util.List;

import controle.ControladorPessoas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Cliente;
import models.Pessoa;

public class TelaRelatorioClientesController {
  
    @FXML private TableView<Pessoa> table;

  
/* 
    public void configurarListaClientes(List<Pessoa> clientes) {
        ObservableList<Pessoa> result = FXCollections.observableArrayList();
        result.addAll(clientes);
        table.setItems(result);
    }

    public void listarClientes(){
        List<Pessoa> clientes = ControladorPessoas.getInstanceControladorCadastro().listarPessoasPorTipo(Cliente.class);
        configurarListaClientes(clientes);
    }
    */
}
