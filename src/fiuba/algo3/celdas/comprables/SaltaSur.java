package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class SaltaSur extends Barrio{

    public SaltaSur() {
        super(23000, 2000, "SaltaSur", 4500);
        super.maxcasas = 2;
        super.maxhoteles = 1;
		super.casas = new ArrayList<Casa>(); 
		super.hoteles = new ArrayList<Hotel>(); 
		
    }
}
