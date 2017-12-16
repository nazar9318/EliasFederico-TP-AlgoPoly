package fiuba.algo3.vista.eventos;

import fiuba.algo3.modelo.Command.Command;
import fiuba.algo3.modelo.excepciones.BarrioSimpleNoPuedeConstruirHotelException;
import fiuba.algo3.modelo.excepciones.JugadorNoPuedeSalirDeLaCarcelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaConstruirEnTerreno;
import fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonOpcionHandler implements EventHandler<ActionEvent> {

    private Command aEjecutar;
    private Jugador jugador_;

    public BotonOpcionHandler(Command command, Jugador jugador) {
        this.aEjecutar = command;
        this.jugador_ = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
    	try{
    		this.aEjecutar.execute(this.jugador_);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de informacion");
            alert.setHeaderText("Accion realizada con exito!");
            alert.show();
            
    	}catch(JugadorNoPuedeSalirDeLaCarcelException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de informacion");
            alert.setHeaderText("No puede realizar esta accion desde la carcel!");
            alert.show();
    	}catch (JugadorNoTieneFondosParaConstruirEnTerreno e){
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de informacion");
            alert.setHeaderText("No tiene fondos para construir su edificacion!");
            alert.show();
    	}catch (BarrioSimpleNoPuedeConstruirHotelException e){
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje de informacion");
            alert.setHeaderText("No puede construir hoteles en este barrio");
            alert.show();
    	}
    	
        Node source = (Node) event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
