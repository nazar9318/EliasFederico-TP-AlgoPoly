package fiuba.algo3.vista.eventos;

import fiuba.algo3.modelo.ArrayPropiedad;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.vista.BotonPropiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;


public class BotonVerPropiedadesHandler implements EventHandler<ActionEvent>{

    private ArrayPropiedad propiedades_;
    private Jugador jugador_;
    private HashMap<String, BotonPropiedad> botones_;

    public BotonVerPropiedadesHandler(ArrayPropiedad propiedades, Jugador jugador){
        this.propiedades_ = propiedades;
        this.jugador_ = jugador;
        this.botones_ = new HashMap<>();
        crearBotones();
    }

    private void crearBotones() {
        BotonPropiedad botonBuenosAiresSur = new BotonPropiedad(propiedades_.buscar("BuenosAiresSur"));
        BotonPropiedad botonBuenosAiresNorte = new BotonPropiedad(propiedades_.buscar("BuenosAiresNorte"));
        BotonPropiedad botonCordobaSur = new BotonPropiedad(propiedades_.buscar("CordobaSur"));
        BotonPropiedad botonCordobaNorte = new BotonPropiedad(propiedades_.buscar("CordobaNorte"));
        BotonPropiedad botonSaltaSur = new BotonPropiedad(propiedades_.buscar("SaltaSur"));
        BotonPropiedad botonSaltaNorte = new BotonPropiedad(propiedades_.buscar("SaltaNorte"));
        BotonPropiedad botonSantaFe = new BotonPropiedad(propiedades_.buscar("SantaFe"));
        BotonPropiedad botonTucuman = new BotonPropiedad(propiedades_.buscar("Tucuman"));
        BotonPropiedad botonNeuquen = new BotonPropiedad(propiedades_.buscar("Neuquen"));
        
        botones_.put(botonBuenosAiresSur.getPropiedad_().getNombre(), botonBuenosAiresSur);
        botones_.put(botonBuenosAiresNorte.getPropiedad_().getNombre(), botonBuenosAiresNorte);
        botones_.put(botonCordobaSur.getPropiedad_().getNombre(), botonCordobaSur);
        botones_.put(botonCordobaNorte.getPropiedad_().getNombre(), botonCordobaNorte);
        botones_.put(botonSaltaSur.getPropiedad_().getNombre(), botonSaltaSur);
        botones_.put(botonSaltaNorte.getPropiedad_().getNombre(), botonSaltaNorte);
        botones_.put(botonSantaFe.getPropiedad_().getNombre(), botonSantaFe);
        botones_.put(botonTucuman.getPropiedad_().getNombre(), botonTucuman);
        botones_.put(botonNeuquen.getPropiedad_().getNombre(), botonNeuquen);

        //TODO: crear un boton por propiedad y meterlo en botones_ en w metodos privados para que sea menos feo
//No se que harcodeada es mas fea, si la que esta ahora o sacar la calse BotonPropiedad y poner lo de abajo

//          Button botonBuenosAiresSur = new Button("BuenosAiresSur");
//          Button botonBuenosAiresNorte = new Button("BuenosAiresNorte");
//          Button botonCordobaSur = new Button("CordobaSur");
//
//          botones_.put("BuenosAiresSur", botonBuenosAiresSur);
//          botones_.put("BuenosAiresNorte", botonBuenosAiresNorte);
//          botones_.put("CordobaSur", botonCordobaSur);

    }

    @Override
    public void handle(ActionEvent event) {
    	this.crearHandlerParaCadaPropiedad();
        //TODO: handler para todas las propiedades en metodo privado para que sea menos feo

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);

        agregarBotonesDePropiedadesA(buttonBox);

        Stage newStage = new Stage();
        Scene stageScene = new Scene(buttonBox, 300, 300);
        newStage.setScene(stageScene);
        newStage.setTitle("Propiedades");
        newStage.show();
    }

    private void crearHandlerParaCadaPropiedad() {
    	BotonPropiedadHandler buenosAiresSurHandler = new BotonPropiedadHandler(propiedades_.buscar("BuenosAiresSur"), jugador_);
        botones_.get("BuenosAiresSur").setOnAction(buenosAiresSurHandler);

        BotonPropiedadHandler buenosAiresNorteHandler = new BotonPropiedadHandler(propiedades_.buscar("BuenosAiresNorte"), jugador_);
        botones_.get("BuenosAiresNorte").setOnAction(buenosAiresNorteHandler);
        
        BotonPropiedadHandler cordobaSurHandler = new BotonPropiedadHandler(propiedades_.buscar("CordobaSur"), jugador_);
        botones_.get("CordobaSur").setOnAction(cordobaSurHandler);
        
        BotonPropiedadHandler cordobaNorteHandler = new BotonPropiedadHandler(propiedades_.buscar("CordobaNorte"), jugador_);
        botones_.get("CordobaNorte").setOnAction(cordobaNorteHandler);
        
        BotonPropiedadHandler saltaSurHandler = new BotonPropiedadHandler(propiedades_.buscar("SaltaSur"), jugador_);
        botones_.get("SaltaSur").setOnAction(saltaSurHandler);
        
        BotonPropiedadHandler saltaNorteHandler = new BotonPropiedadHandler(propiedades_.buscar("SaltaNorte"), jugador_);
        botones_.get("SaltaNorte").setOnAction(saltaNorteHandler);
        
        BotonPropiedadHandler santaFeHandler = new BotonPropiedadHandler(propiedades_.buscar("SantaFe"), jugador_);
        botones_.get("SantaFe").setOnAction(santaFeHandler);
        
        BotonPropiedadHandler tucumanHandler = new BotonPropiedadHandler(propiedades_.buscar("Tucuman"), jugador_);
        botones_.get("Tucuman").setOnAction(tucumanHandler);
        
        BotonPropiedadHandler neuquenHandler = new BotonPropiedadHandler(propiedades_.buscar("Neuquen"), jugador_);
        botones_.get("Neuquen").setOnAction(neuquenHandler);
	}

	private void agregarBotonesDePropiedadesA(HBox buttonBox){
        for(int i = 0; i < jugador_.getCantidadDePropiedades(); i++)
            buttonBox.getChildren().add(botones_.get(jugador_.getPropiedades().get(i).getNombre()));

    }
}
