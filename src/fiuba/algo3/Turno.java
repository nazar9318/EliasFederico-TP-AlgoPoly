package fiuba.algo3;

import fiuba.algo3.modelo.Dado;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;

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
			try {
				hacerJugarAlJugador(juego.jugadorActual(), juego.getTablero());
			}	
			catch (JugadorNoPuedeSalirDeLaCarcelException e) {
				juego.cambiarJugadorActual();
			}	
			catch (JugadorNoTieneFondosParaPagarException e) {
				juego.SacarPerdedor();
			}
			catch (JugadorNoCuentaConDineroSuficienteParaComprarException e) {
				//primero consultar venta(?
				juego.cambiarJugadorActual();
			}
			if (!puedeVolverAjugar()) {
				juego.cambiarJugadorActual();
			}
		}
		else {
			throw new FinDelJuegoException();
		}
	}
	
	public void hacerJugarAlJugador(Jugador jugador, Tablero tablero) {
		jugador.setValorDeTiro(valorDados);
		Visitable celdaNueva = tablero.avanzarJugador(jugador, valorDados);
		celdaNueva.aceptar(jugador);
	}
	
	
	public boolean puedeVolverAjugar () {
		return dado1.getValor() == dado2.getValor();
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