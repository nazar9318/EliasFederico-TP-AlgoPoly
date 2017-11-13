package fiuba.algo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.celdas.Celda;
import fiuba.algo3.celdas.CeldaBarrio;
import fiuba.algo3.celdas.CeldaSalida;
import fiuba.algo3.celdas.especiales.CeldaCarcel;
import fiuba.algo3.celdas.especiales.CeldaQuini6;
import fiuba.algo3.factory.PropiedadFactory;

public class Tablero {

	private HashMap<Jugador, Celda> jugadores;
	private ArrayList<Celda> celdas;
	private Map<Propiedad, Jugador> propiedades = new HashMap<>();
	//TODO: muy buena idea poner enum para las "familias" de propiedades y que cada propiedad tenga de atributo (string) su flia


	public Tablero() {
		jugadores = new HashMap<>();
		celdas = new ArrayList<>();
		generarCeldas();
	}

	private void generarCeldas() {
		//TODO generar propiedades con PropiedadFactory
		Propiedad BsAsSur = PropiedadFactory.getPropiedad("Buenos Aires Sur");

		this.agregarCelda(new CeldaSalida());
		this.agregarCelda(new CeldaQuini6());
		llenarTerreno(BsAsSur);
		this.agregarCelda(new CeldaCarcel());
	}

	private void llenarTerreno(Propiedad propiedad){
		this.agregarCelda(new CeldaBarrio(propiedad));
		this.agregarPropiedad(propiedad);
	}

	public void agregarCelda(Celda celda) {
		celdas.add(celda);
	}

	private void agregarPropiedad(Propiedad propiedad){
		propiedades.put(propiedad, null);
	}

	public void agregarJugador(Jugador j1) {
		this.jugadores.put(j1, getSalida());
	}

	public int getCantidadDeCeldas() {
		return celdas.size();
	}

	public Celda getSalida() {
		return this.celdas.get(0);
	}

	public Celda getPosicionDeJugador(Jugador j1) {
		return this.jugadores.get(j1);
	}

	private Celda reposicionarJugador(Jugador j1, int index, int avance){
		if(index + avance >= getCantidadDeCeldas())
			this.jugadores.put(j1, this.celdas.get(index + avance - getCantidadDeCeldas()));
		else
			this.jugadores.put(j1, this.celdas.get(index+avance));

		return this.jugadores.get(j1);
	}

	public void avanzarJugador(Jugador jugador, int avance) {

		Celda celdaActual = this.jugadores.get(jugador);
		int index = this.celdas.indexOf(celdaActual);
//		celdaActual.sacarJugador(jugador); //TODO: reemplazar sacar jugador por metodo mas integral que valide habilitacion de moverse

		Celda celdaNueva = reposicionarJugador(jugador, index, avance);
	}

	public void aplicarAccionDeCelda(Celda celda, Jugador jugador){
		celda.accionDeCelda(this, jugador);
	}

	public HashMap<Jugador, Celda> getJugadores() {
		return jugadores;
	}

	public Map<Propiedad, Jugador> getPropiedades() {
		return propiedades;
	}

	public ArrayList<Celda> getCeldas(){
		return this.celdas;
	}

	public Jugador getDuenioDePropiedad(CeldaBarrio celda) {
		return this.propiedades.get(celda.getPropiedad());
	}

	public boolean consultarCompra(Jugador jugador, Propiedad propiedad) {
		return true;
	}
}