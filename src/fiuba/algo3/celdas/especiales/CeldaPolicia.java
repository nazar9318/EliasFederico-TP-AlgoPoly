package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Celda;


//TODO: revisar clase con nueva funcionalidad
public class CeldaPolicia implements Celda {

	private CeldaCarcel carcel;

	public CeldaPolicia(CeldaCarcel carcel) {
		this.carcel = carcel;
	}

	@Override
	public void accionDeCelda(Tablero tablero, Jugador unJugador) {
		this.carcel.accionDeCelda(tablero, unJugador);
	}
}
