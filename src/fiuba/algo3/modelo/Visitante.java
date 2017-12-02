package fiuba.algo3.modelo;

import fiuba.algo3.modelo.celdas.comprables.Propiedad;
import fiuba.algo3.modelo.celdas.Salida;
import fiuba.algo3.modelo.celdas.especiales.AvanceDinamico;
import fiuba.algo3.modelo.celdas.especiales.Carcel;
import fiuba.algo3.modelo.celdas.especiales.Policia;
import fiuba.algo3.modelo.celdas.especiales.Quini6;
import fiuba.algo3.modelo.celdas.especiales.RetrocesoDinamico;

public interface Visitante {
	void visitar(Propiedad propiedad);
	void visitar(Quini6 quini6);
	void visitar(Salida salida);
	void visitar(Carcel carcel);
	void visitar(Policia policia);
	void visitar(AvanceDinamico avance);
	void visitar(RetrocesoDinamico retroceso);
}
