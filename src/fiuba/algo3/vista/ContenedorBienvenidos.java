package fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

import fiuba.algo3.vista.eventos.BotonEntrarEventHandler;

public class ContenedorBienvenidos extends VBox {

	 Stage stage;

	    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

	        super();

	        this.stage = stage;

	        this.setAlignment(Pos.CENTER);
	        this.setSpacing(20);
	        this.setPadding(new Insets(25));
	        Image imagen = new Image("file:src/fiuba/algo3/vista/imagenes/fondoInicio.jpg");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        this.setBackground(new Background(imagenDeFondo));

	        Glow glow = new Glow();
	        glow.setLevel(0.9);
	        
	        Button botonEntrar = new Button();
	        botonEntrar.setText("Entrar");
	        botonEntrar.setTextFill(Color.ORANGERED);
	        botonEntrar.setFont(Font.font("cooper black", FontWeight.BLACK, 16));
	        botonEntrar.setStyle("-fx-background-color: white;");

	        Label etiqueta = new Label();

	        etiqueta.setText("Bienvenidos a AlgoPoly");
	        etiqueta.setTextFill(Color.WHITE);
	        etiqueta.setEffect(glow);
	        etiqueta.setFont(Font.font("cooper black", FontWeight.BLACK, 75));
	        etiqueta.setStyle("-fx-background-color: transparent;");

	        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
	        botonEntrar.setOnAction(botonEntrarHandler);

	        this.getChildren().addAll(etiqueta, botonEntrar);
	    }


}
