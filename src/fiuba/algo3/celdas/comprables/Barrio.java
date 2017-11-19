package fiuba.algo3.celdas.comprables;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Propiedad;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.excepciones.BarrioConDuenioException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public abstract class Barrio implements Visitable, Propiedad {

	private Jugador duenio;
	protected Barrio celdaAsociada;
	protected final int precioTerreno;
	protected final int alquiler;

	protected Barrio(int precioTerreno, int alquiler) {
		this.precioTerreno = precioTerreno;
		this.alquiler = alquiler;
	}

	public Barrio getCeldaAsociada() {
		return celdaAsociada;
	}

	public Jugador getDuenio() {
		return duenio;
	}

	public void setDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

	public int getPrecioTerreno() {
		return precioTerreno;
	}

	public void comprarBarrio(Jugador jugador) {
		if (this.getDuenio() == null) {
			try {
				jugador.pagar(this.getPrecioTerreno());
			}catch(JugadorNoTieneFondosParaPagarException e){
				throw new JugadorNoTieneFondosParaPagarException();
			}
			jugador.agregarPropiedad(this);
			this.setDuenio(jugador);
		}
		else {	
			throw new BarrioConDuenioException();//pagar alquiler
		}
	}

	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}

	@Override
	public void cobrar(Jugador jugador) {
		jugador.pagar(getAlquiler());
	}

	public int getAlquiler() {
		return alquiler;
	}

	public void conocer(Barrio conocida) {
		this.celdaAsociada = conocida;
	}
}