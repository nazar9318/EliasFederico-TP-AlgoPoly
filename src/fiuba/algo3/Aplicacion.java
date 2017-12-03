package fiuba.algo3;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.vista.ContenedorBienvenidos;
import fiuba.algo3.vista.contenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	stage.setTitle("AlgoPoly");
    	
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();
        Jugador jugador = algo.jugadorActual();

        tablero.avanzarJugador(jugador, 2); //compra buenos aires sur
        tablero.avanzarJugador(jugador, 1); //compra edesur
        tablero.avanzarJugador(jugador, 1); //compra buenos aires norte

        contenedorPrincipal contenedorPrincipal = new contenedorPrincipal(algo);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1050, 650);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1050, 650);


        stage.setScene(escenaBienvenidos);

        stage.show();

    }
}
