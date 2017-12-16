package fiuba.algo3.vista;

import fiuba.algo3.modelo.AlgoPoly;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(algo);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1020, 650);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1050, 650);

        
        stage.setScene(escenaBienvenidos);
        stage.show();
    }
}
