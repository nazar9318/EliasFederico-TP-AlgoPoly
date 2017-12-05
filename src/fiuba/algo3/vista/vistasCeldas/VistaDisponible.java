package fiuba.algo3.vista.vistasCeldas;

public class VistaDisponible extends VistaCelda {
	public VistaDisponible() {

	super.modificarLabel("Dinero Disponible");
	String cssLayout =	"-fx-background-color: \r\n" + 
			"        linear-gradient(#ffd65b, #e68400),\r\n" + 
			"        linear-gradient(#ffef84, #f2ba44),\r\n" + 
			"        linear-gradient(#ffea6a, #efaa22),\r\n" + 
			"        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n" + 
			"        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n" + 
			"    -fx-background-radius: 0;\r\n" + 
			"    -fx-background-insets: 0,1,2,3,0;\r\n" + 
			"    -fx-text-fill: #654b00;\r\n" + 
			"    -fx-font-weight: bold;\r\n" + 
			"    -fx-font-size: 12px;\r\n" + 
			"    -fx-padding: 1 2 1 2;"; 
			
	super.setCSSStyle(cssLayout);
	}
}
