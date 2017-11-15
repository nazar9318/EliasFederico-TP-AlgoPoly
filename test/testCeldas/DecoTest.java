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
		casa.setAlquiler(1000);
		Barrio barrio = new Barrio();
		barrio.setAlquiler(200);
		Propiedad propiedad = new ConCasa(barrio,casa);
		propiedad.cobrar(jugador);
		assertEquals(jugador.obtenerDinero(),100000-1200);
				
			
			}
	
	@Test
	public void CobroDeAlquilerConDosCasa() {
		Jugador jugador = new Jugador();
		Casa casa = new Casa();
		casa.setAlquiler(1000);
		Barrio barrio = new Barrio();
		barrio.setAlquiler(200);
		Propiedad propiedad = new ConCasa(new ConCasa(barrio,casa),casa);
		propiedad.cobrar(jugador);
		assertEquals(jugador.obtenerDinero(),100000-2200);
		}
	
	@Test
	public void CobroDeAlquilerConHotel() {
		Jugador jugador = new Jugador();
		Hotel hotel = new Hotel();
		hotel.setAlquiler(1000);
		Barrio barrio = new Barrio();
		barrio.setAlquiler(200);
		Propiedad propiedad = new ConHotel(barrio,hotel);
		propiedad.cobrar(jugador);
		assertEquals(jugador.obtenerDinero(),100000-1200);
		}


}
