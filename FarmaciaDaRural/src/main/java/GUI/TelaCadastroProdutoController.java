package GUI;

import controle.ControladorProdutos;
import javafx.scene.control.Alert;
import models.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import exceptions.ProdutoJaExisteException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastroProdutoController {
    
    @FXML private TextArea txtNome;
    @FXML private TextArea txtPreco;
    @FXML private CheckBox cbControlado;

    private void showError2(Exception exception){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Algo de errado");
        alert.setHeaderText(exception.getMessage());
        alert.show();
    }

    private void showMessage2(String text,String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.show();
    }

    @FXML public void botaoCadastrar()
    {
        if(validarCampos2()) {
            Produto produto1 = new Produto(txtNome.getText(),Double.parseDouble(txtPreco.getText()),0,cbControlado.isSelected());
            try {
                ControladorProdutos.getInstanceControladorProdutos().cadastrarProduto(produto1); //passar o produto criado como parametro
                showMessage2("Produto cadastrado com sucesso", "Tudo certo");
                limparCampos();
            } catch (ProdutoJaExisteException pr) {
                showError2(pr);
            }
        } else{
                showMessage2("Valores passados nos campos estão invalidos!\n Verifique se todos os campos estão preenchidos e se sim se foram preenchidos de maneira correta", "Campos inválidos");
            }
        }


    public void cancelar(){
        limparCampos();
        ScreenManager.getInstance().changeScreen(1);
    }


    public static boolean ValidarNome(String nome){
    nome = nome.replaceAll("[^a-zA-Z]","");
return nome.matches("[^a-zA-Z]");
}

private boolean validarCampos2(){
    boolean ok = false;
    if(txtNome.getText() != null && txtPreco.getText() != null)
    {
        ok = true;
    }
    return ok;
}

public static boolean ValidarPreco(String preco)
{
    preco = preco.replaceAll("^[0-9,.]*$","");
    return preco.matches("^[0-9,.]*$");
}

    private void limparCampos(){

        txtNome.setText("");
        txtPreco.setText("");
        cbControlado.setSelected(false);

    }



}
