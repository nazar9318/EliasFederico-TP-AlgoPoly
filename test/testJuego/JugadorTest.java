package testJuego;

import static org.junit.Assert.*;

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
}
