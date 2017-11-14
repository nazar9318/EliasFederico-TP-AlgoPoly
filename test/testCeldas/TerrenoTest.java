package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.BarrioConDuenioException;
import fiuba.algo3.celdas.Barrio;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class TerrenoTest {

	@Test
	public void jugadorCompraTerreno() {
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();
		barrio.setPrecioterreno(100000);
		barrio.comprarBarrio(jugador);
		assertEquals(barrio.getDuenio(),jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagar.class)
	public void jugadorCompraTerrenoYNoTieneFondos() {
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();
		barrio.setPrecioterreno(100001);
		barrio.comprarBarrio(jugador);
		assertEquals(barrio.getDuenio(),null);
	}
	
	@Test (expected = BarrioConDuenioException.class)
	public void jugadorVisitaYCompraTerreno(){
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();
		barrio.setPrecioterreno(100000);
		jugador.visitar(barrio);
		
		Jugador otroJugador = new Jugador();
		otroJugador.comprarBarrio(barrio);
	}

}
