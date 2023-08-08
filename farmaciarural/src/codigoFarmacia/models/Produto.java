package codigoFarmacia.models;

public class Produto {
    private String nome;
    private Double preco;
    private int quantidade;
    private boolean tarja;

    public Produto(String nome, Double preco, int quantidade, boolean tarja) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tarja = tarja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isTarja() {
        return tarja;
    }
    
    public void setTarja(boolean tarja) {
        this.tarja = tarja;
    }
}
