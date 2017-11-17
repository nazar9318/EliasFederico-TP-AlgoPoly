package testCeldas;

import static org.junit.Assert.*;

import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class TerrenoTest {

	@Test
	public void jugadorCompraTerreno() {
		Jugador jugador = new Jugador();
		Barrio barrio = new BuenosAiresSur(100000, 100);

		barrio.comprarBarrio(jugador);

		assertEquals(barrio.getDuenio(), jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorCompraTerrenoYNoTieneFondos() {
		Jugador jugador = new Jugador();
		Barrio barrio = new BuenosAiresSur(100001, 240);

		jugador.visitar(barrio);
		//Respuesta = jugador.visitar(barrio);
		//respuesta.seleccionarOpcion(Opcion.Comprar);

		assertNull(barrio.getDuenio());
	}

	@Test
	public void barrioAgregaCeldaConocida(){

		Barrio buenosAiresNorte = new BuenosAiresNorte(25000, 2500);
		Barrio buenosAiresSur = new BuenosAiresSur(20000, 2000);

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		Assert.assertEquals(buenosAiresNorte.getCeldaAsociada(), buenosAiresSur);
		Assert.assertEquals(buenosAiresSur.getCeldaAsociada(), buenosAiresNorte);
	}
}
