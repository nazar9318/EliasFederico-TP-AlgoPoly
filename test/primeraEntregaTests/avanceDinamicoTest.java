package primeraEntregaTests;

import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Carcel;

public class avanceDinamicoTest {

	@Test
	public void jugadorCaeEnAvanceDinamicoSumandoDosSuPosicionNoDeberiaCambiar() {
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(avanceDinamico);
		tablero.agregarJugador(jugador);
		dado1.setValor(1);
		dado2.setValor(1);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		tablero.avanzarJugador(jugador, 1);
		Visitable esperado = tablero.getPosicionDeJugador(jugador);
		avanceDinamico.calcularAvance(jugador);
		tablero.avanzarJugador(jugador, avanceDinamico.getMovimiento());
		Visitable resultado = tablero.getPosicionDeJugador(jugador);

		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoSumando9SuPosicionDeberiaAvanzar1() {
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(avanceDinamico);
		tablero.agregarJugador(jugador);
		dado1.setValor(1);
		dado2.setValor(8);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		Visitable esperado = tablero.getPosicionDeJugador(jugador);
		tablero.avanzarJugador(jugador, 1);
		avanceDinamico.calcularAvance(jugador);
		tablero.avanzarJugador(jugador, avanceDinamico.getMovimiento());
		Visitable resultado = tablero.getPosicionDeJugador(jugador);

		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void jugadorSinPropiedadesCaeEnAvanceDinamicoSumando11SuPosicionDeberiaAvanzar11() {
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Visitable esperado = new Carcel();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(avanceDinamico);

		for (int i=0; i < 10; i++)
			tablero.agregarCelda(new BuenosAiresSur());

		tablero.agregarCelda(esperado);
		tablero.agregarJugador(jugador);
		dado1.setValor(3);
		dado2.setValor(8);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		tablero.avanzarJugador(jugador, 1);
		avanceDinamico.calcularAvance(jugador);
		tablero.avanzarJugador(jugador, avanceDinamico.getMovimiento());
		Visitable resultado = tablero.getPosicionDeJugador(jugador);

		Assert.assertEquals(esperado, resultado);
	}
}
