package GUI;

public class TelaCadastroController {
    
    public void mudarTelaParaCadastroFuncionario(){
        ScreenManager.getInstance().changeScreen(4);
    }

    public void mudarTelaParaCadastroCliente(){
        ScreenManager.getInstance().changeScreen(2);
    }

     public void mudarTelaParaCadastroProduto(){
        ScreenManager.getInstance().changeScreen(3);
    }

    public void voltar(){
        ScreenManager.getInstance().changeScreen(0);
    }
}

