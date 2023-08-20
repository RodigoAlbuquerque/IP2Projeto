package GUI;

import java.util.List;

import controle.ControladorProdutos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Produto;


public class TelaEstoqueController {

    @FXML
    private TableView<Produto> tableView;
    @FXML
    private TableColumn<Produto, String> colNome;
    @FXML
    private TableColumn<Produto, Double> colPreco;
    @FXML
    private TableColumn<Produto, Integer> colQuantidade;
     @FXML
    private TableColumn<Produto, Boolean> colTarja;

    private ObservableList<Produto> produtoList = FXCollections.observableArrayList();

    public void atualizarProdutosList(ObservableList<Produto> novaLista) {
        produtoList.setAll(novaLista);
    }

    public void initialize() {
        // Configurar as células das colunas
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colTarja.setCellValueFactory(new PropertyValueFactory<>("tarja"));
         // Configurar a TableView para usar a lista de clientes
         tableView.setItems(produtoList);
         
    }

    @FXML
    public void voltar(){
        ScreenManager.getInstance().changeScreen(0);
    }

    @FXML
    public void listarProdutos(){
        ObservableList<Produto> listaDeProdutos = FXCollections.observableArrayList();
        List<Produto> listaDeProd = ControladorProdutos.getInstanceControladorProdutos().listarProdutos();
        for (Produto produto : listaDeProd) {
                listaDeProdutos.add(produto);
            }
        atualizarProdutosList(listaDeProdutos);
    }
       
    }

