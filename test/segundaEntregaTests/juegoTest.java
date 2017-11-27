package segundaEntregaTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.AlgoPoly;

public class juegoTest {

	@Test
	public void comenzarJuegoDeberiaComenzarElJuegoYpararCuandoSoloQuedeUnUnicoJugadorGanador() {
		AlgoPoly juego = new AlgoPoly();
		int CantidadInicial = juego.getCantidadDeJugadores();
		juego.inicializarJuego();
		juego.comenzarJuego();
		assertEquals(CantidadInicial +1,juego.getCantidadDeJugadores());
	}

}
