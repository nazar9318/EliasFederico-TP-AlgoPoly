package fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

	Stage stage;
    Scene proximaEscena;
    MediaPlayer sonido;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena, MediaPlayer mediaPlayer) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.sonido = mediaPlayer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	sonido.stop();
        stage.setScene(proximaEscena);
    }

}