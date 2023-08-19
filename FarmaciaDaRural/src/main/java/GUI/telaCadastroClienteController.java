package GUI;

import controle.ControladorPessoas;
import exceptions.PessoaJaExisteException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import models.Cliente;
import models.Pessoa;

public class telaCadastroClienteController {
    @FXML private TextArea txtCpf;
    @FXML private TextArea txtNome;
    @FXML private TextArea txtEmail;
    @FXML private DatePicker dtData;
    @FXML private CheckBox chkPremium;
     
    private boolean validarCampos() {
        boolean valido = false;
        if (
            txtCpf.getText() != null && 
            validarCPF(txtCpf.getText()) &&
            txtNome.getText() != null &&
            txtEmail.getText() != null &&
            dtData.getValue() != null &&
            chkPremium != null 
        ) {
            valido = true;
        }
        return valido;
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

    @FXML
    public void btnCadastrar(){
        if(validarCampos()){
            Pessoa pessoa3 = new Cliente(txtEmail.getText(), txtNome.getText(), txtCpf.getText(), dtData.getValue(), chkPremium.isSelected());
            try{
                ControladorPessoas.getInstanceControladorCadastro().cadastrarPessoa(pessoa3);
                showMessage("ENTIDADE CADASTRADA COM SUCESSO!","Tudo Okay!");
                limparCampos();
            }
            catch(PessoaJaExisteException pe){
                showError(pe);
            }
        }else{
            showMessage("Valores passados nos campos estão invalidos!\n Verifique se todos os campos estão preenchidos e se sim se foram preenchidos de maneira correta"
            ,"Campos invalidos");
        }
    }

    public static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        return true;
    }

    public void cancelar(){
        limparCampos();
        ScreenManager.getInstance().changeScreen(1);
    }

    private void limparCampos(){
        txtCpf.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        dtData.setValue(null);
        chkPremium.setSelected(false); 
    }


}
