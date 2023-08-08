import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class RepositorioProdutos {
    private List<Produto> produtos;
    private static RepositorioProdutos uniqueInstance = null;

    private RepositorioProdutos(){
        produtos = new ArrayList<>();
    }

    public static RepositorioProdutos getInstanceRepositorioProdutos(){
        if(uniqueInstance == null){
            uniqueInstance = new RepositorioProdutos();
        }
        return uniqueInstance;
    }

    public void cadastrarProduto(Produto produto){
        produtos.add(produto);
    }

    public void descadastrarProduto(Produto produto) {
        produtos.remove(produto);
    }

    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

}
