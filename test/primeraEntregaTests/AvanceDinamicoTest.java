package primeraEntregaTests;

import fiuba.algo3.modelo.celdas.Salida;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.modelo.Dado;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.especiales.AvanceDinamico;
import sun.security.x509.AVA;

public class AvanceDinamicoTest {

	@Test
	public void jugadorCaeEnAvanceDinamicoSumandoDosSuPosicionNoDeberiaCambiar() {
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		jugador.conocerTablero(tablero);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(avanceDinamico);
		tablero.agregarJugador(jugador);
		dado1.setValor(1);
		dado2.setValor(1);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		tablero.avanzarJugador(jugador, 1);

		Assert.assertEquals(avanceDinamico, tablero.getPosicionDeJugador(jugador));
	}
	
	@Test()
	public void jugadorCaeEnAvanceDinamicoSumando9SuPosicionDeberiaAvanzar1() {
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		jugador.conocerTablero(tablero);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(avanceDinamico);
		Visitable esperado = new Salida();
		tablero.agregarCelda(esperado);
		tablero.agregarJugador(jugador);
		dado1.setValor(1);
		dado2.setValor(8);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		AvanceDinamico nueva = (AvanceDinamico) tablero.avanzarJugador(jugador, 1);

		int avance = nueva.getMovimiento().calcularMovimiento(jugador);
		jugador.moverJugador(avance);

		Assert.assertEquals(esperado, tablero.getPosicionDeJugador(jugador));
	}
	
	@Test
	public void jugadorSinPropiedadesCaeEnAvanceDinamicoSumando11SuPosicionDeberiaAvanzar11() {
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		jugador.conocerTablero(tablero);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(avanceDinamico);
		for (int i=0; i < 10; i++) tablero.agregarCelda(new Salida());
		Visitable esperado = new Salida();
		tablero.agregarCelda(esperado);
		
		tablero.agregarJugador(jugador);
		dado1.setValor(3);
		dado2.setValor(8);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		AvanceDinamico nueva = (AvanceDinamico) tablero.avanzarJugador(jugador, 1);

		int avance = nueva.getMovimiento().calcularMovimiento(jugador);
		jugador.moverJugador(avance);

		Visitable resultado = tablero.getPosicionDeJugador(jugador);

		Assert.assertEquals(esperado, resultado);
	}
}
