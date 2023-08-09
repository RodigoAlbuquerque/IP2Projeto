package codigoFarmacia.exceptions;

import codigoFarmacia.models.Produto;

public class ProdutoInexistenteException extends Exception{
    private Produto produto;

    public ProdutoInexistenteException(Produto produto){
        if (produto == null){
            throw new IllegalArgumentException();
        }
        this.produto = produto;
    }

    @Override
    public String getMessage(){
        String mensagem = "Produto não existe";
        return mensagem;
    }
}
