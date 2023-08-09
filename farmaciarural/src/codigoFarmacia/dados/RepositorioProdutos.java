package codigoFarmacia.dados;
import java.util.ArrayList;
import java.util.List;

import codigoFarmacia.models.Produto;

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
    
    public void atualizarProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(produto.getNome())) {
                produtos.set(i, produto);
                break;
            }
        }
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

}
