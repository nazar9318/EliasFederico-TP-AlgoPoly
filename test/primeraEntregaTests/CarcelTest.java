package primeraEntregaTests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.especiales.Carcel;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;

public class CarcelTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void testJugadorCaeEnLaCarcelYNoPuedeMoverse() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Salida salida = new Salida();
		
		jugador.visitar(carcel);
		
		jugador.visitar(salida);
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeUnTurno() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Salida salida = new Salida();
		
		jugador.visitar(carcel);
		try{
			jugador.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){
			
		}
		
		jugador.visitar(salida);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeDosTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		jugador.pagar(100000);
		Salida salida = new Salida();
		
		jugador.visitar(carcel);
		
		try{
			jugador.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		jugador.visitar(salida);
		
		jugador.cobrar(50000);
		
		jugador.visitar(salida);
		
		assertEquals(5000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYSaleDespuesDeTresTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		jugador.pagar(100000);
		Salida salida = new Salida();
		
		jugador.visitar(carcel);
		
		try{
			jugador.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		jugador.visitar(salida);
				
		jugador.visitar(salida);
		
		jugador.visitar(salida);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientes(){
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		
		jugador.pagar(60000);
		
		jugador.visitar(carcel);
		
		//Asumiendo que ya paso un turno desde que llego a la carcel
		carcel.sacarJugador(jugador,2);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientesCuandoOtroYaCayoEnLaCarcel(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		
		Mordecai.visitar(carcel);
		
		Mordecai.pagar(60000);
		
		Rigby.visitar(carcel);
		
		carcel.sacarJugador(Mordecai,2);
	}
	
	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void jugadorCaePorPrimeraVezEnCarcelYNoPuedeSalirCuandoOtroYaEstuvoMasDeUnTurno(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Salida salida = new Salida();
		
		Mordecai.visitar(carcel);
		
		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		Rigby.visitar(carcel);		
		Rigby.visitar(salida);
	}
	
	@Test
	public void jugadorPuedePagarFianzaDespuesDeUnTurnoAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Salida salida = new Salida();
		
		Mordecai.visitar(carcel);
		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		Rigby.visitar(carcel);
		
		Mordecai.visitar(salida);
		
		assertEquals(55000, Mordecai.obtenerDinero());
	}
	
	@Test
	public void jugadorSaleDeLaCarlcelDespuesDeTresTurnosAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Salida salida = new Salida();
		Mordecai.pagar(100000);
		
		Mordecai.visitar(carcel);
		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoTieneFondosParaPagarException e){}
		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoTieneFondosParaPagarException e){}
		
		Rigby.visitar(carcel);
		
		Mordecai.visitar(salida);
	}
	
}
