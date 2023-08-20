package models;

import java.time.LocalDateTime;
import java.util.List;

public class VendaTarja extends Venda {

    private String receita;

    public VendaTarja(Funcionario funcionario, Cliente cliente, List<ItemVenda> produtos,Comprovante comp, LocalDateTime data,String receita) {
        super(funcionario, cliente, produtos, comp, data);
        this.receita = receita;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

}
