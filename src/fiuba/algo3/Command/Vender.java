package fiuba.algo3.Command;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.comprables.Propiedad;

public class Vender extends Command{

    private Propiedad propiedad_;

    public Vender(Propiedad receiver){
        this.propiedad_ = receiver;
        this.nombre = "Vender";
    }

    @Override
    public void execute(Jugador jugador) {
        this.propiedad_.vender();
    }
}
