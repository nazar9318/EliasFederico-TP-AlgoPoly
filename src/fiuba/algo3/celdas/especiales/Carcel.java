package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;

public class Carcel implements Visitable {
	
	public Carcel() {
		
	}
	
	public void sacarJugador(Jugador jugador, int turnosFaltantes) {
		if (turnosFaltantes == 0) {
			jugador.salirDeLaCarcel();
		}else {
			jugador.pagar(45000);
			jugador.salirDeLaCarcel();
		}
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
}
