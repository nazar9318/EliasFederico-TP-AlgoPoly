package fiuba.algo3;

public class Jugador {

	private int dinero;
	
	public Jugador(){
		this.dinero = 100000;
	}

	public int obtenerDinero() {
		return this.dinero;
	}

	public void cobrar(int monto) {
		this.dinero += monto;
	}

}
