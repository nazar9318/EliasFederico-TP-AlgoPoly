package fiuba.algo3;

public class CeldaPolicia implements Celda {

	private CeldaCarcel carcel;

	public CeldaPolicia(CeldaCarcel carcel) {
		this.carcel = carcel;
	}

	@Override
	public void recibirJugador(Jugador unJugador) {
		this.carcel.recibirJugador(unJugador);
	}

}
