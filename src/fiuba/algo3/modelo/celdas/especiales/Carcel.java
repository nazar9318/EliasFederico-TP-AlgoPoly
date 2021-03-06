package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;

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
