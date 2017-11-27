package fiuba.algo3;

import fiuba.algo3.celdas.comprables.Propiedad;
import fiuba.algo3.celdas.Salida;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;

public class EstadoJugadorNormal implements EstadoJugador {

	@Override
	public void visitar(Propiedad propiedad, Jugador jugador) {
		if(propiedad.getDuenio() != null)
			propiedad.cobrarAlquiler(jugador);
		else
			propiedad.comprar(jugador); //TODO: hacer la comrpa opcional
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
}
