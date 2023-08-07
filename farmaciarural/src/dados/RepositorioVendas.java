import java.util.ArrayList;
import java.util.List;

public class RepositorioVendas {
    private List<Venda> vendas;

    public RepositorioVendas() {
        vendas = new ArrayList<>();
    }

    public void cadastrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void removerVenda(Venda venda) {
        vendas.remove(venda);
    }

    public List<Venda> listarVendas() {
        return vendas;
    }
}
