package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;

public class AvanceDinamico implements Visitable {
	
	public int calcularAvance(Jugador unJugador) {
		int resta = 2;
		int totalTiro = unJugador.pedirTiro();
		if(totalTiro <= 6) {
			return totalTiro - resta;
		}
		else if (totalTiro > 6 && totalTiro <= 10) {
			return unJugador.obtenerDinero() % totalTiro;
		}
		return totalTiro - unJugador.getCantidadDePropiedades();
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
		
}
