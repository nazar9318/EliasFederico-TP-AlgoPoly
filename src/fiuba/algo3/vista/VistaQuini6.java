package fiuba.algo3.vista;

import javafx.scene.image.Image;

public class VistaQuini6 extends VistaCelda {
	public VistaQuini6() {

	super.modificarLabel("Quini6");
	String cssLayout = "-fx-padding: 8 15 15 15;    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;    -fx-background-radius: 8;    -fx-background-color:        linear-gradient(from 0% 93% to 0% 100%, #82b74b 0%, #b5e7a0 100%),              radial-gradient(center 50% 50%, radius 100%, #82b74b, #b5e7a0);    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );    ";
	super.setCSSStyle(cssLayout);
	}
}
