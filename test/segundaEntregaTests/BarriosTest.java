package segundaEntregaTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.comprables.Barrio;

public class BarriosTest {

	@Test
	public void jugadorCompraBuenosAiresSurSuDineroDeberiaReducirseEn20mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 2);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 20000, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraBuenosAiresNorteSuDineroDeberiaReducirseEn25mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 4);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 25000, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraCordobaSurSuDineroDeberiaReducirseEn18mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 6);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 18000, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraCordobaNorteSuDineroDeberiaReducirseEn20mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 9);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 20000, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraSantaFeSuDineroDeberiaReducirseEn15mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 11);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 15000, dineroPosterior);
	}

	@Test
	public void jugadorCompraSaltaNorteSuDineroDeberiaReducirseEn23mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 13);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 23000, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraSaltaSurSuDineroDeberiaReducirseEn23mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 14);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 23000, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraNeuquenSuDineroDeberiaReducirseEn17mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 17);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 17000, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraTucumanSuDineroDeberiaReducirseEn25mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 19);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 25000, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConBsAsSurYBsAsNorteYConstruyeUnaCasaSuDineroDeberiaReducirseEn5mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 2);
		Barrio BsAsSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 2);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(BsAsSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 5000, dineroPosterior);
	}
	
	/*@Test
	public void jugadorCuentaConCordobaSurYCordobaNorteYConstruyeUnaCasaSuDineroDeberiaReducirseEn2mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio CordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 9);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(CordobaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 2000, dineroPosterior);
	}*/ //No se esta descontando el alquiler correctamente
	
	/*@Test
	public void jugadorCuentaConBsAsSurYBsAsNorteConUnaCasaEnAmbasAlCaerUnContrincanteSuDineroDeberiaReducirseEn3mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 2);
		Barrio BsAsSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 2);
		Barrio BsAsNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(BsAsSur);
		unJugador.construir(BsAsNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 2);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3000, dineroPosterior);
	}*/   //Falta la modificacion del precio del alquiler con una casa
}
