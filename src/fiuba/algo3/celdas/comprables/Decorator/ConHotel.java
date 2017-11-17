package fiuba.algo3.celdas.comprables.Decorator;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Hotel;
import fiuba.algo3.celdas.Propiedad;

public class ConHotel extends PropiedadDecorator {

	private Hotel hotel;

	public ConHotel(Propiedad c, Hotel h) {
		super(c);
		hotel = h;
	}

	@Override
	public void cobrar(Jugador jugador){
		jugador.pagar(hotel.getAlquiler());
		super.cobrar(jugador);
	}
}

