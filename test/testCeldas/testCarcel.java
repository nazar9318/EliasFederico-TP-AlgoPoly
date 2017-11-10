package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Celda;
import fiuba.algo3.CeldaCarcel;
import fiuba.algo3.Jugador;
import fiuba.algo3.JugadorNoHaEstadoUnTurnoEnLaCarcel;

public class testCarcel {

	@Test (expected = JugadorNoHaEstadoUnTurnoEnLaCarcel.class)
	public void jugadorCaeEnCarcelYNoPuedeEjecutarAccion() {
		
		Celda carcel = new CeldaCarcel();
		Jugador unJugador = new Jugador();
		
		carcel.recibirJugador(unJugador);
		
		unJugador.desplazar();
	}
	
	@Test 
	public void jugadorCaeEnCarcelYNoPuedeEjecutarAccionHastaPasadoUnTurno() {
		
		Celda carcel = new CeldaCarcel();
		Jugador unJugador = new Jugador();
		
		carcel.recibirJugador(unJugador);
		
		unJugador.pasarTurno();
		
		unJugador.desplazar();
		
		assertEquals(55000, unJugador.obtenerDinero());		
	}
	
	@Test 
	public void jugadorCaeEnCarcelYSaleEnTresTurnos() {
		
		Celda carcel = new CeldaCarcel();
		Jugador unJugador = new Jugador();
		
		carcel.recibirJugador(unJugador);
		
		unJugador.pasarTurno();
		unJugador.pasarTurno();
		unJugador.pasarTurno();
		
		unJugador.desplazar();
				
	}
}
