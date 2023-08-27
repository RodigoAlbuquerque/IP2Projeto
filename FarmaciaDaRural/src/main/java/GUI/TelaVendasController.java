package GUI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controle.ControladorPessoas;
import controle.ControladorProdutos;
import controle.ControladorVendas;
import exceptions.CamposInvalidosException;
import exceptions.ProdutoInexistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.CarrinhoDTO;
import models.Cliente;
import models.Funcionario;
import models.ItemVenda;
import models.Produto;

public class TelaVendasController {

  @FXML private TextField txtIdAcesso;
  @FXML private TextField txtCpf;
  @FXML private TextField txtQnt;
  @FXML private TextField txtNomeProd;
  @FXML private TableView<CarrinhoDTO> table;
  @FXML private TableColumn<CarrinhoDTO, String> colNome;
  @FXML private TableColumn<CarrinhoDTO, Integer> colQnt;
  @FXML private TableColumn<CarrinhoDTO, Double> colPreco;
  @FXML private ImageView imageView;
  @FXML private Label valorTotal;

  private List<ItemVenda> carrinho = new ArrayList<>();
  private String imageURL;
  private ObservableList<CarrinhoDTO> carrinhoList = FXCollections.observableArrayList();

  private void limparListaCarrinho(){
    carrinhoList = FXCollections.observableArrayList();
  }

  public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQnt.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        table.setItems(carrinhoList);         
    }

  private void adicionarProdutoALista(){
    Produto produto = ControladorProdutos.getInstanceControladorProdutos().buscarProduto(txtNomeProd.getText());
    Double precoProduto = produto.getPreco();
    carrinhoList.add(new CarrinhoDTO(txtNomeProd.getText(), Integer.parseInt(txtQnt.getText()), precoProduto));
  }

  @FXML
  private void adicionarProdutoAoCart() throws CamposInvalidosException,ProdutoInexistenteException{
    try{
      if(txtNomeProd.getText() != null && txtQnt.getText() != null){
        if(ControladorProdutos.getInstanceControladorProdutos().verificarProdutoExistente(txtNomeProd.getText())){
          ItemVenda compra = new ItemVenda(Integer.parseInt(txtQnt.getText()), ControladorProdutos.getInstanceControladorProdutos().buscarProduto(txtNomeProd.getText()));
          carrinho.add(compra);
          valorTotal.setText(String.valueOf(calcularValorTotalCompra()));
          adicionarProdutoALista();
          limparCampos();
          showMessage("Produto adicionado com sucesso!", "Tudo certo!");
        }else{
          throw new ProdutoInexistenteException(txtNomeProd.getText());
        }
      }else{
        throw new CamposInvalidosException("Campos Não preenchidos");
      }
    }
    catch(ProdutoInexistenteException e){
        showError(e);
    }
    catch(CamposInvalidosException e){
      showError(e);
    }
  }

  @FXML
  private void realizarVendaComum(){
      if(validarCampos()){
          try{
            Funcionario funcionario = ControladorPessoas.getInstanceControladorCadastro().buscarFuncPorId(Double.parseDouble(txtIdAcesso.getText()));
            Cliente cliente = ControladorPessoas.getInstanceControladorCadastro().buscarPessoaPorCpf(txtCpf.getText()); 
            ControladorVendas.getInstanceControladorVendas().realizarVendaComun(carrinho,funcionario,cliente);
            limparCampos();
            esvaziarCarrinho();
            limparListaCarrinho();
            showMessage("Produto Comprado com sucesso", "Tudo certo");
          }
          catch(CamposInvalidosException e){
            showError(e);
          }
      }else{
        showMessage("Campos invalidos tente novaemente", "ALGO ESTÁ ERRADO");
      }
     
  }

  @FXML
  private void realizarVendaControlada() {
    if(validarCampos() && imageURL != null){
        try{
            Funcionario funcionario = ControladorPessoas.getInstanceControladorCadastro().buscarFuncPorId(Double.parseDouble(txtIdAcesso.getText()));
            Cliente cliente = ControladorPessoas.getInstanceControladorCadastro().buscarPessoaPorCpf(txtCpf.getText()); 
            ControladorVendas.getInstanceControladorVendas().realizarVendaControlada(carrinho,funcionario,cliente,imageURL);
            esvaziarCarrinho();
            limparListaCarrinho();
            showMessage("Produto Comprado com sucesso", "Tudo certo");
            imageView.setImage(null);
          }
          catch(CamposInvalidosException e){
            showError(e);
          }
      }else{
        showMessage("Campos invalidos tente novaemente", "ALGO ESTÁ ERRADO");
      }
    }
  @FXML
  public void voltar(){
    ScreenManager.getInstance().changeScreen(0);
  }

  private void limparCampos(){
    txtCpf.setText("");
    txtNomeProd.setText("");
    txtIdAcesso.setText("");
    txtQnt.setText("");
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

  private boolean validarCampos(){
    if(txtIdAcesso.getText() != null && txtCpf.getText() != null &&
      carrinho != null)
    {
      return true;
    }
    else{
      return false;
    }
    
  }
  private void esvaziarCarrinho(){
    carrinho = new ArrayList<>();
  }

  @FXML
  private void selecionarImagem() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Selecionar Imagem");
    File file = fileChooser.showOpenDialog(new Stage());

    if (file != null) {  
       imageURL = file.toURI().toString();
       imageView.setImage(new Image(imageURL));
    }
  }
  
  private Double calcularValorTotalCompra(){
    Double valorTotal = 0.0;
    for(ItemVenda itens: carrinho){
      valorTotal += itens.getQuantidade() * itens.getProduto().getPreco();
    }
    return valorTotal;
  }
}
