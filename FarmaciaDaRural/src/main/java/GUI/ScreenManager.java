package GUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {

    private static ScreenManager instance;
    private Stage primaryStage;

    private  Scene mainScene;
    private MainScreenController mainScreenController;

    private  Scene sceneCadastros;
    private TelaCadastroController telaCadastroController;

    private Scene sceneEstoque;

    private Scene sceneCadastroFuncionario;

    private Scene sceneCadastroProduto;

    private Scene sceneCadastroCliente;

    private  Scene sceneVendas;

    private Scene sceneRelatorios;

    private Scene sceneRelatorioClientes;

    private Scene sceneRelatorioFuncionarios;

    private ScreenManager(){
        this.initialize();
    }
    

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    private void initialize(){
        try{
            primaryStage = new Stage();

            FXMLLoader cadFunc = new FXMLLoader(getClass().getResource("telaCadastroFuncionario.fxml"));
            Parent telaCadFunc = cadFunc.load();
            sceneCadastroFuncionario = new Scene(telaCadFunc,600,400);

            FXMLLoader cadProd = new FXMLLoader(getClass().getResource("telaCadastroProduto.fxml"));
            Parent telaCadProd = cadProd.load();
            sceneCadastroProduto = new Scene(telaCadProd,600,400);

            FXMLLoader cadCliente = new FXMLLoader(getClass().getResource("telaCadastroCliente.fxml"));
            Parent telaCadCliente = cadCliente.load();
            sceneCadastroCliente = new Scene(telaCadCliente,600,400);

            FXMLLoader telaPrincipal = new FXMLLoader(getClass().getResource("telaInicial.fxml"));
            Parent parentTelaPrincipal = telaPrincipal.load();
            mainScene = new Scene(parentTelaPrincipal, 600 , 400);

            FXMLLoader telaCadastro = new FXMLLoader(getClass().getResource("cadastros.fxml"));
            Parent parentTelaCadastro = telaCadastro.load();
            sceneCadastros = new Scene(parentTelaCadastro, 600 , 400);

            FXMLLoader telaVendas = new FXMLLoader(getClass().getResource("telaVendas.fxml"));
            Parent parentTelaVendas = telaVendas.load();
            sceneVendas = new Scene(parentTelaVendas, 600 , 400);

            FXMLLoader telaRelatorios = new FXMLLoader(getClass().getResource("telaRelatorios.fxml"));
            Parent parentTelaRelatorios = telaRelatorios.load();
            sceneRelatorios = new Scene(parentTelaRelatorios, 600 , 400);

            FXMLLoader telaEstoque = new FXMLLoader(getClass().getResource("telaEstoque.fxml"));
            Parent parentTelaEstoque = telaEstoque.load();
            sceneEstoque = new Scene(parentTelaEstoque, 600 , 400);

            FXMLLoader telaRelatorioClientes = new FXMLLoader(getClass().getResource("telaRelatorioClientes.fxml"));
            Parent parentTelaRelatorioClientes = telaRelatorioClientes.load();
            sceneRelatorioClientes = new Scene(parentTelaRelatorioClientes,600,400);

            FXMLLoader telaRelatorioFuncionarios = new FXMLLoader(getClass().getResource("telaRelatorioFuncionarios.fxml"));
            Parent parentTelaRelatorioFuncionarios = telaRelatorioFuncionarios.load();
            sceneRelatorioFuncionarios = new Scene(parentTelaRelatorioFuncionarios, 600 , 400);

        }
        catch(IOException e ){
            e.printStackTrace();
        }
    }
    
    public void changeScreen(int opcao){
        switch(opcao){
            case 0:
                primaryStage.setScene(mainScene);
                break;
            case 1:
                primaryStage.setScene(sceneCadastros);
                break;
            case 2:
                primaryStage.setScene(sceneCadastroCliente);
                break;
            case 3:
                primaryStage.setScene(sceneCadastroProduto);
                break;
            case 4:
                primaryStage.setScene(sceneCadastroFuncionario);
                break;
            case 5:
                primaryStage.setScene(sceneVendas);
                break;
            case 6:
                primaryStage.setScene(sceneRelatorios);
                break;
            case 7:
                primaryStage.setScene(sceneEstoque);
                break;
            case 8:
                primaryStage.setScene(sceneRelatorioClientes);
                break;
            case 9:
                primaryStage.setScene(sceneRelatorioFuncionarios);
                break;

            default:
                primaryStage.setScene(mainScene);
                break;
             
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public MainScreenController getMainScreenController() {
        return mainScreenController;
    }

    public Scene getSceneCadastros() {
        return sceneCadastros;
    }

    public TelaCadastroController getTelaCadastroController() {
        return telaCadastroController;
    }

    public Scene getSceneVendas() {
        return sceneVendas;
    }

   
}

