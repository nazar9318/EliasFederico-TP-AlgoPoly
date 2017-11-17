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

		Barrio buenosAiresNorte = new BuenosAiresNorte(25000, 2500);
		Barrio buenosAiresSur = new BuenosAiresSur(20000, 2000);
		Barrio cordobaSur = new CordobaSur(18000, 1000);
		Barrio cordobaNorte = new CordobaNorte(20000, 1300);
		Barrio saltaNorte = new SaltaNorte(23000, 2000);
		Barrio saltaSur = new SaltaSur(23000, 2000);

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
		//tablero.agregarCelda(new EDESUR());
		tablero.agregarCelda(buenosAiresNorte);
		tablero.agregarCelda(carcel);
		tablero.agregarCelda(cordobaSur);
		tablero.agregarCelda(new AvanceDinamico());
		//tablero.agregarCelda(new SUBTE());
		tablero.agregarCelda(cordobaNorte);
		//tablero.agregarCelda(new Impuesto());
		tablero.agregarCelda(new SantaFe(150000, 1500));
		//tablero.agregarCelda(new AYSA());
		tablero.agregarCelda(saltaNorte);
		tablero.agregarCelda(saltaSur);
		tablero.agregarCelda(policia);
		//tablero.agregarCelda(new TREN());
		tablero.agregarCelda(new Neuquen(17000, 1800));
		tablero.agregarCelda(new RetrocesoDinamico());
		tablero.agregarCelda(new Tucuman(25000, 2500));

	}
}
