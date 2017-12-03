package fiuba.algo3.vista;

import javafx.scene.image.Image;

public class VistaJugador {
	Image jugador;
	public VistaJugador(String avatar){
	 jugador = new Image(avatar);
	 
	}
	
	public Image getVista() {
		return jugador;
	}

}
