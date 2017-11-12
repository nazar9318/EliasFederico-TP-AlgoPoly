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
	private	Dado dado1 = new Dado();
	private	Dado dado2 = new Dado();

	public Tablero() {
		dado1 = new Dado();
		dado2 = new Dado();
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
	
	public int lanzarDados() {
	int numero1=0;
	int numero2=0;
	numero1 = dado1.tirar();
	numero2 = dado2.tirar();
	if (numero1 == numero2) {
		numero1 = dado1.tirar() ;
		numero2 =	dado2.tirar();
		if (numero1 == numero2) {
			return 0;
		}
	}
	return numero1 + numero2;
	}

}

