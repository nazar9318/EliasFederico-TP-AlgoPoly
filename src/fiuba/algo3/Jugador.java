package fiuba.algo3;

import java.util.ArrayList;

import fiuba.algo3.celdas.Celda;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

//TODO: revisar clase con nueva funcionalidad
public class Jugador {

	private int dinero;
	private ArrayList<Celda> propiedades;
	//TODO: muy buena idea poner enum para las "familias" de propiedades y que cada propiedad tenga de atributo (string) su flia

	public Jugador(){
		this.dinero = 100000;
		this.propiedades = new ArrayList<Celda>();
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

	public void comprar(Celda unaCelda) {
		propiedades.add(unaCelda);
	}

}
