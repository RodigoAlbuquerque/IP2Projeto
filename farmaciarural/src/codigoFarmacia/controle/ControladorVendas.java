package codigoFarmacia.controle;

import codigoFarmacia.models.Produto;
import codigoFarmacia.models.Venda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import codigoFarmacia.dados.RepositorioProdutos;
import codigoFarmacia.dados.RepositorioVendas;
import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Comprovante;
import codigoFarmacia.models.Funcionario;

public class ControladorVendas {
    private RepositorioProdutos repositorioProdutos;
    private RepositorioVendas repositorioVendas;
    private static ControladorVendas instance;

    private ControladorVendas() {
        repositorioProdutos = RepositorioProdutos.getInstanceRepositorioProdutos();
        repositorioVendas = RepositorioVendas.getInstanceRepositorioVendas();
    }

    public static ControladorVendas getInstanceControladorVendas() {
        if (instance == null) {
            instance = new ControladorVendas();
        } 
        return instance;
    }

    public void realizarVenda(List<Produto> compra, Funcionario vendedor, Cliente cliente){
        if(compra != null && verificarEstoqueDisponivel(compra)){
            //Criando comprovante da compra 
            //Funcao que calcula valor da compra
            Comprovante comprovante = new Comprovante(compra, 0.00, cliente.getCpf(), vendedor.getIdAcessoSistema());

            if(verificarCompraControlada(compra)){

                


            }else{
                

                Venda venda = new Venda(vendedor, cliente, compra, comprovante,LocalDateTime.now());
                repositorioVendas.adicionarVenda(venda);
            }
        }
    }

    private boolean verificarCompraControlada(List<Produto> compra){
        boolean controlado = false;
        for(Produto pr: compra){
            if(pr.isTarja()){
                controlado = true;
                break;
            }
        }
        return controlado;
    }

   private boolean verificarEstoqueDisponivel(List<Produto> compra){
        boolean disponivel = true;
        for(Produto pr:compra){
            if(pr.getQuantidade() > repositorioProdutos.buscarProduto(pr.getNome()).getQuantidade()){
                disponivel = false;
            }
        }
        return disponivel;
    }
    /*public void realizarVenda(Venda venda) {
        List<Produto> produtosVendidos = venda.getProdutos();
        if (produtosVendidos != null && repositorioProdutos.buscarProduto(produtosVendidos.getNome()) != null) {
            if (produtosVendidos.getQuantidade() > 0) {
                produtosVendidos.setQuantidade(produtosVendidos.getQuantidade() - 1);
                repositorioProdutos.atualizarProduto(produtosVendidos);
                Comprovante comprovante = new Comprovante(venda.getProdutos(), produtosVendidos.getPreco());
                venda.setComprovante(comprovante);
                repositorioVendas.adicionarVenda(venda);
            } else {
                System.out.println("Produto n�o dispon�vel em estoque.");
            }
        } else {
            System.out.println("Produto n�o encontrado.");
        }
    }
    */

    public void adicionarProdutoAoEstoque(Produto produto, int quantidade) {
        if (produto != null && quantidade > 0) {
            Produto produtoExistente = repositorioProdutos.buscarProduto(produto.getNome());
            if (produtoExistente != null) {
                produtoExistente.setQuantidade(produtoExistente.getQuantidade() + quantidade);
                repositorioProdutos.atualizarProduto(produtoExistente);
                System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao estoque.");
            } else {
                produto.setQuantidade(quantidade);
                repositorioProdutos.cadastrarProduto(produto);
                System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao estoque.");
            }
        } else {
            System.out.println("Produto inv�lido ou quantidade inv�lida para adicionar ao estoque.");
        }
    }

    public void removerProdutoDoEstoque(Produto produto, int quantidade) {
        if (produto != null && quantidade > 0) {
            Produto produtoExistente = repositorioProdutos.buscarProduto(produto.getNome());
            if (produtoExistente != null) {
                int estoqueAtual = produtoExistente.getQuantidade();
                if (estoqueAtual >= quantidade) {
                    produtoExistente.setQuantidade(estoqueAtual - quantidade);
                    repositorioProdutos.atualizarProduto(produtoExistente);
                    System.out.println(quantidade + " unidades de " + produto.getNome() + " removidas do estoque.");
                } else {
                    System.out.println("Quantidade insuficiente em estoque.");
                }
            } else {
                System.out.println("Produto n�o encontrado no estoque.");
            }
        } else {
            System.out.println("Produto inv�lido ou quantidade inv�lida para remover do estoque.");
        }
    }
}

