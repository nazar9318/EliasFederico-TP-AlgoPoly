package primeraEntregaTests;

import org.junit.Test;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.especiales.Carcel;
import fiuba.algo3.modelo.celdas.especiales.Policia;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;

public class PoliciaTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void policiaMandaALaCarcelAJugadorYEsteNoPuedeSalir(){
		Carcel carcel = new Carcel();
		Jugador unJugador = new Jugador();
		Policia policia = new Policia(carcel);
		Salida salida = new Salida();
		
		policia.aceptar(unJugador);
		unJugador.visitar(salida);
	}

}
