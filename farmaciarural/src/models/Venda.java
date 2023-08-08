package models;

import java.time.LocalDateTime;

public class Venda {
    private Funcionario funcionario;
    private Cliente cliente;
    private Produto produto;
    private LocalDateTime data;

    public Venda(Funcionario funcionario, Cliente cliente, Produto produto, LocalDateTime data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.produto = produto;
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
   
    public LocalDateTime getData() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
}
