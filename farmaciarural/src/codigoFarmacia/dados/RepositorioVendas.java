package codigoFarmacia.dados;
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
    
    public List<Venda> listarVendasPorPeriodo(Date dataInicial, Date dataFinal) {
        List<Venda> vendasNoPeriodo = new ArrayList<>();

        for (Venda venda : vendas) {
            Date dataVenda = venda.getData();
            if (dataVenda.after(dataInicial) && dataVenda.before(dataFinal)) {
                vendasNoPeriodo.add(venda);
            }
        }
        return vendasNoPeriodo;
    }
}
