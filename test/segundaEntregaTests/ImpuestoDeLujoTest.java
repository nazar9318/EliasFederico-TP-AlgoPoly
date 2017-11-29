package segundaEntregaTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
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
	
	@Test
	public void jugadorCaeEnCeldaImpuestoDeLujoSuDineroDeberiaReducirseEnUn10Porciento() {
		AlgoPoly juego = new AlgoPoly();
		juego.inicializarJuego();
		ArrayList<Jugador> jugadores = juego.getJugadores();
		Tablero tablero = juego.getTablero();
		Jugador unJugador = jugadores.get(0);
		int dineroInicial = unJugador.obtenerDinero();
		tablero.avanzarJugador(unJugador, 10);
		int dineroPosterior = unJugador.obtenerDinero();
		assertEquals(dineroInicial - 10000, dineroPosterior);
	}
}