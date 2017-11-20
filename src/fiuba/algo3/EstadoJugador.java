package fiuba.algo3;

import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.Salida;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;

public interface EstadoJugador {

	void visitar(Barrio barrio, Jugador jugador);

	void visitar(Quini6 quini6, Jugador jugador);

	void visitar(Policia policia, Jugador jugador);

	void visitar(AvanceDinamico avance, Jugador jugador);

	void visitar(RetrocesoDinamico retroceso, Jugador jugador);

	void visitar(Salida salida, Jugador jugador);
	
}
