package testtablero;

import static org.junit.Assert.*;
import fiuba.algo3.celdas.CeldaSalida;
import fiuba.algo3.celdas.especiales.CeldaCarcel;
import fiuba.algo3.celdas.especiales.CeldaQuini6;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcel;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import org.junit.Test;

public class TableroTest {
    
	@Test
	public void testElTableroSeCreaYCargaCasilleros() {
		Tablero tablero = new Tablero();
		assertEquals(1,tablero.getCantidadDeCeldas());
	}
	
	@Test 
	public void testSeCreaJugadorEnPosicionInicial() {
    	Tablero tablero = new Tablero();
    	
    	CeldaQuini6 celda2 = new CeldaQuini6();
    	tablero.agregarCelda(celda2);
		Jugador jugador1 = new Jugador();
		tablero.cargarJugador(jugador1);
		
		assertEquals(tablero.getSalida(),tablero.getCeldaJugador(jugador1));
	}
	
	@Test
	public void testJugadorAvanzaPosicion() {
		Tablero tablero = new Tablero();
    	CeldaQuini6 celda2= new CeldaQuini6();
    	tablero.agregarCelda(celda2);
    	Jugador jugador1 = new Jugador();
		tablero.cargarJugador(jugador1);

		assertEquals(celda2,tablero.jugadorAvanza(jugador1,1));
	}
	
	@Test
	public void tableroMueveAJugadorALaCarcelYEnElSiguienteTurnoJugadorPagaFianzaParaMoverse(){
		Tablero tablero = new Tablero();
    	CeldaCarcel carcel = new CeldaCarcel();
    	 	
    	tablero.agregarCelda(carcel);
    	
    	Jugador jugador1 = new Jugador();
		tablero.cargarJugador(jugador1);
		
		tablero.jugadorAvanza(jugador1,1);
		carcel.reducirTurnosDeEsperaDe(jugador1);
		
		tablero.jugadorAvanza(jugador1,1);
		assertEquals(55000, jugador1.obtenerDinero());
	}
	
	@Test
	public void tableroAvanzaJugadorAQuini6YCobraBono() {
		Tablero tablero = new Tablero();
    	CeldaQuini6 quini = new CeldaQuini6();
    	
    	tablero.agregarCelda(quini);
    	
    	Jugador jugador1 = new Jugador();
		tablero.cargarJugador(jugador1);
		tablero.jugadorAvanza(jugador1,1);

		assertEquals(150000, jugador1.obtenerDinero());
	}
	
	@Test
	public void tableroAvanzaJugadorAQuini6DosVecesYCobraBonosCorrespondientes() {
		Tablero tablero = new Tablero();
    	CeldaQuini6 quini = new CeldaQuini6();
    	
    	tablero.agregarCelda(quini);
    	
    	Jugador jugador1 = new Jugador();
		tablero.cargarJugador(jugador1);
		
		tablero.jugadorAvanza(jugador1,1);
		tablero.jugadorAvanza(jugador1,1);
		tablero.jugadorAvanza(jugador1,1);

		assertEquals(180000, jugador1.obtenerDinero());
	}
}
