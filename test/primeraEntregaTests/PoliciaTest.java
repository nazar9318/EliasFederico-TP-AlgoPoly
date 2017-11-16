package primeraEntregaTests;

import org.junit.Test;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcelException;

public class PoliciaTest {

	@Test (expected=JugadorNoPuedeSalirDeLaCarcelException.class)
	public void policiaMandaALaCarcelAJugadorYEsteNoPuedeSalir(){
		Carcel carcel = new Carcel();
		Jugador unJugador = new Jugador();
		Policia policia = new Policia(carcel);
		
		policia.aceptar(unJugador);
		carcel.sacarJugador(unJugador);
	}

}
