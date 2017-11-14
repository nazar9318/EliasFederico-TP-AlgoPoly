package fiuba.algo3.celdas;

import fiuba.algo3.Jugador;
import fiuba.algo3.excepciones.FondoInsuficienteParaComprar;
import fiuba.algo3.excepciones.JugadorNoTieneFondosParaPagar;

public class Barrio implements Visitable{

private Jugador duenio;
private Visitable celdaAsociada;
private int valoralquiler;
private int precioterreno;
private int alquilercon1casa;
private int alquilercon2casas;
private int alquilerconhotel;
private int precioconstruircasa;
private int precioconstruirhotel;
	
	public Visitable getCeldaasociada() {
		return this.celdaAsociada;
	}

	public void setCeldaasociada(Visitable celdaAsociada) {
		this.celdaAsociada = celdaAsociada;
	}

	public int getValoralquiler() {
		return valoralquiler;
	}

	public void setValoralquiler(int valoralquiler) {
		this.valoralquiler = valoralquiler;
	}

	public int getAlquilercon1casa() {
		return alquilercon1casa;
	}

	public void setAlquilercon1casa(int alquilercon1casa) {
		this.alquilercon1casa = alquilercon1casa;
	}

	public int getAlquilercon2casas() {
		return alquilercon2casas;
	}

	public void setAlquilercon2casas(int alquilercon2casas) {
		this.alquilercon2casas = alquilercon2casas;
	}

	public int getAlquilerconhotel() {
		return alquilerconhotel;
	}

	public void setAlquilerconhotel(int alquilerconhotel) {
		this.alquilerconhotel = alquilerconhotel;
	}

	public int getPrecioconstruircasa() {
		return precioconstruircasa;
	}

	public void setPrecioconstruircasa(int precioconstruircasa) {
		this.precioconstruircasa = precioconstruircasa;
	}

	public int getPrecioconstruirhotel() {
		return precioconstruirhotel;
	}

	public void setPrecioconstruirhotel(int precioconstruirhotel) {
		this.precioconstruirhotel = precioconstruirhotel;
	}

	public Jugador getDuenio() {
		return duenio;
	}

	public void setDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

	public int getPrecioterreno() {
		return precioterreno;
	}

	public void setPrecioterreno(int precioterreno) {
		this.precioterreno = precioterreno;
	}
	public void comprarBarrio(Jugador jugador) {
		if ((jugador.obtenerDinero()>= this.getPrecioterreno()) && (this.getDuenio() == null)) {
			this.setDuenio(jugador);
			jugador.pagar(this.getPrecioterreno());
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
		}else if (dinero < this.getPrecioterreno()){
			throw new FondoInsuficienteParaComprar();
		}
		this.duenio = jugador;
		jugador.pagar(this.getPrecioterreno());
	}
}