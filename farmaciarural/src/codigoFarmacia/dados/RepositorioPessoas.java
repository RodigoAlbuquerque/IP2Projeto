package codigofarmacia.dados;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import codigofarmacia.models.Cliente;
import codigofarmacia.models.Funcionario;
import codigofarmacia.models.Pessoa;

public class RepositorioPessoas implements IRepositorioPessoas {
    private List<Pessoa> pessoas;
    private static IRepositorioPessoas uniqueInstance = null;

    private RepositorioPessoas(){
        pessoas = new ArrayList<>();
    }

    public static IRepositorioPessoas getInstanceRepositorioPessoas(){
        if(uniqueInstance == null){
            uniqueInstance = new RepositorioPessoas();
        }
        return uniqueInstance;
    }

    @Override
    public void cadastrarPessoa(Pessoa pessoa){
        if(!existePessoa(pessoa.getCpf())){
            pessoas.add(pessoa);
        }else{
            System.out.println("Cpf já cadastrado no sistema");
        }
    }
    @Override
    public boolean existePessoa(String cpf){
        for (Pessoa pessoa : pessoas){
            if (pessoa.getCpf().equals(cpf)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void removerPessoa(String cpf){
        Pessoa pessoa = buscarPessoaPorCpf(cpf);

        if (pessoa != null){
            pessoas.remove(pessoa);
        } else{
            System.out.println("Cpf não encontrado");
        }
    }

    @Override
    public Pessoa buscarPessoaPorCpf(String cpf){
        for (Pessoa pessoa : pessoas){
            if (pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public List<Pessoa> listarPessoas(){
        return pessoas;
    }
    
    @Override
    public List<Pessoa> listarPessoasPorTipo(Class<?> tipo){
        List<Pessoa> pessoasDesejadas = new ArrayList<>();
        for (Pessoa pe : pessoas) {
            if( tipo.isInstance(pe) ){
                pessoasDesejadas.add(pe);
            }
        }
        return pessoasDesejadas;
    }
    @Override
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
    
     @Override
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
