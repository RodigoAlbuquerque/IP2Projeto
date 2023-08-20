package controle;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import exceptions.ProdutoJaExisteException;
import models.Produto;

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

    public void cadastrarProduto(Produto produto)throws ProdutoJaExisteException {
        if(!repositorioProdutos.verificarProdutoExistente(produto.getNome())

        ){
           throw new ProdutoJaExisteException(produto);
        }
        else{
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
    public boolean verificarProdutoExistente(String nome){
        return repositorioProdutos.verificarProdutoExistente(nome);
    }
    public List<Produto> listarProdutos(){
        return repositorioProdutos.listarProdutos();
    }

    public List<Produto> listarProdutosEmBaixoEstoque(){
        return repositorioProdutos.listarProdutosEmBaixoEstoque();
    }
    public Produto buscarProduto(String nome) {
        return repositorioProdutos.buscarProduto(nome);
    }
    


}
