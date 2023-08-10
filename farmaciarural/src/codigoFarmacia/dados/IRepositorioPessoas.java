package codigoFarmacia.dados;

import java.util.List;

import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Funcionario;
import codigoFarmacia.models.Pessoa;

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