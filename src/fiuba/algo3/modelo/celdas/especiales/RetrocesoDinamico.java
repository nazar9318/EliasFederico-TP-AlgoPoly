package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;

public class RetrocesoDinamico implements Visitable {

	private MovimientoDinamico movimiento;
	
	public RetrocesoDinamico () {
		this.movimiento = new MovimientoDinamico(11,12,2,6);
	}
	
	public void calcularRetroceso(Jugador jugador) {
		jugador.moverJugador((-1) * movimiento.calcularMovimiento(jugador));
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
	
}
