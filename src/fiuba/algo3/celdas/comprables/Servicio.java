package fiuba.algo3.celdas.comprables;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Apropiable;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.excepciones.BarrioConDuenioException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public abstract class Servicio implements Visitable, Apropiable {

	private Jugador duenio;
	protected Servicio celdaAsociada;
	protected final int precioTerreno;

	protected Servicio(int precioTerreno) {
		this.precioTerreno = precioTerreno;
	}

	public Servicio getCeldaAsociada() {
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
		
	}

	public void conocer(Servicio conocida) {
		this.celdaAsociada = conocida;
	}
	
	@Override
	public void comprar(Jugador jugador) {
	
	}
	
	@Override
	public void vender(Jugador jugador) {
	
	}
}