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
		tablero.avanzarJugador(jugador, 1);

		Assert.assertTrue(jugador.puedeEdificarEn(jugador.getPropiedades().get(0)));
	}

	@Test
	public void jugadorCompraBuenosAiresSurVerificaQueNoPuedeEdificar(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());
		tablero.avanzarJugador(jugador, 2);

		Assert.assertFalse(jugador.puedeEdificarEn(jugador.getPropiedades().get(0)));
	}
}
