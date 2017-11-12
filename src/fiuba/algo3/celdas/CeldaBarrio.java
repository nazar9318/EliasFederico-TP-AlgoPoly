package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;
import fiuba.algo3.Propiedad;
import fiuba.algo3.Tablero;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class CeldaBarrio implements Celda{

private Celda celdaasociada;
private Propiedad propiedad;
	
	@Override
	public void recibirJugador(Tablero tablero, Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	public Celda getCeldaasociada() {
		return celdaasociada;
	}

	public void setCeldaasociada(Celda celdaasociada) {
		this.celdaasociada = celdaasociada;
	}

	public void comprarBarrio(Tablero tablero, Jugador jugador) {
		if ((jugador.obtenerDinero()>= propiedad.getPrecio()) && (tablero.getPropiedades().get(propiedad) == null)) {
			jugador.pagar(propiedad.getPrecio());
			tablero.getPropiedades().put(propiedad, jugador);
		}
		else {	
			throw new JugadorNoTieneFondosParaPagar();
		}
	}

	public void cobrarAlquiler(Tablero tablero, Jugador jugador) {
		if (tablero.getPropiedades().get(propiedad) != null && !tablero.getPropiedades().get(propiedad).equals(jugador)) {
			jugador.pagar(propiedad.getPrecioAlquiler());
			tablero.getPropiedades().get(propiedad).cobrar(propiedad.getPrecioAlquiler());
		}
	}
}