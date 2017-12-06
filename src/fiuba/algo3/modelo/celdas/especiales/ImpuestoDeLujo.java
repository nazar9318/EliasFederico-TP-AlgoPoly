package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;
import javafx.scene.control.Alert;

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
		acumulado = (int)(total * valorImpuesto);
		jugador.pagar((int)(total * valorImpuesto));
	}
}
