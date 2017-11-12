package fiuba.algo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.celdas.Celda;
import fiuba.algo3.celdas.CeldaSalida;

public class Tablero {

	private HashMap<Jugador, Celda> jugadores;
	private ArrayList<Celda> celdas;

	public Tablero() {
		jugadores = new HashMap<>();
		celdas = new ArrayList<>();
		this.agregarCelda(new CeldaSalida());
	}

	public int getCantidadDeCeldas() {
		return celdas.size();
	}

	public Celda getSalida() {
		return this.celdas.get(0);
	}

	public void agregarCelda(Celda c1) {
		celdas.add(c1);
	}

	public void agregarJugador(Jugador j1) {
		this.jugadores.put(j1, getSalida());
	}

	public Celda getPosicionDeJugador(Jugador j1) {
		return this.jugadores.get(j1);
	}

	private Celda reposicionarJugador(Jugador j1, int index, int avance){
		if(index + avance >= getCantidadDeCeldas())
			this.jugadores.put(j1, this.celdas.get(index + avance - getCantidadDeCeldas()));
		else
			this.jugadores.put(j1, this.celdas.get(index+avance));

		return this.jugadores.get(j1);
	}
	
	public void avanzarJugador(Jugador jugador, int avance) {

		Celda celdaActual = this.jugadores.get(jugador);
		int index = this.celdas.indexOf(celdaActual);
		celdaActual.sacarJugador(jugador); //TODO: reemplazar sacar jugador por metodo mas integral que valide habilitacion de moverse

		Celda celdaNueva = reposicionarJugador(jugador, index, avance);
		celdaNueva.recibirJugador(jugador);
	}
}