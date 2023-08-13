package codigofarmacia.dados;

import java.time.LocalDateTime;
import java.util.List;

import codigofarmacia.models.Venda;

public interface IRepositorioVendas {

    void adicionarVenda(Venda venda);

    void removerVenda(Venda venda);

    List<Venda> listarVendas();

    List<Venda> listarVendasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal);

}
