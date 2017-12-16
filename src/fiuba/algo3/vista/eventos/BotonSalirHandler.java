package fiuba.algo3.vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class BotonSalirHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Desea abandonar el juego?", ButtonType.YES, ButtonType.CANCEL);
		alert.setHeaderText("Salir del juego");
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES) {
			System.exit(0); 
		}
	}

}
