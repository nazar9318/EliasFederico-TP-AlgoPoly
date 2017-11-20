package testCeldas;

import static org.junit.Assert.*;
import org.junit.Test;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.Jugador;

public class Quini6Test {

	@Test
	public void jugadorCaeEnQuini6SinHaberCaidoAntesYCobraPremioDePrimeraCaida() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		
		int antesPrimeraCaida = unJugador.obtenerDinero();
		int premioPrimeraCaida = celda.obtenerPremioPrimeraCaida();
		
		celda.pagarPremioAJugador(unJugador);

		assertEquals(antesPrimeraCaida+premioPrimeraCaida, unJugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCaeEnQuini6HabiendoCaidoUnaVezAntesYCobra30000() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		
		int antesPrimeraCaida = unJugador.obtenerDinero();
		int premioPrimeraCaida = celda.obtenerPremioPrimeraCaida();
		int premioSegundaCaida = celda.obtenerPremioSegundaCaida();
		
		celda.pagarPremioAJugador(unJugador);
		celda.pagarPremioAJugador(unJugador);
		
		assertEquals(antesPrimeraCaida + premioPrimeraCaida + premioSegundaCaida, unJugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCaeEnQuini6HabiendoCaidoDosVecesYNoCobraNada() {
		Quini6 celda = new Quini6();
		Jugador unJugador = new Jugador();
		
		int antesPrimera = unJugador.obtenerDinero();
		int premioPrimera = celda.obtenerPremioPrimeraCaida();
		int premioSegunda = celda.obtenerPremioSegundaCaida();
		
		celda.pagarPremioAJugador(unJugador);
		celda.pagarPremioAJugador(unJugador);
		celda.pagarPremioAJugador(unJugador);
		
		assertEquals(antesPrimera + premioPrimera + premioSegunda, unJugador.obtenerDinero());
	}

	@Test
	public void jugadorCobraPorPrimeraVezCuandoOtroYaCobroSuPrimeraVez(){
		Quini6 celda = new Quini6();
		Jugador pablo = new Jugador();
		Jugador miguel = new Jugador();
		
		int antesPrimera = miguel.obtenerDinero();
		int premioPrimera = celda.obtenerPremioPrimeraCaida();

		celda.pagarPremioAJugador(pablo);
		celda.pagarPremioAJugador(miguel);

		assertEquals(antesPrimera + premioPrimera, miguel.obtenerDinero());
	}

	@Test
	public void jugadorCaePorTerceraVezCuandoOtroYaCobroUnaVezYNoCobraNada(){
		Quini6 celda = new Quini6();
		Jugador pablo = new Jugador();
		Jugador miguel = new Jugador();
		
		int antesPrimera = miguel.obtenerDinero();
		int premioPrimera = celda.obtenerPremioPrimeraCaida();
		int premioSegunda = celda.obtenerPremioSegundaCaida();

		celda.pagarPremioAJugador(pablo);
		celda.pagarPremioAJugador(miguel);
		celda.pagarPremioAJugador(miguel);
		celda.pagarPremioAJugador(miguel);

		assertEquals(antesPrimera + premioPrimera + premioSegunda, miguel.obtenerDinero());
	}
}
