package codigoFarmacia.exceptions;

import codigoFarmacia.models.Pessoa;

public class PessoaJaExisteException extends Exception{
    private Pessoa pessoa;

    public PessoaJaExisteException(Pessoa pessoa){
        super("Pessoa já existe no sistema");

        if(pessoa == null){
            throw new IllegalArgumentException();
        }
        this.pessoa = pessoa;
    }

}
