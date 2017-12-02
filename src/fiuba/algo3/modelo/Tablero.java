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

	private Visitable reposicionarJugador(Jugador j1, int index, int avance){
		if(index + avance >= getCantidadDeCeldas())
			jugadores.put(j1, celdas.get(index + avance - getCantidadDeCeldas()));
		else if (index + avance < 0) { 	
			//el indice se iba de rango con los valores negativos del retroceso
			jugadores.put(j1, celdas.get(getCantidadDeCeldas()+ (index + avance)));
		}
		else
			jugadores.put(j1, celdas.get(index+avance));

		return jugadores.get(j1);
	}
	
	public void avanzarJugador(Jugador jugador, int avance) {
		Visitable celdaActual = this.jugadores.get(jugador);
		int index = this.celdas.indexOf(celdaActual);
		Visitable celdaNueva = reposicionarJugador(jugador, index, avance);
		celdaNueva.aceptar(jugador);
	}

	public ArrayList<Visitable> getCeldas() {
		return celdas;
	}
}