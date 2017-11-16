package primeraEntregaTests;

import org.junit.Test;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Barrio;
import fiuba.algo3.excepciones.BarrioConDuenioException;

public class ComprarBarrioTest {

	@Test (expected = BarrioConDuenioException.class)
	public void jugadorVisitaYCompraTerreno(){
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();

		barrio.setPrecioTerreno(100000);
		jugador.visitar(barrio);
		
		Jugador otroJugador = new Jugador();
		otroJugador.visitar(barrio);
	}

}
