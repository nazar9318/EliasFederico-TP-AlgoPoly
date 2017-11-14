package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class PoliciaTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void policiaMandaALaCarcelAJugadorYEsteNoPuedeSalir(){
		Carcel carcel = new Carcel();
		Jugador unJugador = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(unJugador);
		carcel.sacarJugador(unJugador);
	}
	
	@Test
	public void policiaMandaALaCarcelAJugadorYPasadoUnTurnoPuedeSalirConFianza() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeDosTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYSaleDespuesDeTresTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(100000, jugador.obtenerDinero());
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientes(){
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		
		jugador.pagar(60000);
				
		policia.arrestarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientesCuandoOtroYaCayoEnLaCarcel(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		Mordecai.pagar(60000);
		
		carcel.encarcelarJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
	}
	
	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void jugadorCaePorPrimeraVezEnCarcelYNoPuedeSalirCuandoOtroYaEstuvoMasDeUnTurno(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.encarcelarJugador(Rigby);
		
		carcel.sacarJugador(Rigby);
	}
	
	@Test
	public void jugadorPuedePagarFianzaDespuesDeUnTurnoAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.encarcelarJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
		
		assertEquals(55000, Mordecai.obtenerDinero());
	}
	
	@Test
	public void jugadorSaleDeLaCarlcelDespuesDeTresTurnosAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.arrestarJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.encarcelarJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
	}

}
