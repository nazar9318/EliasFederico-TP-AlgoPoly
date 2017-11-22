package testCeldas;

import static org.junit.Assert.*;

import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.Casa;

import fiuba.algo3.celdas.Hotel;
import fiuba.algo3.celdas.Propiedad;

public class DecoTest {



	@Test
	public void CobroDeAlquilerSinCasas() {
		Jugador jugador = new Jugador();
		Barrio barrio = new BuenosAiresSur();

		barrio.cobrar(jugador);

		assertEquals(jugador.obtenerDinero(),100000-2000);
	}
	

}
