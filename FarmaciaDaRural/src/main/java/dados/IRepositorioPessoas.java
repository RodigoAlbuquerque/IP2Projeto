package dados;

import java.util.List;

import models.Funcionario;
import models.Pessoa;

public interface IRepositorioPessoas {

    void cadastrarPessoa(Pessoa pessoa);

    void removerPessoa(String cpf);

    Pessoa buscarPessoaPorCpf(String cpf);

    Funcionario buscarFuncPorId(Double idAcesso);
    
    boolean verificarCpf(String cpf);

    boolean verificarIdAcesso(Double IdAcesso);

    List<Pessoa> listarPessoas();

    List<Pessoa> listarPessoasPorTipo(Class<?> tipo);


}