package primeraEntregaTests;

import static org.junit.Assert.*;
import org.junit.Test;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Barrio;
import fiuba.algo3.excepciones.BarrioConDuenioException;

public class BarrioTest {

	@Test (expected = BarrioConDuenioException.class)
	public void jugadorCaeEnUnBarrioYSeAdueniaDeEsteYEsElDuenioDelBarrio() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new Barrio();
		
		unJugador.visitar(barrio);
		
		barrio.comprarBarrio(otroJugador);
	}

}
