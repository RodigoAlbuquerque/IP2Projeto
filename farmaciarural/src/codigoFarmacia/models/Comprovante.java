package codigoFarmacia.models;

import java.util.List;

public class Comprovante {
    
    private List<Produto> produtosVendidos;
    private double valorDaCompra;

    public Comprovante(List<Produto> produtosVendidos, double valorDaCompra) {
        this.produtosVendidos = produtosVendidos;
        this.valorDaCompra = valorDaCompra;
    }

  public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<Produto> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public double getValorDaCompra() {
        return valorDaCompra;
    }
    
    public void setValorDaCompra(double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }
}
