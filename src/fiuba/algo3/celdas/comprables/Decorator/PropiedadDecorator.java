package fiuba.algo3.celdas.comprables.Decorator;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Propiedad;

public class PropiedadDecorator implements Propiedad {

	protected Propiedad item;
	
	public PropiedadDecorator(Propiedad c){
		this.item=c;
	}

	@Override
	public void cobrar(Jugador jugador) {
		this.item.cobrar(jugador);
	}
}
