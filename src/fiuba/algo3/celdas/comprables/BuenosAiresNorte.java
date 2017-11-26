package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;

public class BuenosAiresNorte extends Barrio{

    public BuenosAiresNorte() {
        super(25000, 2500, "BuenosAiresNorte", 5500, 9000);
        super.maxCasas = 2;
        super.maxHoteles = 1;
        super.alquiler1 = 1000;
        super.alquiler2 = 1000;
        super.alquilerHotel = 3500;
		super.casas = new ArrayList<Casa>(); 
		super.hoteles = new ArrayList<Hotel>(); 
    }
}
