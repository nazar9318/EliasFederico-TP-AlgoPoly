package testJuego;

import static org.junit.Assert.*;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Jugador;

public class JugadorTest {

	@Test
	public void jugadorRecienCreadoDeberiaExistir() {
		Jugador jugador = new Jugador();
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void jugadorRecienCreadoDeberiaTenerUnCapitalDe100MilPesos() {
		Jugador jugador = new Jugador();
		int capital = 100000;
		assertEquals(capital, jugador.obtenerDinero());
	}
	
	@Test
	public void jugadorRecienCreadoNoDeberiaTenerPropiedades() {
		Jugador jugador = new Jugador();
		assertEquals(0, jugador.getCantidadDePropiedades());
	}
	
	@Test 
	public void jugadorPagar50MilDeberiaDisminuirElCapitalDelJugadorEn50Mil() {
		Jugador jugador = new Jugador();
		int monto = 50000;
		jugador.pagar(monto);
		assertEquals(monto, jugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCobrar30MilDeberiaAumentarElCapitalDelJugadorEn30Mil() {
		Jugador jugador = new Jugador();
		int monto = 30000;
		jugador.cobrar(monto);
		assertEquals(130000, jugador.obtenerDinero());
	}

	@Test
	public void jugadorCompraBuenosAiresSurYNorteVerificaQuePuedeEdificar(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());
		tablero.avanzarJugador(jugador, 2);
		tablero.avanzarJugador(jugador, 2);

		Assert.assertTrue(jugador.poseeALaAsociadaDe(jugador.getPropiedades().get(0)));
	}

	@Test
	public void jugadorCompraBuenosAiresSurVerificaQueNoPuedeEdificar(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());
		tablero.avanzarJugador(jugador, 2);

		Assert.assertFalse(jugador.poseeALaAsociadaDe(jugador.getPropiedades().get(0)));
	}

	@Test
	public void jugadorCompraBuenosAiresSurLaVendeYSuDineroAumentaLoCorrecto(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());

		int dineroAnteriorALaCompra = jugador.obtenerDinero();
		tablero.avanzarJugador(jugador, 2);
		jugador.getPropiedades().get(0).vender(jugador);
		int dineroDespues = jugador.obtenerDinero();

		Assert.assertEquals(dineroDespues, dineroAnteriorALaCompra - 3000);
	}

	@Test
	public void jugadorCompraBuenosAiresSurLaVendeYNoPoseeMasElTerreno(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());
		tablero.avanzarJugador(jugador, 2);

		jugador.getPropiedades().get(0).vender(jugador);

		Assert.assertEquals(0, jugador.getPropiedades().size());
	}

	@Test
	public void jugadorCompraBuenosAiresSurOtroJugadorCaeYPagaAlquiler(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador1 = tablero.agregarJugador(new Jugador());
		Jugador jugador2 = tablero.agregarJugador(new Jugador());

		int dineroAnterior = jugador2.obtenerDinero();

		tablero.avanzarJugador(jugador1, 2);
		tablero.avanzarJugador(jugador2, 2);

		int dineroPosterior = jugador2.obtenerDinero();

		Assert.assertEquals(dineroPosterior, dineroAnterior - 2000);
	}
}
