import java.util.ArrayList;
import java.util.List;

import models.Pessoa;

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

}
