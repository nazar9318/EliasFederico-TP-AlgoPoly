package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;

public class ImpuestoDeLujo implements Visitable {
	private double valorImpuesto;
	private int  acumulado;
	
	public ImpuestoDeLujo() {
		this.valorImpuesto = 0.1;
		this.acumulado = 0;
	}
	
	public int getValorAcumulado() {
		return acumulado;
	}
	@Override
	public void aceptar(Jugador jugador) {
		int total = jugador.obtenerDinero();
		acumulado = (int) (acumulado + total * valorImpuesto);
		jugador.pagar(acumulado);
	}
}