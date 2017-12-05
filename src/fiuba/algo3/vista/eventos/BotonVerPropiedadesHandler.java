package fiuba.algo3.vista.eventos;

import fiuba.algo3.AlgoPoly;
import fiuba.algo3.modelo.ArrayPropiedad;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.vista.BotonPropiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;


public class BotonVerPropiedadesHandler extends BotonConSonido implements EventHandler<ActionEvent>{

    private ArrayPropiedad propiedades_;
    private Jugador jugador_;
    private HashMap<String, BotonPropiedad> botones_;
    private AlgoPoly juego_;

    public BotonVerPropiedadesHandler(AlgoPoly algo){
        this.juego_ = algo;
        this.propiedades_ = algo.getPropiedades();
        this.jugador_ = algo.jugadorActual();
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
        BotonPropiedad botonEDESUR = new BotonPropiedad(propiedades_.buscar("EDESUR"));
        BotonPropiedad botonAYSA = new BotonPropiedad(propiedades_.buscar("AYSA"));
        BotonPropiedad botonSUBTE = new BotonPropiedad(propiedades_.buscar("SUBTE"));
        BotonPropiedad botonTREN = new BotonPropiedad(propiedades_.buscar("TREN"));

        botones_.put(botonBuenosAiresSur.getPropiedad_().getNombre(), botonBuenosAiresSur);
        botones_.put(botonBuenosAiresNorte.getPropiedad_().getNombre(), botonBuenosAiresNorte);
        botones_.put(botonCordobaSur.getPropiedad_().getNombre(), botonCordobaSur);
        botones_.put(botonCordobaNorte.getPropiedad_().getNombre(), botonCordobaNorte);
        botones_.put(botonSaltaSur.getPropiedad_().getNombre(), botonSaltaSur);
        botones_.put(botonSaltaNorte.getPropiedad_().getNombre(), botonSaltaNorte);
        botones_.put(botonSantaFe.getPropiedad_().getNombre(), botonSantaFe);
        botones_.put(botonTucuman.getPropiedad_().getNombre(), botonTucuman);
        botones_.put(botonNeuquen.getPropiedad_().getNombre(), botonNeuquen);
        botones_.put(botonEDESUR.getPropiedad_().getNombre(), botonEDESUR);
        botones_.put(botonAYSA.getPropiedad_().getNombre(), botonAYSA);
        botones_.put(botonSUBTE.getPropiedad_().getNombre(), botonSUBTE);
        botones_.put(botonTREN.getPropiedad_().getNombre(), botonTREN);

    }

    @Override
    public void handle(ActionEvent event) {
    	super.sonido.play();

        this.jugador_ = juego_.jugadorActual();
    	crearHandlerParaCadaPropiedad();

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);

        agregarBotonesDePropiedadesA(buttonBox);

        Stage newStage = new Stage();
        Scene stageScene = new Scene(buttonBox, 500, 100);
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

        BotonPropiedadHandler edesurHandler = new BotonPropiedadHandler(propiedades_.buscar("EDESUR"), jugador_);
        botones_.get("EDESUR").setOnAction(edesurHandler);

        BotonPropiedadHandler aysaHandler = new BotonPropiedadHandler(propiedades_.buscar("AYSA"), jugador_);
        botones_.get("AYSA").setOnAction(aysaHandler);

        BotonPropiedadHandler subteHandler = new BotonPropiedadHandler(propiedades_.buscar("SUBTE"), jugador_);
        botones_.get("SUBTE").setOnAction(subteHandler);

        BotonPropiedadHandler trenHandler = new BotonPropiedadHandler(propiedades_.buscar("TREN"), jugador_);
        botones_.get("TREN").setOnAction(trenHandler);
    }

	private void agregarBotonesDePropiedadesA(HBox buttonBox){
        for(int i = 0; i < jugador_.getCantidadDePropiedades(); i++)
            buttonBox.getChildren().add(botones_.get(jugador_.getPropiedades().get(i).getNombre()));

    }
}
