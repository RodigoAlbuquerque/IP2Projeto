package GUI;

import controle.ControladorPessoas;
import exceptions.PessoaJaExisteException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import models.Funcionario;
import models.Pessoa;

public class telaCadastroFuncionarioController {
    @FXML private TextArea txtCpf;
    @FXML private TextArea txtNome;
    @FXML private TextArea txtEmail;
    @FXML private TextArea txtIdAcesso;
    @FXML private DatePicker dtData;
     
    private boolean validarCampos(){
        boolean valido = false;
        if(
            txtCpf.getText()!=null && 
            validarCPF(txtCpf.getText()) &&
            txtNome.getText()!=null &&
            txtEmail.getText()!=null &&
            txtIdAcesso.getText()!=null &&
            dtData.getValue()!=null
        ){
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
            Pessoa pessoa1 = new Funcionario(txtEmail.getText(), txtNome.getText(), txtCpf.getText(), dtData.getValue(), Double.parseDouble(txtIdAcesso.getText()));
            try{
                ControladorPessoas.getInstanceControladorCadastro().cadastrarPessoa(pessoa1);
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
        txtIdAcesso.setText("");
        dtData.setValue(null);
    }


}
