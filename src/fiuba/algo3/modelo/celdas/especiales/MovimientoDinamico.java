package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;

public class MovimientoDinamico {
	private int tope1;
	private int tope2;
	private int tope3;
	private int tope4;
	
	public MovimientoDinamico(int tope1, int tope2, int tope3, int tope4) {
		this.tope1 = tope1;
		this.tope2 = tope2;
		this.tope3 = tope3;
		this.tope4 = tope4;
	}
	
	public int calcularMovimiento (Jugador jugador) {
		int resta = 2;
		int totalTiro = jugador.getValorDeTiro();
		if(totalTiro >= tope1 && totalTiro <= tope2) {
			return totalTiro - resta;
		}
		else if (totalTiro >= tope3 && totalTiro <= tope4) {
			return totalTiro - jugador.getCantidadDePropiedades();
		}
		return jugador.obtenerDinero() % totalTiro;
	}
}
