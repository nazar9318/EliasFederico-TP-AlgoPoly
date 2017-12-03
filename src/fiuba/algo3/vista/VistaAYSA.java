package fiuba.algo3.vista;

import javafx.scene.image.Image;

public class VistaAYSA extends VistaCelda {
	public VistaAYSA() {

	super.modificarLabel("AYSA");
	String cssLayout = "-fx-padding: 8 15 15 15;    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;    -fx-background-radius: 8;    -fx-background-color:        linear-gradient(from 0% 93% to 0% 100%, #ffcc5c 0%, #ffef96 100%),              radial-gradient(center 50% 50%, radius 100%, #ffcc5c, #ffef96);    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );    ";
	super.setCSSStyle(cssLayout);

	}
}
