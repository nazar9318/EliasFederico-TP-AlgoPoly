package fiuba.algo3.celdas.comprables;

import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.excepciones.BarrioConDuenioException;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public abstract class Barrio implements Visitable {

	protected Jugador duenio;
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

	private int getPrecioTerreno() {
		return precioTerreno;
	}

	public void comprar(Jugador jugador) {
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

	public void cobrar(Jugador jugador) {
		jugador.pagar(getAlquiler());
	}

	private int getAlquiler() {
		return alquiler;
	}

	public void cobrarAlquiler(Jugador jugador) {
		cobrar(jugador);
		this.duenio.cobrar(getAlquiler());
	}

	public void conocer(Barrio conocida) {
		this.celdaAsociada = conocida;
	}

	public void vender(Jugador jugador) {
		//TODO: cuando se agreguen las construcciones, es necesario sacarlas de la pripeidad al venderla
		jugador.cobrar(getPrecioDeVenta());
		jugador.getPropiedades().remove(this);
		this.duenio = null;
	}

	private int getPrecioDeVenta() {
		return (precioTerreno - 15*precioTerreno/100);
	}

}