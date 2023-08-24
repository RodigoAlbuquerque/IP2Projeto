package controle;
import models.Cliente;
import models.Funcionario;
import models.Pessoa;
import models.Venda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dados.IRepositorioPessoas;
import dados.IRepositorioVendas;
import dados.RepositorioPessoas;
import dados.RepositorioVendas;
import exceptions.PessoaJaExisteException;


public class ControladorPessoas {
    private IRepositorioPessoas repositorioPessoas;
    private IRepositorioVendas repositorioVendas;
    private static ControladorPessoas instance;

    private ControladorPessoas(){
        repositorioPessoas = RepositorioPessoas.getInstanceRepositorioPessoas();
        repositorioVendas = RepositorioVendas.getInstanceRepositorioVendas();
    }

    public static ControladorPessoas getInstanceControladorCadastro(){
        if(instance == null){
            instance = new ControladorPessoas();
        }
        return instance;
    }

    public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaExisteException{
        if(repositorioPessoas.verificarCpf(pessoa.getCpf()) ||
           pessoa instanceof Funcionario && repositorioPessoas.verificarIdAcesso(((Funcionario)pessoa).getIdAcessoSistema())             
        ){
            throw new PessoaJaExisteException(pessoa);    
        }
        else{
            repositorioPessoas.cadastrarPessoa(pessoa);
        }
    }

    public void removerPessoa(String cpf){
        if(cpf != null){
            repositorioPessoas.removerPessoa(cpf);
        }
    }

    public List<Pessoa> listarPessoasPorTipo(Class<?> tipo){
        return repositorioPessoas.listarPessoasPorTipo(tipo);
    }

    public List<Pessoa> listarPessoas(){
        return repositorioPessoas.listarPessoas();
    }
    public Funcionario buscarFuncPorId(Double id){
        return repositorioPessoas.buscarFuncPorId(id);
    }
    public Cliente buscarPessoaPorCpf(String cpf){
       if(repositorioPessoas.buscarPessoaPorCpf(cpf) instanceof Cliente){
        return (Cliente)repositorioPessoas.buscarPessoaPorCpf(cpf);
       }
       return null;
    }
    public List<Cliente> listarClientesQueMaisCompram(){
        List<Venda> todasAsVendas = repositorioVendas.listarVendas();
        List<Pessoa> todasAsPessoas = listarPessoas();

        Map<Cliente, Integer> vendasPorCliente = new HashMap<>();
        for (Pessoa cliente : todasAsPessoas) {
            if(cliente instanceof Cliente){
                int numeroDeVendas = calcularCompras(cliente,todasAsVendas);
                vendasPorCliente.put((Cliente) cliente, numeroDeVendas);
            }
        }
        List<Pessoa> clientes = listarPessoasPorTipo(Cliente.class);
        Collections.sort(clientes, Comparator.comparingInt(vendasPorCliente::get).reversed());
        List<Cliente> clientesQueMaisCompram = new ArrayList<>();
        for(Pessoa cliente: clientes){
            clientesQueMaisCompram.add((Cliente)cliente);
        }

        return clientesQueMaisCompram;
    } 

    public List<Funcionario> listarFuncionariosQueMaisVendem(){
        List<Venda> todasAsVendas = repositorioVendas.listarVendas();
        List<Pessoa> todasAsPessoas = listarPessoas();

        Map<Funcionario, Integer> vendasPorCliente = new HashMap<>();
        for (Pessoa funcionario : todasAsPessoas) {
            if(funcionario instanceof Funcionario){
                int numeroDeVendas = calcularVendas(funcionario,todasAsVendas);
                vendasPorCliente.put((Funcionario) funcionario, numeroDeVendas);
            }
        }
        List<Pessoa> funcionarios = listarPessoasPorTipo(Funcionario.class);
        Collections.sort(funcionarios, Comparator.comparingInt(vendasPorCliente::get).reversed());
        List<Funcionario> funcionariosQueMaisVendem = new ArrayList<>();
        for(Pessoa func: funcionarios){
            funcionariosQueMaisVendem.add((Funcionario)func);
        }

        return funcionariosQueMaisVendem;

    } 
     public int calcularVendas(Pessoa pe,List<Venda> ve){
        int nVendas=0;
        for(Venda venda: ve){
            if(venda.getFuncionario() == pe){
                nVendas+=1;
            }
        }
        return nVendas;
    }
    public int calcularCompras(Pessoa pe,List<Venda> ve){
        int nVendas=0;
        for(Venda venda: ve){
            if(venda.getCliente() == pe){
                nVendas+=1;
            }
        }
        return nVendas;
    }
}
    

