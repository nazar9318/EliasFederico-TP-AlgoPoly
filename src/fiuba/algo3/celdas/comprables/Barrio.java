package fiuba.algo3.celdas.comprables;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;

public abstract class Barrio extends Propiedad implements Visitable {

	protected Barrio(int precioTerreno, int alquiler, String nombre) {
		super(precioTerreno, alquiler, nombre);
	}
	
	public void cobrarAlquiler(Jugador jugador) {
		jugador.pagar(getAlquiler());
		this.duenio.cobrar(getAlquiler());
	}

}