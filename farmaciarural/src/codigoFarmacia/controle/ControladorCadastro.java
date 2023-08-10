package codigoFarmacia.controle;
import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Funcionario;
import codigoFarmacia.models.Pessoa;
import codigoFarmacia.models.Produto;

import java.util.List;

import codigoFarmacia.dados.IRepositorioPessoas;
import codigoFarmacia.dados.IRepositorioProdutos;
import codigoFarmacia.dados.RepositorioPessoas;
import codigoFarmacia.dados.RepositorioProdutos;

public class ControladorCadastro {
    private IRepositorioPessoas repositorioPessoas;
    private static ControladorCadastro instance;

    private ControladorCadastro(){
        repositorioPessoas = RepositorioPessoas.getInstanceRepositorioPessoas();
    }

    public static ControladorCadastro getInstanceControladorCadastro(){
        if(instance == null){
            instance = new ControladorCadastro();
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
