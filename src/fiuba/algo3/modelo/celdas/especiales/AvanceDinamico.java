package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;
import javafx.scene.control.Alert;

public class AvanceDinamico implements Visitable {

	public MovimientoDinamico getMovimiento() {
		return movimiento;
	}

	private MovimientoDinamico movimiento;
	
	public AvanceDinamico() {
		this.movimiento = new MovimientoDinamico(2,6,11,12);
	}
	
	public void calcularAvance(Jugador jugador) {
		int avance = movimiento.calcularMovimiento(jugador);
		mostrarMensaje(avance);
		jugador.moverJugador(avance);
	}

	private void mostrarMensaje(int avance) {
		Alert msj = new Alert(Alert.AlertType.INFORMATION);
		msj.setHeaderText("Cayo en Avance Dinamico!");
		msj.setContentText("Avanza " + avance + " casilleros extra");
		msj.showAndWait();
	}

	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}

}
