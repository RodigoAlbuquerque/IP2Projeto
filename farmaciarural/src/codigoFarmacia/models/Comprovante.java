package codigofarmacia.models;

import java.util.List;

public class Comprovante {
    
    private List<Produto> produtosVendidos;
    private double valorDaCompra;
    private String cpf;
    private Double idAcessFuncionario;

    public Comprovante(List<Produto> produtosVendidos, double valorDaCompra,String cpf, Double idAcess) {
        this.produtosVendidos = produtosVendidos;
        this.valorDaCompra = valorDaCompra;
        this.cpf = cpf;
        this.idAcessFuncionario = idAcess;
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

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return String return the idAcessFuncionario
     */
    public Double getIdAcessFuncionario() {
        return idAcessFuncionario;
    }

    /**
     * @param idAcessFuncionario the idAcessFuncionario to set
     */
    public void setIdAcessFuncionario(Double idAcessFuncionario) {
        this.idAcessFuncionario = idAcessFuncionario;
    }

}
