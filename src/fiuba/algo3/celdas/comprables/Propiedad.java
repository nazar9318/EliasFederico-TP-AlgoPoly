package fiuba.algo3.celdas.comprables;

import fiuba.algo3.Command.Respuesta;
import fiuba.algo3.Jugador;
import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;
import fiuba.algo3.excepciones.PropiedadConDuenioException;

public abstract class Propiedad implements Visitable {

	protected Jugador duenio;
	protected Propiedad celdaAsociada;
	protected final int precioTerreno;
	protected final int alquiler;
	protected final String nombre;

	protected Propiedad (int precioTerreno, int alquiler, String nombre) {
		this.precioTerreno = precioTerreno;
		this.alquiler = alquiler;
		this.nombre = nombre;
	}

	public Propiedad getCeldaAsociada() {
		return celdaAsociada;
	}

	public Jugador getDuenio() {
		return duenio;
	}

	private void setDuenio(Jugador duenio) {
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
			throw new PropiedadConDuenioException();//pagar alquiler
		}
	}

	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}

	protected int getAlquiler() {
		return alquiler;
	}

	public void conocer(Propiedad conocida) {
		this.celdaAsociada = conocida;
	}

	public void vender() {
		duenio.cobrar(getPrecioDeVenta());
		duenio.removerPropiedad(this);
		this.duenio = null;
	}

	protected int getPrecioDeVenta() {
		return (precioTerreno - 15*precioTerreno/100);
	}

	public abstract void cobrarAlquiler(Jugador jugador);

	public abstract Respuesta getOpciones(Jugador jugador);
}
