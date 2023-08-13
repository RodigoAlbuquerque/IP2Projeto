package codigofarmacia.controle;

import codigofarmacia.dados.IRepositorioProdutos;
import codigofarmacia.dados.RepositorioProdutos;
import codigofarmacia.models.Produto;

import java.util.List;

public class ControladorProdutos {
    private IRepositorioProdutos repositorioProdutos;
    private static ControladorProdutos instance;

    private ControladorProdutos(){
        repositorioProdutos = RepositorioProdutos.getInstanceRepositorioProdutos();
    }

    public static ControladorProdutos getInstanceControladorProdutos(){
        if (instance == null){
            instance = new ControladorProdutos();
        }
        return instance;
    }

    public void cadastrarProduto(Produto produto){
        if( produto.getNome()!=null
                && produto.getPreco()!=null
                && produto.getQuantidade() !=0
        ){
            repositorioProdutos.cadastrarProduto(produto);
        }
    }

    public void descadastrarProduto(String nome){
        if(nome !=null){
            if(repositorioProdutos.buscarProduto(nome)!=null){
                repositorioProdutos.descadastrarProduto(repositorioProdutos.buscarProduto(nome));
            }
        }
    }

    public List<Produto> listarProdutos(){
        return repositorioProdutos.listarProdutos();
    }

    public List<Produto> listarProdutosEmBaixoEstoque(){
        return repositorioProdutos.listarProdutosEmBaixoEstoque();
    }

}
