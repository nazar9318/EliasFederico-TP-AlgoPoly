package fiuba.algo3.vista.eventos;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Turno;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.excepciones.ConsultarCompraException;
import fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.modelo.excepciones.JugadorFueTrasladadoALaCarcel;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
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
	
	public BotonTirarDadosHandler(AlgoPoly algo) {
		this.algoPoly = algo;
		this.turno = algo.getTurno();
	}

	@Override
	public void handle(ActionEvent arg0) {
		super.sonido.play();
		try{
			turno.jugar();
		} catch (JugadorPerdioException e) {
			algoPoly.SacarPerdedor();
			mostrarMensajeConSonido("src/fiuba/algo3/vista/sonidos/perdio.mp3","Ha perdido el juego!");
		} catch (JugadorNoCuentaConDineroSuficienteParaComprarException e) {
			mostrarMensajeConSonido("src/fiuba/algo3/vista/sonidos/alerta.mp3","Su dinero no es suficiente Para Realizar esta Compra");
			algoPoly.cambiarJugadorActual();
		} catch (FinDelJuegoException e) {
			hacerSonarAlerta("src/fiuba/algo3/vista/sonidos/ganador.mp3");
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText("Fin Del Juego");
			alert.setContentText("Felicidades!!! Ha Ganado El Juego. Desea Volver a Jugar?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
				algoPoly.reiniciarJuego();
			mostrarMensajeConSonido("src/fiuba/algo3/vista/sonidos/ganador.mp3","Se ha reiniciado el juego!");
			if (result.get() == ButtonType.CANCEL) {
				System.exit(0);
			}
		} catch (ConsultarCompraException e){
			
			Propiedad aComprar = (Propiedad) algoPoly.getTablero().getPosicionDeJugador(algoPoly.jugadorActual());

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(aComprar.getNombre() + " esta a la venta!");
			alert.setContentText("Desea adquirir esta propiedad?");
			
			hacerSonarAlerta("src/fiuba/algo3/vista/sonidos/alerta.mp3");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
				intentarCompra(aComprar);
		} catch (JugadorNoPuedeSalirDeLaCarcelException e) {
			mostrarMensajeConSonido("src/fiuba/algo3/vista/sonidos/alerta.mp3","Usted esta en La Carcel. Pierde El turno!");
			algoPoly.cambiarJugadorActual();
		} catch (JugadorFueTrasladadoALaCarcel e){
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de informacion");
            alert.setHeaderText("Usted ha sido arrestado y trasladado a la carcel");
            alert.show();
		}
	}
	
	private void intentarCompra(Propiedad aComprar) {
		try {
			aComprar.comprar(algoPoly.jugadorActual());
		} 
		catch (JugadorNoCuentaConDineroSuficienteParaComprarException e) {
			mostrarMensajeConSonido("src/fiuba/algo3/vista/sonidos/alerta.mp3","Su dinero no es suficiente Para Realizar esta Compra");
		}
		algoPoly.cambiarJugadorActual();
	}

	private void mostrarMensajeConSonido(String ruta, String mensaje) {
		hacerSonarAlerta(ruta);
		Alert msj = new Alert(Alert.AlertType.INFORMATION);
		msj.setContentText(mensaje); //faltaria el nombre del jugador que pierde
		msj.show();
	}
	
	private void hacerSonarAlerta(String ruta) {
		Media sonidoClick = new Media(new File(ruta).toURI().toString());
	    MediaPlayer Sonido = new MediaPlayer(sonidoClick);
	    Sonido.play();
	}
	
}
