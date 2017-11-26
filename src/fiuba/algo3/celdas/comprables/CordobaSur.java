package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class CordobaSur extends Barrio{

    public CordobaSur() {
        super(18000, 1000, "CordobaSur", 2000);
        super.maxcasas = 2;
        super.maxhoteles = 1;
		super.casas = new ArrayList<Casa>(); 
		super.hoteles = new ArrayList<Hotel>(); 
    }
}
