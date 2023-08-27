package exceptions;

import java.util.List;

import models.ItemVenda;


public class ProdutoForaDeEstoqueException extends Exception {
    private List<ItemVenda> prod;

    public ProdutoForaDeEstoqueException(List<ItemVenda> produto){
        super("Produto fora de Estoque no sistema");

        if(produto == null){
            throw new IllegalArgumentException();
        }
        this.prod = produto;
    }

}
