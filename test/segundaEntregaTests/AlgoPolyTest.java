package segundaEntregaTests;

import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.AlgoPoly;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;

public class AlgoPolyTest {

    @Test
    public void tableroSeIniciaConPropiedadesYUnJugadorCompra(){
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();

        Jugador jugador = tablero.agregarJugador(new Jugador());

        Propiedad nueva = (Propiedad) tablero.avanzarJugador(jugador, 2);
        nueva.comprar(jugador);

        Assert.assertEquals(jugador.getCantidadDePropiedades(), 1);
    }

    @Test
    public void inicializarJuegoDeberiaCrearUnTableroCon20Celdas() {
    	AlgoPoly juego = new AlgoPoly();
    	juego.inicializarJuego();
    	Tablero tablero = juego.getTablero();
    	Assert.assertEquals(20, tablero.getCantidadDeCeldas());
    }
    
    @Test
    public void inicializarJuegoDeberiaAgregar3Jugadores() {
    	AlgoPoly juego = new AlgoPoly();
    	juego.inicializarJuego();
    	Assert.assertEquals(3, juego.getCantidadDeJugadores());
    }
}
