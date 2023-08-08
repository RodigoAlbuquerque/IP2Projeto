package codigoFarmacia.models;

import java.time.LocalDateTime;
import java.util.List;

public class Venda {
    private Funcionario funcionario;
    private Cliente cliente;
    private List<Produto> produtos;

    private LocalDateTime data;

    public Venda(Funcionario funcionario, Cliente cliente,List<Produto> produtos, LocalDateTime data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
        this.produtos = produtos;
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
   
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }



    public LocalDateTime getData() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
}
