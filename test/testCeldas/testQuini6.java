package testCeldas;
import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Celda;
import fiuba.algo3.CeldaQuini6;
import fiuba.algo3.Jugador;

public class testQuini6 {

	@Test
	public void jugadorCaeEnQuini6SinHaberCaidoAntesYCobra50000() {
		Celda celda = new CeldaQuini6();
		Jugador unJugador = new Jugador();
		
		celda.recibirJugador(unJugador);
		
		assertEquals(150000, unJugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCaeEnQuini6HabiendoCaidoUnaVezAntesYCobra30000() {
		Celda celda = new CeldaQuini6();
		Jugador unJugador = new Jugador();
		
		celda.recibirJugador(unJugador);
		celda.recibirJugador(unJugador);
		
		assertEquals(180000, unJugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCaeEnQuini6HabiendoCaidoDosVecesYNoCobraNada() {
		Celda celda = new CeldaQuini6();
		Jugador unJugador = new Jugador();
		
		celda.recibirJugador(unJugador);
		celda.recibirJugador(unJugador);
		celda.recibirJugador(unJugador);
		
		assertEquals(180000, unJugador.obtenerDinero());
	}

}
