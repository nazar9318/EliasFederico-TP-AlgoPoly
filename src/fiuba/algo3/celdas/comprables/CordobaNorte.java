package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class CordobaNorte extends Barrio{

    public CordobaNorte() {
        super(20000, 1300, "CordobaNorte", 2200, 3500);
        super.maxCasas = 2;
        super.maxHoteles = 1;
        super.alquiler1 = 500;
        super.alquiler2 = 1100;
        super.alquilerHotel = 2200;
		super.casas = new ArrayList<Casa>(); 
		super.hoteles = new ArrayList<Hotel>(); 
    }
}
