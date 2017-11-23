package testCeldas;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.comprables.Servicios.EDESUR;
import fiuba.algo3.celdas.comprables.Servicios.Servicio;
import org.junit.Assert;
import org.junit.Test;

public class ServiciosTest {

    @Test
    public void unJugaorCompraEDESURYLoTieneEnSuLista(){
        Servicio edesur = new EDESUR();
        Jugador jugador = new Jugador();

        edesur.comprar(jugador);

        Assert.assertEquals(jugador.getPropiedades().get(0), edesur);
    }

    @Test
    public void unJugaorCompraEDESURYSuDineroDisminuye(){
        Servicio edesur = new EDESUR();
        Jugador jugador = new Jugador();

        int dineroAnterior = jugador.obtenerDinero();
        edesur.comprar(jugador);
        int dineroPosterior = jugador.obtenerDinero();

        Assert.assertEquals(dineroPosterior, dineroAnterior - 35000);
    }

    @Test
    public void unJugaorCompraEDESURYLoVendeYNoPoseeMasElServicio(){
        Servicio edesur = new EDESUR();
        Jugador jugador = new Jugador();

        edesur.comprar(jugador);

        jugador.getPropiedades().get(0).vender(jugador);

        Assert.assertEquals(0, jugador.getPropiedades().size());
    }

    @Test
    public void unJugaorCompraEDESURYLoVendeYSuDineroAumentaLoCorrecto(){
        Servicio edesur = new EDESUR();
        Jugador jugador = new Jugador();

        int dineroAnteriorACompra = jugador.obtenerDinero();

        edesur.comprar(jugador);
        jugador.getPropiedades().get(0).vender(jugador);
        int dineroDespues = jugador.obtenerDinero();

        Assert.assertEquals(dineroDespues, dineroAnteriorACompra - 5250);
    }

    @Test
    public void jugadorCompraEDESUROtroJugadorCaeYPagaAlquiler(){
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();

        Jugador jugador1 = tablero.agregarJugador(new Jugador());
        Jugador jugador2 = tablero.agregarJugador(new Jugador());

        int dineroAnterior = jugador2.obtenerDinero();
        jugador2.setValorDeTiro(3);

        tablero.avanzarJugador(jugador1, 3);
        tablero.avanzarJugador(jugador2, jugador2.getValorDeTiro());

        int dineroPosterior = jugador2.obtenerDinero();

        Assert.assertEquals(dineroPosterior, dineroAnterior - 1500);
    }

    @Test
    public void jugadorCompraEDESURYAYSAOtroJugadorCaeEnEDESURYPagaAlquiler(){
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();

        Jugador jugador1 = tablero.agregarJugador(new Jugador());
        Jugador jugador2 = tablero.agregarJugador(new Jugador());

        int dineroAnterior = jugador2.obtenerDinero();
        jugador2.setValorDeTiro(3);

        tablero.avanzarJugador(jugador1, 3);
        tablero.avanzarJugador(jugador1, 9);
        tablero.avanzarJugador(jugador2, jugador2.getValorDeTiro());

        int dineroPosterior = jugador2.obtenerDinero();

        Assert.assertEquals(dineroPosterior, dineroAnterior - 3000);
    }

    @Test
    public void jugadorCompraEDESURYAYSAtroJugadorCaeEnEDENORYPagaAlquiler(){
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();

        Jugador jugador1 = tablero.agregarJugador(new Jugador());
        Jugador jugador2 = tablero.agregarJugador(new Jugador());

        int dineroAnterior = jugador2.obtenerDinero();
        jugador2.setValorDeTiro(12);

        tablero.avanzarJugador(jugador1, 3);
        tablero.avanzarJugador(jugador1, 9);
        tablero.avanzarJugador(jugador2, jugador2.getValorDeTiro());

        int dineroPosterior = jugador2.obtenerDinero();

        Assert.assertEquals(dineroPosterior, dineroAnterior - 6000);
    }
}
