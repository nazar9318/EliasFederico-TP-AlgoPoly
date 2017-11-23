package testCeldas;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.EDESUR;
import fiuba.algo3.celdas.comprables.Servicio;
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

}
