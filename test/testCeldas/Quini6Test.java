package testCeldas;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.celdas.Celda;
import fiuba.algo3.celdas.especiales.CeldaQuini6;
import fiuba.algo3.Jugador;

public class Quini6Test {

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

	@Test
	public void jugadorCobraPorPrimeraVezCuandoOtroYaCobroSuPrimeraVez(){
		Celda celda = new CeldaQuini6();
		Jugador pablo = new Jugador();
		Jugador miguel = new Jugador();

		celda.recibirJugador(pablo);
		celda.recibirJugador(miguel);

		assertEquals(150000, miguel.obtenerDinero());
	}

	@Test
	public void jugadorCaePorTerceraVezCuandoOtroYaCobroUnaVezYNoCobraNada(){
		Celda celda = new CeldaQuini6();
		Jugador pablo = new Jugador();
		Jugador miguel = new Jugador();

		celda.recibirJugador(pablo);
		celda.recibirJugador(miguel);
		celda.recibirJugador(miguel);
		celda.recibirJugador(miguel);

		assertEquals(180000, miguel.obtenerDinero());
	}
}
