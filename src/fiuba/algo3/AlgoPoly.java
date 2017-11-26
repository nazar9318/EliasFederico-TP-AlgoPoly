package fiuba.algo3;

import java.util.ArrayList;
import java.util.Collections;

import fiuba.algo3.celdas.comprables.*;
import fiuba.algo3.celdas.comprables.Servicios.*;
import fiuba.algo3.celdas.especiales.*;

public class AlgoPoly {

	private Tablero tablero;
	private ArrayList<Jugador> jugadores;
	private Turno turno;

	public AlgoPoly(){
		this.tablero = new Tablero();
		this.jugadores = new ArrayList<Jugador>();
		this.turno = new Turno();
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
		for(Jugador jugador: jugadores) {
			tablero.agregarJugador(jugador);
		}
	}
	
	public void reiniciarJuego() {
		Collections.shuffle(jugadores);
	}
	
	public void jugarTurno(Jugador unJugador) {
		turno.jugar(unJugador, tablero);
	}
}
