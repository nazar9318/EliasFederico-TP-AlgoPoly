package fiuba.algo3.vista.eventos;

import fiuba.algo3.AlgoPoly;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonComenzarJuegoHandler extends BotonConSonido implements EventHandler<ActionEvent> {

	AlgoPoly juego;
	
	public BotonComenzarJuegoHandler(AlgoPoly algo) {
		this.juego = algo;
	}
	@Override
	public void handle(ActionEvent event) {
		super.sonido.play();
	}

}
