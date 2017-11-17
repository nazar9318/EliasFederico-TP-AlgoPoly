package primeraEntregaTests;

import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import org.junit.Test;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.excepciones.BarrioConDuenioException;

public class BarrioTest {

	@Test (expected = BarrioConDuenioException.class)
	public void jugadorCaeEnUnBarrioYSeAdueniaDeEsteYEsElDuenioDelBarrio() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new BuenosAiresSur(5000, 15);
		
		unJugador.visitar(barrio);
		
		barrio.comprarBarrio(otroJugador);
	}

}
