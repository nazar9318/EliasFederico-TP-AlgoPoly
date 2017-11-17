package fiuba.algo3.celdas.comprables.Decorator;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Propiedad;

public class ConCasa extends PropiedadDecorator {

	private Casa casa;

	public ConCasa(Propiedad c, Casa agregarcasa) {
		super(c);
		casa = agregarcasa;
	}

	@Override
	public void cobrar(Jugador jugador){
		jugador.pagar(casa.getAlquiler());
		super.cobrar(jugador);
	}
}
