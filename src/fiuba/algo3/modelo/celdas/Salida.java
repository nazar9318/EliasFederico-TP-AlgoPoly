package fiuba.algo3.modelo.celdas;

import fiuba.algo3.modelo.Jugador;

public class Salida implements Visitable{
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
}
