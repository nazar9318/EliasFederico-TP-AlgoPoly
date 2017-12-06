package fiuba.algo3.vista.eventos;

import javafx.event.EventHandler;
import fiuba.algo3.AlgoPoly;
import fiuba.algo3.vista.VistaTablero;
import fiuba.algo3.vista.contenedorPrincipal;
import javafx.event.ActionEvent;

public class BotonReiniciarHandler extends BotonConSonido implements EventHandler<ActionEvent> {
	
	private AlgoPoly juego_;
	
	public BotonReiniciarHandler(AlgoPoly juego) {
		this.juego_ = juego;
	}
	
	@Override
	public void handle(ActionEvent event) {
		super.sonido.play();
		juego_.reiniciarJuego();
	}

}
