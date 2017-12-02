package fiuba.algo3.vista.eventos;

import fiuba.algo3.modelo.Command.Respuesta;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class BotonPropiedadHandler implements EventHandler<ActionEvent> {

    private Propiedad propiedad_;
    private Jugador jugador_;
    private HashMap<String, Button> botones_;

    public BotonPropiedadHandler(Propiedad propiedad, Jugador jugador){
        this.propiedad_ = propiedad;
        this.jugador_ = jugador;
        this.botones_ = new HashMap<>();
        crearBotonesDeOpciones();
    }

    @Override
    public void handle(ActionEvent event) {
        Respuesta opciones = propiedad_.getOpciones(jugador_);

        BotonOpcionHandler botonVenderHandler = new BotonOpcionHandler(opciones.getAccion("Vender"), jugador_);
        botones_.get("Vender").setOnAction(botonVenderHandler);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        buttonBox.getChildren().add(botones_.get("Vender"));

        agregarOpcionConstruir(opciones, buttonBox);

        Stage newStage = new Stage();
        Scene stageScene = new Scene(buttonBox, 300, 300);
        newStage.setScene(stageScene);
        newStage.setTitle("Opciones de Propiedad");
        newStage.show();

        Node source = (Node) event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void agregarOpcionConstruir(Respuesta opciones, HBox buttonBox) {
        if(opciones.getAccion("Construir") != null){
            BotonOpcionHandler botonConstruirHandler = new BotonOpcionHandler(opciones.getAccion("Construir"), jugador_);
            botones_.get("Construir").setOnAction(botonConstruirHandler);
            buttonBox.getChildren().add(botones_.get("Construir"));
        }

    }

    private void crearBotonesDeOpciones() {
        Button botonOpcionVender = new Button("Vender");
        Button botonOpcionConstruir = new Button("Construir");

        botones_.put("Vender", botonOpcionVender);
        botones_.put("Construir", botonOpcionConstruir);
    }
}

