package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;

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
