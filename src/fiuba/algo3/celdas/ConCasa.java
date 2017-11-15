package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;

public class ConCasa extends PropiedadDecorator {

	private  Casa casa;

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
