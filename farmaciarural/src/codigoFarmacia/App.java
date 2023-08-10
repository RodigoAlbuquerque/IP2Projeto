package codigoFarmacia;

import codigoFarmacia.controle.ControladorCadastro;
import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Funcionario;
import codigoFarmacia.models.Produto;

import java.time.LocalDateTime;


public class App {
    public static void main(String[] args) throws Exception {
        ControladorCadastro controladorCadastro = ControladorCadastro.getInstanceControladorCadastro();

        controladorCadastro.cadastrarPessoa(new Funcionario("rodrigodogera@gmail.com", "Rodrigo escamoso",
                                        "147895564", LocalDateTime.now(), 123456, 10));
        controladorCadastro.cadastrarPessoa(new Funcionario("ra faelmcc@gmail.com", "Rafael platinado",
                                        "546497253", LocalDateTime.now(), 147859, 15));

        controladorCadastro.cadastrarProduto(new Produto("Fluviral", 12.5, 10, false));
        controladorCadastro.cadastrarProduto(new Produto("Omeprazol", 20.0, 4, true));

        controladorCadastro.cadastrarPessoa(new Cliente("alanfogueteiro@gmail.com", "Alan ratao",
                                        "142536789", LocalDateTime.now()));
        controladorCadastro.cadastrarPessoa(new Cliente("josedelas@gmail.com", "Jose delas",
                                        "145795533", LocalDateTime.now()));

        controladorCadastro.descadastrarProduto("Fluviral");
        controladorCadastro.removerPessoa("546497253");



>>>>>>> Stashed changes
    }
}
