package fiuba.algo3.celdas.comprables;

import java.util.ArrayList;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Casa;
import fiuba.algo3.celdas.Hotel;
import fiuba.algo3.celdas.Visitable;

public abstract class Barrio extends Propiedad implements Visitable {
    int maxCasas;
    int maxHoteles;
    ArrayList<Casa> casas;
    ArrayList<Hotel> hoteles;
    int alquiler1;
    int alquiler2;
    int precioCasa;
    int precioHotel;
    int alquilerHotel;
    
	protected Barrio(int precioTerreno, int alquiler, String nombre, int precioCasa, int precioHotel) {
		super(precioTerreno, alquiler, nombre);
		this.precioCasa = precioCasa;
		this.precioHotel = precioHotel;
	}
	
	public void cobrarAlquiler(Jugador jugador) {
		jugador.pagar(getAlquiler() + this.getAlquilerDeEdificaciones() + this.getAlquilerHotel());
		this.duenio.cobrar(getAlquiler());
	}

	private int getAlquilerHotel() {
		int alquilerHotel = 0;
		for(int i = 0; i < hoteles.size(); i++){
			alquilerHotel += hoteles.get(i).getAlquiler();
		}
		return alquilerHotel;
	}

	private int getAlquilerDeEdificaciones() {
		int alquiler = 0;
		for(int i = 0; i < casas.size(); i++){
			alquiler += casas.get(i).getAlquiler();
		}
		return alquiler;
	}

	public int cantidadCasas() {
		return casas.size();
	}
	public int cantidadHoteles() {
		return hoteles.size();
	}

	public void construir(Jugador jugador) {
		if ((jugador.poseeALaAsociadaDe(this)) ) {
			if ((maxCasas >= casas.size() + 1) && (hoteles.size() == 0)){
				Casa casa = null;
				if(casas.size() == 0){
					casa = new Casa(alquiler1);
				}else {
					casa = new Casa(alquiler2);
				}
				casas.add(casa);
				jugador.pagar(precioCasa);

			} else {
				if ((maxCasas < casas.size() + 1) && (maxHoteles >= hoteles.size() + 1) && 
						(((Barrio) this.getCeldaAsociada()).cantidadCasas() == maxCasas)) {
					Hotel hotel = new Hotel(alquilerHotel);
					casas.clear();
					hoteles.add(hotel);
					jugador.pagar(precioHotel);
				}
			}

		}
	}
}