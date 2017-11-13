package testJuego;

import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.CeldaBarrio;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void tableroAgregaJugadorAlInicio(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();

        tablero.agregarJugador(jugador);

        Assert.assertEquals(tablero.getPosicionDeJugador(jugador), tablero.getSalida());
    }

    @Test
    public void avanzaAJugadorEnElTablero(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();

        tablero.agregarJugador(jugador);
        tablero.avanzarJugador(jugador, 2);

        Assert.assertEquals(tablero.getPosicionDeJugador(jugador), tablero.getCeldas().get(2));
    }

    @Test
    public void jugadorAvanzaYCompraUnTerreno(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador();

        tablero.agregarJugador(jugador);
        tablero.avanzarJugador(jugador, 2);
        tablero.aplicarAccionDeCelda(tablero.getPosicionDeJugador(jugador), jugador);

        Assert.assertEquals(jugador.obtenerDinero(), 80000);
    }

    @Test
    public void jugadorCaeEnTerrenoYaComprado(){
        //TODO
    }
}
