package fiuba.algo3;

import fiuba.algo3.modelo.Dado;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.excepciones.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Optional;

public class Turno {

	private Dado dado1;
	private Dado dado2;
	private int valorDados;
	private int turnosJugados;
	private AlgoPoly juego;
	
	public Turno (AlgoPoly algo) {
		this.dado1  = new Dado();
		this.dado2 = new Dado();
		this.juego = algo;
		
	}
	
	public void tirarDados() {
		int valor1 = dado1.tirar();
		int valor2 = dado2.tirar();
		this.valorDados = valor1 + valor2;
	}

	public void jugar() {

		if (juego.noHayUnGanador()) {
			tirarDados();
			hacerJugarAlJugador(juego.jugadorActual(), juego.getTablero());
			if (!puedeVolverAjugar()) {
				juego.cambiarJugadorActual();
			}
		}
		else {
			throw new FinDelJuegoException();
		}
	}

	public boolean puedeVolverAjugar () {
		return dado1.getValor() == dado2.getValor();
	}

	public void hacerJugarAlJugador(Jugador jugador, Tablero tablero) {
		jugador.setValorDeTiro(valorDados);
		Visitable celdaNueva = tablero.avanzarJugador(jugador, valorDados);
		celdaNueva.aceptar(jugador);
	}

	public int getTurnosJugados() {
		return turnosJugados;
	}

	public int getValorDado1() {
		return this.dado1.getValor();
	}

	public int getValorDado2() {
		return this.dado2.getValor();
	}
}