package GUI;

public class MainScreenController  {

    public void mudarTelaParaCadastro(){
        ScreenManager.getInstance().changeScreen(1);
    }

    public void mudarTelaParaVendas(){
        ScreenManager.getInstance().changeScreen(2);
    }

    public void mudarTelaParaEstoque(){
        ScreenManager.getInstance().changeScreen(3);
    }

    public void mudarTelaParaRelatorios(){
        ScreenManager.getInstance().changeScreen(4);
    }

}

