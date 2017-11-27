package fiuba.algo3.Command;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Barrio;

public class Construir extends Command{

    private Barrio propiedad_;

    public Construir(Barrio receiver){
        this.propiedad_ = receiver;
        this.nombre = "Construir";
    }

    @Override
    public void execute(Jugador jugador) {
        this.propiedad_.construir(jugador);
    }

}
