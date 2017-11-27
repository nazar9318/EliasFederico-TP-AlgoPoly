package segundaEntregaTests;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AlgoPolyTest {

    @Test
    public void tableroSeIniciaConPropiedadesYUnJugadorCompra(){
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();

        Jugador jugador = tablero.agregarJugador(new Jugador());
        tablero.avanzarJugador(jugador, 2);

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
    
    @Test
	public void comenzarJuegoDeberiaPararCuandoSoloQuedeUnUnicoJugadorGanador() {
		AlgoPoly juego = new AlgoPoly();
		int CantidadInicial = juego.getCantidadDeJugadores();
		juego.inicializarJuego();
		juego.comenzarJuego();
		assertEquals(CantidadInicial +1,juego.getCantidadDeJugadores());
	}
   
}
