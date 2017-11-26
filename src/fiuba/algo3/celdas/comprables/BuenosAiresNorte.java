package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class BuenosAiresNorte extends Barrio{

    public BuenosAiresNorte() {
        super(25000, 2500, "BuenosAiresNorte", 5500);
        super.maxcasas = 2;
        super.maxhoteles = 1;
		super.casas = new ArrayList<Casa>(); 
		super.hoteles = new ArrayList<Hotel>(); 
    }
}
