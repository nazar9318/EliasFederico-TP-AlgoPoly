package fiuba.algo3.celdas.comprables;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;

public abstract class Servicio extends Barrio implements Visitable {

	protected Servicio(int precioTerreno, int alquiler) {
		super(precioTerreno, alquiler);
	}

	@Override
	public void cobrarAlquiler(Jugador jugador) {
		//TODO: redefinir con tiro de dados
	}

	public void conocer(Servicio conocida) {
		this.celdaAsociada = conocida;
	}

}