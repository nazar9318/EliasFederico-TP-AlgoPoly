package testCeldas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.Dado;
import fiuba.algo3.Jugador;

public class RetrocesoDinamicoTest {

	@Test
	public void RetrocesoDinamicoRecienCreadaDeveriaExistir() {
		RetrocesoDinamico unaCelda = new RetrocesoDinamico();
		assertNotNull(unaCelda);
	}
	
	@Test
	public void JugadorRecienCreadoCaeEnRetrocesoDinamicoSacandoDiezElRetrocesoDeberiaSerCero() {
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(5);
		dado2.setValor(5);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		int resultado = retrocesoDinamico.calcularRetroceso(jugador);
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void JugadorSinPropiedadesCaeEnRetrocesoDinamicoSacandoUnSeisElRetrocesoDeberiaSer6() {
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(1);
		dado2.setValor(5);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		int resultado = retrocesoDinamico.calcularRetroceso(jugador);
		Assert.assertEquals(-6, resultado);
	}
	
	@Test
	public void JugadorCaeEnRetrocesoDinamicoSacandoUn12ElRetrocesoDeberiaSer10() {
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Jugador jugador = new Jugador();
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		dado1.setValor(6);
		dado2.setValor(6);
		jugador.setValorDeTiro(dado1.getValor() + dado2.getValor());
		int resultado = retrocesoDinamico.calcularRetroceso(jugador);
		Assert.assertEquals(-10, resultado);
	}

}
