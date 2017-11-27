package fiuba.algo3.celdas.especiales;

import fiuba.algo3.Jugador;
import fiuba.algo3.MovimientoDinamico;
import fiuba.algo3.celdas.Visitable;

public class RetrocesoDinamico implements Visitable {

	private MovimientoDinamico movimiento;
	private int movimientoCalculado;
	
	public RetrocesoDinamico () {
		this.movimiento = new MovimientoDinamico(11,12,2,6);
	}
	
	public void calcularRetroceso(Jugador jugador) {
		movimientoCalculado = (-1) * movimiento.calcularMovimiento(jugador);
	}
	
	public int getMovimiento() {
		return movimientoCalculado;
	}
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
	
}
