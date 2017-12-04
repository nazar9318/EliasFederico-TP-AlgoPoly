package fiuba.algo3.vista.eventos;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Turno;
import fiuba.algo3.modelo.Dado;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.excepciones.ConsultarCompraException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Optional;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	private AlgoPoly algoPoly;
	private Dado dado1;
	private Dado dado2;
	private Turno turno;
	private Jugador jugador;
	private Tablero tablero;
	
	public BotonTirarDadosHandler(Turno turno, Jugador jugador, Tablero tablero) {
		this.turno = turno;
		this.jugador = jugador;
		this.tablero = tablero;
	}

	@Override
	public void handle(ActionEvent arg0) {
		try {
			turno.jugar(this.jugador, this.tablero);
		}catch (ConsultarCompraException e){
			Propiedad aComprar = (Propiedad) tablero.getPosicionDeJugador(jugador);

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(aComprar.getNombre() + " esta a la venta!");
			alert.setContentText("Desea adquirir esta propiedad?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
				aComprar.comprar(jugador);
		}
	}
}
