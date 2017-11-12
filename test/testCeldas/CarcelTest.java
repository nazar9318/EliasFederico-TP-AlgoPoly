package testCeldas;

import fiuba.algo3.Tablero;
import org.junit.Test;

import fiuba.algo3.celdas.especiales.CeldaCarcel;
import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcel;

public class CarcelTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcel.class)
	public void testJugadorCaeEnLaCarcelYNoPuedeMoverse() {
		Tablero tablero = new Tablero();
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		
		carcel.accionDeCelda(tablero, jugador);
		
		carcel.sacarJugador(jugador);
	}
/*
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeUnTurno() {
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		
		carcel.accionDeCelda(, jugador, );
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeDosTurnos() {
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		
		carcel.accionDeCelda(, jugador, );
		carcel.reducirTurnosDeEsperaDe(jugador);
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYSaleDespuesDeTresTurnos() {
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador = new Jugador();
		
		carcel.accionDeCelda(, jugador, );
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
		
		jugador.pagar(60000);
		
		carcel.accionDeCelda(, jugador, );
		carcel.reducirTurnosDeEsperaDe(jugador);
		
		carcel.sacarJugador(jugador);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagar.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientesCuandoOtroYaCayoEnLaCarcel(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		carcel.accionDeCelda(, Mordecai, );
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		Mordecai.pagar(60000);
		
		carcel.accionDeCelda(, Rigby, );
		
		carcel.sacarJugador(Mordecai);
	}
	
	@Test (expected=JugadorNoPuedeSalirDeLaCarcel.class)
	public void jugadorCaePorPrimeraVezEnCarcelYNoPuedeSalirCuandoOtroYaEstuvoMasDeUnTurno(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		carcel.accionDeCelda(, Mordecai, );
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.accionDeCelda(, Rigby, );
		
		carcel.sacarJugador(Rigby);
	}
	
	@Test
	public void jugadorPuedePagarFianzaDespuesDeUnTurnoAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		carcel.accionDeCelda(, Mordecai, );
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.accionDeCelda(, Rigby, );
		
		carcel.sacarJugador(Mordecai);
		
		assertEquals(55000, Mordecai.obtenerDinero());
	}
	
	@Test
	public void jugadorSaleDeLaCarlcelDespuesDeTresTurnosAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		CeldaCarcel carcel = new CeldaCarcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		carcel.accionDeCelda(, Mordecai, );
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		carcel.reducirTurnosDeEsperaDe(Mordecai);
		
		carcel.accionDeCelda(, Rigby, );
		
		carcel.sacarJugador(Mordecai);
	}
*/
}
