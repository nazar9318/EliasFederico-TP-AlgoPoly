package fiuba.algo3.vista.eventos;


import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public abstract class BotonConSonido {
	 
	protected MediaPlayer sonido;
	
	public BotonConSonido() {
		String sound = "src/fiuba/algo3/vista/sonidos/click.mp3";
        Media sonidoClick = new Media(new File(sound).toURI().toString());
        this.sonido = new MediaPlayer(sonidoClick);
		
	}

}
