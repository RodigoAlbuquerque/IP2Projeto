package models;

import java.time.LocalDate;
import java.util.List;

public class Venda {
    private Funcionario funcionario;
    private Cliente cliente;
    private List<ItemVenda> compra;
    private LocalDate data;

    public Venda(Funcionario funcionario, Cliente cliente,List<ItemVenda> produtos, LocalDate data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
        this.compra = produtos;
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
   
    public List<ItemVenda> getItemVenda() {
        return compra;
    }

    public void setItemVenda(List<ItemVenda> produtos) {
        this.compra = produtos;
    }



    public LocalDate getData() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
