package dados;
import java.time.LocalDate;
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
    public List<Venda> listarVendasPorData(LocalDate data){
        List<Venda> vendasNoPeriodo = new ArrayList<>();
        for(Venda ven: vendas){
            if( ven.getData().getYear() == data.getYear() &&
                ven.getData().getMonth()  == data.getMonth())
            {
                vendasNoPeriodo.add(ven);
            }
        }
        return vendasNoPeriodo;
    }
   
}
