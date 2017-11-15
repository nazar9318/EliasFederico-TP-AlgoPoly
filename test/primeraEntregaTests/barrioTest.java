package primeraEntregaTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Barrio;

public class barrioTest {

	@Test
	public void jugadorCaeEnUnBarrioYSeAdueñaDeElDeberiaDevolverAlJugadorComoDueñoDelBarrio() {
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();

		jugador.visitar(barrio);

		assertEquals(barrio.getDuenio(), jugador);
	}
	
}
