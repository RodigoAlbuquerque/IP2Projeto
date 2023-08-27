package exceptions;

public class PessoaJaExisteException extends Exception{
    private String pessoa;

    public PessoaJaExisteException(String pessoa){
        super("Pessoa já existe no sistema");

        if(pessoa == null){
            throw new IllegalArgumentException();
        }
        this.pessoa = pessoa;
    }

}
