package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class CordobaSur extends Barrio{

    public CordobaSur() {
        super(18000, 1000, "CordobaSur", 2000, 3000);
        super.maxCasas = 2;
        super.maxHoteles = 1;
        super.alquiler1 = 500;
        super.alquiler2 = 1000;
        super.alquilerHotel = 2000; 
    }
}
