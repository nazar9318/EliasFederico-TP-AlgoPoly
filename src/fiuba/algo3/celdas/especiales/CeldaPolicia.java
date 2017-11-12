package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Celda;
import fiuba.algo3.celdas.especiales.CeldaCarcel;

public class CeldaPolicia implements Celda {

	private CeldaCarcel carcel;

	public CeldaPolicia(CeldaCarcel carcel) {
		this.carcel = carcel;
	}

	@Override
	public void recibirJugador(Jugador unJugador) {
		this.carcel.recibirJugador(unJugador);
	}

	@Override
	public void sacarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

}
