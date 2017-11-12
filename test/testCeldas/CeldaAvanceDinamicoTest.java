package testCeldas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.celdas.especiales.CeldaAvanceDinamico;
import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;

public class CeldaAvanceDinamicoTest {

	@Test
	public void CeldaAvanceDinamicoRecienCreadaDeveriaExistir() {
		CeldaAvanceDinamico unaCelda = new CeldaAvanceDinamico();
		assertNotNull(unaCelda);
	}
	
	@Test
	public void JugadorCaeEnCeldaAvanceDinamicoSacandoUnDosElAvanceDeberiaSerCero() {
		CeldaAvanceDinamico avanceDinamico = new CeldaAvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(1);
		dado2.setValor(1);
		int resultado = avanceDinamico.calcularAvance(jugador,dado1,dado2);
		Assert.assertEquals(0, resultado);
	}

	@Test
	public void JugadorCaeEnCeldaAvanceDinamicoSacandoUnSieteElAvanceDeberiaSer5() {
		CeldaAvanceDinamico avanceDinamico = new CeldaAvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(2);
		dado2.setValor(5);
		int resultado = avanceDinamico.calcularAvance(jugador,dado1,dado2);
		Assert.assertEquals(5, resultado);
	}

	@Test
	public void JugadorSinProiedadesCaeEnCeldaAvanceDinamicoSacandoUn12ElAvanceDeberiaSer12() {
		CeldaAvanceDinamico avanceDinamico = new CeldaAvanceDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(6);
		dado2.setValor(6);
		int resultado = avanceDinamico.calcularAvance(jugador,dado1,dado2);
		Assert.assertEquals(12, resultado);
	}
	
	@Test
	public void JugadorCaeEnCeldaAvanceDinamicoSacandoUn10ConCapital333ElAvanceDeberiaSer3() {
		CeldaAvanceDinamico avanceDinamico = new CeldaAvanceDinamico();
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
