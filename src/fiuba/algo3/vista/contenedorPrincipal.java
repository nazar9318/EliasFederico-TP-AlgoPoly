package fiuba.algo3.vista;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.vista.eventos.BotonComenzarJuegoHandler;
import fiuba.algo3.vista.eventos.BotonReiniciarHandler;
import fiuba.algo3.vista.eventos.BotonSalirHandler;
import fiuba.algo3.vista.eventos.BotonTirarDadosHandler;
import fiuba.algo3.vista.eventos.BotonVerPropiedadesHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.util.ArrayList;

public class contenedorPrincipal extends BorderPane{
	   VistaTablero vistaTablero;

    public contenedorPrincipal(AlgoPoly algo){
    	setConsola();
        setBotonera(algo);
        setCentro(algo);
        vistaTablero.actaulizarVista();

        Image imagen = new Image("file:src/fiuba/algo3/vista/imagenes/fondoInicio.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    private void setBotonera(AlgoPoly algo) {
    	
    	Button botonComenzarJuego = new Button("Comenzar Juego");
    	BotonComenzarJuegoHandler botonDeComienzo = new BotonComenzarJuegoHandler(algo);
    	botonComenzarJuego.addEventHandler(ActionEvent.ACTION, botonDeComienzo);
    	
        Button botonTirarDados = new Button("Tirar Dados");
     
        botonTirarDados.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	hacerSonar("src/fiuba/algo3/vista/sonidos/click.mp3");
                actualizarConsola("Valores de los dados:\n" + "Dado uno= " + algo.getTurno().getValorDado1() + "\n" + "Dado dos= " + algo.getTurno().getValorDado2());
            }
        });
        BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(algo.getTurno(), algo.jugadorActual(), algo.getTablero());
        botonTirarDados.addEventHandler(ActionEvent.ACTION, botonTirarDadosHandler);

        Button botonVerPropiedades = new Button("Ver Propiedades");
        BotonVerPropiedadesHandler verPropiedadesHandler = new BotonVerPropiedadesHandler(algo.getPropiedades(), algo.jugadorActual());
        botonVerPropiedades.setOnAction(verPropiedadesHandler);

        Button botonReiniciarJuego = new Button("Reiniciar Juego");
        BotonReiniciarHandler botonReiniciarHandler = new BotonReiniciarHandler(algo);
        botonReiniciarJuego.addEventFilter(ActionEvent.ACTION, botonReiniciarHandler);
        
        Button botonSalir = new Button("Salir");
        BotonSalirHandler botonSalirHandler = new BotonSalirHandler();
        botonSalir.addEventHandler(ActionEvent.ACTION, botonSalirHandler);
        
        VBox contenedorVertical = new VBox(botonComenzarJuego, botonTirarDados, botonVerPropiedades, botonReiniciarJuego, botonSalir);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
    }

	private void actualizarConsola(String texto) {
        vistaTablero.actaulizarVista();
        Label etiqueta = new Label();
        etiqueta.setText(texto);
        etiqueta.setFont(Font.font("cooper black", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);
        etiqueta.setEffect(new Lighting());

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: red;");
        
        hacerSonar("src/fiuba/algo3/vista/sonidos/consola.mp3");

        this.setBottom(contenedorConsola);		
	}

	private void setCentro(AlgoPoly algo){

     	vistaTablero = new VistaTablero(algo);
        this.setCenter(vistaTablero);

    }
    
    private void setConsola() {
        Label etiqueta = new Label();
        etiqueta.setText("Comencemos el juego!");
        etiqueta.setFont(Font.font("cooper black", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);
        etiqueta.setEffect(new Lighting());

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: red;");

        this.setBottom(contenedorConsola);
    }
    
    private void hacerSonar(String ruta) {
        Media sonidoClick = new Media(new File(ruta).toURI().toString());
        MediaPlayer consolaSonido = new MediaPlayer(sonidoClick);
		consolaSonido.play();
    }
}
