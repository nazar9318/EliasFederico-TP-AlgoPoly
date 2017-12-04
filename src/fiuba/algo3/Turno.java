package fiuba.algo3;

import fiuba.algo3.modelo.Dado;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;

public class Turno {

	private Dado dado1;
	private Dado dado2;
	private int valorDados;
	private int turnosJugados;
	
	public Turno () {
		this.dado1  = new Dado();
		this.dado2 = new Dado();
	}
	
	public void tirarDados() {
		int valor1 = dado1.tirar();
		int valor2 = dado2.tirar();
		this.valorDados = valor1 + valor2;
	}

	public int jugar(Jugador unJugador, Tablero tablero) {
		turnosJugados = 0;
		setValorDados(0,0);
		while (puedeJugar() && turnosJugados < 2) {	
			tirarDados();
			try {
				hacerJugarAlJugador(unJugador, tablero);
			}	
			catch (JugadorNoPuedeSalirDeLaCarcelException e) {
				return 0;
			}	
			catch (JugadorNoTieneFondosParaPagarException e) {
				return -1;
			}
			catch (JugadorNoCuentaConDineroSuficienteParaComprarException e) {
				return 0;
			}
			turnosJugados++;
		}
		return 0;
	}
	
	public void hacerJugarAlJugador(Jugador jugador, Tablero tablero) {
		jugador.setValorDeTiro(valorDados);
		Visitable celdaNueva = tablero.avanzarJugador(jugador, valorDados);
		//actualizar vista?
		celdaNueva.aceptar(jugador);
	}
	
	public void setValorDados(int valor1, int valor2) {
		dado1.setValor(valor1);
		dado2.setValor(valor2);
		this.valorDados = valor1 + valor2;
	}
	
	public boolean puedeJugar () {
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