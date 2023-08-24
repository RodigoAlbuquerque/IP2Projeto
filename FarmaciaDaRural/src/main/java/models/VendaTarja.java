package models;

import java.time.LocalDate;
import java.util.List;

public class VendaTarja extends Venda {

    private String receita;

    public VendaTarja(Funcionario funcionario, Cliente cliente, List<ItemVenda> produtos, LocalDate data,String receita) {
        super(funcionario, cliente, produtos, data);
        this.receita = receita;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

}
