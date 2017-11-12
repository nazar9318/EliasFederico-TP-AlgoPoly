package testTablero;

import static org.junit.Assert.*;

import fiuba.algo3.celdas.Celda;
import fiuba.algo3.celdas.CeldaSalida;
import fiuba.algo3.celdas.especiales.CeldaCarcel;
import fiuba.algo3.celdas.especiales.CeldaQuini6;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcel;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

	@Test
	public void TableroSeIniciaConCeldaDeSalida() {
		Tablero tablero = new Tablero();

		Assert.assertEquals(tablero.getCantidadDeCeldas(), 1);
	}

	@Test
	public void SeCreaJugadorEnPosicionInicial() {
		Tablero tablero = new Tablero();
		Celda celda2 = new CeldaQuini6();
		Jugador jugador1 = new Jugador();

		tablero.agregarCelda(celda2);
		tablero.agregarJugador(jugador1);

		Assert.assertEquals(tablero.getPosicionDeJugador(jugador1), tablero.getSalida());
	}


	@Test
	public void testJugadorAvanzaPosicion() {
		Tablero tab = new Tablero();
		Jugador j1 = new Jugador();
		Celda c1 = new CeldaQuini6();
		Celda c2 = new CeldaCarcel();

		tab.agregarCelda(c1);
		tab.agregarCelda(c2);
		tab.agregarJugador(j1);

		tab.avanzarJugador(j1, 2);

		Assert.assertEquals(tab.getPosicionDeJugador(j1), c2);
	}

	
	@Test
	public void tableroMueveAJugadorALaCarcelYEnElSiguienteTurnoJugadorPagaFianzaParaMoverse(){
		Tablero tablero = new Tablero();
    	CeldaCarcel carcel = new CeldaCarcel();
		Jugador jugador1 = new Jugador();

    	tablero.agregarCelda(carcel);
		tablero.agregarJugador(jugador1);
		
		tablero.avanzarJugador(jugador1,1);
		carcel.reducirTurnosDeEsperaDe(jugador1);
		tablero.avanzarJugador(jugador1,1);

		assertEquals(55000, jugador1.obtenerDinero());
	}
	
	@Test
	public void tableroAvanzaJugadorAQuini6YCobraBono() {
		Tablero tablero = new Tablero();
    	CeldaQuini6 quini = new CeldaQuini6();
    	
    	tablero.agregarCelda(quini);
    	
    	Jugador jugador1 = new Jugador();
		tablero.agregarJugador(jugador1);
		tablero.avanzarJugador(jugador1,1);

		assertEquals(150000, jugador1.obtenerDinero());
	}
	
	@Test
	public void tableroAvanzaJugadorAQuini6DosVecesYCobraBonosCorrespondientes() {
		Tablero tablero = new Tablero();
    	CeldaQuini6 quini = new CeldaQuini6();
    	
    	tablero.agregarCelda(quini);
    	
    	Jugador jugador1 = new Jugador();
		tablero.agregarJugador(jugador1);
		
		tablero.avanzarJugador(jugador1,1);
		tablero.avanzarJugador(jugador1, 1);
		tablero.avanzarJugador(jugador1,1);

		assertEquals(180000, jugador1.obtenerDinero());
	}
}