package testCeldas;

import static org.junit.Assert.*;
import org.junit.Test;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.Jugador;

public class Quini6Test {

	@Test
	public void jugadorCaeEnQuini6SinHaberCaidoAntesYCobra50000() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		
		celda.pagarPremioAJugador(unJugador);

		assertEquals(150000, unJugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCaeEnQuini6HabiendoCaidoUnaVezAntesYCobra30000() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		
		celda.pagarPremioAJugador(unJugador);
		celda.pagarPremioAJugador(unJugador);
		
		assertEquals(180000, unJugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCaeEnQuini6HabiendoCaidoDosVecesYNoCobraNada() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		
		celda.pagarPremioAJugador(unJugador);
		celda.pagarPremioAJugador(unJugador);
		celda.pagarPremioAJugador(unJugador);
		
		assertEquals(180000, unJugador.obtenerDinero());
	}

	@Test
	public void jugadorCobraPorPrimeraVezCuandoOtroYaCobroSuPrimeraVez(){
		Quini6 celda = new Quini6();
		Jugador pablo = new Jugador();
		Jugador miguel = new Jugador();

		celda.pagarPremioAJugador(pablo);
		celda.pagarPremioAJugador(miguel);

		assertEquals(150000, miguel.obtenerDinero());
	}

	@Test
	public void jugadorCaePorTerceraVezCuandoOtroYaCobroUnaVezYNoCobraNada(){
		Quini6 celda = new Quini6();
		Jugador pablo = new Jugador();
		Jugador miguel = new Jugador();

		celda.pagarPremioAJugador(pablo);
		celda.pagarPremioAJugador(miguel);
		celda.pagarPremioAJugador(miguel);
		celda.pagarPremioAJugador(miguel);

		assertEquals(180000, miguel.obtenerDinero());
	}
}
