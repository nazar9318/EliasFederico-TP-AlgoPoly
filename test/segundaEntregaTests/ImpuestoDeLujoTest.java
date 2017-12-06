package segundaEntregaTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import fiuba.algo3.modelo.celdas.Visitable;
import org.junit.Test;

import fiuba.algo3.modelo.AlgoPoly;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.especiales.ImpuestoDeLujo;

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
	
	@Test
	public void jugadorCaeEnCeldaImpuestoDeLujoSuDineroDeberiaReducirseEnUn10Porciento() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		Visitable imp = tablero.avanzarJugador(unJugador, 10);
		imp.aceptar(unJugador);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 10000, dineroPosterior);
	}
}
