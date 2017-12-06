package fiuba.algo3.vista.vistasCeldas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public abstract class VistaCelda extends VBox {
	Label label;
	FlowPane jugadores;
	Label duenio;
	Label precio;
protected VistaCelda() {

	jugadores = new FlowPane();
	jugadores.setAlignment(Pos.CENTER);
	jugadores.setHgap(4);
	
	 label =  new Label(" ");
	 precio =  new Label(" ");
	 duenio =  new Label(" ");
	 
	label.setStyle("-fx-background-color: \r\n" + 
	 		"        rgba(0,0,0,0.08),\r\n" + 
	 		"        linear-gradient(#9a9a9a, #909090),\r\n" + 
	 		"        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\r\n" + 
	 		"    -fx-background-insets: 0 0 -1 0,0,1;\r\n" + 
	 		"    -fx-background-radius: 5,5,4;\r\n" + 
	 		"    -fx-padding: 1 1 1 1;\r\n" + 
	 		"    -fx-text-fill: #242d35;\r\n" + 
	 		"    -fx-font-size: 12px;");
	label.setAlignment(Pos.CENTER);
	duenio.setAlignment(Pos.CENTER);
	precio.setAlignment(Pos.CENTER);
	this.getChildren().add(label);
	this.getChildren().add(duenio);
	this.getChildren().add(precio);
	this.getChildren().add(jugadores);
	this.setMinSize(140 ,90);
	this.setMaxSize(140 ,90);
	this.duenio.setMaxSize(140 ,80);
	this.precio.setMaxSize(140 ,80);
	this.label.setMaxSize(140 ,80);
	}
	

	public void agregarJugador(String jugador) {
		Label nombre = new Label(jugador);
		nombre.setStyle("-fx-background-color:\r\n" + 
				"        linear-gradient(#f0ff35, #a9ff00),\r\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\r\n" + 
				"    -fx-background-radius: 6, 5;\r\n" + 
				"    -fx-background-insets: 0, 1;\r\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\r\n" + 
				"    -fx-text-fill: #395306;");
		
		jugadores.getChildren().add(nombre);
	
	}
	public void modificarLabel(String texto) {
	    label.setText(texto);
	}
	public void modificarDinero(String texto) {
	    precio.setText(texto);
	}	
	public String getDinero() {
	    return precio.getText();
	}	
	
	public void setCSSStyle(String string) {
		this.setStyle(string);
	}
	
	public void removerUltimocontenido() {
		jugadores.getChildren().clear();
		duenio.setText("");
	}
	
	public String getNombre() {
		return label.getText();
	}


	public void modificarDuenio(String texto) {
	    duenio.setText(texto);
	    duenio.setStyle(" -fx-background-color: \r\n" + 
	    		"        #090a0c,\r\n" + 
	    		"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n" + 
	    		"        linear-gradient(#20262b, #191d22),\r\n" + 
	    		"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\r\n" + 
	    		"    -fx-background-radius: 5,4,3,5;\r\n" + 
	    		"    -fx-background-insets: 0,1,2,0;\r\n" + 
	    		"    -fx-text-fill: white;\r\n" + 
	    		"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n" + 
	    		"    -fx-font-family: \"Arial\";\r\n" + 
	    		"    -fx-text-fill: linear-gradient(white, #d0d0d0);\r\n" + 
	    		"    -fx-font-size: 12px;\r\n" + 
	    		"    -fx-padding: 1 2 1 2;");
		
	}
	
}
