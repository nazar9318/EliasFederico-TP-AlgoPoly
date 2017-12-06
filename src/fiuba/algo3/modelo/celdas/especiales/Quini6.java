package fiuba.algo3.modelo.celdas.especiales;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;

import java.util.HashMap;

public class Quini6 implements Visitable {
	
	private HashMap<Jugador, Integer> jugadores;
	private int premioPrimeraCaida;
	private int premioSegundaCaida;
	private int premioTerceraCaida;

	public Quini6() {
		jugadores = new HashMap<>();
		this.premioPrimeraCaida = 50000;
		this.premioSegundaCaida = 30000;
		this.premioTerceraCaida = 0;
	}

	private boolean primeraCaida(Jugador unJugador){
		return !this.jugadores.containsKey(unJugador);
	}

	private boolean segundaCaida(Jugador unJugador){
		return (this.jugadores.get(unJugador) == 1);
	}

	private void cobrarCaidaRepetida(Jugador unJugador){
		if(segundaCaida(unJugador)) {
			sumarCaida(unJugador);
			unJugador.cobrar(this.obtenerPremioSegundaCaida());
			return;
		}
		unJugador.cobrar(this.obtenerPremioTerceraCaida());
	}

	private void sumarCaida(Jugador unJugador) {
		this.jugadores.put(unJugador, 2);
	}

	public void pagarPremioAJugador(Jugador unJugador) {
		if (primeraCaida(unJugador)) {
			jugadores.put(unJugador, 1);
			unJugador.cobrar(this.obtenerPremioPrimeraCaida());
			return;
		}
		cobrarCaidaRepetida(unJugador);
	}
	
	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}

	public int obtenerPremioPrimeraCaida() {
		return this.premioPrimeraCaida;
	}

	public int obtenerPremioSegundaCaida() {
		return this.premioSegundaCaida;
	}

	public int obtenerPremioTerceraCaida() {
		return this.premioTerceraCaida;
	}
	
}
