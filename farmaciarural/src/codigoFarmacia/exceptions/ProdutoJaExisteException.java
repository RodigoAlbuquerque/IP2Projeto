package codigofarmacia.exceptions;

import codigofarmacia.models.Produto;

public class ProdutoJaExisteException extends Exception{
    private Produto produto;

    public ProdutoJaExisteException(Produto produto){
        super("Produto já existe");

        if (produto == null){
            throw new IllegalArgumentException();
        }
        this.produto = produto;
    }
}
