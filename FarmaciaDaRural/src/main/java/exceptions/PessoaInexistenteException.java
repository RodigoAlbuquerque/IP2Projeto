package exceptions;

public class PessoaInexistenteException extends Exception{
    private String pessoa;

    public PessoaInexistenteException(String pessoa){
        super("Pessoa Não Existe No sistema");

        if(pessoa == null){
            throw new IllegalArgumentException();
        }
        this.pessoa = pessoa;
    }

}
