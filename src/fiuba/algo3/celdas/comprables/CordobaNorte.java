package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class CordobaNorte extends Barrio{

    public CordobaNorte() {
        super(20000, 1300, "CordobaNorte", 2200);
        super.maxcasas = 2;
        super.maxhoteles = 1;
		super.casas = new ArrayList<Casa>(); 
		super.hoteles = new ArrayList<Hotel>(); 
    }
}
