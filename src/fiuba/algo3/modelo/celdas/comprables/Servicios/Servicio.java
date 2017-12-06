package fiuba.algo3.modelo.celdas.comprables.Servicios;

import fiuba.algo3.modelo.Command.Respuesta;
import fiuba.algo3.modelo.Command.Vender;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;
import fiuba.algo3.modelo.excepciones.JugadorPerdioException;

public abstract class Servicio extends Propiedad implements Visitable {

	protected int modificadorDeAlquiler;

	protected Servicio(int precioTerreno, int alquiler, String nombre) {
		super(precioTerreno, alquiler, nombre);
	}

	@Override
	public void cobrarAlquiler(Jugador jugador) {
		try{
			if (this.duenio.poseeALaAsociadaDe(this)){
				jugador.pagar((getAlquiler() + modificadorDeAlquiler)*jugador.getValorDeTiro());
				this.duenio.cobrar((getAlquiler() + modificadorDeAlquiler)*jugador.getValorDeTiro());
			} else{
				jugador.pagar(getAlquiler() * jugador.getValorDeTiro());
				this.duenio.cobrar(getAlquiler() * jugador.getValorDeTiro());
			}
		}catch (JugadorNoTieneFondosParaPagarException e){
			if(jugador.getCantidadDePropiedades() == 0)
				throw new JugadorPerdioException();
			else
				super.hacerVenderParaCubrirAlquiler(jugador);
				this.cobrarAlquiler(jugador);
		}
	}

	public void conocer(Servicio conocida) {
		this.celdaAsociada = conocida;
	}

	@Override
	public Respuesta getOpciones(Jugador jugador){
		Respuesta opciones = new Respuesta();

		opciones.agregarOpcion(new Vender(this));
		return opciones;
	}
}