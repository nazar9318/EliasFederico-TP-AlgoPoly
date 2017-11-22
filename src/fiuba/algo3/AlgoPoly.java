package fiuba.algo3;

import fiuba.algo3.celdas.comprables.*;
import fiuba.algo3.celdas.especiales.*;

public class AlgoPoly {

	private Tablero tablero;

	public AlgoPoly(){
		this.tablero = new Tablero();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void inicializarJuego(){
		construirTablero();
		//agregarJugadores();
	}

	private void construirTablero() {

		Barrio buenosAiresNorte = new BuenosAiresNorte();
		Barrio buenosAiresSur = new BuenosAiresSur();
		Barrio cordobaSur = new CordobaSur();
		Barrio cordobaNorte = new CordobaNorte();
		Barrio saltaNorte = new SaltaNorte();
		Barrio saltaSur = new SaltaSur();

		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);

		buenosAiresNorte.conocer(buenosAiresSur);
		buenosAiresSur.conocer(buenosAiresNorte);
		cordobaNorte.conocer(cordobaSur);
		cordobaSur.conocer(cordobaNorte);
		saltaNorte.conocer(saltaSur);
		saltaSur.conocer(saltaNorte);

		tablero.agregarCelda(new Quini6());
		tablero.agregarCelda(buenosAiresSur);
		tablero.agregarCelda(new EDESUR());
		tablero.agregarCelda(buenosAiresNorte);
		tablero.agregarCelda(carcel);
		tablero.agregarCelda(cordobaSur);
		tablero.agregarCelda(new AvanceDinamico());
		tablero.agregarCelda(new SUBTE());
		tablero.agregarCelda(cordobaNorte);
		//tablero.agregarCelda(new Impuesto());
		tablero.agregarCelda(new SantaFe());
		tablero.agregarCelda(new AYSA());
		tablero.agregarCelda(saltaNorte);
		tablero.agregarCelda(saltaSur);
		tablero.agregarCelda(policia);
		tablero.agregarCelda(new TREN());
		tablero.agregarCelda(new Neuquen());
		tablero.agregarCelda(new RetrocesoDinamico());
		tablero.agregarCelda(new Tucuman());

	}
}
