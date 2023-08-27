package GUI;

import java.util.List;

import controle.ControladorProdutos;
import exceptions.ProdutoEmEstoqueException;
import exceptions.ProdutoInexistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtIncrementar;

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

    @FXML
    public void descadastrarProduto() throws ProdutoEmEstoqueException{
        try{
            if(ControladorProdutos.getInstanceControladorProdutos().buscarProduto(txtNome.getText()).getQuantidade() == 0){
                ControladorProdutos.getInstanceControladorProdutos().descadastrarProduto(txtNome.getText());
                limparCampos();
                showMessage("PRODUTO REMOVIDO COM SUCESSO", "Tudo Okay");
            }else{
                throw new ProdutoEmEstoqueException("Ainda existem unidades deste produto em estoque");
            }
        }
        catch(ProdutoInexistenteException e){
            limparCampos();
            showError(e);
        }
        catch(ProdutoEmEstoqueException e){
            limparCampos();
            showError(e);
        }
    }

    @FXML 
    public void incrementar(){
        if(ControladorProdutos.getInstanceControladorProdutos().verificarProdutoExistente(txtIncrementar.getText())){
            Produto produto = ControladorProdutos.getInstanceControladorProdutos().buscarProduto(txtIncrementar.getText());
            produto.setQuantidade(produto.getQuantidade()+1);
        }else{
            showMessage("PRODUTO INEXISTENTE","ERRO PRODUTO NÃO ENCONTRADO");
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

    private void limparCampos(){
        txtNome.setText("");
    }

}

