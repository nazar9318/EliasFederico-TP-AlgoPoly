package fiuba.algo3.vista.eventos;

import javafx.event.EventHandler;
import fiuba.algo3.modelo.AlgoPoly;
import javafx.event.ActionEvent;

public class BotonReiniciarHandler implements EventHandler<ActionEvent> {
	
	private AlgoPoly juego_;
	
	public BotonReiniciarHandler(AlgoPoly juego) {
		this.juego_ = juego;
	}
	
	@Override
	public void handle(ActionEvent event) {
		juego_.reiniciarJuego();
	}

}
