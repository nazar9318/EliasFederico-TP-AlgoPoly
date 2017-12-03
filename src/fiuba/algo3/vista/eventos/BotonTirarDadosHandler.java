package fiuba.algo3.vista.eventos;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Turno;
import fiuba.algo3.modelo.Dado;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	private AlgoPoly algoPoly;
	private Dado dado1;
	private Dado dado2;
	private Turno turno;
	private Jugador jugador;
	private Tablero tablero;
	
	public BotonTirarDadosHandler(AlgoPoly algo) {
		this.algoPoly = algo;
		this.dado1 = new Dado();
		this.dado2 = new Dado();
	}

	public BotonTirarDadosHandler(Turno turno, Jugador jugador, Tablero tablero) {
		this.turno = turno;
		this.jugador = jugador;
		this.tablero = tablero;
	}

	@Override
	public void handle(ActionEvent arg0) {
		turno.hacerJugarAlJugador(this.jugador, this.tablero);
		
	}

}
