package fiuba.algo3.vista;

import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import javafx.scene.control.Button;

public class BotonPropiedad extends Button {

    private Propiedad propiedad_;

    public BotonPropiedad(Propiedad propiedad){
        this.propiedad_ = propiedad;
        this.setText(this.propiedad_.getNombre());
    }

    public Propiedad getPropiedad_() {
        return propiedad_;
    }
}
