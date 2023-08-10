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
         System.out.println("CLIENTES QUE MAIS COMPRAM\n");
        List<Cliente> clientesQueMaisCompram = controladorCadastro.listarClientesQueMaisCompram();
        for(Cliente cl: clientesQueMaisCompram){
            System.out.println("Nome: "+ cl.getNome() +"| Compras: "+ cl.getNumeroDeCompras());
        }
        System.out.println("*------------------------------------------------------------*\n");
         System.out.println("FUNCIONARIOS QUE MAIS VENDEM\n");
        List<Funcionario> funcionariosQueMaisVendem = controladorCadastro.listarFuncionariosQueMaisVendem();
        for(Funcionario fc: funcionariosQueMaisVendem){
            System.out.println("Nome: " + fc.getNome() + "| Vendas: " + fc.getNumerodeVendas());
        }
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("PESSOAS CADASTRADAS\n");
        List<Pessoa> pessoasCadastradas = controladorCadastro.listarPessoas();
        for(Pessoa pe: pessoasCadastradas){
            System.out.println("Nome: " + pe.getNome());
        }
        System.out.println("*------------------------------------------------------------*\n");
        System.out.println("PRODUTOS CADASTRADOS\n");
        List<Produto> produtosCadastrados = controladorCadastro.listarProdutos();
        for(Produto pr: produtosCadastrados){
            System.out.println("Nome: " + pr.getNome() + "| Quantidade: "+ pr.getQuantidade()+"\n");
        }
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("CLIENTES DA FARMACIA\n");
        List<Pessoa> clientesDaFarmacia = controladorCadastro.listarPessoasPorTipo(Cliente.class);
        for(Pessoa cl: clientesDaFarmacia){
            System.out.println("Nome: "+ cl.getNome());
        }
        System.out.println("*------------------------------------------------------------*\n");
        System.out.println("FUNCIONARIOS DA FARMACIA\n");
        List<Pessoa> funcionariosDaFarmacia = controladorCadastro.listarPessoasPorTipo(Funcionario.class);
        for(Pessoa func: funcionariosDaFarmacia){
            System.out.println("Nome: " + func.getNome());
        }
        System.out.println("\n--------------------------------------------------------------");

    }
}
