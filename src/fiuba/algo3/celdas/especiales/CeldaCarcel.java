package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcel;
import fiuba.algo3.celdas.Celda;

import java.util.HashMap;

public class CeldaCarcel implements Celda {
	
	private HashMap<Jugador, Integer> jugadores;
	
	public CeldaCarcel() {
		jugadores = new HashMap<>();
	}
	
	@Override
	public void recibirJugador(Jugador jugador) {
		jugadores.put(jugador, 3);
	}

	public void reducirTurnosDeEsperaDe(Jugador jugador) {
		if(jugadores.containsKey(jugador)){
			int turnosDeEsperaActuales = jugadores.get(jugador);
			turnosDeEsperaActuales --;
			jugadores.put(jugador, turnosDeEsperaActuales);
		}
	}

	@Override
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

}
