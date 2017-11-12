package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Celda;
import fiuba.algo3.celdas.CeldaBarrio;
import fiuba.algo3.celdas.especiales.CeldaCarcel;
import fiuba.algo3.celdas.especiales.CeldaQuini6;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class TerrenoTest {

	@Test
	public void jugadorCompraTerreno() {
		Jugador jugador = new Jugador();
		CeldaBarrio barrio = new CeldaBarrio();
		barrio.setPrecioterreno(100000);
		barrio.comprarBarrio(jugador);
		assertEquals(barrio.getDuenio(),jugador);
	}
	@Test (expected = JugadorNoTieneFondosParaPagar.class)
	public void jugadorCompraTerrenoYNoTieneFondos() {
		Jugador jugador = new Jugador();
		CeldaBarrio barrio = new CeldaBarrio();
		barrio.setPrecioterreno(100001);
		barrio.comprarBarrio(jugador);
		assertEquals(barrio.getDuenio(),null);
	}

}
