package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcel;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class CarcelTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcel.class)
	public void testJugadorCaeEnLaCarcelYNoPuedeMoverse() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		
		carcel.encarcelarJugador(jugador);
		
		carcel.sacarJugador(jugador);
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeUnTurno() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		
		carcel.encarcelarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeDosTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		
		carcel.encarcelarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYSaleDespuesDeTresTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		
		carcel.encarcelarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(100000, jugador.obtenerDinero());
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagar.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientes(){
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		
		jugador.pagar(60000);
		
		carcel.encarcelarJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagar.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientesCuandoOtroYaCayoEnLaCarcel(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		carcel.encarcelarJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		Mordecai.pagar(60000);
		
		carcel.encarcelarJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
	}
	
	@Test (expected=JugadorNoPuedeSalirDeLaCarcel.class)
	public void jugadorCaePorPrimeraVezEnCarcelYNoPuedeSalirCuandoOtroYaEstuvoMasDeUnTurno(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		carcel.encarcelarJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.encarcelarJugador(Rigby);
		
		carcel.sacarJugador(Rigby);
	}
	
	@Test
	public void jugadorPuedePagarFianzaDespuesDeUnTurnoAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		carcel.encarcelarJugador(Mordecai);
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
		
		carcel.encarcelarJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.encarcelarJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
	}
	
}
