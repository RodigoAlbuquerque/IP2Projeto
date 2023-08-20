package GUI;

public class TelaRelatoriosController {
    
    public void mudarTelaParaRelatorioFuncionarios(){
        ScreenManager.getInstance().changeScreen(9);
    }

    public void mudarTelaParaRelatorioClientes(){
        ScreenManager.getInstance().changeScreen(8);
    }

     public void mudarTelaParaRelatorioVendas(){
        ScreenManager.getInstance().changeScreen(10);
    }

    public void voltar(){
        ScreenManager.getInstance().changeScreen(0);
    }
}
