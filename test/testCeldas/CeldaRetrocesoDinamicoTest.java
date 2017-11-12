package testCeldas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.celdas.especiales.CeldaRetrocesoDinamico;
import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;

public class CeldaRetrocesoDinamicoTest {

	@Test
	public void CeldaRetrocesoDinamicoRecienCreadaDeveriaExistir() {
		CeldaRetrocesoDinamico unaCelda = new CeldaRetrocesoDinamico();
		assertNotNull(unaCelda);
	}
	
	@Test
	public void JugadorRecienCreadoCaeEnCeldaRetrocesoDinamicoSacandoDiezElRetrocesoDeberiaSerCero() {
		CeldaRetrocesoDinamico retrocesoDinamico = new CeldaRetrocesoDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(5);
		dado2.setValor(5);
		int resultado = retrocesoDinamico.calcularRetroceso(jugador,dado1,dado2);
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void JugadorSinPropiedadesCaeEnCeldaRetrocesoDinamicoSacandoUnSeisElRetrocesoDeberiaSer6() {
		CeldaRetrocesoDinamico retrocesoDinamico = new CeldaRetrocesoDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(1);
		dado2.setValor(5);
		int resultado = retrocesoDinamico.calcularRetroceso(jugador,dado1,dado2);
		Assert.assertEquals(6, resultado);
	}
	
	@Test
	public void JugadorCaeEnCeldaRetrocesoDinamicoSacandoUn12ElRetrocesoDeberiaSer10() {
		CeldaRetrocesoDinamico retrocesoDinamico = new CeldaRetrocesoDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(6);
		dado2.setValor(6);
		int resultado = retrocesoDinamico.calcularRetroceso(jugador,dado1,dado2);
		Assert.assertEquals(10, resultado);
	}

}
