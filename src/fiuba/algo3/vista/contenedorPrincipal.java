package fiuba.algo3.vista;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.Turno;
import fiuba.algo3.modelo.ArrayPropiedad;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.vista.eventos.BotonTirarDadosHandler;
import fiuba.algo3.vista.eventos.BotonVerPropiedadesHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import java.util.ArrayList;

public class contenedorPrincipal extends BorderPane{
	   GridPane vistaTablero;
    public contenedorPrincipal(AlgoPoly algo){
    	setConsola();
        setBotonera(algo.getPropiedades(), algo.jugadorActual(), algo.getTurno(), algo.getTablero());
        setCentro(algo.getTablero().getCeldas());
    }

    private void setBotonera(ArrayPropiedad propiedades, Jugador jugador, Turno turno, Tablero tablero) {

        Button botonTirarDados = new Button("Tirar Dados");
        BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(turno, jugador, tablero);
        botonTirarDados.setOnAction(botonTirarDadosHandler);

        this.actualizarConsola(turno);

        Button botonVerPropiedades = new Button("Ver Propiedades");
        BotonVerPropiedadesHandler verPropiedadesHandler = new BotonVerPropiedadesHandler(propiedades, jugador);
        botonVerPropiedades.setOnAction(verPropiedadesHandler);

        VBox contenedorVertical = new VBox(botonTirarDados, botonVerPropiedades);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
    }

    private void actualizarConsola(Turno turno) {
    	int dado1 = turno.getValorDado1();
		int dado2 = turno.getValorDado2();
		
        Label etiqueta = new Label();
        etiqueta.setText("Valores de los dados\n" + "Dado uno: " + dado1 + " \n" + "Dado dos: " + dado2);
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);		
	}

	private void setCentro(ArrayList<Visitable> celdas){

        StackPane salida = new StackPane();
        salida.getChildren().addAll(new Rectangle(100,100, Color.MIDNIGHTBLUE), new Label("<= Salida"));

        StackPane bs = new StackPane();
        bs.getChildren().addAll(new Rectangle(100,100, Color.RED), new Label("Bs As Sur"));

        StackPane imp = new StackPane();
        imp.getChildren().addAll(new Rectangle(100,100, Color.YELLOW), new Label("Impuesto De Lujo"));

        StackPane cdba = new StackPane();
        cdba.getChildren().addAll(new Rectangle(100,100, Color.GREEN), new Label("Cordoba"));

        GridPane gp = new GridPane();
        gp.add(salida, 1,1);
        gp.add(bs, 0,1);
        gp.add(imp, 0,0);
        gp.add(cdba, 1,0);
     	vistaTablero = new VistaTablero();
        this.setCenter(vistaTablero);

     //   this.setCenter(gp);
    }
    
    private void setConsola() {
        Label etiqueta = new Label();
        etiqueta.setText("Valores de los dados\n" + "Dado uno: " + 0 + " \n" + "Dado dos: " + 0);
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }
}
