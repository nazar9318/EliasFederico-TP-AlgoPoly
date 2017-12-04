package fiuba.algo3.vista.eventos;

import fiuba.algo3.Turno;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.excepciones.ConsultarCompraException;
import fiuba.algo3.modelo.excepciones.JugadorPerdioException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Optional;

public class BotonTirarDadosHandler extends BotonConSonido implements EventHandler<ActionEvent> {
	
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
		super.sonido.play();
		try {
			turno.jugar();
		}catch (ConsultarCompraException e){
			Propiedad aComprar = (Propiedad) tablero.getPosicionDeJugador(jugador);

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(aComprar.getNombre() + " esta a la venta!");
			alert.setContentText("Desea adquirir esta propiedad?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
				aComprar.comprar(jugador);
		} catch (JugadorPerdioException e) {
			 String sound = "src/fiuba/algo3/vista/sonidos/perdio.mp3";
		     Media sonidoClick = new Media(new File(sound).toURI().toString());
		     MediaPlayer perdioSonido = new MediaPlayer(sonidoClick);
		     perdioSonido.play();
				
			Alert msj = new Alert(Alert.AlertType.INFORMATION);
			msj.setContentText("El jugador ha perdido el juego!"); //faltaria el nombre del jugador que pierde
		}
	}
}
