package GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ScreenManager controladorTelas = ScreenManager.getInstance();
        controladorTelas.changeScreen(0);
        controladorTelas.getPrimaryStage().show();
    }

    public static void main(String[] args) {
        launch();
    }
}