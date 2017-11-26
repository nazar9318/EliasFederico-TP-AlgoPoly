package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class BuenosAiresSur extends Barrio{

    public BuenosAiresSur() {
        super(20000, 2000, "BuenosAiresSur");
        super.maxcasas = 2;
        super.maxhoteles = 1;
    	super.casas = new ArrayList<Casa>(); 
    	super.hoteles = new ArrayList<Hotel>(); 
    }
}
