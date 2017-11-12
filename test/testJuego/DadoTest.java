package testJuego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Dado;


public class DadoTest {

	@Test
	public void dadoRecienCreadoDeberiaExistir(){
		Dado unDado = new Dado();
		assertNotNull(unDado);
	}
	
	@Test
	public void TirarUnDadoDeberiaDevolverUnNumeroEntre1y6() {
		Dado unDado = new Dado();
		int numero = unDado.tirar();
		int maximo = 6;
		assertTrue(numero > 0 && numero <= maximo);
	}

}
