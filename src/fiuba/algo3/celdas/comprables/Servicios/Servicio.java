package fiuba.algo3.celdas.comprables.Servicios;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.comprables.Barrio;

public abstract class Servicio extends Barrio implements Visitable {

	protected int modificadorDeAlquiler;

	protected Servicio(int precioTerreno, int alquiler) {
		super(precioTerreno, alquiler);
	}

	@Override
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