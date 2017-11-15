package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;

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
