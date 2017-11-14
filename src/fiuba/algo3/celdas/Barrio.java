package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.BarrioConDuenioException;
import fiuba.algo3.excepciones.FondoInsuficienteParaComprar;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class Barrio implements Visitable{

private Jugador duenio;
private Visitable celdaAsociada;
private int valorAlquiler;
private int precioTerreno;
private int alquilerCon1Casa;
private int alquilerCon2Casas;
private int alquilerConHotel;
private int precioConstruirCasa;
private int precioConstruirHotel;
	
	public Visitable getCeldaasociada() {
		return this.celdaAsociada;
	}

	public void setCeldaasociada(Visitable celdaAsociada) {
		this.celdaAsociada = celdaAsociada;
	}

	public int getValorAlquiler() {
		return this.valorAlquiler;
	}

	public void setValorAlquiler(int valoralquiler) {
		this.valorAlquiler = valoralquiler;
	}

	public int getAlquilerCon1Casa() {
		return alquilerCon1Casa;
	}

	public void setAlquilerCon1Casa(int alquilercon1casa) {
		this.alquilerCon1Casa = alquilercon1casa;
	}

	public int getAlquilerCon2Casas() {
		return this.alquilerCon2Casas;
	}

	public void setAlquilerCon2Casas(int alquilercon2casas) {
		this.alquilerCon2Casas = alquilercon2casas;
	}

	public int getAlquilerConHotel() {
		return this.alquilerConHotel;
	}

	public void setAlquilerConHotel(int alquilerconhotel) {
		this.alquilerConHotel = alquilerconhotel;
	}

	public int getPrecioConstruirCasa() {
		return precioConstruirCasa;
	}

	public void setPrecioConstruirCasa(int precioconstruircasa) {
		this.precioConstruirCasa = precioconstruircasa;
	}

	public int getPrecioConstruirHotel() {
		return precioConstruirHotel;
	}

	public void setPrecioConstruirHotel(int precioconstruirhotel) {
		this.precioConstruirHotel = precioconstruirhotel;
	}

	public Jugador getDuenio() {
		return duenio;
	}

	public void setDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

	public int getPrecioTerreno() {
		return precioTerreno;
	}

	public void setPrecioTerreno(int precioterreno) {
		this.precioTerreno = precioterreno;
	}
	public void comprarBarrio(Jugador jugador) {
		if ((jugador.obtenerDinero()>= this.getPrecioTerreno()) && (this.getDuenio() == null)) {
			this.setDuenio(jugador);
			jugador.pagar(this.getPrecioTerreno());
		}
		else {	
			throw new JugadorNoTieneFondosParaPagar();
		}
	}

	@Override
	public void aceptar(Jugador jugador) {
		jugador.visitar(this);
	}

	public void venderseAJugador(Jugador jugador, int dinero) {
		if(jugador != this.getDuenio() && this.getDuenio() != null){
			throw new BarrioConDuenioException();
		}else if (dinero < this.getPrecioTerreno()){
			throw new FondoInsuficienteParaComprar();
		}
		this.duenio = jugador;
		jugador.pagar(this.getPrecioTerreno());
	}
}