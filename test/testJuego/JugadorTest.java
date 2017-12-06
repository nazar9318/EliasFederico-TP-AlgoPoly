package testJuego;

import static org.junit.Assert.*;

import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;

import fiuba.algo3.modelo.excepciones.JugadorPerdioException;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.AlgoPoly;
import fiuba.algo3.modelo.Jugador;

public class JugadorTest {

	@Test
	public void jugadorRecienCreadoDeberiaExistir() {
		Jugador jugador = new Jugador();
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void jugadorRecienCreadoDeberiaTenerUnCapitalDe100MilPesos() {
		Jugador jugador = new Jugador();
		int capital = 100000;
		assertEquals(capital, jugador.obtenerDinero());
	}
	
	@Test
	public void jugadorRecienCreadoNoDeberiaTenerPropiedades() {
		Jugador jugador = new Jugador();
		assertEquals(0, jugador.getCantidadDePropiedades());
	}
	
	@Test 
	public void jugadorPagar50MilDeberiaDisminuirElCapitalDelJugadorEn50Mil() {
		Jugador jugador = new Jugador();
		int monto = 50000;
		jugador.pagar(monto);
		assertEquals(monto, jugador.obtenerDinero());
	}
	
	@Test
	public void jugadorCobrar30MilDeberiaAumentarElCapitalDelJugadorEn30Mil() {
		Jugador jugador = new Jugador();
		int monto = 30000;
		jugador.cobrar(monto);
		assertEquals(130000, jugador.obtenerDinero());
	}

	@Test
	public void jugadorCompraBuenosAiresSurYNorteVerificaQuePuedeEdificar(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());

		Barrio nueva = (Barrio) tablero.avanzarJugador(jugador, 2);
		nueva.comprar(jugador);

		nueva = (Barrio) tablero.avanzarJugador(jugador, 2);
		nueva.comprar(jugador);

		Assert.assertTrue(jugador.poseeALaAsociadaDe(jugador.getPropiedades().get(0)));
	}

	@Test
	public void jugadorCompraBuenosAiresSurVerificaQueNoPuedeEdificar(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());

		Barrio nueva = (Barrio) tablero.avanzarJugador(jugador, 2);
		nueva.comprar(jugador);

		Assert.assertFalse(jugador.poseeALaAsociadaDe(jugador.getPropiedades().get(0)));
	}

	@Test
	public void jugadorCompraBuenosAiresSurLaVendeYSuDineroAumentaLoCorrecto(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());

		int dineroAnteriorALaCompra = jugador.obtenerDinero();
		Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jugador, 2);
		propiedad.comprar(jugador);

		jugador.getPropiedades().get(0).vender();
		int dineroDespues = jugador.obtenerDinero();

		Assert.assertEquals(dineroDespues, dineroAnteriorALaCompra - 3000);
	}

	@Test
	public void jugadorCompraBuenosAiresSurLaVendeYNoPoseeMasElTerreno(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());
		Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jugador, 2);
		propiedad.comprar(jugador);

		jugador.getPropiedades().get(0).vender();

		Assert.assertEquals(0, jugador.getPropiedades().size());
	}

	@Test
	public void jugadorCompraBuenosAiresSurOtroJugadorCaeYPagaAlquiler(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador1 = tablero.agregarJugador(new Jugador());
		Jugador jugador2 = tablero.agregarJugador(new Jugador());

		int dineroAnterior = jugador2.obtenerDinero();

		Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jugador1, 2);
		propiedad.comprar(jugador1);

		Visitable nueva = tablero.avanzarJugador(jugador2, 2);
		nueva.aceptar(jugador2);
		int dineroPosterior = jugador2.obtenerDinero();

		Assert.assertEquals(dineroPosterior, dineroAnterior - 2000);
	}
	
	@Test (expected = JugadorNoCuentaConDineroSuficienteParaComprarException.class)
	public void JugadorNoCuentaConDineroSuficienteParaComprarUnaPropiedadDeberiaLanzarUnExcepcion() {
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();
		Jugador jugador = tablero.agregarJugador(new Jugador());

		jugador.pagar(80001);
		Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jugador, 2);
		propiedad.comprar(jugador);

	}

	@Test(expected = JugadorPerdioException.class)
	public void jugadorSinPropiedadesNoPuedePagarAlquilerYPierde(){
		Tablero tablero = new Tablero();

		Jugador jugador1 = tablero.agregarJugador(new Jugador());
		Jugador jugador2 = tablero.agregarJugador(new Jugador());
		tablero.agregarCelda(new BuenosAiresSur());

		Barrio BsAs = (Barrio) tablero.avanzarJugador(jugador1, 1);
		BsAs.comprar(jugador1);

		Visitable nueva = tablero.avanzarJugador(jugador2,1);
		nueva.aceptar(jugador2);
		do{
			nueva = tablero.avanzarJugador(jugador2,2);
			nueva.aceptar(jugador2);
		}while (jugador2.obtenerDinero() >= BsAs.getAlquilerActual());

		nueva = tablero.avanzarJugador(jugador2,2);
		nueva.aceptar(jugador2);
	}

	@Test
	public void jugadorNoPuedePagarAlquilerYVendeUnaPropiedadParaPoder(){
		Tablero tablero = new Tablero();

		tablero.agregarCelda(new BuenosAiresSur());
		tablero.agregarCelda(new BuenosAiresNorte());

		Jugador jugador1 = tablero.agregarJugador(new Jugador());
		Jugador jugador2 = tablero.agregarJugador(new Jugador());

		Barrio BsAsS = (Barrio) tablero.avanzarJugador(jugador1, 1);
		BsAsS.comprar(jugador1);

		Barrio BSAsN = (Barrio) tablero.avanzarJugador(jugador2, 2);
		BSAsN.comprar(jugador2);

		Visitable nueva = tablero.avanzarJugador(jugador2, 2);
		nueva.aceptar(jugador2);

		do{
			nueva = tablero.avanzarJugador(jugador2,3);
			nueva.aceptar(jugador2);
		}while (jugador2.obtenerDinero() >= BsAsS.getAlquilerActual());

		Assert.assertTrue(jugador2.obtenerDinero() < BsAsS.getAlquilerActual());

		jugador2.verPropiedades();
		jugador2.buscarPropiedad("BuenosAiresNorte").vender();
		nueva = tablero.avanzarJugador(jugador2,3);
		nueva.aceptar(jugador2);
	}
}
