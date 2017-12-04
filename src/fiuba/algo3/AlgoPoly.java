package fiuba.algo3;

import java.util.ArrayList;
import java.util.Arrays;
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
		reiniciarJuego();
	}

	private void construirTablero() {

		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio cordobaSur = new CordobaSur();
		Barrio cordobaNorte = new CordobaNorte();
		Barrio saltaNorte = new SaltaNorte();
		Barrio saltaSur = new SaltaSur();
		Barrio neuquen = new Neuquen();
		Barrio tucuman = new Tucuman();
		Barrio santaFe = new SantaFe();

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

		propiedades.addAll(Arrays.asList(buenosAiresNorte, buenosAiresSur, cordobaSur, cordobaNorte, saltaNorte, saltaSur,
				neuquen, santaFe, tucuman,edesur, aysa, subte, tren));

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
		tablero.agregarCelda(santaFe);
		tablero.agregarCelda(aysa);
		tablero.agregarCelda(saltaNorte);
		tablero.agregarCelda(saltaSur);
		tablero.agregarCelda(policia);
		tablero.agregarCelda(tren);
		tablero.agregarCelda(neuquen);
		tablero.agregarCelda(new RetrocesoDinamico());
		tablero.agregarCelda(tucuman);

	}
	
	private void agregarJugadores() {
		crearJugadores();
		agregarJugadoresEnTablero();
	}

	private void crearJugadores() {
		while (jugadores.size()<3) {
			jugadores.add(new Jugador());
		}
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
		agregarJugadores();
	}

	public Invoker getInvoker() {
		return invoker;
	}

	public ArrayPropiedad getPropiedades() {
		return propiedades;
	}

	public Jugador jugadorActual() {
		return this.jugadores.get(0);	//TODO: rotacion de jugadores
	}

	public Turno getTurno() {
		return this.turno;
	}
}
