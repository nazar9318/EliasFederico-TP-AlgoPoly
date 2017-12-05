package fiuba.algo3.modelo.Command;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.comprables.Barrio;

public class Construir extends Command{

    private Barrio propiedad_;

    public Construir(Barrio receiver){
        this.propiedad_ = receiver;
        this.nombre = "Construir";
    }

    @Override
    public void execute(Jugador jugador) {
    	jugador.construir(this.propiedad_);
        //this.propiedad_.construir(jugador);
    }

}
