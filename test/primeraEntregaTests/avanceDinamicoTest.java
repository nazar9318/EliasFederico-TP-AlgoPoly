package primeraEntregaTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;

public class avanceDinamicoTest {

	@Test
	public void jugadorCaeEnAvanceDinamicoSumandoDosSuPosicionNoDeberiaCambiar() {
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		tablero.agregarCelda(avanceDinamico);
		tablero.agregarJugador(jugador);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(1);
		dado2.setValor(1);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		tablero.avanzarJugador(jugador, 1);
		Visitable esperado = tablero.getPosicionDeJugador(jugador);
		tablero.avanzarJugador(jugador, avanceDinamico.calcularAvance(jugador));
		Visitable resultado = tablero.getPosicionDeJugador(jugador);
		Assert.assertEquals(esperado, resultado);
	}
}
