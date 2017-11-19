package testJuego;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class AlgoPolyTest {

    @Test
    public void tableroSeIniciaConPropiedadesYUnJugadorCompra(){
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();

        Jugador jugador = tablero.agregarJugador(new Jugador());
        tablero.avanzarJugador(jugador, 2);

        Assert.assertEquals(jugador.getCantidadDePropiedades(), 1);
    }


}
