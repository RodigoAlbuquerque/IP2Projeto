package codigoFarmacia.exceptions;

import codigoFarmacia.models.Produto;

public class ProdutoJaExisteException extends Exception{
    private Produto produto;

    public ProdutoJaExisteException(Produto produto){
        if (produto == null){
            throw new IllegalArgumentException();
        }
        this.produto = produto;
    }

    @Override
    public String getMessage(){
        String mensagem = "Produto já existe";
        return mensagem;
    }
}
