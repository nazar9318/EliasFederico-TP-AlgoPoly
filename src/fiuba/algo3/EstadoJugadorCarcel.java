package fiuba.algo3;

import fiuba.algo3.celdas.comprables.Propiedad;
import fiuba.algo3.celdas.Salida;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class EstadoJugadorCarcel implements EstadoJugador {
	
	private int turnos = 3;
	private Carcel carcel;
	
	public EstadoJugadorCarcel(Carcel carcel) {
		this.carcel = carcel;
	}

	@Override
	public void visitar(Propiedad propiedad, Jugador jugador) {
		this.visitarVisitable(propiedad, jugador);
	}

	@Override
	public void visitar(Quini6 quini6, Jugador jugador) {
		this.visitarVisitable(quini6, jugador);
	}	

	@Override
	public void visitar(Policia policia, Jugador jugador) {
		this.visitarVisitable(policia, jugador);
	}

	@Override
	public void visitar(AvanceDinamico avance, Jugador jugador) {
		this.visitarVisitable(avance, jugador);
	}

	@Override
	public void visitar(RetrocesoDinamico retroceso, Jugador jugador) {
		this.visitarVisitable(retroceso, jugador);
	}

	@Override
	public void visitar(Salida salida, Jugador jugador) {
		this.visitarVisitable(salida, jugador);
	}
	
	private void visitarVisitable(Visitable visitable, Jugador jugador){
		if(this.turnos == 3){
			this.turnos --;
			throw new JugadorNoPuedeSalirDeLaCarcelException();
		}else if (this.turnos > 0){
			try{
				this.carcel.sacarJugador(jugador, this.turnos);
			} catch(JugadorNoTieneFondosParaPagarException e){}
			this.turnos --;
		}else{
			this.carcel.sacarJugador(jugador, this.turnos);
			jugador.visitar(visitable);
		}
	}
}
