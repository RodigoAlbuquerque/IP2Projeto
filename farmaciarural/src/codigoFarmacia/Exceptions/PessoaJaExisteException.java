public class PessoaJaExisteException extends Exception{
    private Pessoa pessoa;

    public PessoaJaExisteException(Pessoa pessoa){
        if(pessoa == null){
            throw new IllegalArgumentException();
        }
        this.pessoa = pessoa;
    }

    @Override
    public String getMessage(){
        String mensagem = "Pessoa já existe";
        return mensagem;
    }

}
