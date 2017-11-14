package primeraEntregaTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Barrio;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.excepciones.FondoInsuficienteParaComprar;

public class quini6Test {

	@Test
	public void unJugadorCaeEnQuini6PorPrimeraVezYSuCapitalSeIncrementaEn50000Pesos() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new Barrio();
		barrio.setPrecioTerreno(150000);
		
		unJugador.visitar(celda);
		
		unJugador.visitar(barrio);
		
		assertEquals(barrio.getDuenio(),unJugador);
	}
	
	@Test
	public void unJugadorCaeEnQuini6PorSegundaVezYSuCapitalSeIncrementaEn30000Pesos() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new Barrio();
		barrio.setPrecioTerreno(180000);
		
		unJugador.visitar(celda);
		unJugador.visitar(celda);
		
		unJugador.visitar(barrio);
		
		assertEquals(barrio.getDuenio(),unJugador);
	}
	
	@Test (expected = FondoInsuficienteParaComprar.class)
	public void unJugadorCaeEnQuini6PorTerceraVezYSuCapitalNoSeIncrementaMas() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		Barrio barrio = new Barrio();
		barrio.setPrecioTerreno(200000);
		
		unJugador.visitar(celda);
		unJugador.visitar(celda);
		unJugador.visitar(celda);
		
		unJugador.visitar(barrio);
	}
}
