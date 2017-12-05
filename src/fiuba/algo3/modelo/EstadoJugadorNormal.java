package fiuba.algo3.modelo;

import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.especiales.AvanceDinamico;
import fiuba.algo3.modelo.celdas.especiales.Policia;
import fiuba.algo3.modelo.celdas.especiales.Quini6;
import fiuba.algo3.modelo.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.modelo.excepciones.ConsultarCompraException;

public class EstadoJugadorNormal implements EstadoJugador {

	@Override
	public void visitar(Propiedad propiedad, Jugador jugador) {
		if(propiedad.getDuenio() != null)
			propiedad.cobrarAlquiler(jugador);
		else
			throw new ConsultarCompraException();
	}

	@Override
	public void visitar(Quini6 quini6, Jugador jugador) {
		quini6.pagarPremioAJugador(jugador);
	}

	@Override
	public void visitar(Policia policia, Jugador jugador) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitar(AvanceDinamico avance, Jugador jugador) {
		avance.calcularAvance(jugador);
	}

	@Override
	public void visitar(RetrocesoDinamico retroceso, Jugador jugador) {
		retroceso.calcularRetroceso(jugador);
	}

	@Override
	public void visitar(Salida salida, Jugador jugador) {
		// TODO Auto-generated method stub
	}

	@Override
	public Visitable reUbicarse(Jugador jugador, Tablero tablero, int index, int avance) {
		return tablero.reposicionarJugador(jugador, index, avance);
	}

}
