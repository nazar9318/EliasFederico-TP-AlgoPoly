package primeraEntregaTests;

import static org.junit.Assert.*;

import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;
import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.especiales.Quini6;

public class quini6Test {

	@Test
	public void unJugadorCaeEnQuini6PorPrimeraVezYSuCapitalSeIncrementaEn50000Pesos() {
		Quini6 quini = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new BuenosAiresSur(150000, 100);

		unJugador.visitar(quini);
		unJugador.visitar(barrio);
		
		assertEquals(barrio.getDuenio(),unJugador);
	}
	
	@Test
	public void unJugadorCaeEnQuini6PorSegundaVezYSuCapitalSeIncrementaEn30000Pesos() {
		Quini6 quini = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new BuenosAiresSur(180000, 120);

		unJugador.visitar(quini);
		unJugador.visitar(quini);
		
		unJugador.visitar(barrio);
		
		assertEquals(barrio.getDuenio(),unJugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void unJugadorCaeEnQuini6PorTerceraVezYSuCapitalNoSeIncrementaMas() {
		Quini6 quini = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new BuenosAiresSur(200000, 250);
		
		unJugador.visitar(quini);
		unJugador.visitar(quini);
		unJugador.visitar(quini);
		
		unJugador.visitar(barrio);
	}
}
