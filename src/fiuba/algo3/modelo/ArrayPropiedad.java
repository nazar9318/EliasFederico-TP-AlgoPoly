package fiuba.algo3.modelo;

import fiuba.algo3.modelo.celdas.comprables.Propiedad;

import java.util.ArrayList;

public class ArrayPropiedad extends ArrayList<Propiedad> {

    public Propiedad buscar(String nombre){
        for(int i = 0; i < this.size(); i++)
            if(this.get(i).getNombre().equals(nombre))
                return this.get(i);
        return null; //excepcion?
    }
}
