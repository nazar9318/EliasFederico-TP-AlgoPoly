package fiuba.algo3.vista.eventos;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Turno;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.FinDelJuegoException;
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

	private AlgoPoly algoPoly;
	private Turno turno;
	private Jugador jugador;
	private Tablero tablero;
	
	public BotonTirarDadosHandler(AlgoPoly algo) {
		this.algoPoly = algo;
		this.turno = algo.getTurno();
		this.jugador = algo.jugadorActual();
		this.tablero = algo.getTablero();
	}

	@Override
	public void handle(ActionEvent arg0) {
		super.sonido.play();
		try{
			turno.jugar();
			/*obtener la posicion actual
			 * obtener la vista de esa posicion
			 * mover al jugador a esa vista			
			*/
		} catch (JugadorPerdioException e) {
			mostrarMensajeConSonido("src/fiuba/algo3/vista/sonidos/perdio.mp3","El jugador ha perdido el juego!");
		} catch (FinDelJuegoException e) {
			mostrarMensajeConSonido("src/fiuba/algo3/vista/sonidos/ganador.mp3","Felicidades. Ha ganado el Juego!!");
		}
	}
	
	private void mostrarMensajeConSonido(String ruta, String mensaje) {
	    Media sonidoClick = new Media(new File(ruta).toURI().toString());
	    MediaPlayer perdioSonido = new MediaPlayer(sonidoClick);
	    perdioSonido.play();
			
		Alert msj = new Alert(Alert.AlertType.INFORMATION);
		msj.setContentText(mensaje); //faltaria el nombre del jugador que pierde
		msj.show();
	}
}
