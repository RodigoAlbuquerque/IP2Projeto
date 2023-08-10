package codigoFarmacia.dados;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import codigoFarmacia.models.Venda;

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
    public List<Venda> listarVendasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        List<Venda> vendasNoPeriodo = new ArrayList<>();

        for (Venda venda : vendas) {
            LocalDateTime dataVenda = venda.getData();
            if (dataVenda.isAfter(dataInicial) && dataVenda.isBefore(dataFinal)) {
                vendasNoPeriodo.add(venda);
            }
        }
        return vendasNoPeriodo;
    }
}
