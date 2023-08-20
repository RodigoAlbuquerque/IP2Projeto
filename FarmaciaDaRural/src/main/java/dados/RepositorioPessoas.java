package dados;

import java.util.ArrayList;
import java.util.List;

import models.Funcionario;
import models.Pessoa;

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
        pessoas.add(pessoa);
    }

    @Override
    public boolean verificarCpf(String cpf){
        for (Pessoa pessoa : pessoas){
            if (pessoa.getCpf().equals(cpf)){
                return true;
            }
        }

        return false;
    }
    @Override
    public boolean verificarIdAcesso(Double IdAcesso){
         for (Pessoa pessoa : pessoas){
            if (pessoa instanceof Funcionario && ((Funcionario)pessoa).getIdAcessoSistema() == IdAcesso){
                return true;
            }
        }
        return false;
    }
    @Override 
    public Funcionario buscarFuncPorId(Double idAcesso){
        for (Pessoa pessoa : pessoas){
            if (pessoa instanceof Funcionario && ((Funcionario)pessoa).getIdAcessoSistema() == idAcesso){
                return (Funcionario)pessoa;
            }
        }
        return null;
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

  

  

}
