import java.util.ArrayList;
import java.util.List;

public class RepositorioProdutos {
    private List<Produto> produtos;

    public RepositorioProdutos(){
        produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto){
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
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
