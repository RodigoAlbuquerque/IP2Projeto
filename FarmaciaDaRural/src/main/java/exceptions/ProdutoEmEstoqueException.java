package exceptions;

public class ProdutoEmEstoqueException extends Exception {
    private String msg;
    public ProdutoEmEstoqueException(String msg){
        super(msg);
        if(msg == null){
            throw new IllegalArgumentException();
        }
        this.msg = msg;
    }
}

