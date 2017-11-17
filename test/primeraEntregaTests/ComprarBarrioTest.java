package primeraEntregaTests;

import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import org.junit.Test;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.excepciones.BarrioConDuenioException;

public class ComprarBarrioTest {

	@Test (expected = BarrioConDuenioException.class)
	public void jugadorVisitaYCompraTerreno(){
		Jugador jugador = new Jugador();
		Barrio barrio = new BuenosAiresSur(100000, 1500);

		jugador.visitar(barrio);
		
		Jugador otroJugador = new Jugador();
		otroJugador.visitar(barrio);
	}
}
