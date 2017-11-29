package testJuego;

import static org.junit.Assert.*;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;

import fiuba.algo3.excepciones.JugadorPerdioException;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.Jugador;

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
		tablero.avanzarJugador(jugador, 2);
		tablero.avanzarJugador(jugador, 2);

		Assert.assertTrue(jugador.poseeALaAsociadaDe(jugador.getPropiedades().get(0)));
	}

	@Test
	public void jugadorCompraBuenosAiresSurVerificaQueNoPuedeEdificar(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());
		tablero.avanzarJugador(jugador, 2);

		Assert.assertFalse(jugador.poseeALaAsociadaDe(jugador.getPropiedades().get(0)));
	}

	@Test
	public void jugadorCompraBuenosAiresSurLaVendeYSuDineroAumentaLoCorrecto(){
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();

		Jugador jugador = tablero.agregarJugador(new Jugador());

		int dineroAnteriorALaCompra = jugador.obtenerDinero();
		tablero.avanzarJugador(jugador, 2);
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
		tablero.avanzarJugador(jugador, 2);

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

		tablero.avanzarJugador(jugador1, 2);
		tablero.avanzarJugador(jugador2, 2);

		int dineroPosterior = jugador2.obtenerDinero();

		Assert.assertEquals(dineroPosterior, dineroAnterior - 2000);
	}
	
	@Test (expected = JugadorNoCuentaConDineroSuficienteParaComprarException.class)
	public void JugadorNoCuentaConDineroSuficienteParaComprarUnaPropiedadDeberiaLanzarUnExcepcion() {
		AlgoPoly algo = new AlgoPoly();

		algo.inicializarJuego();
		Tablero tablero = algo.getTablero();
		Jugador jugador = tablero.agregarJugador(new Jugador());

		jugador.pagar(80000);
		tablero.avanzarJugador(jugador, 4);
	}

	@Test(expected = JugadorPerdioException.class)
	public void jugadorSinPropiedadesNoPuedePagarAlquilerYPierde(){
		Tablero tablero = new Tablero();

		Jugador jugador1 = tablero.agregarJugador(new Jugador());
		Jugador jugador2 = tablero.agregarJugador(new Jugador());
		tablero.agregarCelda(new BuenosAiresSur());

		tablero.avanzarJugador(jugador1,1);
		Barrio BsAs = (Barrio) jugador1.getPropiedades().get(0);
		tablero.avanzarJugador(jugador2,1);

		do{
			tablero.avanzarJugador(jugador2,2);
		}while (jugador2.obtenerDinero() >= BsAs.getAlquilerActual());

		tablero.avanzarJugador(jugador2,2);
	}

	@Test
	public void jugadorNoPuedePagarAlquilerYVendeUnaPropiedadParaPoder(){
		Tablero tablero = new Tablero();

		tablero.agregarCelda(new BuenosAiresSur());
		tablero.agregarCelda(new BuenosAiresNorte());

		Jugador jugador1 = tablero.agregarJugador(new Jugador());
		Jugador jugador2 = tablero.agregarJugador(new Jugador());

		tablero.avanzarJugador(jugador1, 1);
		tablero.avanzarJugador(jugador2, 2);

		Barrio BsAs = (Barrio) jugador1.getPropiedades().get(0);

		tablero.avanzarJugador(jugador2, 2);
		do{
			tablero.avanzarJugador(jugador2,3);
		}while (jugador2.obtenerDinero() >= BsAs.getAlquilerActual());

		jugador2.verPropiedades();
		jugador2.buscarPropiedad("BuenosAiresNorte").vender();
		tablero.avanzarJugador(jugador2,3);
	}
}
