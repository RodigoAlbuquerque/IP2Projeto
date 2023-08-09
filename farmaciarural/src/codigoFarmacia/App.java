package codigoFarmacia;

import java.util.ResourceBundle.Control;

import codigoFarmacia.controle.ControladorCadastro;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ControladorCadastro controladorCadastro = ControladorCadastro.getInstanceControladorCadastro();
    
    }
}
