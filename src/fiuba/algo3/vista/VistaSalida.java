package fiuba.algo3.vista;

import javafx.scene.image.Image;

public class VistaSalida extends VistaCelda {
	public VistaSalida() {

	super.modificarLabel("Salida");
	String cssLayout =	"-fx-padding: 8 15 15 15;    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;    -fx-background-radius: 8;    -fx-background-color:        linear-gradient(from 0% 93% to 0% 100%, #686256 0%, #454140 100%),              radial-gradient(center 50% 50%, radius 100%, #686256, #454140);    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );    ";
	super.setCSSStyle(cssLayout);

	}
}
