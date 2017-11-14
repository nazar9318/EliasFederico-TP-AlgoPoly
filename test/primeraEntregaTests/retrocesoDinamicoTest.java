package primeraEntregaTests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;

public class retrocesoDinamicoTest {

	@Test
	public void jugadorCon100MilDeCapitalCaeEnRetrocesoDinamicoSumando10SuPosicionNoDeberiaCambiar() {
		Tablero tablero = new Tablero();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Jugador jugador = new Jugador();
		tablero.agregarCelda(retrocesoDinamico);
		tablero.agregarJugador(jugador);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(5);
		dado2.setValor(5);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		tablero.avanzarJugador(jugador, 1);
		Visitable esperado = tablero.getPosicionDeJugador(jugador);
		tablero.avanzarJugador(jugador, retrocesoDinamico.calcularRetroceso(jugador));
		Visitable resultado = tablero.getPosicionDeJugador(jugador);
		Assert.assertEquals(esperado, resultado);
	}
	@Test
	public void jugadorCaeEnRetrocesoDinamicoSumando9SuPosicionDeberiaRetroceder1() {
		Tablero tablero = new Tablero();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Jugador jugador = new Jugador();
		tablero.agregarCelda(retrocesoDinamico);
		tablero.agregarJugador(jugador);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(1);
		dado2.setValor(8);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		Visitable esperado = tablero.getPosicionDeJugador(jugador);
		tablero.avanzarJugador(jugador, 1);
		tablero.avanzarJugador(jugador, retrocesoDinamico.calcularRetroceso(jugador));
		Visitable resultado = tablero.getPosicionDeJugador(jugador);
		Assert.assertEquals(esperado, resultado);
	}
	

}
