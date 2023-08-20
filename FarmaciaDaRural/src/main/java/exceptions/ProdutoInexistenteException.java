package exceptions;


public class ProdutoInexistenteException extends Exception{
    private String produtoNome;

    public ProdutoInexistenteException(String nome){
     super("Produto não existe");

        if (nome == null){
            throw new IllegalArgumentException();
        }
        this.produtoNome = nome;
    }
}
