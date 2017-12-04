package fiuba.algo3.vista.vistasCeldas;

public class VistaCarcel extends VistaCelda {
	public VistaCarcel() {

	super.modificarLabel("Carcel");
	String cssLayout = "-fx-padding: 8 15 15 15;    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;    -fx-background-radius: 8;    -fx-background-color:        linear-gradient(from 0% 93% to 0% 100%, #92a8d1 0%, #deeaee 100%),              radial-gradient(center 50% 50%, radius 100%, #92a8d1, #deeaee);    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );    ";
	super.setCSSStyle(cssLayout);
	}
}
