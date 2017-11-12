package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Celda;

public class CeldaPolicia implements Celda {

	private CeldaCarcel carcel;

	public CeldaPolicia(CeldaCarcel carcel) {
		this.carcel = carcel;
	}

	@Override
	public void recibirJugador(Tablero tablero, Jugador unJugador) {
		this.carcel.recibirJugador(tablero, unJugador);
	}

	@Override
	public void sacarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

}
