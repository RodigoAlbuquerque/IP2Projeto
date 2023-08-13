package codigofarmacia.dados;

import java.util.List;

import codigofarmacia.models.Cliente;
import codigofarmacia.models.Funcionario;
import codigofarmacia.models.Pessoa;

public interface IRepositorioPessoas {

    void cadastrarPessoa(Pessoa pessoa);

    void removerPessoa(String cpf);

    Pessoa buscarPessoaPorCpf(String cpf);
    
    boolean existePessoa(String cpf);

    List<Pessoa> listarPessoas();

    List<Pessoa> listarPessoasPorTipo(Class<?> tipo);

    List<Funcionario> listarFuncionariosQueMaisVendem();

    List<Cliente> listarClientesQueMaisCompram();

}
