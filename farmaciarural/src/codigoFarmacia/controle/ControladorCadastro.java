package codigoFarmacia.controle;
import codigoFarmacia.models.Pessoa;
import codigoFarmacia.models.Produto;
import codigoFarmacia.dados.RepositorioPessoas;
import codigoFarmacia.dados.RepositorioProdutos;

public class ControladorCadastro {
    private RepositorioPessoas repositorioPessoas;
    private RepositorioProdutos repositorioProdutos;
    private static ControladorCadastro instance;

    private ControladorCadastro(){
        repositorioPessoas = RepositorioPessoas.getInstanceRepositorioPessoas();
        repositorioProdutos = RepositorioProdutos.getInstanceRepositorioProdutos();
    }

    public static ControladorCadastro getInstanceControladorCadastro(){
        if(instance == null){
            instance = new ControladorCadastro();
        }
        return instance;
    }

    public void cadastrarPessoa(Pessoa pessoa){
        if( pessoa.getCpf() != null
            && pessoa.getNome() != null 
            && pessoa.getEmail()!=null
            && pessoa.getDataNascimento()!=null
        ){
            repositorioPessoas.cadastrarPessoa(pessoa);
        }
    }

    public void removerPessoa(String cpf){
        if(cpf != null){
            repositorioPessoas.removerPessoa(cpf);
        }
    }

    public void cadastrarProduto(Produto produto){
        if( produto.getNome()!=null
            && produto.getPreco()!=null
            && produto.isTarja()
        ){
            repositorioProdutos.cadastrarProduto(produto);
        }
    }
    public void descadastrarProduto(String nome){
        if(nome !=null){
            if(repositorioProdutos.buscarProduto(nome)!=null){
                repositorioProdutos.descadastrarProduto(repositorioProdutos.buscarProduto(nome));
            }
        }
    }


}
