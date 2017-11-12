package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Celda;

import java.util.HashMap;


//TODO: revisar clase con nueva funcionalidad
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
	public void accionDeCelda(Tablero tablero, Jugador unJugador) {
		if (primeraCaida(unJugador)) {
			jugadores.put(unJugador, 1);
			unJugador.cobrar(50000);
			return;
		}
		cobrarCaidaRepetida(unJugador);
	}

}
