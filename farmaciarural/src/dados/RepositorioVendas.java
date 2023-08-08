import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVendas {
    private List<Venda> vendas;
    private static RepositorioVendas uniqueInstance = null;

    private RepositorioVendas() {
        vendas = new ArrayList<>();
    }

    public static RepositorioVendas getInstanceRepositorioVendas(){
        if(uniqueInstance == null){
            uniqueInstance = new RepositorioVendas();
        }
        return uniqueInstance;
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void removerVenda(Venda venda) {
        vendas.remove(venda);
    }

    public List<Venda> listarVendas() {
        return vendas;
    }
    public List<Venda> listarVendasEmPeriodo(LocalDateTime inic, LocalDateTime fim){

    }
}
