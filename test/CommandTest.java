import fiuba.algo3.AlgoPoly;
import fiuba.algo3.modelo.Command.Command;
import fiuba.algo3.modelo.Command.Invoker;
import fiuba.algo3.modelo.Command.Respuesta;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test
    public void jugadorPideOpcionesABuenosAiresSurPuedeSoloVender(){
        AlgoPoly juego = new AlgoPoly();
        juego.inicializarJuego();

        Jugador jug1 = juego.getJugadores().get(0);
        Tablero tablero = juego.getTablero();

        Barrio barrio = (Barrio) tablero.avanzarJugador(jug1, 2);
        barrio.comprar(jug1);

        Propiedad celda = jug1.getPropiedades().get(0);
        Respuesta opciones = celda.getOpciones(jug1);

        Assert.assertEquals(opciones.getAccionesPosibles().size(), 1);
        Assert.assertEquals(opciones.getAccion("Vender").getNombre(), "Vender" );
    }

    @Test
    public void jugadorPideOpcionesAEDESURYPuedeSoloVender(){
        AlgoPoly juego = new AlgoPoly();
        juego.inicializarJuego();

        Jugador jug1 = juego.getJugadores().get(0);
        Tablero tablero = juego.getTablero();

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jug1, 3);
        propiedad.comprar(jug1);

        Respuesta opciones = jug1.getPropiedades().get(0).getOpciones(jug1);

        Assert.assertEquals(opciones.getAccionesPosibles().size(), 1);
        Assert.assertEquals(opciones.getAccion("Vender").getNombre(), "Vender" );
    }

    @Test
    public void jugadorPideOpcionesAEDESURYLaVende(){
        AlgoPoly juego = new AlgoPoly();
        juego.inicializarJuego();

        Jugador jug1 = juego.getJugadores().get(0);
        Tablero tablero = juego.getTablero();
        Invoker invoker = juego.getInvoker();

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jug1, 3);
        propiedad.comprar(jug1);
        int propiedadesAntes = jug1.getCantidadDePropiedades();

        Respuesta opciones = jug1.getPropiedades().get(0).getOpciones(jug1);

        opciones.mostrarAcciones(); //en el juego muestra los botones
        Command aEjecutar = opciones.getAccion("Vender");

        invoker.setCommand(aEjecutar);
        invoker.executeCommand(jug1);

        Assert.assertEquals(jug1.getCantidadDePropiedades(), propiedadesAntes - 1);
    }

    @Test
    public void jugadorPideOpcionesABuenosAiresSurYLaVende(){
        AlgoPoly juego = new AlgoPoly();
        juego.inicializarJuego();

        Jugador jug1 = juego.getJugadores().get(0);
        Tablero tablero = juego.getTablero();
        Invoker invoker = juego.getInvoker();

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jug1, 2);
        propiedad.comprar(jug1);

        int propiedadesAntes = jug1.getCantidadDePropiedades();

        Respuesta opciones = jug1.getPropiedades().get(0).getOpciones(jug1);

        opciones.mostrarAcciones(); //en el juego muestra los botones
        Command aEjecutar = opciones.getAccion("Vender");

        invoker.setCommand(aEjecutar);
        invoker.executeCommand(jug1);

        Assert.assertEquals(jug1.getCantidadDePropiedades(), propiedadesAntes - 1);
    }

    @Test
    public void jugsdorPoseeAmbosBuenosAiresPideOpcionesABuenosAiresYPuedeConstruir(){
        AlgoPoly juego = new AlgoPoly();
        juego.inicializarJuego();

        Jugador jug1 = juego.getJugadores().get(0);
        Tablero tablero = juego.getTablero();

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jug1, 2);
        propiedad.comprar(jug1);
        propiedad = (Propiedad) tablero.avanzarJugador(jug1, 2);
        propiedad.comprar(jug1);

        Respuesta opciones = jug1.getPropiedades().get(0).getOpciones(jug1);

        Assert.assertEquals(opciones.getAccionesPosibles().size(), 2);
    }

    @Test
    public void jugsdorPoseeAmbosBuenosAiresPideOpcionesABuenosAiresConstruyeYSeCobraElAlquilerCorrecto(){
        AlgoPoly juego = new AlgoPoly();
        juego.inicializarJuego();

        Jugador jug1 = juego.getJugadores().get(0);
        Tablero tablero = juego.getTablero();
        Invoker invoker = juego.getInvoker();

        Propiedad propiedad = (Propiedad) tablero.avanzarJugador(jug1, 2);
        propiedad.comprar(jug1);
        propiedad = (Propiedad) tablero.avanzarJugador(jug1, 2);
        propiedad.comprar(jug1);

        Propiedad aConstruir = jug1.getPropiedades().get(0);
        Respuesta opciones = aConstruir.getOpciones(jug1);

        opciones.mostrarAcciones(); //en el juego muestra los botones
        Command aEjecutar = opciones.getAccion("Construir");

        invoker.setCommand(aEjecutar);
        invoker.executeCommand(jug1);

        Jugador jug2 = new Jugador();
        int dineroAnterior = jug2.obtenerDinero();
        aConstruir.cobrarAlquiler(jug2);

        Assert.assertEquals(dineroAnterior - ((Barrio) aConstruir).getAlquilerActual(), jug2.obtenerDinero());
    }

}
