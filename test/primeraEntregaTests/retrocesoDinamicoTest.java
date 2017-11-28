package primeraEntregaTests;

import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;

public class retrocesoDinamicoTest {

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
		tablero.avanzarJugador(jugador, 1);

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
		tablero.avanzarJugador(jugador, 1);

		Assert.assertEquals(esperado, tablero.getPosicionDeJugador(jugador));
	}
	
	@Test
	public void jugadorCaeEnRetrocesoDinamicoSumando11SuPosicionDeberiaRetroceder9() {
		Tablero tablero = new Tablero();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Visitable esperado = new Quini6();
		Jugador jugador = new Jugador();
		jugador.conocerTablero(tablero);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();

		tablero.agregarCelda(retrocesoDinamico);
		tablero.agregarCelda(esperado);
		for (int i=0; i < 7; i++)
			tablero.agregarCelda(new BuenosAiresSur());

		tablero.agregarJugador(jugador);
		dado1.setValor(3);
		dado2.setValor(8);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		tablero.avanzarJugador(jugador, 1);

		Assert.assertEquals(esperado, tablero.getPosicionDeJugador(jugador));
	}

}
