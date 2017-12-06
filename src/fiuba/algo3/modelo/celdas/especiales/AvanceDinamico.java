package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.MovimientoDinamico;
import fiuba.algo3.modelo.celdas.Visitable;

public class AvanceDinamico implements Visitable {
	
	private MovimientoDinamico movimiento;
	
	public AvanceDinamico() {
		this.movimiento = new MovimientoDinamico(2,6,11,12);
	}
	
	public void calcularAvance(Jugador jugador) {
		jugador.moverJugador(movimiento.calcularMovimiento(jugador));
		
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}

}
