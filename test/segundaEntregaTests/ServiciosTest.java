package segundaEntregaTests;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Jugador;
import fiuba.algo3.Tablero;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.celdas.comprables.Servicios.AYSA;
import fiuba.algo3.celdas.comprables.Servicios.EDESUR;
import fiuba.algo3.celdas.comprables.Servicios.SUBTE;
import fiuba.algo3.celdas.comprables.Servicios.Servicio;
import fiuba.algo3.celdas.comprables.Servicios.TREN;

import static org.junit.Assert.assertEquals;

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

        jugador.getPropiedades().get(0).vender();

        Assert.assertEquals(0, jugador.getPropiedades().size());
    }

    @Test
    public void unJugaorCompraEDESURYLoVendeYSuDineroAumentaLoCorrecto(){
        Servicio edesur = new EDESUR();
        Jugador jugador = new Jugador();

        int dineroAnteriorACompra = jugador.obtenerDinero();

        edesur.comprar(jugador);
        jugador.getPropiedades().get(0).vender();
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
    
    //////////////test segunda entrega
    
    @Test
    public void jugadorCaeEnTRENESadquiridaPreviamentePorOtroQueNoPoseeSUBTES() {
    //Verificar que su dinero se reduzca por 450 veces lo que dice los dados arrojados previamente.
    	Jugador jugador = new Jugador();
    	Jugador jugador2 = new Jugador();
		TREN trenes = new TREN();
		SUBTE subtes = new SUBTE();
		trenes.conocer(subtes);
		subtes.conocer(trenes);
		trenes.aceptar(jugador);//compra trenes
		assertEquals(jugador2.obtenerDinero(),100000);
		jugador2.setValorDeTiro(12);
		trenes.aceptar(jugador2);
		assertEquals(jugador2.obtenerDinero(),100000-(12*450));
    }
    
    @Test
    public void  jugadorCaeEnTRENESYElDuenioEsOtroJugadorQueAdemasPoseeSubtes() {
    //Verificar que su dinero se reduzca por 800 veces lo que dice los dados arrojados previamente.
    	Jugador jugador = new Jugador();
    	Jugador jugador2 = new Jugador();
		TREN trenes = new TREN();
		SUBTE subtes = new SUBTE();
		trenes.conocer(subtes);
		subtes.conocer(trenes);
		trenes.aceptar(jugador);//compra trenes
		subtes.aceptar(jugador);//compra subtes
		assertEquals(jugador2.obtenerDinero(),100000);
		jugador2.setValorDeTiro(12);
		trenes.aceptar(jugador2);
		assertEquals(jugador2.obtenerDinero(),100000-(12*800));
    }
    

    
    @Test
    public void jugadorCaeEnEDESURAdquiridaPorOtroJugadorQueNoEsDuenioDeAYSA() {
    	//Verificar que su dinero se reduzca por 500 veces lo que dice los dados arrojados previamente.
    	Jugador jugador = new Jugador();
    	Jugador jugador2 = new Jugador();
		EDESUR edesur = new EDESUR();
		AYSA aysa = new AYSA();
		aysa.conocer(edesur);
		edesur.conocer(aysa);
		edesur.aceptar(jugador);//compra edesur
		assertEquals(jugador2.obtenerDinero(),100000);
		jugador2.setValorDeTiro(12);
		edesur.aceptar(jugador2);
		assertEquals(jugador2.obtenerDinero(),100000-(12*500));
    	
    }
    
    @Test
    public void jugadorCaeEnEDESURAdquiridaPorOtroJugadorQueEsDuenioDeAYSA() {
    	// Verificar que su dinero se reduzca por 1000 veces lo que dice los dados arrojados previamente.
    	Jugador jugador = new Jugador();
    	Jugador jugador2 = new Jugador();
		EDESUR edesur = new EDESUR();
		AYSA aysa = new AYSA();
		aysa.conocer(edesur);
		edesur.conocer(aysa);
		edesur.aceptar(jugador);//compra edesur
		aysa.aceptar(jugador);//compra aysa
		assertEquals(jugador2.obtenerDinero(),100000);
		jugador2.setValorDeTiro(12);
		edesur.aceptar(jugador2);
		assertEquals(jugador2.obtenerDinero(),100000-(12*1000));
    	
    }
    
    @Test
    public void jugadorIntercambiaUnaPropiedadSuyaPorOtraPropiedadDeOtroJugador() {
    //Verificar que un tercer jugador cae en el area y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad.
    	Jugador jugador1 = new Jugador();
    	Jugador jugador2 = new Jugador();
    	Jugador jugador3 = new Jugador();
		EDESUR edesur = new EDESUR();
		AYSA aysa = new AYSA();
		aysa.conocer(edesur);
		edesur.conocer(aysa);
        edesur.aceptar(jugador1);
        edesur.vender();
        assertEquals(jugador2.obtenerDinero(),100000);
        edesur.aceptar(jugador2);
        assertEquals(jugador2.obtenerDinero(),100000-35000);
    	jugador3.setValorDeTiro(12);
        edesur.aceptar(jugador3);
        assertEquals(jugador2.obtenerDinero(),100000-35000+(12*500));
    }
 }
