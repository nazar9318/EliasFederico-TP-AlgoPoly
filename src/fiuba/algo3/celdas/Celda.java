package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;

public interface Celda {

	void recibirJugador(Tablero tablero, Jugador unJugador);
	
	void sacarJugador(Jugador jugador);

}
