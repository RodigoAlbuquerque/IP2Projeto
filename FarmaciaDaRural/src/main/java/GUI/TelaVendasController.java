package GUI;

import java.io.File;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TelaVendasController {
       private void selecionarImagem() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar Imagem");
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
           
            String imageUrl = file.toURI().toString();
            Image imagem = new Image(imageUrl);

            // Definir a imagem no ImageView
              }
    }
}
