package fiuba.algo3;

import fiuba.algo3.celdas.comprables.Barrio;
import fiuba.algo3.celdas.comprables.Propiedad;
import fiuba.algo3.celdas.Salida;
import fiuba.algo3.celdas.especiales.AvanceDinamico;
import fiuba.algo3.celdas.especiales.Carcel;
import fiuba.algo3.celdas.especiales.Policia;
import fiuba.algo3.celdas.especiales.Quini6;
import fiuba.algo3.celdas.especiales.RetrocesoDinamico;

public interface Visitante {
	void visitar(Propiedad propiedad);
	void visitar(Quini6 quini6);
	void visitar(Salida salida);
	void visitar(Carcel carcel);
	void visitar(Policia policia);
	void visitar(AvanceDinamico avance);
	void visitar(RetrocesoDinamico retroceso);
}
