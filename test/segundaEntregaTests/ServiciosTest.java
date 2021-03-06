package segundaEntregaTests;

import fiuba.algo3.modelo.AlgoPoly;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresNorte;
import fiuba.algo3.modelo.celdas.comprables.BuenosAiresSur;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.celdas.comprables.Servicios.AYSA;
import fiuba.algo3.modelo.celdas.comprables.Servicios.EDESUR;
import fiuba.algo3.modelo.celdas.comprables.Servicios.SUBTE;
import fiuba.algo3.modelo.celdas.comprables.Servicios.Servicio;
import fiuba.algo3.modelo.celdas.comprables.Servicios.TREN;

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
        jugador2.setValorDeTiro(3);

        int dineroAnterior = jugador2.obtenerDinero();

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jugador1, 3);
        propiedad.comprar(jugador1);

        propiedad = (Propiedad) tablero.avanzarJugador(jugador2, 3);
        propiedad.aceptar(jugador2);

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

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jugador1, 3);
        propiedad.comprar(jugador1);

        propiedad = (Propiedad) tablero.avanzarJugador(jugador1, 9);
        propiedad.comprar(jugador1);

        propiedad = (Propiedad) tablero.avanzarJugador(jugador2, 3);
        propiedad.aceptar(jugador2);

        int dineroPosterior = jugador2.obtenerDinero();

        Assert.assertEquals(dineroPosterior, dineroAnterior - 3000);
    }

    @Test
    public void jugadorCompraEDESURYAYSAtroJugadorCaeEnAYSAYPagaAlquiler(){
        AlgoPoly algo = new AlgoPoly();

        algo.inicializarJuego();
        Tablero tablero = algo.getTablero();

        Jugador jugador1 = tablero.agregarJugador(new Jugador());
        Jugador jugador2 = tablero.agregarJugador(new Jugador());

        int dineroAnterior = jugador2.obtenerDinero();
        jugador2.setValorDeTiro(12);

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jugador1, 3);
        propiedad.comprar(jugador1);

        propiedad = (Propiedad) tablero.avanzarJugador(jugador1, 9);
        propiedad.comprar(jugador1);

        propiedad = (Propiedad) tablero.avanzarJugador(jugador2, jugador2.getValorDeTiro());
        propiedad.aceptar(jugador2);

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

		trenes.comprar(jugador);//compra trenes
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

		trenes.comprar(jugador);//compra trenes
		subtes.comprar(jugador);//compra subtes
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

		edesur.comprar(jugador);//compra edesur
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

		edesur.comprar(jugador);//compra edesur
		aysa.comprar(jugador);//compra aysa
		assertEquals(jugador2.obtenerDinero(),100000);

        jugador2.setValorDeTiro(12);
        edesur.aceptar(jugador2);

        assertEquals(jugador2.obtenerDinero(),100000-(12*1000));
    	
    }
    
    @Test
    public void jugadorIntercambiaUnaPropiedadSuyaPorOtraPropiedadDeOtroJugadorYOtroJugadorCaeEnEsaPropiedad() {
    //Verificar que un tercer jugador cae en el area y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad.
    	Jugador jugador1 = new Jugador();
    	Jugador jugador2 = new Jugador();
    	Jugador jugador3 = new Jugador();
		EDESUR edesur = new EDESUR();
		AYSA aysa = new AYSA();

		aysa.conocer(edesur);
		edesur.conocer(aysa);

		edesur.comprar(jugador1);
        edesur.vender();
        assertEquals(jugador2.obtenerDinero(),100000);

        edesur.comprar(jugador2);
        assertEquals(jugador2.obtenerDinero(),100000-35000);

        jugador3.setValorDeTiro(12);
        edesur.aceptar(jugador3);

        assertEquals(jugador2.obtenerDinero(),100000-35000+(12*500));
    }
    
    @Test
    public void jugadorIntercambiaUnaPropiedadSuyaPorOtraPropiedadDeOtroJugadorYOtroJugadorCaeEnEsaPropiedadYSeLeCobraPorSoloElAlquilerDeTerreno() {
    	// Verificar que un tercer jugador cae en el area y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad por un monto igual al area sin construccion.
    	Jugador jugador1 = new Jugador();
    	Jugador jugador2 = new Jugador();
    	Jugador jugador3 = new Jugador();
    	BuenosAiresSur buenosairessur = new BuenosAiresSur();
    	BuenosAiresNorte buenosairesnorte = new BuenosAiresNorte();

    	buenosairessur.conocer(buenosairesnorte);
    	buenosairesnorte.conocer(buenosairessur);

    	buenosairessur.comprar(jugador1);//100000-20000=80000
     	buenosairesnorte.comprar(jugador1);//80000-25000=55000

        jugador1.construir(buenosairessur);//55000-5000=50000 construye 1 casa
    	jugador1.construir(buenosairessur);//50000-5000=45000 construye 2 casas  	
    	jugador1.construir(buenosairesnorte);//45000-5500=39500 construye 1 casa
    	jugador1.construir(buenosairesnorte);//39500-5500=34000 construye 2 casas
       	jugador1.construir(buenosairessur);//34000-8000=26000  construye 1 hotel
       	jugador1.construir(buenosairesnorte);//26000-9000= 17000 construye 1 hotel  	

        buenosairessur.vender();//17000+(20000 - 15*20000/100)=34000
    	assertEquals(jugador2.obtenerDinero(),100000);

    	buenosairessur.comprar(jugador2);
    	assertEquals(jugador2.obtenerDinero(),100000-20000);

    	buenosairessur.aceptar(jugador3);
    	assertEquals(jugador2.obtenerDinero(),100000-20000+2000);

    	buenosairesnorte.aceptar(jugador3);
    	assertEquals(jugador1.obtenerDinero(),34000+2500);
    }
 }
