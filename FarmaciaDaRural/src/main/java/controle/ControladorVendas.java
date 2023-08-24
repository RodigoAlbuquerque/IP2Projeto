package controle;

import models.Produto;
import models.Venda;
import models.VendaTarja;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import dados.IRepositorioPessoas;
import dados.IRepositorioProdutos;
import dados.IRepositorioVendas;
import dados.RepositorioPessoas;
import dados.RepositorioProdutos;
import dados.RepositorioVendas;
import exceptions.CamposInvalidosException;
import models.Cliente;
import models.Funcionario;
import models.ItemVenda;

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

    public void realizarVendaComun(List<ItemVenda> compra, Funcionario vendedor,Cliente cliente) throws CamposInvalidosException{ 
        if (compra != null &&
            verificarEstoqueDisponivel(compra) &&
            repositorioPessoas.verificarCpf(vendedor.getCpf()) &&
            repositorioPessoas.verificarCpf(cliente.getCpf())) 
        {
            for (ItemVenda itemComprado : compra) {
                Produto produtoNoEstoque = repositorioProdutos.buscarProduto(itemComprado.getProduto().getNome());
                produtoNoEstoque.setQuantidade(produtoNoEstoque.getQuantidade() - itemComprado.getQuantidade());
                repositorioProdutos.atualizarProduto(produtoNoEstoque);
            }
            Venda venda = new Venda( (Funcionario) vendedor, (Cliente) cliente, compra, LocalDate.now());
            repositorioVendas.adicionarVenda(venda);   
        }
        else{
            throw new CamposInvalidosException("Preencha os campos corretamente!");
        }
    }
    public void realizarVendaControlada(List<ItemVenda> compra, Funcionario vendedor, Cliente cliente, String receita) throws CamposInvalidosException { 
        if (compra != null &&
            verificarEstoqueDisponivel(compra) && 
            repositorioPessoas.verificarCpf(vendedor.getCpf()) &&
            repositorioPessoas.verificarCpf(cliente.getCpf()) &&
            verificarCompraControlada(compra) &&
            receita != null)
        {
            for (ItemVenda itemComprado : compra) {
                Produto produtoNoEstoque = repositorioProdutos.buscarProduto(itemComprado.getProduto().getNome());
                produtoNoEstoque.setQuantidade(produtoNoEstoque.getQuantidade() - itemComprado.getQuantidade());
                repositorioProdutos.atualizarProduto(produtoNoEstoque);
            }
            Venda venda = new VendaTarja( vendedor, cliente, compra, LocalDate.now(), receita);
            repositorioVendas.adicionarVenda(venda);
        }else{
            throw new CamposInvalidosException("Preencha os campos corretamente!");
        }
    }
        
    public double calcularValorDaCompra(List<ItemVenda> compra) {
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

   public boolean verificarEstoqueDisponivel(List<ItemVenda> compra){
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

    public List<Venda> listarVendas(){
        return repositorioVendas.listarVendas();
    }

    public List<Venda> listarVendasPorData(LocalDate data){
        return repositorioVendas.listarVendasPorData(data);
    }

}

