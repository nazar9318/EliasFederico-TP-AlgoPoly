package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.especiales.Carcel;
import fiuba.algo3.modelo.celdas.especiales.Policia;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.JugadorFueTrasladadoALaCarcel;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;

public class PoliciaTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void policiaMandaALaCarcelAJugadorYEsteNoPuedeSalir(){
		Carcel carcel = new Carcel();
		Jugador unJugador = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		
		try{
			policia.aceptar(unJugador);
		}catch (JugadorFueTrasladadoALaCarcel e){}
				
		unJugador.visitar(salida);
	}
	
	@Test
	public void policiaMandaALaCarcelAJugadorYPasadoUnTurnoPuedeSalirConFianza() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		
		try{
			policia.aceptar(jugador);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		try{
			jugador.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		jugador.visitar(salida);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYParaSalirTieneQuePagarFianzaDespuesDeDosTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		jugador.pagar(60000);
		try{
			policia.aceptar(jugador);
		}catch (JugadorFueTrasladadoALaCarcel e){}		
		try{
			policia.aceptar(jugador);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		try{
			jugador.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		//En este intento de salir no puede pagar la fianza por fondos insuficientes
		jugador.visitar(salida);
				
		jugador.cobrar(60000);
		jugador.visitar(salida);
		
		assertEquals(55000, jugador.obtenerDinero());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYSaleDespuesDeTresTurnos() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		jugador.pagar(60000);
		
		try{
			policia.aceptar(jugador);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		try{
			jugador.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		//En este intento de salir no puede pagar la fianza por fondos insuficientes
		jugador.visitar(salida);
		jugador.visitar(salida);
		
		jugador.cobrar(60000);
		jugador.visitar(salida);
		
		assertEquals(100000, jugador.obtenerDinero());
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientes(){
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		jugador.pagar(60000);
				
		try{
			policia.aceptar(jugador);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		try{
			jugador.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		//Asumiendo que ya paso un turno desde que llego a la carcel		
		carcel.sacarJugador(jugador,2);
	}
	
	@Test (expected = JugadorNoTieneFondosParaPagarException.class)
	public void jugadorNoPuedePagarFianzaPorFondosInsuficientesCuandoOtroYaCayoEnLaCarcel(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		
		try{
			policia.aceptar(Mordecai);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		Mordecai.pagar(60000);
		
		try{
			policia.aceptar(Rigby);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		carcel.sacarJugador(Mordecai, 2);
	}
	
	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void jugadorCaePorPrimeraVezEnCarcelYNoPuedeSalirCuandoOtroYaEstuvoMasDeUnTurno(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		
		try{
			policia.aceptar(Mordecai);
		}catch (JugadorFueTrasladadoALaCarcel e){}

		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		try{
			policia.aceptar(Rigby);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		Rigby.visitar(salida);
	}
	
	@Test
	public void jugadorPuedePagarFianzaDespuesDeUnTurnoAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		
		try{
			policia.aceptar(Mordecai);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}
		
		try{
			policia.aceptar(Rigby);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		Mordecai.visitar(salida);
		
		assertEquals(55000, Mordecai.obtenerDinero());
	}
	
	@Test
	public void jugadorSaleDeLaCarlcelDespuesDeTresTurnosAunqueOtroHayaCaidoEnCarcelPorPrimeraVez(){
		Carcel carcel = new Carcel();
		Jugador Mordecai = new Jugador();
		Jugador Rigby = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		Mordecai.cobrar(80000);
		
		try{
			policia.aceptar(Mordecai);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoPuedeSalirDeLaCarcelException e){}

		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoTieneFondosParaPagarException e){}

		try{
			Mordecai.visitar(salida);
		} catch(JugadorNoTieneFondosParaPagarException e){}
		
		try{
			policia.aceptar(Rigby);
		}catch (JugadorFueTrasladadoALaCarcel e){}
		
		Mordecai.visitar(salida);
	}

}
