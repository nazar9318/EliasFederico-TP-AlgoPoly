package testCeldas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Barrio;
import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.ConCasa;
import fiuba.algo3.celdas.ConHotel;
import fiuba.algo3.celdas.Hotel;
import fiuba.algo3.celdas.Propiedad;

public class DecoTest {

	@Test
	public void CobroDeAlquilerSinAlquiler() {
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();

		barrio.cobrar(jugador);
		assertEquals(jugador.obtenerDinero(),100000);
	}

	@Test
	public void CobroDeAlquilerSinCasas() {
		Jugador jugador = new Jugador();
		Barrio barrio = new Barrio();

		barrio.setAlquiler(200);
		barrio.cobrar(jugador);

		assertEquals(jugador.obtenerDinero(),100000-200);
	}
	
	@Test
	public void CobroDeAlquilerConUnaCasa() {
		Jugador jugador = new Jugador();
		Casa casa = new Casa();
		Barrio barrio = new Barrio();
		Propiedad propiedad = new ConCasa(barrio, casa);

		casa.setAlquiler(1000);
		barrio.setAlquiler(200);
		propiedad.cobrar(jugador);

		assertEquals(jugador.obtenerDinero(),100000-1200);
	}
	
	@Test
	public void CobroDeAlquilerConDosCasa() {
		Jugador jugador = new Jugador();
		Casa casa = new Casa();
		Barrio barrio = new Barrio();
		Propiedad propiedad = new ConCasa(new ConCasa(barrio,casa),casa);

		casa.setAlquiler(1000);
		barrio.setAlquiler(200);
		propiedad.cobrar(jugador);

		assertEquals(jugador.obtenerDinero(),100000-2200);
	}
	
	@Test
	public void CobroDeAlquilerConHotel() {
		Jugador jugador = new Jugador();
		Hotel hotel = new Hotel();
		Barrio barrio = new Barrio();
		Propiedad propiedad = new ConHotel(barrio,hotel);

		hotel.setAlquiler(1000);
		barrio.setAlquiler(200);
		propiedad.cobrar(jugador);

		assertEquals(jugador.obtenerDinero(),100000-1200);
	}
}
