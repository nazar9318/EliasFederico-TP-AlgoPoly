package fiuba.algo3;

import java.util.ArrayList;
import java.util.Collections;

import fiuba.algo3.modelo.ArrayPropiedad;
import fiuba.algo3.modelo.Command.Invoker;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.*;
import fiuba.algo3.modelo.celdas.comprables.Servicios.*;
import fiuba.algo3.modelo.celdas.especiales.*;

public class AlgoPoly {

	private Tablero tablero;
	private ArrayList<Jugador> jugadores;
	private Turno turno;
	private Invoker invoker;
	private ArrayPropiedad propiedades;

	public AlgoPoly(){
		this.tablero = new Tablero();
		this.jugadores = new ArrayList<Jugador>();
		this.turno = new Turno();
		this.invoker = new Invoker();
		this.propiedades = new ArrayPropiedad();

	}

	public Tablero getTablero() {
		return tablero;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	
	public int getCantidadDeJugadores() {
		return jugadores.size();
	}

	public void inicializarJuego(){
		construirTablero();
		agregarJugadores();
	}

	private void construirTablero() {

		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio cordobaSur = new CordobaSur();
		Barrio cordobaNorte = new CordobaNorte();
		Barrio saltaNorte = new SaltaNorte();
		Barrio saltaSur = new SaltaSur();

		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);

		Servicio edesur = new EDESUR();
		Servicio aysa = new AYSA();
		Servicio subte = new SUBTE();
		Servicio tren = new TREN();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);
		cordobaNorte.conocer(cordobaSur);
		cordobaSur.conocer(cordobaNorte);
		saltaNorte.conocer(saltaSur);
		saltaSur.conocer(saltaNorte);

		edesur.conocer(aysa);
		aysa.conocer(edesur);
		subte.conocer(tren);
		tren.conocer(subte);

		tablero.agregarCelda(new Quini6());
		tablero.agregarCelda(buenosAiresSur);
		tablero.agregarCelda(edesur);
		tablero.agregarCelda(buenosAiresNorte);
		tablero.agregarCelda(carcel);
		tablero.agregarCelda(cordobaSur);
		tablero.agregarCelda(new AvanceDinamico());
		tablero.agregarCelda(subte);
		tablero.agregarCelda(cordobaNorte);
		tablero.agregarCelda(new ImpuestoDeLujo());
		tablero.agregarCelda(new SantaFe());
		tablero.agregarCelda(aysa);
		tablero.agregarCelda(saltaNorte);
		tablero.agregarCelda(saltaSur);
		tablero.agregarCelda(policia);
		tablero.agregarCelda(tren);
		tablero.agregarCelda(new Neuquen());
		tablero.agregarCelda(new RetrocesoDinamico());
		tablero.agregarCelda(new Tucuman());

	}
	
	public void agregarJugadores() {
		while (jugadores.size()<3) {
			jugadores.add(new Jugador());
		}
		agregarJugadoresEnTablero();
	}
	
	public void agregarJugadoresEnTablero() {
		for(Jugador jugador: jugadores) {
			tablero.agregarJugador(jugador);
			jugador.conocerTablero(tablero);
		}
	}
	public void reiniciarJuego() {
		Collections.shuffle(jugadores);
		this.tablero = new Tablero();
		construirTablero();
		agregarJugadoresEnTablero();
	}
	
	public void jugarTurno(Jugador unJugador) {
		if (turno.jugar(unJugador, tablero) < 0) {
			jugadores.remove(unJugador);
		}
	}
	
	public void comenzarJuego() {
		int pos = 0;
		while (jugadores.size() > 1) {
			if (pos >= jugadores.size()) pos = pos - pos;
			jugarTurno(jugadores.get(pos));
			pos ++;
		}
	}

	public Invoker getInvoker() {
		return invoker;
	}

	public ArrayPropiedad getPropiedades() {
		return propiedades;
	}
}
