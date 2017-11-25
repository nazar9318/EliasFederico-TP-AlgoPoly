package fiuba.algo3.celdas.comprables.Servicios;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.Propiedad;

public abstract class Servicio extends Propiedad implements Visitable {

	protected int modificadorDeAlquiler;

	protected Servicio(int precioTerreno, int alquiler, String nombre) {
		super(precioTerreno, alquiler, nombre);
	}

	public void cobrarAlquiler(Jugador jugador) {
		if (this.duenio.poseeALaAsociadaDe(this)){
			jugador.pagar((getAlquiler() + modificadorDeAlquiler)*jugador.getValorDeTiro());
			this.duenio.cobrar((getAlquiler() + modificadorDeAlquiler)*jugador.getValorDeTiro());
		} else{
			jugador.pagar(getAlquiler() * jugador.getValorDeTiro());
			this.duenio.cobrar(getAlquiler() * jugador.getValorDeTiro());
		}
	}

	public void conocer(Servicio conocida) {
		this.celdaAsociada = conocida;
	}

}