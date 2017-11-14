package fiuba.algo3;

import java.util.ArrayList;

import fiuba.algo3.celdas.Visitable;
import fiuba.algo3.celdas.Barrio;
import fiuba.algo3.celdas.Salida;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class Jugador implements Visitante {

	private int dinero;
	private ArrayList<Visitable> propiedades;
	
	public Jugador(){
		this.dinero = 100000;
		this.propiedades = new ArrayList<Visitable>();
	}

	public int obtenerDinero() {
		return this.dinero;
	}

	public void cobrar(int monto) {
		this.dinero += monto;
	}

	public void pagar(int monto) {
		if(this.dinero < monto){
			throw new JugadorNoTieneFondosParaPagar();
		}
		this.dinero -= monto;
	}

	public int getCantidadDePropiedades() {
		return propiedades.size();
	}
	
	public void comprar(Visitable unaCelda) {
		propiedades.add(unaCelda);
	}
	
	public void comprarBarrio(Barrio barrio) {
		barrio.venderseAJugador(this, this.obtenerDinero());		
	}

	@Override
	public void visitar(Barrio barrio) {
		this.comprarBarrio(barrio);
	}

	@Override
	public void visitar(Quini6 quini6) {
		quini6.pagarPremioAJugador(this);
	}

	@Override
	public void visitar(Salida salida) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void visitar(Carcel carcel) {
		carcel.encarcelarJugador(this);
	}

	@Override
	public void visitar(Policia policia) {
		policia.arrestarJugador(this);
	}

	@Override
	public void visitar(AvanceDinamico avance) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void visitar(RetrocesoDinamico retroceso) {
		// TODO Auto-generated method stub
	}

}
