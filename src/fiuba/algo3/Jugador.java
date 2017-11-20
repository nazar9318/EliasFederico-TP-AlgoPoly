package fiuba.algo3;

import java.util.ArrayList;
import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.Salida;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagarException;

public class Jugador implements Visitante {

	private int dinero;
	private ArrayList<Barrio> propiedades;
	private int valorDeTiro;
	private EstadoJugador estado;
	
	public Jugador(){
		this.dinero = 100000;
		this.propiedades = new ArrayList<Barrio>();
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
	
	public int pedirTiro() {
		return valorDeTiro;
	}
	
	public int getCantidadDePropiedades() {
		return propiedades.size();
	}

	public ArrayList<Barrio> getPropiedades() {
		return propiedades;
	}
	
	public void agregarPropiedad(Barrio unaCelda) {
		propiedades.add(unaCelda);
	}

	@Override
	public void visitar(Barrio barrio) {
		this.estado.visitar(barrio, this);
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
		//carcel.encarcelarJugador(this);
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
	
	public boolean puedeEdificarEn(Barrio barrio) {
		return (barrio.getCeldaAsociada().getDuenio() == this);
	}
}
