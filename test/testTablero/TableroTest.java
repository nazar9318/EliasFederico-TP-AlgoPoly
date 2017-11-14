package testTablero;

import static org.junit.Assert.*;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Quini6;
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
		Quini6 celda2 = new Quini6();
		Jugador jugador1 = new Jugador();

		tablero.agregarCelda(celda2);
		tablero.agregarJugador(jugador1);

		Assert.assertEquals(tablero.getPosicionDeJugador(jugador1), tablero.getSalida());
	}


	@Test
	public void testJugadorAvanzaPosicion() {
		Tablero tab = new Tablero();
		Jugador j1 = new Jugador();
		Quini6 c1 = new Quini6();
		Carcel c2 = new Carcel();

		tab.agregarCelda(c1);
		tab.agregarCelda(c2);
		tab.agregarJugador(j1);

		tab.avanzarJugador(j1, 2);

		Assert.assertEquals(tab.getPosicionDeJugador(j1), c2);
	}

	
	@Test
	public void tableroMueveAJugadorALaCarcelYEnElSiguienteTurnoJugadorPagaFianzaParaMoverse(){
		Tablero tablero = new Tablero();
    	Carcel carcel = new Carcel();
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
    	Quini6 quini = new Quini6();
    	
    	tablero.agregarCelda(quini);
    	
    	Jugador jugador1 = new Jugador();
		tablero.agregarJugador(jugador1);
		tablero.avanzarJugador(jugador1,1);

		assertEquals(150000, jugador1.obtenerDinero());
	}
	
	@Test
	public void tableroAvanzaJugadorAQuini6DosVecesYCobraBonosCorrespondientes() {
		Tablero tablero = new Tablero();
    	Quini6 quini = new Quini6();
    	
    	tablero.agregarCelda(quini);
    	
    	Jugador jugador1 = new Jugador();
		tablero.agregarJugador(jugador1);
		
		tablero.avanzarJugador(jugador1,1);
		tablero.avanzarJugador(jugador1, 1);
		tablero.avanzarJugador(jugador1,1);

		assertEquals(180000, jugador1.obtenerDinero());
	}
}