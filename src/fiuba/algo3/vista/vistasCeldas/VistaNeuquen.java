package fiuba.algo3.vista.vistasCeldas;


public class VistaNeuquen extends VistaCelda {
	public VistaNeuquen() {

	super.modificarLabel("Neuquen");
	String cssLayout =	"-fx-padding: 8 15 15 15;    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;    -fx-background-radius: 8;    -fx-background-color:        linear-gradient(from 0% 93% to 0% 100%, #eea29a 0%, #f7cac9 100%),              radial-gradient(center 50% 50%, radius 100%, #eea29a, #f7cac9);    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );    ";
	super.setCSSStyle(cssLayout);

	}
}
