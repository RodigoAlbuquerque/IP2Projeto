package codigofarmacia;

import codigoFarmacia.controle.ControladorPessoas;
import codigoFarmacia.controle.ControladorProdutos;
import codigoFarmacia.controle.ControladorVendas;
import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Funcionario;
import codigoFarmacia.models.Pessoa;
import codigoFarmacia.models.Produto;
import codigoFarmacia.models.Venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        ControladorPessoas controladorPessoas = ControladorPessoas.getInstanceControladorCadastro();
        ControladorVendas controladorVendas = ControladorVendas.getInstanceControladorVendas();
        ControladorProdutos controladorProdutos = ControladorProdutos.getInstanceControladorProdutos();

        Pessoa f1 = new Funcionario("rodrigodogera@gmail.com", "Rodrigo escamoso",
                                        "147895564", LocalDateTime.now(), 123456, 10);
        Pessoa f2= new Funcionario("canetaazul@gmail.com", "Manuel gomes",
                                        "457933467", LocalDateTime.now(), 145793, 18);
        Pessoa f3=new Funcionario("sobrevivendonaroca@gmail.com", "Erivelton",
                                        "458763664", LocalDateTime.now(), 147958, 50);
        Pessoa f4=new Funcionario("rafaelmcc@gmail.com", "Rafael platinado",
                                        "546497253", LocalDateTime.now(), 147859, 15);

        controladorPessoas.cadastrarPessoa(f1);
        controladorPessoas.cadastrarPessoa(f2);
        controladorPessoas.cadastrarPessoa(f3);
        controladorPessoas.cadastrarPessoa(f4);

        controladorProdutos.cadastrarProduto(new Produto("Fluviral", 12.5, 30, false));
        controladorProdutos.cadastrarProduto(new Produto("Omeprazol", 20.0, 4, true));

        Pessoa c1=new Cliente("alanfogueteiro@gmail.com", "Alan ratao",
                                        "142536789", LocalDateTime.now());
        Pessoa c2=new Cliente("guetoegueto@gmail.com", "Marcinho do gera",
                                        "457983465", LocalDateTime.now());
        Pessoa c3=new Cliente("dalledalle@gmail.com", "MC anonimo",
                                        "457985321", LocalDateTime.now());
        Pessoa c4=new Cliente("josedelas@gmail.com", "Jose delas",
                                        "145795533", LocalDateTime.now());
        controladorPessoas.cadastrarPessoa(c1);
        controladorPessoas.cadastrarPessoa(c2);
        controladorPessoas.cadastrarPessoa(c3);
        controladorPessoas.cadastrarPessoa(c4);

        controladorProdutos.descadastrarProduto("Omeprazol");
        controladorPessoas.removerPessoa("546497253");
       
        Produto p1 = new Produto("Fluviral",12.5,1,false);
        Produto p2 = new Produto("Fluviral",12.5,3,false);
        Produto p3 = new Produto("Fluviral",12.5,5,false);
        Produto p4 = new Produto("Fluviral",12.5,7,false);

        ArrayList<Produto> compra1 = new ArrayList<>();
        compra1.add(p1);
        ArrayList<Produto> compra2 = new ArrayList<>();
        ArrayList<Produto> compra3 = new ArrayList<>();
        ArrayList<Produto> compra4 = new ArrayList<>();
        compra2.add(p2);
        compra3.add(p3);
        compra4.add(p4);


        System.out.println("*------------------------------------------------------------*\n");
        System.out.println("PRODUTOS CADASTRADOS\n");
        List<Produto> produtosCadastrados = controladorProdutos.listarProdutos();
        for(Produto pr: produtosCadastrados){
            System.out.println("Nome: " + pr.getNome() + " | Quantidade: "+ pr.getQuantidade()+"\n");
        }


        controladorVendas.realizarVenda(compra1,(Funcionario) f1,(Cliente) c1);
        controladorVendas.realizarVenda(compra2,(Funcionario) f2,(Cliente) c2);
        controladorVendas.realizarVenda(compra3,(Funcionario) f1,(Cliente) c4);
        controladorVendas.realizarVenda(compra4,(Funcionario) f1,(Cliente) c3);
        


        System.out.println("\n--------------------------------------------------------------");
         System.out.println("CLIENTES QUE MAIS COMPRAM\n");
        List<Cliente> clientesQueMaisCompram = controladorPessoas.listarClientesQueMaisCompram();
        for(Cliente cl: clientesQueMaisCompram){
            System.out.println("Nome: "+ cl.getNome() +" | Compras: "+ cl.getNumeroDeCompras());
        }
        System.out.println("*------------------------------------------------------------*\n");
         System.out.println("FUNCIONARIOS QUE MAIS VENDEM\n");
        List<Funcionario> funcionariosQueMaisVendem = controladorPessoas.listarFuncionariosQueMaisVendem();
        for(Funcionario fc: funcionariosQueMaisVendem){
            System.out.println("Nome: " + fc.getNome() + " | Vendas: " + fc.getNumerodeVendas());
        }
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("PESSOAS CADASTRADAS\n");
        List<Pessoa> pessoasCadastradas = controladorPessoas.listarPessoas();
        for(Pessoa pe: pessoasCadastradas){
            System.out.println("Nome: " + pe.getNome());
        }
       
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("CLIENTES DA FARMACIA\n");
        List<Pessoa> clientesDaFarmacia = controladorPessoas.listarPessoasPorTipo(Cliente.class);
        for(Pessoa cl: clientesDaFarmacia){
            System.out.println("Nome: "+ cl.getNome());
        }
        System.out.println("*------------------------------------------------------------*\n");
        System.out.println("FUNCIONARIOS DA FARMACIA\n");
        List<Pessoa> funcionariosDaFarmacia = controladorPessoas.listarPessoasPorTipo(Funcionario.class);
        for(Pessoa func: funcionariosDaFarmacia){
            System.out.println("Nome: " + func.getNome());
        }
        
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("*------------------------------------------------------------*\n");
        System.out.println("VENDAS DA FARMACIA\n");
        List<Venda> vendasDaFarmacia = controladorVendas.listarVendas();
        for(Venda vd: vendasDaFarmacia){
            System.out.println("Cliente: "+ vd.getComprovante().getCpf() +"\nFuncionario: "+ vd.getComprovante().getIdAcessFuncionario()+"\nValor: R$"+vd.getComprovante().getValorDaCompra()+"\n");
        }
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("*------------------------------------------------------------*\n");
        System.out.println("VENDAS DA FARMACIA em determinado periodo\n");
        List<Venda> vendasDaFarmaciaEmPeriodo = controladorVendas.listarVendasPorPeriodos(LocalDateTime.of(2015,1,1,0,0),LocalDateTime.of(2025, 1, 1, 0, 0));
        for(Venda vd: vendasDaFarmaciaEmPeriodo){
            System.out.println("Cliente: "+ vd.getComprovante().getCpf() +"\nFuncionario: "+ vd.getComprovante().getIdAcessFuncionario()+"\nValor: R$"+vd.getComprovante().getValorDaCompra());
        }
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("*------------------------------------------------------------*\n");
        System.out.println("PRODUTOS CADASTRADOS\n");
        List<Produto> produtosCadastrados2 = controladorProdutos.listarProdutos();
        for(Produto pr: produtosCadastrados2){
            System.out.println("Nome: " + pr.getNome() + " | Quantidade: "+ pr.getQuantidade()+"\n");
        }
    }
}
