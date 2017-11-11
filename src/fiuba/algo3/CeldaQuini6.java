package fiuba.algo3;

import java.util.HashMap;


public class CeldaQuini6 implements Celda {
	
	private HashMap<Jugador, Integer> jugadores;

	public CeldaQuini6() {
		jugadores = new HashMap<>();
	}

	private boolean primeraCaida(Jugador unJugador){
		return !this.jugadores.containsKey(unJugador);
	}

	private boolean segundaCaida(Jugador unJugador){
		return (this.jugadores.get(unJugador) == 1);
	}

	private void cobrarCaidaRepetida(Jugador unJugador){
		if(segundaCaida(unJugador)) {
			sumarCaida(unJugador);
			unJugador.cobrar(30000);
			return;
		}
		unJugador.cobrar(0);
	}

	private void sumarCaida(Jugador unJugador) {
		this.jugadores.put(unJugador, 2);
	}

	@Override
	public void recibirJugador(Jugador unJugador) {
		if (primeraCaida(unJugador)) {
			jugadores.put(unJugador, 1);
			unJugador.cobrar(50000);
			return;
		}
		cobrarCaidaRepetida(unJugador);
	}

}
