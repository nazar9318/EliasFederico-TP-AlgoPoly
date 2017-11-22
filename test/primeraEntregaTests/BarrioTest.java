package primeraEntregaTests;

import fiuba.algo3.celdas.comprables.BuenosAiresSur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.excepciones.BarrioConDuenioException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class BarrioTest {

	@Test (expected = BarrioConDuenioException.class)
	public void jugadorCaeEnUnBarrioYSeAdueniaDeEsteYEsElDuenioDelBarrio() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new BuenosAiresSur();
		
		unJugador.visitar(barrio);
		
		barrio.comprarBarrio(otroJugador);
	}

	@Test (expected = BarrioConDuenioException.class)
	public void jugadorVisitaYCompraTerreno(){
		Jugador jugador = new Jugador();
		Barrio barrio = new BuenosAiresSur();

		jugador.visitar(barrio);
		
		Jugador otroJugador = new Jugador();
		otroJugador.visitar(barrio);
	}

	@Test
	public void jugadorCompraTerreno() {
		Jugador jugador = new Jugador();
		Barrio barrio = new BuenosAiresSur();

		barrio.comprarBarrio(jugador);

		assertEquals(barrio.getDuenio(), jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorCompraTerrenoYNoTieneFondos() {
		Jugador jugador = new Jugador();
		jugador.pagar(100000);
		Barrio barrio = new BuenosAiresSur();

		jugador.visitar(barrio);
		//Respuesta = jugador.visitar(barrio);
		//respuesta.seleccionarOpcion(Opcion.Comprar);

		assertNull(barrio.getDuenio());
	}

	@Test
	public void barrioAgregaCeldaConocida(){

		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		Assert.assertEquals(buenosAiresNorte.getCeldaAsociada(), buenosAiresSur);
		Assert.assertEquals(buenosAiresSur.getCeldaAsociada(), buenosAiresNorte);
	}
	
	@Test
	public void  JugadorConstruyeCasaEnBuenosAires() {
		
	}
	
}