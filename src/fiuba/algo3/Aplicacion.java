package fiuba.algo3;

import java.io.File;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.vista.ContenedorBienvenidos;
import fiuba.algo3.vista.contenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	stage.setTitle("AlgoPoly");
    	stage.getIcons().add(new Image("file:src/fiuba/algo3/vista/imagenes/Monopoly.png"));
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        
        contenedorPrincipal contenedorPrincipal = new contenedorPrincipal(algo);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1050, 650);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1050, 650);
        
        String sound = "src/fiuba/algo3/vista/sonidos/sonidoInicio.mp3";
        Media sonido = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sonido);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        
        stage.setScene(escenaBienvenidos);

        stage.show();

    }
}
