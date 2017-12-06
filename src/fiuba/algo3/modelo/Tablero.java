package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.Salida;

public class Tablero {

	private HashMap<Jugador, Visitable> jugadores;
	private ArrayList<Visitable> celdas;

	public Tablero() {
		jugadores = new HashMap<>();
		celdas = new ArrayList<>();
		this.agregarCelda(new Salida());
	}

	public int getCantidadDeCeldas() {
		return celdas.size();
	}

	public Visitable getSalida() {
		return this.celdas.get(0);
	}

	public void agregarCelda(Visitable c1) {
		celdas.add(c1);
	}

	public Jugador agregarJugador(Jugador j1) {
		this.jugadores.put(j1, getSalida());
		return j1;
	}
	
	public int getPosicionEnTablero(Jugador jugador) {
		return celdas.indexOf(getPosicionDeJugador(jugador));
	}

	public Visitable getPosicionDeJugador(Jugador j1) {
		return this.jugadores.get(j1);
	}

	public Visitable reposicionarJugador(Jugador j1, int index, int avance){
		if(index + avance >= getCantidadDeCeldas())
			jugadores.put(j1, celdas.get(index + avance - getCantidadDeCeldas()));
		else if (index + avance < 0) { 	
			jugadores.put(j1, celdas.get(getCantidadDeCeldas()+ (index + avance)));
		}
		else
			jugadores.put(j1, celdas.get(index+avance));
		
		/*if(this.celdas.indexOf(jugadores.get(j1)) == 15){
			jugadores.put(j1, celdas.get(5));
		}*/

		return jugadores.get(j1);
	}
	
	public Visitable avanzarJugador(Jugador jugador, int avance) {
		Visitable celdaActual = this.jugadores.get(jugador);
		int index = this.celdas.indexOf(celdaActual);
		return jugador.reUbicarse(this, avance, index);
		//return reposicionarJugador(jugador, index, avance);
	}

	public ArrayList<Visitable> getCeldas() {
		return celdas;
	}

	public void ubicarJugadorEnCelda(Jugador jugador, Visitable visitable) {
		jugadores.put(jugador, visitable);
	}
}