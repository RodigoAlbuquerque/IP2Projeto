package GUI;
import java.time.LocalDate;
import java.util.List;

import controle.ControladorVendas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.ComprovanteADT;
import models.ItemVenda;
import models.Venda;

public class TelaRelatorioVendasController {


    @FXML
    private TableView<ComprovanteADT> tableView;
    @FXML
    private TableColumn<ComprovanteADT, LocalDate> colData;
    @FXML
    private TableColumn<ComprovanteADT, String> colCpf;
    @FXML
    private TableColumn<ComprovanteADT, Double> colIdAcesso;
    @FXML
    private TableColumn<ComprovanteADT, Double> colValor;

    @FXML DatePicker dt;

    private ObservableList<ComprovanteADT> comprovanteList = FXCollections.observableArrayList();

    public void atualizarVendaList(ObservableList<ComprovanteADT> novaLista) {
        comprovanteList.setAll(novaLista);
    }

    public void initialize() {
        // Configurar as células das colunas
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colIdAcesso.setCellValueFactory(new PropertyValueFactory<>("idAcessFuncionario"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valorDaCompra"));
        // Configurar a TableView para usar a lista de clientes
        tableView.setItems(comprovanteList);         
    }

    @FXML
    public void voltar(){
        ScreenManager.getInstance().changeScreen(6);
    }

    @FXML
    public void listarVendas(){
        ObservableList<ComprovanteADT> listaDeVendas = FXCollections.observableArrayList();
        List<Venda> listaVendas = ControladorVendas.getInstanceControladorVendas().listarVendas();
        for (Venda venda : listaVendas) {
                String cpf = venda.getCliente().getCpf();
                Double id = venda.getFuncionario().getIdAcessoSistema();
                LocalDate dt = venda.getData();
                double valorCompra=0;
                for(ItemVenda compra: venda.getItemVenda()){
                    valorCompra += compra.getProduto().getPreco() * compra.getQuantidade();
                }
                ComprovanteADT compra = new ComprovanteADT(valorCompra, cpf, id, dt);
                listaDeVendas.add(compra);
        }
        atualizarVendaList(listaDeVendas);
    }

    @FXML
    public void listarPorDatas(){
        List<Venda> vendasNoPeriodo = ControladorVendas.getInstanceControladorVendas().listarVendasPorData(dt.getValue());
        ObservableList<ComprovanteADT> listarVendasNoPeriodo = FXCollections.observableArrayList();
        for (Venda venda : vendasNoPeriodo) {
                String cpf = venda.getCliente().getCpf();
                Double id = venda.getFuncionario().getIdAcessoSistema();
                LocalDate dt = venda.getData();
                double valorCompra=0;
                for(ItemVenda compra: venda.getItemVenda()){
                    valorCompra += compra.getProduto().getPreco() * compra.getQuantidade();
                }
                ComprovanteADT compra = new ComprovanteADT(valorCompra, cpf, id, dt);
                listarVendasNoPeriodo.add(compra);
        }
        atualizarVendaList(listarVendasNoPeriodo);
    }
       
}






