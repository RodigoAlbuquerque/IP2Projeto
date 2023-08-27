package exceptions;

public class CompraNaoControladaException extends RuntimeException {
    private String msg;

    public CompraNaoControladaException(String msg){
        super(msg);

        if(msg == null){
            throw new IllegalArgumentException();
        }
        this.msg = msg;
    }
}


