package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;
import fiuba.algo3.Propiedad;
import fiuba.algo3.Tablero;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;
import fiuba.algo3.factory.PropiedadFactory;

public class CeldaBarrio implements Celda{

	private String nombre;
	private Celda celdaasociada; //TODO: muy buena idea poner enum para las "familias" de propiedades y que cada propiedad tenga de atributo (string) su flia
	private Propiedad propiedad;

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public CeldaBarrio(Propiedad propiedad){
		this.propiedad = propiedad;
		this.nombre = propiedad.getNombre();
	}

	@Override
	public void accionDeCelda(Tablero tablero, Jugador jugador) { //comprar
		if(jugador.obtenerDinero()<propiedad.getPrecio())
			return;
		if ((tablero.getPropiedades().get(propiedad) == null)) {
			if (tablero.consultarCompra(jugador, propiedad)){
				jugador.pagar(propiedad.getPrecio());
				tablero.getPropiedades().put(propiedad, jugador);
			}
		}
	}

	public Celda getCeldaasociada() {
		return celdaasociada;
	}

	public void setCeldaasociada(Celda celdaasociada) {
		this.celdaasociada = celdaasociada;
	}


	public void cobrarAlquiler(Tablero tablero, Jugador jugador) {
		if (tablero.getPropiedades().get(propiedad) != null && !tablero.getPropiedades().get(propiedad).equals(jugador)) {
			jugador.pagar(propiedad.getPrecioAlquiler());
			tablero.getPropiedades().get(propiedad).cobrar(propiedad.getPrecioAlquiler());
		}
	}

	public String getNombre() {
		return nombre;
	}
}