package fiuba.algo3.vista.eventos;

import fiuba.algo3.modelo.Command.Command;
import fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonOpcionHandler extends BotonConSonido implements EventHandler<ActionEvent> {

    private Command aEjecutar;
    private Jugador jugador_;

    public BotonOpcionHandler(Command command, Jugador jugador) {
        this.aEjecutar = command;
        this.jugador_ = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
    	super.sonido.play();
        this.aEjecutar.execute(this.jugador_);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje de informacion");
        alert.setHeaderText("Accion realizada con exito!");
        alert.show();

        Node source = (Node) event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
