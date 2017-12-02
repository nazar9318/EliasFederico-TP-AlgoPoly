package fiuba.algo3.modelo.Command;

import fiuba.algo3.modelo.Jugador;

public abstract class Command {

    protected String nombre;

    public abstract void execute(Jugador jugador);

    public String getNombre() {
        return nombre;
    }
}
