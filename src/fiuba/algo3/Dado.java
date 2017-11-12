package fiuba.algo3;

public class Dado {
	
	private int valor;
	
	public int tirar() {
		valor = (int) (Math.random() * 6) + 1;
		return valor;
	}
	
}
