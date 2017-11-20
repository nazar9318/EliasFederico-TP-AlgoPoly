package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.celdas.Visitable;

import java.util.HashMap;

public class Carcel implements Visitable {
	
	public Carcel() {
		
	}
	
	/*public void encarcelarJugador(Jugador jugador) {
		jugadores.put(jugador, 3);
	}

	public void reducirTurnosDeEsperaDe(Jugador jugador) {
		if(jugadores.containsKey(jugador)){
			int turnosDeEsperaActuales = jugadores.get(jugador);
			turnosDeEsperaActuales --;
			jugadores.put(jugador, turnosDeEsperaActuales);
		}
	}*/

	public void sacarJugador(Jugador jugador, int turnosFaltantes) {
		if (turnosFaltantes == 0) {
			jugador.salirDeLaCarcel();
		}else {
			jugador.pagar(45000);
			jugador.salirDeLaCarcel();
		}
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
}
