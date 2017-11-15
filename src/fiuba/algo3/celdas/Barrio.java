package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.BarrioConDuenioException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class Barrio implements Visitable, Propiedad{

	private Jugador duenio;
	private Visitable celdaAsociada;
	private int precioTerreno;
	private int alquiler;


	public Jugador getDuenio() {
		return duenio;
	}

	public void setDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

	public int getPrecioTerreno() {
		return precioTerreno;
	}

	public void setPrecioTerreno(int precioterreno) {
		this.precioTerreno = precioterreno;
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

	public void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}

}