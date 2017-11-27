package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;

public class Policia implements Visitable {

	private Carcel carcel;

	public Policia(Carcel carcel) {
		this.carcel = carcel;
	}
		
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(carcel);
	}

}
