package dados;

import java.time.LocalDate;
import java.util.List;

import models.Venda;

public interface IRepositorioVendas {

    void adicionarVenda(Venda venda);

    void removerVenda(Venda venda);

    List<Venda> listarVendas();
    
    List<Venda> listarVendasPorData(LocalDate data);
}