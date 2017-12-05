package fiuba.algo3.vista;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.vista.vistasCeldas.*;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class VistaTablero extends GridPane {
	private HashMap<Jugador, String> playerid;
	public ArrayList<VistaCelda> celdas;
	private AlgoPoly algo;
	private VistaCelda dinero;

	public VistaTablero(AlgoPoly algopoly) {
		this.celdas = new ArrayList<VistaCelda>();
		this.algo = algopoly;
		playerid = new HashMap<Jugador, String>();
		int i = 1;
		for (Jugador jugador : this.algo.getJugadores()) {
			playerid.put(jugador, "J" + String.valueOf(i));
			i++;
		}

		this.setPadding(new Insets(40, 40, 40, 40));
		this.setVgap(0);
		this.setHgap(0);
		this.setStyle("-fx-background-color: \r\n" + "        linear-gradient(#f2f2f2, #d6d6d6),\r\n"
				+ "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\r\n"
				+ "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\r\n" + "    -fx-background-radius: 8,7,6;\r\n"
				+ "    -fx-background-insets: 0,1,2;\r\n" + "    -fx-text-fill: black;\r\n"
				+ "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

		// Salida
		VistaCelda c55 = new VistaSalida();
		GridPane.setConstraints(c55, 5, 5);
		celdas.add(c55);

		// Quini6
		VistaCelda c45 = new VistaQuini6();
		GridPane.setConstraints(c45, 4, 5);
		celdas.add(c45);

		// BuenosAiresSur
		VistaCelda c35 = new VistaBSASSur();
		GridPane.setConstraints(c35, 3, 5);
		celdas.add(c35);

		// EDESUR
		VistaCelda c25 = new VistaEDESUR();
		GridPane.setConstraints(c25, 2, 5);
		celdas.add(c25);

		// BenosAiiresNorte
		VistaCelda c15 = new VistaBSASNorte();
		GridPane.setConstraints(c15, 1, 5);
		celdas.add(c15);

		// Carcel
		VistaCelda c05 = new VistaCarcel();
		GridPane.setConstraints(c05, 0, 5);
		celdas.add(c05);

		// CordobaSur
		VistaCelda c04 = new VistaCordobaSur();
		GridPane.setConstraints(c04, 0, 4);
		celdas.add(c04);

		// Avance
		VistaCelda c03 = new VistaAvance();
		GridPane.setConstraints(c03, 0, 3);
		celdas.add(c03);

		// SUBTE
		VistaCelda c02 = new VistaSUBTE();
		GridPane.setConstraints(c02, 0, 2);
		celdas.add(c02);

		// CordobaNorte
		VistaCelda c01 = new VistaCordobaNorte();
		GridPane.setConstraints(c01, 0, 1);
		celdas.add(c01);

		// Impuesto
		VistaCelda c00 = new VistaImpuesto();
		GridPane.setConstraints(c00, 0, 0);
		celdas.add(c00);

		// SantaFe
		VistaCelda c10 = new VistaSantaFe();
		GridPane.setConstraints(c10, 1, 0);
		celdas.add(c10);

		// AYSA
		VistaCelda c20 = new VistaAYSA();
		GridPane.setConstraints(c20, 2, 0);
		celdas.add(c20);

		// SaltaNorte
		VistaCelda c30 = new VistaSaltaNorte();
		GridPane.setConstraints(c30, 3, 0);
		celdas.add(c30);

		// SaltaSur
		VistaCelda c40 = new VistaSaltaSur();
		GridPane.setConstraints(c40, 4, 0);
		celdas.add(c40);

		// Policia
		VistaCelda c50 = new VistaPolicia();
		GridPane.setConstraints(c50, 5, 0);
		celdas.add(c50);

		// Tren
		VistaCelda c51 = new VistaTREN();
		GridPane.setConstraints(c51, 5, 1);
		celdas.add(c51);

		// Neuquen
		VistaCelda c52 = new VistaNeuquen();
		GridPane.setConstraints(c52, 5, 2);
		celdas.add(c52);

		// Retroceso
		VistaCelda c53 = new VistaRetroceso();
		GridPane.setConstraints(c53, 5, 3);
		celdas.add(c53);

		// Tucuman
		VistaCelda c54 = new VistaTucuman();
		GridPane.setConstraints(c54, 5, 4);
		celdas.add(c54);
		
		//dinero disponible
		dinero = new VistaDisponible();
		GridPane.setConstraints(dinero, 1, 1);
		
		this.getChildren().addAll(c00, c01, c02, c03, c04, c05, c10, c20, c30, c40, c50, c51, c52, c53, c54, c55, c15,
				c25, c35, c45,dinero);
	}

	public void actaulizarVista() {

		// limpia los jugadores de las celdas
		for (VistaCelda celda : celdas) {
			celda.removerUltimocontenido();
			dinero.modificarDinero(" ");
		}

		for (Jugador jugador : this.algo.getJugadores()) {
			dinero.modificarDinero(dinero.getDinero()+ playerid.get(jugador)+ ": " + jugador.obtenerDinero() + "\n ");
			int pos = this.algo.getTablero().getPosicionEnTablero(jugador);
			celdas.get(pos).agregarJugador(playerid.get(jugador));
			for (Propiedad propiedad : jugador.getPropiedades()) {
				celdas.get(this.algo.getTablero().getCeldas().indexOf(propiedad)).modificarDuenio("Propietario: " + playerid.get(jugador));
			}
		}
		
	}
}
