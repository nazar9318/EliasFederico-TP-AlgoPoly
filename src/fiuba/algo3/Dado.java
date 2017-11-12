package fiuba.algo3;

//TODO: revisar clase con nueva funcionalidad
public class Dado {

	private int valor;
	
	public int tirar() {
		valor = (int) (Math.random() * 6) + 1;
		return valor;
	}

	public int getValor() {
		return valor;
	}
	
	public void setValor(int unValor) {
		valor = unValor;
	}
}
