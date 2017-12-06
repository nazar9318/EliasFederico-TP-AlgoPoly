package ultimaEntregaTests;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.modelo.AlgoPoly;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.excepciones.BarrioSimpleNoPuedeConstruirHotelException;

public class BarriosSimplesTest {

	@Test (expected = BarrioSimpleNoPuedeConstruirHotelException.class)
	public void JugadorCuentaConSantaFeYUnaCasaNoDeberiaPoderConstruirHotel() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		
		tablero.avanzarJugador(unJugador, 11);
		Barrio SantaFe = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(SantaFe);
		unJugador.construir(SantaFe);
	}
	
	@Test (expected = BarrioSimpleNoPuedeConstruirHotelException.class)
	public void JugadorCuentaConNeuquenYUnaCasaNoDeberiaPoderConstruirHotel() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		
		tablero.avanzarJugador(unJugador, 17);
		Barrio Neuquen = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(Neuquen);
		unJugador.construir(Neuquen);
	}
	
	@Test (expected = BarrioSimpleNoPuedeConstruirHotelException.class)
	public void JugadorCuentaConTucumanYUnaCasaNoDeberiaPoderConstruirHotel() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		
		tablero.avanzarJugador(unJugador, 19);
		Barrio Tucuman = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(Tucuman);
		unJugador.construir(Tucuman);
	}

}
