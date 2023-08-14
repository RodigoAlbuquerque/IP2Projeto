package dados;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class RepositorioProdutos implements IRepositorioProdutos {
    private List<Produto> produtos;
    private static IRepositorioProdutos uniqueInstance = null;

    private RepositorioProdutos(){
        produtos = new ArrayList<>();
    }

    public static IRepositorioProdutos getInstanceRepositorioProdutos(){
        if(uniqueInstance == null){
            uniqueInstance = new RepositorioProdutos();
        }
        return uniqueInstance;
    }

    @Override
    public void cadastrarProduto(Produto produto){
        produtos.add(produto);
    }

    @Override
    public void descadastrarProduto(Produto produto) {
        produtos.remove(produto);
    }

    @Override
    public Produto buscarProduto(String nome) {
        Produto prod = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                prod = produto;
            }
        }
        return prod;
    }

    @Override
    public int buscarProduto(Produto pr){
        int posicao = 0;
        for (Produto produto : produtos) {
            if(pr != produto){
                posicao ++;
            }
        }
        if(pr == produtos.get(0)){
            posicao = 0;
            return posicao;
         }
        return posicao;
    }
    
    @Override
    public void atualizarProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(produto.getNome())) {
                produtos.set(i, produto);
                break;
            }
        }
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtos;
    }
    @Override
    public List<Produto> listarProdutosEmBaixoEstoque(){
        ArrayList<Produto> produtosEmBaixoEstoque = new ArrayList<>();
        for(Produto pr: produtos){
            if(pr.getQuantidade() < 2){
                produtosEmBaixoEstoque.add(pr);
            }
        }
        return produtosEmBaixoEstoque;
    }

}
