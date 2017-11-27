package fiuba.algo3.Command;

import fiuba.algo3.Jugador;

public class Invoker {

    private Command command_;

    public void setCommand(Command command){
        this.command_ = command;
    }

    public void executeCommand(Jugador jugador){
        this.command_.execute(jugador);
    }
}
