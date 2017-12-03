package fiuba.algo3.vista;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class VistaCelda extends VBox {
	Label label;
	FlowPane jugadores;
	FlowPane contenidoCelda;
protected VistaCelda() {

	jugadores = new FlowPane();
	jugadores.setAlignment(Pos.CENTER);
	jugadores.setHgap(4);
	
	 label =  new Label(" ");
 
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
	this.getChildren().add(label);
	this.getChildren().add(jugadores);
	this.setMinSize(140 ,80);
	this.setMaxSize(140 ,80);

	this.label.setMaxSize(140 ,80);
	}
	

public void agregarJugador(VistaJugador jugador) {
	ImageView imagen =new ImageView( jugador.getVista());
	imagen.maxHeight(20);
	imagen.maxWidth(20); 
	jugadores.getChildren().add(imagen);

}
public void modificarLabel(String texto) {
    label.setText(texto);
}

public void setCSSStyle(String string) {
	this.setStyle(string);
}

public void removerUltimocontenido() {
	contenidoCelda.getChildren().remove(contenidoCelda.getChildren().size()-1);
}

}
