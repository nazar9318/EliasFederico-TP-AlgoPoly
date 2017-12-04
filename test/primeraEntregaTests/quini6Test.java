package primeraEntregaTests;

import static org.junit.Assert.*;

import fiuba.algo3.modelo.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;
import org.junit.Test;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.especiales.Quini6;

public class quini6Test {

	@Test
	public void unJugadorCaeEnQuini6PorPrimeraVezYSuCapitalSeIncrementaEn50000Pesos() {
		Quini6 quini = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new BuenosAiresSur();

		unJugador.visitar(quini);
		barrio.comprar(unJugador);

		assertEquals(barrio.getDuenio(),unJugador);
	}
	
	@Test
	public void unJugadorCaeEnQuini6PorSegundaVezYSuCapitalSeIncrementaEn30000Pesos() {
		Quini6 quini = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new BuenosAiresSur();

		unJugador.visitar(quini);
		unJugador.visitar(quini);
		
		barrio.comprar(unJugador);
		
		assertEquals(barrio.getDuenio(),unJugador);
	}
	
	@Test (expected = JugadorNoCuentaConDineroSuficienteParaComprarException.class)
	public void unJugadorCaeEnQuini6PorTerceraVezYSuCapitalNoSeIncrementaMas() {
		Quini6 quini = new Quini6();
		Jugador unJugador = new Jugador();
		unJugador.pagar(100000);
		Barrio barrio = new BuenosAiresSur();
		
		unJugador.visitar(quini);
		unJugador.pagar(50000);
		unJugador.visitar(quini);
		unJugador.pagar(30000);
		unJugador.visitar(quini);
	
		barrio.comprar(unJugador);
	}
}
