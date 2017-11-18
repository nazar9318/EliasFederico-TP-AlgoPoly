package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.especiales.ImpuestoDeLujo;

public class ImpuestoDeLujoTest {

	@Test
	public void impuestoDeLujoRecienCreadoDeberiaExistir() {
		ImpuestoDeLujo impuesto = new ImpuestoDeLujo();
		assertNotNull(impuesto);
	}
	
	@Test
	public void jugadorCaeEnImpuestoDeLujoDeberiaCobrarseE10PorcientoDelCapitalDelJugador(){
		Jugador jugador = new Jugador();
		ImpuestoDeLujo impuesto = new ImpuestoDeLujo();
		int saldoInicial = jugador.obtenerDinero();
		impuesto.aceptar(jugador);
		int montoCobrado = impuesto.getValorAcumulado();
		int saldoFinal = jugador.obtenerDinero();
		assertEquals(saldoInicial - montoCobrado, saldoFinal);
	}
}
