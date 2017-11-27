package fiuba.algo3;

import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class Turno {

	private Dado dado1;
	private Dado dado2;
	private int valorDados;
	private int turnosJugados;
	private boolean jugar;
	
	public Turno () {
		this.dado1  = new Dado();
		this.dado2 = new Dado();
	}
	
	public void tirarDados() {
		int valor1 = dado1.tirar();
		int valor2 = dado2.tirar();
		if (valor1 != valor2) jugar = false;
		this.valorDados = valor1 + valor2;
	}

	public int jugar(Jugador unJugador, Tablero tablero) {
		jugar = true;
		turnosJugados = 0;
		while (jugar && turnosJugados < 2) {
			tirarDados();
			try {
				unJugador.setValorDeTiro(valorDados);
				tablero.avanzarJugador(unJugador, valorDados);
				int posicionActual = tablero.getPosicionEnTablero(unJugador);
				if (posicionActual == 7) {
					AvanceDinamico celda1 = (AvanceDinamico) tablero.getPosicionDeJugador(unJugador);
					tablero.avanzarJugador(unJugador, celda1.getMovimiento());
				}
				if (posicionActual == 18) {
					RetrocesoDinamico celda2 = (RetrocesoDinamico) tablero.getPosicionDeJugador(unJugador);
					tablero.avanzarJugador(unJugador, celda2.getMovimiento());
				}
			}	catch (JugadorNoPuedeSalirDeLaCarcelException e) {
				jugar = false;
			}	catch (JugadorNoTieneFondosParaPagarException e) {
				return -1;
			}
			turnosJugados ++;
		}
		return 0;
	}
	
	
}
