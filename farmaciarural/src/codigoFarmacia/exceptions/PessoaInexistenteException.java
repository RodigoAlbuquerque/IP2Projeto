package codigoFarmacia.exceptions;

import codigoFarmacia.models.Pessoa;

public class PessoaInexistenteException extends Exception{
    private Pessoa pessoa;

    public PessoaInexistenteException(Pessoa pessoa){
        if (pessoa == null){
            throw new IllegalArgumentException();
        }
        this.pessoa = pessoa;
    }

    @Override
    public String getMessage(){
        String mensagem = "Pessoa não existe";
        return mensagem;
    }
}
