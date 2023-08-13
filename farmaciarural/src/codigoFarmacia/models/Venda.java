package codigoFarmacia.models;

import java.time.LocalDateTime;
import java.util.List;

public class Venda {
    private Funcionario funcionario;
    private Cliente cliente;
    private List<ItemVenda> compra;
    private Comprovante comprovante;
    private LocalDateTime data;

    public Venda(Funcionario funcionario, Cliente cliente,List<ItemVenda> produtos,Comprovante comp, LocalDateTime data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
        this.comprovante = comp;
        this.compra = produtos;
    }

    public Comprovante getComprovante() {
        return comprovante;
    }

    public void setComprovante(Comprovante comprovante) {
        this.comprovante = comprovante;
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



    public LocalDateTime getData() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
}
