package codigoFarmacia.dados;
import java.util.ArrayList;
import java.util.List;

import codigoFarmacia.models.Produto;

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
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public int buscarProduto(Produto pr){
        int posicao = 0;
         if(pr == produtos.get(0)){
            return posicao;
         }
        for (Produto produto : produtos) {
            if(pr != produto){
                posicao ++;
            }
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
