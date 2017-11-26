package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class BuenosAiresSur extends Barrio{

    public BuenosAiresSur() {
        super(20000, 2000, "BuenosAiresSur", 5000, 8000);
        super.maxCasas = 2;
        super.maxHoteles = 1;
        super.alquiler1 = 1000;
        super.alquiler2 = 500;
        super.alquilerHotel = 3000;
    }
}
