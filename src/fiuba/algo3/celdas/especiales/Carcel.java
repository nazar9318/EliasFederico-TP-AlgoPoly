package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcel;
import fiuba.algo3.celdas.Visitable;

import java.util.HashMap;

public class Carcel implements Visitable {
	
	private HashMap<Jugador, Integer> jugadores;
	
	public Carcel() {
		jugadores = new HashMap<>();
	}
	
	public void encarcelarJugador(Jugador jugador) {
		jugadores.put(jugador, 3);
	}

	public void reducirTurnosDeEsperaDe(Jugador jugador) {
		if(jugadores.containsKey(jugador)){
			int turnosDeEsperaActuales = jugadores.get(jugador);
			turnosDeEsperaActuales --;
			jugadores.put(jugador, turnosDeEsperaActuales);
		}
	}

	public void sacarJugador(Jugador jugador) {
		if (jugadores.containsKey(jugador)){
			if (jugadores.get(jugador) == 3){
				throw new JugadorNoPuedeSalirDeLaCarcel();
			}else if (jugadores.get(jugador) == 0) {
				jugadores.remove(jugador);
			}else {
				jugador.pagar(45000);
				jugadores.remove(jugador);
			}
		}		
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
}
