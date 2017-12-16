package fiuba.algo3.modelo.celdas.comprables;

import fiuba.algo3.modelo.Command.Respuesta;

import java.util.ArrayList;
import java.util.Optional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.excepciones.JugadorNoCuentaConDineroSuficienteParaComprarException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;
import fiuba.algo3.modelo.excepciones.PropiedadConDuenioException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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

	public String getNombre() {
		return nombre;
	}

	public Jugador getDuenio() {
		return duenio;
	}

	private void setDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

	public int getPrecioTerreno() {
		return precioTerreno;
	}

	public void comprar(Jugador jugador) {
		if (this.getDuenio() == null) {
			try {
				jugador.pagar(this.getPrecioTerreno());
			}catch(JugadorNoTieneFondosParaPagarException e){
				throw new JugadorNoCuentaConDineroSuficienteParaComprarException();
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

	public int getAlquiler() {
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
	
	protected void hacerVenderParaCubrirAlquiler(Jugador jugadorActual) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje de informacion");
        alert.setHeaderText("Debe vender una de sus propiedades para pagar alquiler, de lo contrario perdera");

        ArrayList<ButtonType> botonesDePropiedades = new ArrayList<ButtonType>();
        for(int i = 0; i<= jugadorActual.getCantidadDePropiedades() -1; i++){
        	ButtonType botonPropiedad = new ButtonType(jugadorActual.getPropiedades().get(i).getNombre());
        	botonesDePropiedades.add(botonPropiedad);
        }
        alert.getButtonTypes().setAll(botonesDePropiedades);
        
        Optional<ButtonType> eleccion = alert.showAndWait();
        hacerVenderEleccion(jugadorActual, eleccion);
	}

	protected void hacerVenderEleccion(Jugador jugadorActual, Optional<ButtonType> eleccion) {
		jugadorActual.venderPropiedadDeNombre(eleccion.get().getText());
	}
}
