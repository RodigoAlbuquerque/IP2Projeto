package models;

import java.time.LocalDateTime;
import java.util.List;

public class VendaTarja extends Venda {

    private List<byte[]> receita;

    public VendaTarja(Funcionario funcionario, Cliente cliente, List<ItemVenda> produtos,Comprovante comp, LocalDateTime data,List<byte[]>receita) {
        super(funcionario, cliente, produtos, comp, data);
        this.receita = receita;
    }

    public List<byte[]> getReceita() {
        return receita;
    }

    public void setReceita(List<byte[]> receita) {
        this.receita = receita;
    }

}
