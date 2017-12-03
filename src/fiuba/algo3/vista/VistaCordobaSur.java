package fiuba.algo3.vista;

import javafx.scene.image.Image;

public class VistaCordobaSur extends VistaCelda {
	public VistaCordobaSur() {

	super.modificarLabel("Cordoba Sur");
	String cssLayout = "-fx-padding: 8 15 15 15;    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;    -fx-background-radius: 8;    -fx-background-color:        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),              radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );    ";
	super.setCSSStyle(cssLayout);

	}
}
