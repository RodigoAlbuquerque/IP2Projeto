package controle;
import farmaciarural.dados.repositorioPessoas;

public class ControladorCadastro {
    private RepositorioPessoas repositorioPessoas;
    private RepositorioProdutos repositorioProdutos;
    private static ControladorCadastro instance;

    private ControladorCadastro(){
        repositorioPessoas = RepositorioPessoas getInstanceRepositorioPessoas();
        repositorioProdutos = RepositorioProdutos getInstanceRepositorioProdutos();
    }

    public static ControladorCadastro getInstanceControladorCadastro(){
        if(instance == null){
            instance = ControladorCadastro();
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
            repositorioPessoas.removerPessoa();
        }
    }

    public void cadastrarProduto(Produto produto){
        if( produto.getNome()!=null
            && produto.getPreco()!=null
            && produto.getTarja()!=null
        ){
            repositorioProdutos.cadastrarProduto();
        }
    }
    public void descadastrarProduto(String nome){
        if(nome !=null){
            if(buscarProduto(nome)){
                repositorioProdutos.descadastrarProduto(buscarProduto(nome));
            }

        }
    }
    private Produto buscarProduto(String nome){
        Produto prod = null;
        for(Produto po: repositorioProdutos){
            if(po.getNome() == nome){
               prod = po;
            }
        }
        return prod;
    }
}
