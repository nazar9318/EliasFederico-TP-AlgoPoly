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

	private List<Celda> celdas; 

	private Iterator<Celda> iteratorTablero;

	public Tablero() {
		jugadores = new HashMap<>();
		celdas = new ArrayList<Celda>();
		CeldaSalida salida = new CeldaSalida();
		celdas.add(salida);
	}
	
	public int getCantidadDeCeldas() {
		return celdas.size();	
	}
	
	public Celda getSalida() {
		Iterator<Celda> iteratorAux;
		iteratorAux = celdas.iterator();
		return iteratorAux.next();
	}

	public Celda getSiguiente() {
		return (iteratorTablero.next());
	}
	
	public void cargarJugador(Jugador jugador) {
		jugadores.put(jugador, this.celdas.get(0));
	}
	
	public Celda getCeldaJugador(Jugador jugador) {
		return jugadores.get(jugador);
	}
	
	public void agregarCelda(Celda celda) {
		celdas.add(celda);
	}
	
	public Celda jugadorAvanza(Jugador jugador, int avance) {
		Celda celdaActual = this.jugadores.get(jugador);
		int indice = this.celdas.indexOf(celdaActual);
		celdaActual.sacarJugador(jugador);
		if(indice + avance >= this.celdas.size()){
			this.jugadores.put(jugador, this.celdas.get(this.celdas.size() - (indice + avance)));
		} else {
			this.jugadores.put(jugador, this.celdas.get(indice + avance));
		}		
		
		Celda celdaNueva = this.jugadores.get(jugador);
		
		celdaNueva.recibirJugador(jugador);
		
		return celdaNueva;
	}

}

