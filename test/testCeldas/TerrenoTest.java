package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Barrio;
import fiuba.algo3.excepciones.BarrioConDuenioException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class TerrenoTest {

	@Test
	public void jugadorCompraTerreno() {
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();

		barrio.setPrecioTerreno(100000);
		barrio.comprarBarrio(jugador);

		assertEquals(barrio.getDuenio(), jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorCompraTerrenoYNoTieneFondos() {
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();

		barrio.setPrecioTerreno(100001);
		jugador.visitar(barrio);

		assertNull(barrio.getDuenio());
	}
}
