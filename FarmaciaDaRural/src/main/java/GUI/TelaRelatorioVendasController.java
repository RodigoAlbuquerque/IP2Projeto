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
import models.ComprovanteDTO;
import models.ItemVenda;
import models.Venda;

public class TelaRelatorioVendasController {


    @FXML
    private TableView<ComprovanteDTO> tableView;
    @FXML
    private TableColumn<ComprovanteDTO, LocalDate> colData;
    @FXML
    private TableColumn<ComprovanteDTO, String> colCpf;
    @FXML
    private TableColumn<ComprovanteDTO, Double> colIdAcesso;
    @FXML
    private TableColumn<ComprovanteDTO, Double> colValor;

    @FXML DatePicker dt;

    private ObservableList<ComprovanteDTO> comprovanteList = FXCollections.observableArrayList();

    public void atualizarVendaList(ObservableList<ComprovanteDTO> novaLista) {
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
        ObservableList<ComprovanteDTO> listaDeVendas = FXCollections.observableArrayList();
        List<Venda> listaVendas = ControladorVendas.getInstanceControladorVendas().listarVendas();
        for (Venda venda : listaVendas) {
                String cpf = venda.getCliente().getCpf();
                Double id = venda.getFuncionario().getIdAcessoSistema();
                LocalDate dt = venda.getData();
                double valorCompra=0;
                if(venda.getCliente().isPremium()){
                    for(ItemVenda compra: venda.getItemVenda()){
                        valorCompra += compra.getProduto().getPreco() *0.5 * compra.getQuantidade();
                    }
                }else{
                     for(ItemVenda compra: venda.getItemVenda()){
                        valorCompra += compra.getProduto().getPreco() * compra.getQuantidade();
                    }
                }
                ComprovanteDTO compra = new ComprovanteDTO(valorCompra, cpf, id, dt);
                listaDeVendas.add(compra);
        }
        atualizarVendaList(listaDeVendas);
    }

    @FXML
    public void listarPorDatas(){
        List<Venda> vendasNoPeriodo = ControladorVendas.getInstanceControladorVendas().listarVendasPorData(dt.getValue());
        ObservableList<ComprovanteDTO> listarVendasNoPeriodo = FXCollections.observableArrayList();
        for (Venda venda : vendasNoPeriodo) {
                String cpf = venda.getCliente().getCpf();
                Double id = venda.getFuncionario().getIdAcessoSistema();
                LocalDate dt = venda.getData();
                double valorCompra=0;
                if(venda.getCliente().isPremium()){
                    for(ItemVenda compra: venda.getItemVenda()){
                        valorCompra += compra.getProduto().getPreco() *0.5 * compra.getQuantidade();
                    }
                }else{
                     for(ItemVenda compra: venda.getItemVenda()){
                        valorCompra += compra.getProduto().getPreco() * compra.getQuantidade();
                    }
                }
                ComprovanteDTO compra = new ComprovanteDTO(valorCompra, cpf, id, dt);
                listarVendasNoPeriodo.add(compra);
        }
        atualizarVendaList(listarVendasNoPeriodo);
    }
       
}






