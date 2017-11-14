package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;

public class Salida implements Visitable{
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}

}
