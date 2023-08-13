package codigofarmacia.controle;
import codigofarmacia.models.Cliente;
import codigofarmacia.models.Funcionario;
import codigofarmacia.models.Pessoa;

import java.util.List;

import codigofarmacia.dados.IRepositorioPessoas;
import codigofarmacia.dados.RepositorioPessoas;


public class ControladorPessoas {
    private IRepositorioPessoas repositorioPessoas;
    private static ControladorPessoas instance;

    private ControladorPessoas(){
        repositorioPessoas = RepositorioPessoas.getInstanceRepositorioPessoas();
    }

    public static ControladorPessoas getInstanceControladorCadastro(){
        if(instance == null){
            instance = new ControladorPessoas();
        }
        return instance;
    }

    public void cadastrarPessoa(Pessoa pessoa){
        if( pessoa.getCpf() != null
            && pessoa.getNome() != null 
            && pessoa.getEmail()!=null
            && pessoa.getDataNascimento()!=null
        ){
            repositorioPessoas.cadastrarPessoa(pessoa);
        }
    }

    public void removerPessoa(String cpf){
        if(cpf != null){
            repositorioPessoas.removerPessoa(cpf);
        }
    }

    public List<Cliente> listarClientesQueMaisCompram(){
        return repositorioPessoas.listarClientesQueMaisCompram();
    }

    public List<Funcionario> listarFuncionariosQueMaisVendem(){
        return repositorioPessoas.listarFuncionariosQueMaisVendem();
    }

    public List<Pessoa> listarPessoasPorTipo(Class<?> tipo){
        return repositorioPessoas.listarPessoasPorTipo(tipo);
    }

    public List<Pessoa> listarPessoas(){
        return repositorioPessoas.listarPessoas();
    }

}
