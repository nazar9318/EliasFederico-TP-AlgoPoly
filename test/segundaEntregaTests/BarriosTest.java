package segundaEntregaTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.celdas.comprables.CordobaNorte;
import fiuba.algo3.celdas.comprables.CordobaSur;

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
	
	@Test
	public void jugadorCuentaConCordobaSurYCordobaNorteYConstruyeUnaCasaSuDineroDeberiaReducirseEn2mil() {
		Jugador traspie = new Jugador();
		Barrio cordobaSur = new CordobaSur();
		Barrio cordobaNorte = new CordobaNorte();
		
		cordobaSur.conocer(cordobaNorte);
		cordobaNorte.conocer(cordobaSur);
		
		cordobaSur.aceptar(traspie);
		cordobaNorte.aceptar(traspie);
		int dineroAntesDeConstruir = traspie.obtenerDinero();
		traspie.construir(cordobaSur);
		
		assertEquals(traspie.obtenerDinero(), dineroAntesDeConstruir -2000);
	}
	
	@Test
	public void jugadorRecorreTableroCompraLasDosCordobasConstruyeEnUnaYSuDineroSeReduceEnDosMil(){
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(cordobaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 2000, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConSaltaSurYSaltaNorteYConstruyeUnaCasaSuDineroDeberiaReducirseEn4500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 13);
		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 1);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(saltaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 4500, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConBsAsSurYBsAsNorteConUnaCasaEnBsAsSurAlCaerUnContrincanteSuDineroDeberiaReducirseEn3mil(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.aceptar(traspie);
		buenosAiresNorte.aceptar(traspie);
		traspie.construir(buenosAiresSur);
		
		Jugador regio = new Jugador();
		int dineroAntesDeAlquilar = regio.obtenerDinero();
		buenosAiresSur.aceptar(regio);
		assertEquals(regio.obtenerDinero(), dineroAntesDeAlquilar -3000);
	}
	
	@Test
	public void jugadorRecorreTableroComprandoBsAsNorteYSurContrincanteRecorreTableroCaeEnBsAsSurYPagaTresMilPesos() {
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
	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurConUnaCasaEnAmbasYUnContrincanteCaeEnCordobaSurSuDineroDeberiaReducirseEn1500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 6);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 1500, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurConUnaCasaEnAmbasYUnContrincanteCaeEnSaltaNorteSuDineroDeberiaReducirseEn3250() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 13);
		Barrio saltaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 1);
		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 13);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3250, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurConstruyeDosCasasEnBsAsNorteYContrincanteAlCaerPaga3500(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.aceptar(traspie);
		buenosAiresNorte.aceptar(traspie);
		
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresSur);
		
		Jugador regio = new Jugador();
		int dineroAntesDeAlquilar = regio.obtenerDinero();
		buenosAiresSur.aceptar(regio);
		assertEquals(regio.obtenerDinero(), dineroAntesDeAlquilar - 3500);
	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEstaAreaSuDineroDeberiaDisminuirseEn3500() {
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
		unJugador.construir(BsAsSur);
		unJugador.construir(BsAsNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 2);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3500, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEnSurSuDineroDeberiaDisminuirseEn2500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 6);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 2500, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn1800() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 9);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 1800, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurYNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn2900() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 9);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 2900, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn3250() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 13);
		Barrio saltaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 1);
		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 13);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3250, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaSaltaNorteYSurCon2CasasEnSurYNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn3850() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 13);
		Barrio saltaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 1);
		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 13);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3850, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurConstruyeDosCasasEnNorteYUnaEnSurYNoPuedeConstruirHotelEnNorte(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.aceptar(traspie);
		buenosAiresNorte.aceptar(traspie);
		
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresNorte);
		traspie.construir(buenosAiresNorte);
		int dineroAntesDeIntentarConstruirHotel = traspie.obtenerDinero();
		traspie.construir(buenosAiresNorte);
		
		assertEquals(dineroAntesDeIntentarConstruirHotel, traspie.obtenerDinero());
	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurY1EnNorteYConstruyeUnHotelSuDineroNoDeberiaDisminuir() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(cordobaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurCon2CasasEnSurY1EnNorteYConstruyeUnHotelSuDineroNoDeberiaDisminuir() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 13);
		Barrio saltaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 1);
		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(saltaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurConstruyeDosCasasEnAmbasYAlConstruirHotelEnSurSuDineroSeDecrementaEn8mil(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.aceptar(traspie);
		buenosAiresNorte.aceptar(traspie);
		
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresNorte);
		traspie.construir(buenosAiresNorte);
		
		int dineroAntesDeIntentarConstruirHotel = traspie.obtenerDinero();
		traspie.construir(buenosAiresSur);
		
		assertEquals(traspie.obtenerDinero(), dineroAntesDeIntentarConstruirHotel - 8000);
	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurYNorteYConstruyeUnHotelEnElSurSuDineroDeberiaDisminuirEn3mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(cordobaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 3000, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurYNorteYConstruyeUnHotelEnNorteSuDineroDeberiaDisminuirEn3500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(cordobaNorte);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 3500, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurCon2CasasEnSurYNorteYConstruyeUnHotelSuDineroDeberiaDisminuirEn7500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 13);
		Barrio saltaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 1);
		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaNorte);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(saltaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 7500, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurConstruyeDosCasasEnAmbasYHotelEnSurLuegoUnContrincanteCaeEnNorteYPagaAlquier(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.aceptar(traspie);
		buenosAiresNorte.aceptar(traspie);
		
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresNorte);
		traspie.construir(buenosAiresNorte);
		traspie.construir(buenosAiresSur);
		Jugador regio = new Jugador();
		int dineroAntesDeCaerEnBarrioConHotel = regio.obtenerDinero();
		buenosAiresSur.aceptar(regio);
		
		assertEquals(regio.obtenerDinero(), dineroAntesDeCaerEnBarrioConHotel - 5000);
	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurConUnHotelEnElSurYUnContrincanteCaeEnCordobaSurSuDineroDeberiaDisminuirEn3mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaSur);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 6);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3000, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurConUnHotelEnNorteYUnContrincanteCaeEnCordobaNorteSuDineroDeberiaDisminuirEn3500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 6);
		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 3);
		Barrio cordobaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 9);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3500, dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurConHotelYUnContrincanteCaeEnSaltaSurSuDineroDeberiaDisminuirEn5500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 13);
		Barrio saltaNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);
		tablero.avanzarJugador(unJugador, 1);
		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaSur);
		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 14);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 5500, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConSantaFeYConstruyeUnaCasaSuDineroDeberiaReducirseEn4mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 11);
		Barrio SantaFe = (Barrio) tablero.getPosicionDeJugador(unJugador);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(SantaFe);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 4000, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConNeuquenYConstruyeUnaCasaSuDineroDeberiaReducirseEn4800() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 17);
		Barrio Neuquen = (Barrio) tablero.getPosicionDeJugador(unJugador);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(Neuquen);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 4800, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConTucumanYConstruyeUnaCasaSuDineroDeberiaReducirseEn7mil() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 19);
		Barrio Tucuman = (Barrio) tablero.getPosicionDeJugador(unJugador);
		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(Tucuman);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 7000, dineroPosterior);
	}
	
	@Test
	public void unJugadorCuentaConSantaFeYUnaCasaYUnContrincanteCaeEnSantaFeSuDineroDeberiaReducirseEn3500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 11);
		Barrio SantaFe = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(SantaFe);
		Jugador otroJugador = jugadores.get(2);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 11);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3500, dineroPosterior);
	}
	
	@Test
	public void unJugadorCuentaConNeuquenYUnaCasaYUnContrincanteCaeEnSantaFeSuDineroDeberiaReducirseEn3800() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 17);
		Barrio Neuquen = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(Neuquen);
		Jugador otroJugador = jugadores.get(2);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 17);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 3800, dineroPosterior);
	}
	
	@Test
	public void unJugadorCuentaConTucumanYUnaCasaYUnContrincanteCaeEnSantaFeSuDineroDeberiaReducirseEn4500() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		tablero.avanzarJugador(unJugador, 19);
		Barrio Tucuman = (Barrio) tablero.getPosicionDeJugador(unJugador);
		unJugador.construir(Tucuman);
		Jugador otroJugador = jugadores.get(2);
		int dineroInicial = otroJugador.obtenerDinero();
		tablero.avanzarJugador(otroJugador, 19);
		int dineroPosterior = otroJugador.obtenerDinero();
		assertEquals(dineroInicial - 4500, dineroPosterior);
	}
}
