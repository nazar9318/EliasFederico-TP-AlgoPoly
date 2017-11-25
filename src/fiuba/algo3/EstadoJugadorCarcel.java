package fiuba.algo3;

import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.Propiedad;
import fiuba.algo3.celdas.Salida;
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
			jugador.visitar(propiedad);
		}
	}

	@Override
	public void visitar(Quini6 quini6, Jugador jugador) {
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
			jugador.visitar(quini6);
		}
	}
	

	@Override
	public void visitar(Policia policia, Jugador jugador) {
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
			jugador.visitar(policia);
		}
	}

	@Override
	public void visitar(AvanceDinamico avance, Jugador jugador) {
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
			jugador.visitar(avance);
		}
	}

	@Override
	public void visitar(RetrocesoDinamico retroceso, Jugador jugador) {
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
			jugador.visitar(retroceso);
		}
	}

	@Override
	public void visitar(Salida salida, Jugador jugador) {
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
			jugador.visitar(salida);
		}
	}
}
