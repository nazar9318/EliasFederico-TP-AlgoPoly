package fiuba.algo3.modelo;

import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.especiales.AvanceDinamico;
import fiuba.algo3.modelo.celdas.especiales.Carcel;
import fiuba.algo3.modelo.celdas.especiales.Policia;
import fiuba.algo3.modelo.celdas.especiales.Quini6;
import fiuba.algo3.modelo.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;

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

	@Override
	public Visitable reUbicarse(Jugador jugador, Tablero tablero, int index, int avance) {
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
			return jugador.reUbicarse(tablero, index, avance);
		}
		return jugador.reUbicarse(tablero, index, avance);
	}

	@Override
	public void construir(Jugador jugador, Barrio barrio) {
		throw new JugadorNoPuedeSalirDeLaCarcelException();
	}
}
