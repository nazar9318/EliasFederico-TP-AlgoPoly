package testtablero;

import static org.junit.Assert.*;
import fiuba.algo3.celdas.CeldaSalida;
import fiuba.algo3.celdas.especiales.CeldaQuini6;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import org.junit.Test;

public class TableroTest {
    @Test
    public void testCargoPrimerCeldaEnTablero() {
    	Tablero tablero = new Tablero();
    	CeldaSalida celda= new CeldaSalida();
    	tablero.agregarCelda(celda);
    	assertEquals(tablero.getSalida(),celda);    	
    }
    
	@Test
	public void testElTableroSeCreaYCargaCasilleros() {
		Tablero tablero = new Tablero();
    	CeldaSalida celda= new CeldaSalida();
    	tablero.agregarCelda(celda);
		assertEquals(1,tablero.getCantidadDeCeldas());
	}
	
	@Test 
	public void testSeCreJugadorEnPosicionInicial() {
    	Tablero tablero = new Tablero();
    	CeldaSalida celda= new CeldaSalida();
    	tablero.agregarCelda(celda);
    	CeldaQuini6 celda2= new CeldaQuini6();
    	tablero.agregarCelda(celda2);
		Jugador jugador1 = new Jugador();
		tablero.cargarJugador(jugador1);
		assertEquals(celda,tablero.getCeldaJugador(jugador1));
	}
	
	@Test
	public void testJugadorAvanzaPosicion() {
		Tablero tablero = new Tablero();
    	CeldaSalida celda= new CeldaSalida();
    	tablero.agregarCelda(celda);
    	CeldaQuini6 celda2= new CeldaQuini6();
    	tablero.agregarCelda(celda2);
    	Jugador jugador1 = new Jugador();
		tablero.cargarJugador(jugador1);
		;
		assertEquals(celda2,tablero.jugadorAvanza(jugador1,1));
	}
	
}
