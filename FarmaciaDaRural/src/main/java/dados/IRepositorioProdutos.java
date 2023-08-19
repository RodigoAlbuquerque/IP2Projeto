package dados;

import java.util.List;

import models.Produto;

public interface IRepositorioProdutos {

    void cadastrarProduto(Produto produto);

    void descadastrarProduto(Produto produto);

    Produto buscarProduto(String nome);

    int buscarProduto(Produto pr);
    
    boolean verificarProdutoExistente(String nome);

    void atualizarProduto(Produto produto);

    List<Produto> listarProdutos();

    List<Produto> listarProdutosEmBaixoEstoque();

}
