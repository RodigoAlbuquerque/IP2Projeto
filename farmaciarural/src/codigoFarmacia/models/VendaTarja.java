package codigoFarmacia.models;

import java.time.LocalDateTime;
import java.util.List;

public class VendaTarja extends Venda {

    public VendaTarja(Funcionario funcionario, Cliente cliente, Produto produto, LocalDateTime data) {
        super(funcionario, cliente, produto, data);
        
    }

    private List<byte[]> receita;

    public List<byte[]> getReceita() {
        return receita;
    }

    public void setReceita(List<byte[]> receita) {
        this.receita = receita;
    }

}
