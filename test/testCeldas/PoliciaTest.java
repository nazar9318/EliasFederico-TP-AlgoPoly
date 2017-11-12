package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.celdas.especiales.CeldaCarcel;
import fiuba.algo3.celdas.especiales.CeldaPolicia;
import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcel;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class PoliciaTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcel.class)
	public void policiaMandaALaCarcelAJugadorYEsteNoPuedeSalir(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador unJugador = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(unJugador);
		carcel.sacarJugador(unJugador);
	}
	
	@Test
	public void policiaMandaALaCarcelAJugadorYPasadoUnTurnoPuedeSalirConFianza() {
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeDosTurnos() {
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYSaleDespuesDeTresTurnos() {
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(100000, jugador.obtenerDinero());
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagar.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientes(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		jugador.pagar(60000);
				
		policia.recibirJugador(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagar.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientesCuandoOtroYaCayoEnLaCarcel(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		Mordecai.pagar(60000);
		
		carcel.recibirJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
	}
	
	@Test (expected=JugadorNoPuedeSalirDeLaCarcel.class)
	public void jugadorCaePorPrimeraVezEnCarcelYNoPuedeSalirCuandoOtroYaEstuvoMasDeUnTurno(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.recibirJugador(Rigby);
		
		carcel.sacarJugador(Rigby);
	}
	
	@Test
	public void jugadorPuedePagarFianzaDespuesDeUnTurnoAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.recibirJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
		
		assertEquals(55000, Mordecai.obtenerDinero());
	}
	
	@Test
	public void jugadorSaleDeLaCarlcelDespuesDeTresTurnosAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		CeldaPolicia policia = new CeldaPolicia(carcel);
		
		policia.recibirJugador(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.recibirJugador(Rigby);
		
		carcel.sacarJugador(Mordecai);
	}

}
