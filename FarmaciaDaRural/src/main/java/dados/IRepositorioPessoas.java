package dados;

import java.util.List;
import models.Pessoa;

public interface IRepositorioPessoas {

    void cadastrarPessoa(Pessoa pessoa);

    void removerPessoa(String cpf);

    Pessoa buscarPessoaPorCpf(String cpf);
    
    boolean existePessoa(String cpf);

    List<Pessoa> listarPessoas();

    List<Pessoa> listarPessoasPorTipo(Class<?> tipo);


}