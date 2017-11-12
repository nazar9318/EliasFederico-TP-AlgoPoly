package fiuba.algo3.factory;

import fiuba.algo3.Propiedad;

public class PropiedadFactory {

    public static Propiedad getPropiedad(String nombre) {
        if (nombre.equals("Buenos Aires Norte"))
            return new Propiedad(nombre, 5000, 3000, 1000);
        else if (nombre.equals("Buenos Aires Sur"))
            return new Propiedad(nombre, 5000, 3000, 1000);
        else if(nombre.equals("Buenos Aires Centro"))
            return new Propiedad(nombre, 5000, 3000, 1000);
        return null;
    }

}
