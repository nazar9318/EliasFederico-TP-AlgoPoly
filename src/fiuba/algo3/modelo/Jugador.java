package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.celdas.comprables.Barrio;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.especiales.AvanceDinamico;
import fiuba.algo3.modelo.celdas.especiales.Carcel;
import fiuba.algo3.modelo.celdas.especiales.Policia;
import fiuba.algo3.modelo.celdas.especiales.Quini6;
import fiuba.algo3.modelo.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;

public class Jugador implements Visitante {

	private int dinero;
	private ArrayPropiedad propiedades;
	private int valorDeTiro;
	private EstadoJugador estado;
	private Tablero tablero;
	
	public Jugador(){
		this.dinero = 100000;
		this.propiedades = new ArrayPropiedad();
		this.estado = new EstadoJugadorNormal();
	}

	public void setEstado(EstadoJugador estado) {
		this.estado = estado;
	}

	public EstadoJugador getEstado() {
		return estado;
	}

	public int obtenerDinero() {
		return this.dinero;
	}

	public void cobrar(int monto) {
		this.dinero += monto;
	}

	public void pagar(int monto) {
		if(this.dinero < monto){
			throw new JugadorNoTieneFondosParaPagarException();
		}
		this.dinero -= monto;
	}

	public void setValorDeTiro(int valorTiro) {
		valorDeTiro = valorTiro;
	}
	
	public int getValorDeTiro() {
		return valorDeTiro;
	}
	
	public int getCantidadDePropiedades() {
		return propiedades.size();
	}

	public ArrayPropiedad getPropiedades() {
		return propiedades;
	}
	
	public void agregarPropiedad(Propiedad unaCelda) {
		propiedades.add(unaCelda);
	}
	
	public void conocerTablero(Tablero unTablero) {
		tablero = unTablero;
	}
	
	public void moverJugador(int movimiento) {
		if (movimiento != 0) tablero.avanzarJugador(this, movimiento);
	}

	@Override
	public void visitar(Propiedad propiedad) {
		this.estado.visitar(propiedad, this);
	}

	@Override
	public void visitar(Quini6 quini6) {
		this.estado.visitar(quini6, this);
	}

	@Override
	public void visitar(Salida salida) {
		this.estado.visitar(salida, this);
	}
	
	@Override
	public void visitar(Carcel carcel) {
		this.estado = new EstadoJugadorCarcel(carcel);
	}

	@Override
	public void visitar(AvanceDinamico avance) {
		this.estado.visitar(avance, this);
//		avance.calcularAvance(this);
	}

	@Override
	public void visitar(RetrocesoDinamico retroceso) {
		this.estado.visitar(retroceso, this);
	//	retroceso.calcularRetroceso(this);
	}

	public void salirDeLaCarcel() {
		this.estado = new EstadoJugadorNormal();
	}

	@Override
	public void visitar(Policia policia) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean poseeALaAsociadaDe(Propiedad propiedad) {
		if (propiedad.getCeldaAsociada() == null) return true;
		return (propiedad.getCeldaAsociada().getDuenio() == this);
	}

	public void construir(Barrio barrio) {
		barrio.construir(this);
	}

	public void removerPropiedad(Propiedad propiedad) {
		this.propiedades.remove(propiedad);
	}

	public void visitar(Visitable visitable) {
		// TODO Auto-generated method stub
		
	}

	public void verPropiedades() {
		for(int i = 0; i < getCantidadDePropiedades(); i++){
			System.out.println(this.propiedades.get(i).getNombre());
		}
	}

	public Propiedad buscarPropiedad(String propiedad) {
		for(int i = 0; i < getCantidadDePropiedades(); i++) {
			if(this.propiedades.get(i).getNombre().equals(propiedad))
				return this.propiedades.get(i);
		}
		return null;
	}
}
