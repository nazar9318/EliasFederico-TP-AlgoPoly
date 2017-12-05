package fiuba.algo3.modelo;

import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.especiales.AvanceDinamico;
import fiuba.algo3.modelo.celdas.especiales.Policia;
import fiuba.algo3.modelo.celdas.especiales.Quini6;
import fiuba.algo3.modelo.celdas.especiales.RetrocesoDinamico;

public interface EstadoJugador {

	void visitar(Propiedad propiedad, Jugador jugador);

	void visitar(Quini6 quini6, Jugador jugador);

	void visitar(Policia policia, Jugador jugador);

	void visitar(AvanceDinamico avance, Jugador jugador);

	void visitar(RetrocesoDinamico retroceso, Jugador jugador);

	void visitar(Salida salida, Jugador jugador);

	Visitable reUbicarse(Jugador jugador, Tablero tablero, int index, int avance);

	void construir(Jugador jugador, Barrio barrio);
	
}
