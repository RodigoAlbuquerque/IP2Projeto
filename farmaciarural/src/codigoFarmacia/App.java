package codigoFarmacia;

import codigoFarmacia.controle.ControladorCadastro;
import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Funcionario;
import codigoFarmacia.models.Pessoa;
import codigoFarmacia.models.Produto;

import java.time.LocalDateTime;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        ControladorCadastro controladorCadastro = ControladorCadastro.getInstanceControladorCadastro();

        controladorCadastro.cadastrarPessoa(new Funcionario("rodrigodogera@gmail.com", "Rodrigo escamoso",
                                        "147895564", LocalDateTime.now(), 123456, 10));
        controladorCadastro.cadastrarPessoa(new Funcionario("canetaazul@gmail.com", "Manuel gomes",
                                        "457933467", LocalDateTime.now(), 145793, 18));
        controladorCadastro.cadastrarPessoa(new Funcionario("sobrevivendonaroca@gmail.com", "Erivelton",
                                        "458763664", LocalDateTime.now(), 147958, 50));
        controladorCadastro.cadastrarPessoa(new Funcionario("rafaelmcc@gmail.com", "Rafael platinado",
                                        "546497253", LocalDateTime.now(), 147859, 15));

        controladorCadastro.cadastrarProduto(new Produto("Fluviral", 12.5, 10, false));
        controladorCadastro.cadastrarProduto(new Produto("Omeprazol", 20.0, 4, true));

        controladorCadastro.cadastrarPessoa(new Cliente("alanfogueteiro@gmail.com", "Alan ratao",
                                        "142536789", LocalDateTime.now()));
        controladorCadastro.cadastrarPessoa(new Cliente("guetoegueto@gmail.com", "Marcinho do gera",
                                        "457983465", LocalDateTime.now()));
        controladorCadastro.cadastrarPessoa(new Cliente("dalledalle@gmail.com", "MC anonimo",
                                        "457985321", LocalDateTime.now()));
        controladorCadastro.cadastrarPessoa(new Cliente("josedelas@gmail.com", "Jose delas",
                                        "145795533", LocalDateTime.now()));

        controladorCadastro.descadastrarProduto("Fluviral");
        controladorCadastro.removerPessoa("546497253");
        

        System.out.println("\n--------------------------------------------------------------");
        controladorCadastro.listarClientesQueMaisCompram();
        System.out.println("*------------------------------------------------------------*\n");
        controladorCadastro.listarFuncionariosQueMaisVendem();
        System.out.println("\n--------------------------------------------------------------");
        controladorCadastro.listarPessoas();
        System.out.println("*------------------------------------------------------------*\n");
        controladorCadastro.listarProdutos();
        System.out.println("\n--------------------------------------------------------------");
        controladorCadastro.listarPessoasPorTipo(Cliente.class);
        System.out.println("*------------------------------------------------------------*\n");
        controladorCadastro.listarPessoasPorTipo(Funcionario.class);
        System.out.println("\n--------------------------------------------------------------");

    }
}
