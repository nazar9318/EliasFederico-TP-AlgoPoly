package testJuego;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;

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

    //este test a veces pasa y a veces no, eso esta mal
    /*
    @Test
    public void reiniciarJuegoDeberiaModificarElOrdenDeLosJugadores() {
    	AlgoPoly juego = new AlgoPoly();

    	juego.inicializarJuego();
    	ArrayList<Jugador> antes = new ArrayList<Jugador>();

    	for(Jugador jugador: juego.getJugadores())
    		antes.add(jugador);
		ArrayList<Jugador> despues = new ArrayList<Jugador>();

		juego.reiniciarJuego();

    	for(Jugador jugador: juego.getJugadores())
    		despues.add(jugador);

    	boolean resultado = true;
    	for (int i = 0; i < 3; i++) {
    		if (antes.get(i) != despues.get(i)) {
    			resultado = false;
    		}
    	}
    	Assert.assertFalse(resultado);
    }
*/
}
