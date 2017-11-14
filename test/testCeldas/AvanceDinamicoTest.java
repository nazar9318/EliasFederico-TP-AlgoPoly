package testCeldas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;

public class AvanceDinamicoTest {

	@Test
	public void AvanceDinamicoRecienCreadaDeveriaExistir() {
		AvanceDinamico unaCelda = new AvanceDinamico();
		assertNotNull(unaCelda);
	}
	
	@Test
	public void JugadorCaeEnAvanceDinamicoSacandoUnDosElAvanceDeberiaSerCero() {
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(1);
		dado2.setValor(1);
		int resultado = avanceDinamico.calcularAvance(jugador,dado1,dado2);
		Assert.assertEquals(0, resultado);
	}

	@Test
	public void JugadorCaeEnAvanceDinamicoSacandoUnSieteElAvanceDeberiaSer5() {
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(2);
		dado2.setValor(5);
		int resultado = avanceDinamico.calcularAvance(jugador,dado1,dado2);
		Assert.assertEquals(5, resultado);
	}

	@Test
	public void JugadorSinProiedadesCaeEnAvanceDinamicoSacandoUn12ElAvanceDeberiaSer12() {
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(6);
		dado2.setValor(6);
		int resultado = avanceDinamico.calcularAvance(jugador,dado1,dado2);
		Assert.assertEquals(12, resultado);
	}
	
	@Test
	public void JugadorCaeEnAvanceDinamicoSacandoUn10ConCapital333ElAvanceDeberiaSer3() {
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Jugador jugador = new Jugador();
		int monto = 99667;
		jugador.pagar(monto);
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(5);
		dado2.setValor(5);
		int resultado = avanceDinamico.calcularAvance(jugador,dado1,dado2);
		Assert.assertEquals(3, resultado);
	}
}
