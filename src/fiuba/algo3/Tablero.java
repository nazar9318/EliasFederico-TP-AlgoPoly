package fiuba.algo3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import fiuba.algo3.celdas.Celda;

public class Tablero {
private HashMap<Jugador, Iterator<Celda>> jugadores;

LinkedList<Celda> celdas; 

Iterator<Celda> iteratorTablero;

public Tablero() {
	jugadores = new HashMap<>();
	celdas = new LinkedList<Celda>();	
}

public int getCantidadDeCeldas() {
	return celdas.size();	
}

public Celda getSalida() {
	Iterator<Celda> iteratorAux;
	iteratorAux=celdas.iterator();
	return 	 iteratorAux.next();
}
public Celda getSiguiente() {
	return (iteratorTablero.next());
	}

public void cargarJugador(Jugador jugador) {
	Iterator<Celda> iterator;
	iterator=celdas.listIterator();
	jugadores.put(jugador, iterator);
}
public Celda getCeldaJugador(Jugador jugador) {
	return jugadores.get(jugador).next();
}

public void agregarCelda(Celda celda) {
	celdas.add(celda);
}

public Celda jugadorAvanza(Jugador jugador1, int avance) {
	Celda celda = null;
	int i = 0;
	while ((jugadores.get(jugador1).hasNext()) && ( i <= avance)){
		celda =jugadores.get(jugador1).next();
		i++;
		} 
	return celda;
}

}

