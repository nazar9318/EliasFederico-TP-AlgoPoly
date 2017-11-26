package fiuba.algo3;

import java.util.ArrayList;
import java.util.HashMap;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.Salida;

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

	public Visitable getPosicionDeJugador(Jugador j1) {
		return this.jugadores.get(j1);
	}

	private Visitable reposicionarJugador(Jugador j1, int index, int avance){
		if(index + avance >= getCantidadDeCeldas())
			this.jugadores.put(j1, this.celdas.get(index + avance - getCantidadDeCeldas()));
		else if (index + avance < 0) { 	
			//el indice se iba de rango con los valores negativos del retroceso
			this.jugadores.put(j1, this.celdas.get(getCantidadDeCeldas()+ (index + avance)));
		}
		else
			this.jugadores.put(j1, this.celdas.get(index+avance));

		return this.jugadores.get(j1);
	}
	
	public void avanzarJugador(Jugador jugador, int avance) {
		Visitable celdaActual = this.jugadores.get(jugador);
		int index = this.celdas.indexOf(celdaActual);
		Visitable celdaNueva = reposicionarJugador(jugador, index, avance);
		celdaNueva.aceptar(jugador);
	}
}