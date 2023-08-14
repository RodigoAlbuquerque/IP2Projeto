package dados;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import models.Venda;

public class RepositorioVendas implements IRepositorioVendas {
    private List<Venda> vendas;
    private static IRepositorioVendas uniqueInstance = null;

    private RepositorioVendas() {
        vendas = new ArrayList<>();
    }

    public static IRepositorioVendas getInstanceRepositorioVendas(){
        if(uniqueInstance == null){
            uniqueInstance = new RepositorioVendas();
        }
        return uniqueInstance;
    }

    @Override
    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    @Override
    public void removerVenda(Venda venda) {
        vendas.remove(venda);
    }

    @Override
    public List<Venda> listarVendas() {
        return vendas;
    }
    @Override
    public List<Venda> listarVendasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        List<Venda> vendasNoPeriodo = new ArrayList<>();

        for (Venda venda : vendas) {
            LocalDateTime dataVenda = venda.getData();
            if (dataVenda.getDayOfYear() > dataInicial.getDayOfYear() && dataVenda.getDayOfYear() < dataFinal.getDayOfYear()) {
                vendasNoPeriodo.add(venda);
            }
        }
        return vendasNoPeriodo;
    }
   
}
