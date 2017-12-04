package fiuba.algo3.vista;

import fiuba.algo3.vista.vistasCeldas.*;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class VistaTablero extends GridPane {
	

	public VistaTablero() {
	this.setPadding(new Insets(40,40,40,40));
	this.setVgap(0);
	this.setHgap(0);
	this.setStyle("-fx-background-color: \r\n" + 
			"        linear-gradient(#f2f2f2, #d6d6d6),\r\n" + 
			"        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\r\n" + 
			"        linear-gradient(#dddddd 0%, #f6f6f6 50%);\r\n" + 
			"    -fx-background-radius: 8,7,6;\r\n" + 
			"    -fx-background-insets: 0,1,2;\r\n" + 
			"    -fx-text-fill: black;\r\n" + 
			"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	VistaCelda c00 = new VistaImpuesto();
	GridPane.setConstraints(c00, 0, 0);
	VistaCelda c01 = new VistaCordobaNorte();
	GridPane.setConstraints(c01, 0, 1);
	VistaCelda c02 = new VistaSUBTE();
	GridPane.setConstraints(c02, 0, 2);
	VistaCelda c03 = new VistaAvance();
	GridPane.setConstraints(c03, 0, 3);
	VistaCelda c04 = new VistaCordobaSur();
	GridPane.setConstraints(c04, 0, 4);
	VistaCelda c05 = new VistaCarcel();
	GridPane.setConstraints(c05, 0, 5);
	
	VistaCelda c10 = new VistaSantaFe();
	GridPane.setConstraints(c10, 1, 0);
	VistaCelda c20 = new VistaAYSA();
	GridPane.setConstraints(c20, 2, 0);
	VistaCelda c30 = new VistaSaltaNorte();
	GridPane.setConstraints(c30, 3, 0);
	VistaCelda c40 = new VistaSaltaSur();
	GridPane.setConstraints(c40, 4, 0);
	VistaCelda c50 = new VistaPolicia();
	GridPane.setConstraints(c50, 5, 0);
	
	VistaCelda c51 = new VistaTREN();
	GridPane.setConstraints(c51, 5, 1);
	VistaCelda c52 = new VistaNeuquen();
	GridPane.setConstraints(c52, 5, 2);
	VistaCelda c53 = new VistaRetroceso();
	GridPane.setConstraints(c53, 5, 3);
	VistaCelda c54 = new VistaTucuman();
	GridPane.setConstraints(c54, 5, 4);
	VistaCelda c55 = new VistaSalida();
	GridPane.setConstraints(c55, 5, 5);
	
	VistaCelda c15 = new VistaBSASNorte();
	GridPane.setConstraints(c15, 1, 5);
	VistaCelda c25 = new VistaEDESUR();
	GridPane.setConstraints(c25, 2, 5);
	VistaCelda c35 = new VistaBSASSur();
	GridPane.setConstraints(c35, 3, 5);
	VistaCelda c45 = new VistaQuini6();
	GridPane.setConstraints(c45, 4, 5);
	
    this.getChildren().addAll(c00,c01,c02,c03,c04,c05,c10,c20,c30,c40,c50,c51,c52,c53,c54,c55,c15,c25,c35,c45);
	}
}
