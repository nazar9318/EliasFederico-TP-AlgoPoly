package segundaEntregaTests;

import static org.junit.Assert.*;
import java.util.ArrayList;

import fiuba.algo3.modelo.celdas.Visitable;
import org.junit.Test;

import fiuba.algo3.modelo.AlgoPoly;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.modelo.celdas.comprables.CordobaNorte;
import fiuba.algo3.modelo.celdas.comprables.CordobaSur;
import fiuba.algo3.modelo.celdas.comprables.Neuquen;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.celdas.comprables.SaltaNorte;
import fiuba.algo3.modelo.celdas.comprables.SaltaSur;
import fiuba.algo3.modelo.celdas.comprables.SantaFe;
import fiuba.algo3.modelo.celdas.comprables.Tucuman;

public class BarriosTest {

	@Test
	public void jugadorCompraBuenosAiresSurSuDineroDeberiaReducirseEn20mil() {
		Jugador traspie = new Jugador();
		Barrio bsAsSur = new BuenosAiresSur();
		
		int dineroInicial = traspie.obtenerDinero();
		bsAsSur.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();
		assertEquals(dineroInicial - bsAsSur.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraBuenosAiresSurYSuDineroSeReduceEn20mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 2);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraBuenosAiresNorteSuDineroDeberiaReducirseEn25mil() {
		Jugador jugador = new Jugador();
		Barrio bsAsNorte = new BuenosAiresNorte();
		
		int dineroInicial = jugador.obtenerDinero();
		bsAsNorte.comprar(jugador);
		int dineroPosterior = jugador.obtenerDinero();

		assertEquals(dineroInicial - bsAsNorte.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraBuenosAiresNorteYSuDineroSeReduceEn25Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 4);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraCordobaSurSuDineroDeberiaReducirseEn18mil() {
		Jugador traspie = new Jugador();
		Barrio cordobaSur = new CordobaSur();
		
		int dineroInicial = traspie.obtenerDinero();
		cordobaSur.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();
		assertEquals(dineroInicial - cordobaSur.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraCordobaSurYSuDineroSeReduceEn18Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 6);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraCordobaNorteSuDineroDeberiaReducirseEn20mil() {
		Jugador traspie = new Jugador();
		Barrio cordobaNorte = new CordobaNorte();
		
		int dineroInicial = traspie.obtenerDinero();
		cordobaNorte.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();

			assertEquals(dineroInicial - cordobaNorte.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraCordobaNorteYSuDineroSeReduceEn20Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 9);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraSantaFeSuDineroDeberiaReducirseEn15mil() {
		Jugador traspie = new Jugador();
		Barrio santaFe = new SantaFe();
		
		int dineroInicial = traspie.obtenerDinero();
		santaFe.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();

		assertEquals(dineroInicial - santaFe.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraSantaFeYSuDineroSeReduceEn15Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 11);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}

	@Test
	public void jugadorCompraSaltaNorteSuDineroDeberiaReducirseEn23mil() {
		Jugador traspie = new Jugador();
		Barrio saltaNorte = new SaltaNorte();
		
		int dineroInicial = traspie.obtenerDinero();
		saltaNorte.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();

		assertEquals(dineroInicial - saltaNorte.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraSaltaNorteYSuDineroSeReduceEn23Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 13);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraSaltaSurSuDineroDeberiaReducirseEn23mil() {
		Jugador traspie = new Jugador();
		Barrio saltaSur = new SaltaSur();
		
		int dineroInicial = traspie.obtenerDinero();
		saltaSur.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();

		assertEquals(dineroInicial - saltaSur.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraSaltaSurYSuDineroSeReduceEn23Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 14);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraNeuquenSuDineroDeberiaReducirseEn17mil() {
		Jugador traspie = new Jugador();
		Barrio neuquen = new Neuquen();
		
		int dineroInicial = traspie.obtenerDinero();
		neuquen.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();

		assertEquals(dineroInicial - neuquen.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraNeuqenYSuDineroSeReduceEn17Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 17);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCompraTucumanSuDineroDeberiaReducirseEn25mil() {
		Jugador traspie = new Jugador();
		Barrio tucuman = new Tucuman();
		
		int dineroInicial = traspie.obtenerDinero();
		tucuman.comprar(traspie);
		int dineroPosterior = traspie.obtenerDinero();

		assertEquals(dineroInicial - tucuman.getPrecioTerreno(), dineroPosterior);
	}
	
	@Test
	public void jugadorRecorreTableroCompraTucumanYSuDineroSeReduceEn25Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 19);
		nueva.comprar(unJugador);

		int dineroPosterior = unJugador.obtenerDinero();
		int costoTerreno = ((Propiedad) tablero.getPosicionDeJugador(unJugador)).getPrecioTerreno();

		assertEquals(dineroInicial - costoTerreno, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConBsAsSurYBsAsNorteYConstruyeUnaCasaSuDineroDeberiaReducirseEn5mil() {
		Jugador chade = new Jugador();
		
		Barrio bsAsSur = new BuenosAiresSur();
		Barrio bsAsNorte = new BuenosAiresNorte();
		
		bsAsSur.comprar(chade);
		bsAsNorte.comprar(chade);
		
		int dineroAntesDeConstruir = chade.obtenerDinero();
		chade.construir(bsAsSur);
		int dineroDespuesDeConstruir = chade.obtenerDinero();

		assertEquals(dineroAntesDeConstruir - bsAsSur.getPrecioCasa(), dineroDespuesDeConstruir);
	}
	
	@Test
	public void jugadorRecorreTableroCompraLasDosBuenosAiresYConstruyeUnaCasaSuDineroSeReduceEn5Mil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio BsAsSur = (Barrio) tablero.avanzarJugador(unJugador, 2);
		BsAsSur.comprar(unJugador);

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 2);
		nueva.comprar(unJugador);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(BsAsSur);
		int dineroPosterior = unJugador.obtenerDinero();
		int costoConstruccion = BsAsSur.getPrecioCasa();

		assertEquals(dineroInicial - costoConstruccion, dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConCordobaSurYCordobaNorteYConstruyeUnaCasaSuDineroDeberiaReducirseEn2mil() {
		Jugador traspie = new Jugador();
		Barrio cordobaSur = new CordobaSur();
		Barrio cordobaNorte = new CordobaNorte();
		
		cordobaSur.conocer(cordobaNorte);
		cordobaNorte.conocer(cordobaSur);
		
		cordobaSur.comprar(traspie);
		cordobaNorte.comprar(traspie);

		int dineroAntesDeConstruir = traspie.obtenerDinero();
		traspie.construir(cordobaSur);
		
		assertEquals(traspie.obtenerDinero(), dineroAntesDeConstruir - cordobaSur.getPrecioCasa());
	}
	
	@Test
	public void jugadorRecorreTableroCompraLasDosCordobasConstruyeEnUnaYSuDineroSeReduceEnDosMil(){
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 6);
		nueva.comprar(unJugador);

		Barrio cordobaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);

		Propiedad propiedad = (Propiedad) tablero.avanzarJugador(unJugador, 3);
		propiedad.comprar(unJugador);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(cordobaSur);
		int dineroPosterior = unJugador.obtenerDinero();

		assertEquals(dineroInicial - cordobaSur.getPrecioCasa(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConSaltaSurYSaltaNorteYConstruyeUnaCasaSuDineroDeberiaReducirseEn4500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();

		Jugador unJugador = jugadores.get(0);

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 13);
		nueva.comprar(unJugador);

		Barrio saltaSur = (Barrio) tablero.getPosicionDeJugador(unJugador);

		Propiedad propiedad = (Propiedad) tablero.avanzarJugador(unJugador, 1);
		propiedad.comprar(unJugador);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(saltaSur);
		int dineroPosterior = unJugador.obtenerDinero();

		assertEquals(dineroInicial - saltaSur.getPrecioCasa(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConBsAsSurYBsAsNorteConUnaCasaEnBsAsSurAlCaerUnContrincanteSuDineroDeberiaReducirseEn3mil(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.comprar(traspie);
		buenosAiresNorte.comprar(traspie);
		traspie.construir(buenosAiresSur);
		
		Jugador regio = new Jugador();
		int dineroAntesDeAlquilar = regio.obtenerDinero();
		buenosAiresSur.aceptar(regio);

		assertEquals(regio.obtenerDinero(), dineroAntesDeAlquilar - buenosAiresSur.getAlquilerActual());
	}
	
	@Test
	public void jugadorRecorreTableroComprandoBsAsNorteYSurContrincanteRecorreTableroCaeEnBsAsSurYPagaTresMilPesos() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Propiedad nueva = (Propiedad) tablero.avanzarJugador(unJugador, 2);
		nueva.comprar(unJugador);
		Barrio BsAsSur = (Barrio) tablero.getPosicionDeJugador(unJugador);

		Propiedad prop = (Propiedad) tablero.avanzarJugador(unJugador, 2);
		prop.comprar(unJugador);

		Barrio BsAsNorte = (Barrio) tablero.getPosicionDeJugador(unJugador);

		unJugador.construir(BsAsSur);
		unJugador.construir(BsAsNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable celda = tablero.avanzarJugador(otroJugador, 2);
		celda.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - BsAsSur.getAlquilerActual(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurConUnaCasaEnAmbasYUnContrincanteCaeEnCordobaSurSuDineroDeberiaReducirseEn1500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 6);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - cordobaSur.getAlquilerActual(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurConUnaCasaEnAmbasYUnContrincanteCaeEnSaltaNorteSuDineroDeberiaReducirseEn3250() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio saltaNorte = (Barrio) tablero.avanzarJugador(unJugador, 13);
		saltaNorte.comprar(unJugador);

		Barrio saltaSur = (Barrio) tablero.avanzarJugador(unJugador, 1);
		saltaSur.comprar(unJugador);

		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 13);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - saltaNorte.getAlquilerActual(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurConstruyeDosCasasEnBsAsNorteYContrincanteAlCaerPaga3500(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.comprar(traspie);
		buenosAiresNorte.comprar(traspie);
		
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresSur);
		
		Jugador regio = new Jugador();
		int dineroAntesDeAlquilar = regio.obtenerDinero();
		buenosAiresSur.aceptar(regio);

		assertEquals(regio.obtenerDinero(), dineroAntesDeAlquilar - buenosAiresSur.getAlquilerActual());
	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEstaAreaSuDineroDeberiaDisminuirseEn3500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio BsAsSur = (Barrio) tablero.avanzarJugador(unJugador, 2);
		BsAsSur.comprar(unJugador);

		Barrio BsAsNorte = (Barrio) tablero.avanzarJugador(unJugador, 2);
		BsAsNorte.comprar(unJugador);

		unJugador.construir(BsAsSur);
		unJugador.construir(BsAsSur);
		unJugador.construir(BsAsNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 2);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - BsAsSur.getAlquilerActual(), dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEnSurSuDineroDeberiaDisminuirseEn2500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 6);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - cordobaSur.getAlquilerActual(), dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn1800() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 9);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - cordobaNorte.getAlquilerActual(), dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurYNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn2900() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 9);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - cordobaNorte.getAlquilerActual(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurCon2CasasEnSurY1EnNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn3250() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio saltaNorte = (Barrio) tablero.avanzarJugador(unJugador, 13);
		saltaNorte.comprar(unJugador);

		Barrio saltaSur = (Barrio) tablero.avanzarJugador(unJugador, 1);
		saltaSur.comprar(unJugador);

		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 13);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - saltaNorte.getAlquilerActual(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaSaltaNorteYSurCon2CasasEnSurYNorteUnContrincanteCaeEnEnNorteSuDineroDeberiaDisminuirseEn3850() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio saltaNorte = (Barrio) tablero.avanzarJugador(unJugador, 13);
		saltaNorte.comprar(unJugador);

		Barrio saltaSur = (Barrio) tablero.avanzarJugador(unJugador, 1);
		saltaSur.comprar(unJugador);

		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 13);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - saltaNorte.getAlquilerActual(), dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurConstruyeDosCasasEnNorteYUnaEnSurYNoPuedeConstruirHotelEnNorte(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.comprar(traspie);
		buenosAiresNorte.comprar(traspie);
		
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

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

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

		Barrio saltaNorte = (Barrio) tablero.avanzarJugador(unJugador, 13);
		saltaNorte.comprar(unJugador);

		Barrio saltaSur = (Barrio) tablero.avanzarJugador(unJugador, 1);
		saltaSur.comprar(unJugador);

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
		
		buenosAiresSur.comprar(traspie);
		buenosAiresNorte.comprar(traspie);
		
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresNorte);
		traspie.construir(buenosAiresNorte);
		
		int dineroAntesDeIntentarConstruirHotel = traspie.obtenerDinero();
		traspie.construir(buenosAiresSur);
		
		assertEquals(traspie.obtenerDinero(), dineroAntesDeIntentarConstruirHotel - buenosAiresSur.getPrecioHotel());
	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurCon2CasasEnSurYNorteYConstruyeUnHotelEnElSurSuDineroDeberiaDisminuirEn3mil() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(cordobaSur);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - cordobaSur.getPrecioHotel(), dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurCon2CasasEnSurYNorteYConstruyeUnHotelSuDineroDeberiaDisminuirEn7500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio saltaNorte = (Barrio) tablero.avanzarJugador(unJugador, 13);
		saltaNorte.comprar(unJugador);

		Barrio saltaSur = (Barrio) tablero.avanzarJugador(unJugador, 1);
		saltaSur.comprar(unJugador);

		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaNorte);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(saltaSur);
		int dineroPosterior = unJugador.obtenerDinero();

		assertEquals(dineroInicial - saltaSur.getPrecioHotel(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConBsAsNorteYSurConstruyeDosCasasEnAmbasYHotelEnSurLuegoUnContrincanteCaeEnSurYPagaAlquier(){
		Jugador traspie = new Jugador();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		
		buenosAiresSur.conocer(buenosAiresNorte);
		buenosAiresNorte.conocer(buenosAiresSur);
		
		buenosAiresSur.comprar(traspie);
		buenosAiresNorte.comprar(traspie);
		
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresSur);
		traspie.construir(buenosAiresNorte);
		traspie.construir(buenosAiresNorte);
		traspie.construir(buenosAiresSur);

		Jugador regio = new Jugador();
		int dineroAntesDeCaerEnBarrioConHotel = regio.obtenerDinero();
		buenosAiresSur.aceptar(regio);
		
		assertEquals(regio.obtenerDinero(), dineroAntesDeCaerEnBarrioConHotel - buenosAiresSur.getAlquilerActual());
	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurConUnHotelEnElSurYUnContrincanteCaeEnCordobaSurSuDineroDeberiaDisminuirEn3mil() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaSur);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 6);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - cordobaSur.getAlquilerActual(), dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConCordobaNorteYSurConUnHotelEnNorteYUnContrincanteCaeEnCordobaNorteSuDineroDeberiaDisminuirEn3500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio cordobaSur = (Barrio) tablero.avanzarJugador(unJugador, 6);
		cordobaSur.comprar(unJugador);

		Barrio cordobaNorte = (Barrio) tablero.avanzarJugador(unJugador, 3);
		cordobaNorte.comprar(unJugador);

		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaSur);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);
		unJugador.construir(cordobaNorte);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 9);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - cordobaNorte.getAlquilerActual(), dineroPosterior);

	}
	
	@Test
	public void jugadorCuentaConSaltaNorteYSurConHotelYUnContrincanteCaeEnSaltaSurSuDineroDeberiaDisminuirEn5500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio saltaNorte = (Barrio) tablero.avanzarJugador(unJugador, 13);
		saltaNorte.comprar(unJugador);

		Barrio saltaSur = (Barrio) tablero.avanzarJugador(unJugador, 1);
		saltaSur.comprar(unJugador);

		unJugador.construir(saltaSur);
		unJugador.construir(saltaSur);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaNorte);
		unJugador.construir(saltaSur);

		Jugador otroJugador = jugadores.get(1);
		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 14);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - saltaSur.getAlquilerActual(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConSantaFeYConstruyeUnaCasaSuDineroDeberiaReducirseEn4mil() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio SantaFe = (Barrio) tablero.avanzarJugador(unJugador, 11);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(SantaFe);
		int dineroPosterior = unJugador.obtenerDinero();

		assertEquals(dineroInicial - SantaFe.getPrecioCasa(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConNeuquenYConstruyeUnaCasaSuDineroDeberiaReducirseEn4800() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio Neuquen = (Barrio) tablero.avanzarJugador(unJugador, 17);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(Neuquen);
		int dineroPosterior = unJugador.obtenerDinero();

		assertEquals(dineroInicial - Neuquen.getPrecioCasa(), dineroPosterior);
	}
	
	@Test
	public void jugadorCuentaConTucumanYConstruyeUnaCasaSuDineroDeberiaReducirseEn7mil() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio Tucuman = (Barrio) tablero.avanzarJugador(unJugador, 19);

		int dineroInicial = unJugador.obtenerDinero();
		unJugador.construir(Tucuman);
		int dineroPosterior = unJugador.obtenerDinero();

		assertEquals(dineroInicial - Tucuman.getPrecioCasa(), dineroPosterior);
	}
	
	@Test
	public void unJugadorCuentaConSantaFeYUnaCasaYUnContrincanteCaeEnSantaFeSuDineroDeberiaReducirseEn3500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio SantaFe = (Barrio) tablero.avanzarJugador(unJugador, 11);
		SantaFe.comprar(unJugador);

		unJugador.construir(SantaFe);
		Jugador otroJugador = jugadores.get(2);

		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 11);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - SantaFe.getAlquilerActual(), dineroPosterior);
	}
	
	@Test
	public void unJugadorCuentaConTucumanYUnaCasaYUnContrincanteCaeEnSantaFeSuDineroDeberiaReducirseEn4500() {
		AlgoPoly juego = new AlgoPoly();

		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();

		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);

		Barrio Tucuman = (Barrio) tablero.avanzarJugador(unJugador, 19);
		Tucuman.comprar(unJugador);

		unJugador.construir(Tucuman);
		Jugador otroJugador = jugadores.get(2);

		int dineroInicial = otroJugador.obtenerDinero();
		Visitable nueva = tablero.avanzarJugador(otroJugador, 19);
		nueva.aceptar(otroJugador);
		int dineroPosterior = otroJugador.obtenerDinero();

		assertEquals(dineroInicial - Tucuman.getAlquilerActual(), dineroPosterior);
	}

}
