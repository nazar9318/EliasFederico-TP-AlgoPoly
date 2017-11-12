package fiuba.algo3.factory;

import fiuba.algo3.Propiedad;

public class PropiedadFactory {

    public static Propiedad getPropiedad(String nombre) {
        if (nombre.equals("Buenos Aires Norte"))
            return new Propiedad(nombre, 25000, 5500, 2500);
        else if (nombre.equals("Buenos Aires Sur"))
            return new Propiedad(nombre, 20000, 5000, 2000);
        return null;
    }

}
