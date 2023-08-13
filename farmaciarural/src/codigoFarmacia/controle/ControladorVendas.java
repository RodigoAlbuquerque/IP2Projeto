package codigoFarmacia.controle;

import codigoFarmacia.models.Produto;
import codigoFarmacia.models.Venda;


import java.time.LocalDateTime;
import java.util.List;

import codigoFarmacia.dados.IRepositorioPessoas;
import codigoFarmacia.dados.IRepositorioProdutos;
import codigoFarmacia.dados.IRepositorioVendas;
import codigoFarmacia.dados.RepositorioPessoas;
import codigoFarmacia.dados.RepositorioProdutos;
import codigoFarmacia.dados.RepositorioVendas;
import codigoFarmacia.models.Cliente;
import codigoFarmacia.models.Comprovante;
import codigoFarmacia.models.Funcionario;
import codigoFarmacia.models.ItemVenda;
import codigoFarmacia.models.Pessoa;

public class ControladorVendas {
    private IRepositorioProdutos repositorioProdutos;
    private IRepositorioVendas repositorioVendas;
    private IRepositorioPessoas repositorioPessoas;
    private static ControladorVendas instance;

    private ControladorVendas() {
        repositorioProdutos = RepositorioProdutos.getInstanceRepositorioProdutos();
        repositorioVendas = RepositorioVendas.getInstanceRepositorioVendas();
        repositorioPessoas = RepositorioPessoas.getInstanceRepositorioPessoas();
    }

    public static ControladorVendas getInstanceControladorVendas() {
        if (instance == null) {
            instance = new ControladorVendas();
        } 
        return instance;
    }

    public void realizarVenda(List<ItemVenda> compra, Funcionario vendedor, Cliente cliente) { 
        if (compra != null && verificarEstoqueDisponivel(compra) && repositorioPessoas.existePessoa(vendedor.getCpf())&& repositorioPessoas.existePessoa(cliente.getCpf())) {
            Pessoa func = repositorioPessoas.buscarPessoaPorCpf(vendedor.getCpf());
            if( func instanceof Funcionario ){
                double valorTotal = calcularValorDaCompra(compra); 
                Comprovante comprovante = new Comprovante(compra, valorTotal, cliente.getCpf(), vendedor.getIdAcessoSistema());
        
                if (verificarCompraControlada(compra)) {
                    return;
                } else {
                    /*for (ItemVenda itemComprado : compra) {
                        Produto produtoNoEstoque = repositorioProdutos.buscarProduto(itemComprado.getProduto().getNome());
                        produtoNoEstoque.setQuantidade(produtoNoEstoque.getQuantidade() - itemComprado.getProduto().getQuantidade());
                        repositorioProdutos.atualizarProduto(produtoNoEstoque);
                    }
                    */
                        Venda venda = new Venda(vendedor, cliente, compra, comprovante, LocalDateTime.now());
                        repositorioVendas.adicionarVenda(venda);

                    } 
                }
            }
        }

    private double calcularValorDaCompra(List<ItemVenda> compra) {
        double valorTotal = 0.0;
        for (ItemVenda pr : compra) {
            valorTotal += pr.getProduto().getPreco() * pr.getQuantidade();
        }
        return valorTotal;
    }

    private boolean verificarCompraControlada(List<ItemVenda> compra){
        boolean controlado = false;
        for(ItemVenda pr: compra){
            if(pr.getProduto().isTarja()){
                controlado = true;
                break;
            }
        }
        return controlado;
    }

   private boolean verificarEstoqueDisponivel(List<ItemVenda> compra){
        boolean disponivel = true;
        for(ItemVenda pr:compra){
            if(repositorioProdutos.buscarProduto(pr.getProduto().getNome())!=null){
                if(pr.getQuantidade() > repositorioProdutos.buscarProduto(pr.getProduto().getNome()).getQuantidade()){
                    disponivel = false;
                }
            }else{
                disponivel = false;
            }
        }
        return disponivel;
    }

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

    public List<Produto> listarProdutosEmBaixoEstoque(){
        return repositorioProdutos.listarProdutosEmBaixoEstoque();
    }

    public List<Produto> listarEstoque(){
        return repositorioProdutos.listarProdutos();
    }

    public List<Venda> listarVendas(){
        return repositorioVendas.listarVendas();
    }

    public List<Venda> listarVendasPorPeriodos(LocalDateTime inic, LocalDateTime fim){
        return repositorioVendas.listarVendasPorPeriodo(inic, inic);
    }
}

