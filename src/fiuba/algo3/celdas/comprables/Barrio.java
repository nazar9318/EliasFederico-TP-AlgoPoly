package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;
import fiuba.algo3.celdas.Visitable;

public abstract class Barrio extends Propiedad implements Visitable {
    int maxcasas;
    int maxhoteles;
    ArrayList<Casa> casas;
    ArrayList<Hotel> hoteles;
    int alquiler1;
    int preciocasa;
    int preciohotel;
    int alquilerh;
    
	protected Barrio(int precioTerreno, int alquiler, String nombre) {
		super(precioTerreno, alquiler, nombre);
	}
	
	public void cobrarAlquiler(Jugador jugador) {
		jugador.pagar(getAlquiler());
		this.duenio.cobrar(getAlquiler());
	}

	public int cantidadcasas() {
		return casas.size();
	}
	public int cantidadhoteles() {
		return hoteles.size();
	}


	public void construir(Jugador jugador) {

		if ((jugador.poseeALaAsociadaDe(this)) ) {
			if ((maxcasas >= casas.size() + 1) && (hoteles.size() == 0)){
				Casa casa = new Casa(alquiler1);
				casas.add(casa);
				jugador.pagar(preciocasa);

			} else {
				if ((maxcasas < casas.size() + 1) && (maxhoteles >= hoteles.size() + 1) && (((Barrio) this.getCeldaAsociada()).cantidadcasas() == maxcasas)) {
					Hotel hotel = new Hotel(alquilerh);
					casas.clear();
					hoteles.add(hotel);
					jugador.pagar(preciohotel);
				}
			}

		}
	}
}