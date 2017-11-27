package fiuba.algo3;

import java.util.ArrayList;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.Propiedad;
import fiuba.algo3.celdas.comprables.Servicios.Servicio;
import fiuba.algo3.celdas.Salida;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class Jugador implements Visitante {

	private int dinero;
	private ArrayList<Propiedad> propiedades;
	private int valorDeTiro;
	private EstadoJugador estado;
	
	public Jugador(){
		this.dinero = 100000;
		this.propiedades = new ArrayList<Propiedad>();
		this.estado = new EstadoJugadorNormal();
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

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}
	
	public void agregarPropiedad(Propiedad unaCelda) {
		propiedades.add(unaCelda);
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
}
