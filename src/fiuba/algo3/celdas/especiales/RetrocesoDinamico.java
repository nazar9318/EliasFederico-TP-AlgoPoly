package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;

public class RetrocesoDinamico implements Visitable {

	public int calcularRetroceso(Jugador unJugador, Dado dado1, Dado dado2) {
		int resta = 2;
		int totalTiro = dado1.getValor() + dado2.getValor();
		if(totalTiro <= 6) {
			return totalTiro - unJugador.getCantidadDePropiedades();
		}
		else if (totalTiro > 6 && totalTiro <= 10) {
			return unJugador.obtenerDinero() % totalTiro;
		}
		return totalTiro - resta;
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
	
}
