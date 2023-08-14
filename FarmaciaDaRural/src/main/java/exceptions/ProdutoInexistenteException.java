package exceptions;

import models.Produto;

public class ProdutoInexistenteException extends Exception{
    private Produto produto;

    public ProdutoInexistenteException(Produto produto){
     super("Produto não existe");

        if (produto == null){
            throw new IllegalArgumentException();
        }
        this.produto = produto;
    }
}
