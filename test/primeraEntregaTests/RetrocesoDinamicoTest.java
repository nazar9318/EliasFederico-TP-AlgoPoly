package primeraEntregaTests;

import com.sun.org.apache.regexp.internal.RE;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresSur;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.modelo.Dado;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.especiales.Carcel;
import fiuba.algo3.modelo.celdas.especiales.Quini6;
import fiuba.algo3.modelo.celdas.especiales.RetrocesoDinamico;

public class RetrocesoDinamicoTest {

	@Test
	public void jugadorSinPropiedadesCaeEnRetrocesoDinamicoSumando2SuPosicionDeberiaRetroceder2() {
		Tablero tablero = new Tablero();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Visitable carcel = new Carcel();
		Jugador jugador = new Jugador();
		jugador.conocerTablero(tablero);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(retrocesoDinamico);
		tablero.agregarCelda(new BuenosAiresSur());
		tablero.agregarCelda(carcel);
		tablero.agregarJugador(jugador);
		dado1.setValor(1);
		dado2.setValor(1);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());

		RetrocesoDinamico nueva = (RetrocesoDinamico) tablero.avanzarJugador(jugador, 1);

		int retroceso = nueva.getMovimiento().calcularMovimiento(jugador);
		jugador.moverJugador(retroceso);

		Assert.assertEquals(carcel, tablero.getPosicionDeJugador(jugador));
	}
	@Test
	public void jugadorCon100MilDeCapitalCaeEnRetrocesoDinamicoSumando9SuPosicionDeberiaRetroceder1() {
		Tablero tablero = new Tablero();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Jugador jugador = new Jugador();
		jugador.conocerTablero(tablero);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(retrocesoDinamico);
		tablero.agregarJugador(jugador);
		dado1.setValor(1);
		dado2.setValor(8);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		Visitable esperado = tablero.getPosicionDeJugador(jugador);

		RetrocesoDinamico nueva = (RetrocesoDinamico) tablero.avanzarJugador(jugador, 1);

		int retroceso = nueva.getMovimiento().calcularMovimiento(jugador);
		jugador.moverJugador(retroceso);

		Assert.assertEquals(esperado, tablero.getPosicionDeJugador(jugador));
	}
}
