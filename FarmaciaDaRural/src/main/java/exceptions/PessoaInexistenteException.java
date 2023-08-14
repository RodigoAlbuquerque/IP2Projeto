package exceptions;

import models.Pessoa;

public class PessoaInexistenteException extends Exception{
    private Pessoa pessoa;

    public PessoaInexistenteException(Pessoa pessoa){
        super("Pessoa não existe");

        if (pessoa == null){
            throw new IllegalArgumentException();
        }
        this.pessoa = pessoa;
    }
}
