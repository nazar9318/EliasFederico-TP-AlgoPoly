package fiuba.algo3;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
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

        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();
        Jugador jugador = algo.jugadorActual();

        tablero.avanzarJugador(jugador, 2); //compra buenos aires sur
        tablero.avanzarJugador(jugador, 1); //compra edesur
        tablero.avanzarJugador(jugador, 1); //compra buenos aires norte

        stage.setScene(new Scene(new contenedorPrincipal(algo), 500, 500));
        stage.show();
    }
}
