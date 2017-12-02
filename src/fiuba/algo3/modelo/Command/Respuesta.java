package fiuba.algo3.modelo.Command;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Command> accionesPosibles;

    public Respuesta(){
        this.accionesPosibles = new ArrayList<>();
    }

    public ArrayList<Command> getAccionesPosibles() {
        return accionesPosibles;
    }

    public void agregarOpcion(Command command) {
        this.accionesPosibles.add(command);
    }

    public void mostrarAcciones() {
        for(int i = 0; i < this.accionesPosibles.size(); i++)
            System.out.println(this.accionesPosibles.get(i).getNombre());
    }

    public Command getAccion(String accion) {
        for(int i = 0; i < this.accionesPosibles.size(); i++)
            if(this.accionesPosibles.get(i).getNombre().equals(accion))
                return this.accionesPosibles.get(i);
        return null;    //excepcion? va a depender de los botones, nunca va a bsucar algo que no existe
    }
}

