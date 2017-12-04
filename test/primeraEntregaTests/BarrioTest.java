package primeraEntregaTests;

import fiuba.algo3.modelo.celdas.comprables.BuenosAiresSur;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;

public class BarrioTest {

	@Test
	public void jugadorCompraTerreno() {
		Jugador jugador = new Jugador();
		Barrio barrio = new BuenosAiresSur();

		barrio.comprar(jugador);

		assertEquals(barrio.getDuenio(), jugador);
	}
	
	@Test (expected = JugadorNoCuentaConDineroSuficienteParaComprarException.class)
	public void jugadorCompraTerrenoYNoTieneFondos() {
		Jugador jugador = new Jugador();
		jugador.pagar(100000);
		Barrio barrio = new BuenosAiresSur();

		barrio.comprar(jugador);

		assertNull(barrio.getDuenio());
	}

	@Test
	public void barrioAgregaCeldaConocida(){

		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		Assert.assertEquals(buenosAiresNorte.getCeldaAsociada(), buenosAiresSur);
		Assert.assertEquals(buenosAiresSur.getCeldaAsociada(), buenosAiresNorte);
	}
	
	@Test
	public void  JugadorConstruyeCasaEnBuenosAires() {
		Jugador jugador = new Jugador();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		buenosAiresSur.comprar(jugador);
		buenosAiresNorte.comprar(jugador);
		jugador.construir(buenosAiresSur);

		assertEquals(1 , buenosAiresSur.cantidadCasas());
	}
	
	@Test
	public void  JugadorConstruyeDosCasasEnBuenosAires() {
		Jugador jugador = new Jugador();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		buenosAiresNorte.comprar(jugador);
		buenosAiresSur.comprar(jugador);

		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresSur);

		assertEquals(2 , buenosAiresSur.cantidadCasas());
	}
	
	@Test
	public void  JugadorConstruyeTresCasasEnBuenosAiresYFalla() {
		Jugador jugador = new Jugador();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		buenosAiresSur.comprar(jugador);
		buenosAiresNorte.comprar(jugador);

		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresSur);

		assertEquals(2 , buenosAiresSur.cantidadCasas());
	}
	
	@Test
	public void  JugadorConstruyeHotelEnBuenosAires() {
		Jugador jugador = new Jugador();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		buenosAiresSur.comprar(jugador);
		buenosAiresNorte.comprar(jugador);

		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresNorte);
		jugador.construir(buenosAiresNorte);
		jugador.construir(buenosAiresSur);

		assertEquals(1 , buenosAiresSur.cantidadHoteles());
		assertEquals(0 , buenosAiresSur.cantidadCasas());
	}
	
	@Test
	public void  JugadorConstruyeOtroHotelEnBuenosAiresYFalla() {
		Jugador jugador = new Jugador();
		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);

		buenosAiresSur.comprar(jugador);
		buenosAiresNorte.comprar(jugador);

		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresNorte);
		jugador.construir(buenosAiresNorte);
		jugador.construir(buenosAiresSur);
		jugador.construir(buenosAiresSur);

		assertEquals(1 , buenosAiresSur.cantidadHoteles());
		assertEquals(0 , buenosAiresSur.cantidadCasas());
	}
}