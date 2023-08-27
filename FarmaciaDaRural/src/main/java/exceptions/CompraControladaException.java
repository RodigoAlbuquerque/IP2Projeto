package exceptions;

public class CompraControladaException extends Exception{
    
    private String msg;

    public CompraControladaException(String msg){
        super(msg);

        if(msg == null){
            throw new IllegalArgumentException();
        }
        this.msg = msg;
    }
}


