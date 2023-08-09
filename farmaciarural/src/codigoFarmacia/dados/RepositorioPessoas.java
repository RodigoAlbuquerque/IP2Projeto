package codigoFarmacia.dados;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Funcionario;
import codigoFarmacia.models.Pessoa;

public class RepositorioPessoas {
    private List<Pessoa> pessoas;
    private static RepositorioPessoas uniqueInstance = null;

    private RepositorioPessoas(){
        pessoas = new ArrayList<>();
    }

    public static RepositorioPessoas getInstanceRepositorioPessoas(){
        if(uniqueInstance == null){
            uniqueInstance = new RepositorioPessoas();
        }
        return uniqueInstance;
    }

    public void cadastrarPessoa(Pessoa pessoa){
        if(!existePessoa(pessoa.getCpf())){
            pessoas.add(pessoa);
        }else{
            System.out.println("Cpf já cadastrado no sistema");
        }
    }

    private boolean existePessoa(String cpf){
        for (Pessoa pessoa : pessoas){
            if (pessoa.getCpf().equals(cpf)){
                return true;
            }
        }

        return false;
    }

    public void removerPessoa(String cpf){
        Pessoa pessoa = buscarPessoaPorCpf(cpf);

        if (pessoa != null){
            pessoas.remove(pessoa);
        } else{
            System.out.println("Cpf não encontrado");
        }
    }

    public Pessoa buscarPessoaPorCpf(String cpf){
        for (Pessoa pessoa : pessoas){
            if (pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }

    public void listarPessoas(){
        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa.getNome());
        }
    }
    
    public List<Pessoa> listarPessoasPorTipo(Class<?> tipo){
        List<Pessoa> pessoasDesejadas = new ArrayList<>();
        for (Pessoa pe : pessoas) {
            if( tipo.isInstance(pe) ){
                pessoasDesejadas.add(pe);
            }
        }
        return pessoasDesejadas;
    }
    public List<Funcionario> listarFuncionariosQueMaisVendem(){
        List<Pessoa> pessoasDesejadas = listarPessoasPorTipo(Funcionario.class);
        List<Funcionario> funcionarios = new ArrayList<>();
        for(Pessoa pe:pessoasDesejadas){
            if(pe instanceof Funcionario){
                funcionarios.add((Funcionario)pe);
            }
        }
        Collections.sort(funcionarios);

        List<Funcionario> funcionariosQueMaisVenderam = new ArrayList<>();
        funcionariosQueMaisVenderam.add(funcionarios.get(0));
        funcionariosQueMaisVenderam.add(funcionarios.get(1));
        funcionariosQueMaisVenderam.add(funcionarios.get(2));
        return funcionariosQueMaisVenderam;
    }
    
     public List<Cliente> listarClientesQueMaisCompram(){

        List<Pessoa> pessoasDesejadas = listarPessoasPorTipo(Cliente.class);
        List<Cliente> clientes = new ArrayList<>();
        for(Pessoa pe:pessoasDesejadas){
            if(pe instanceof Cliente){
                clientes.add((Cliente)pe);
            }
        }
        Collections.sort(clientes);

        List<Cliente> clientesQueMaisCompram = new ArrayList<>();
        clientesQueMaisCompram.add(clientes.get(0));
        clientesQueMaisCompram.add(clientes.get(1));
        clientesQueMaisCompram.add(clientes.get(2));
        return clientesQueMaisCompram;
    }
 

  

}
