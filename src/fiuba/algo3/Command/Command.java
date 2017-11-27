package fiuba.algo3.Command;

import fiuba.algo3.Jugador;

public abstract class Command {

    protected String nombre;

    public abstract void execute(Jugador jugador);

    public String getNombre() {
        return nombre;
    }
}
