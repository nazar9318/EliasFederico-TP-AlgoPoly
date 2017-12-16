package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;
import javafx.scene.control.Alert;

public class RetrocesoDinamico implements Visitable {

	public MovimientoDinamico getMovimiento() {
		return movimiento;
	}

	private MovimientoDinamico movimiento;
	
	public RetrocesoDinamico () {
		this.movimiento = new MovimientoDinamico(11,12,2,6);
	}
	
	public void calcularRetroceso(Jugador jugador) {
		int retroceso = (-1) * movimiento.calcularMovimiento(jugador);
		mostrarMensaje(retroceso);
		jugador.moverJugador(retroceso);
	}

	private void mostrarMensaje(int retroceso) {
		Alert msj = new Alert(Alert.AlertType.INFORMATION);
		msj.setHeaderText("Cayo en Retroceso Dinamico!");
		msj.setContentText("Retrocede " + (-1)*retroceso + " casilleros");
		msj.showAndWait();
	}

	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}
	
}
