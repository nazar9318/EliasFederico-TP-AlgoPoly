package fiuba.algo3;

import java.util.HashMap;


public class CeldaQuini6 implements Celda {
	
	private HashMap<Jugador, Object> jugadores = new HashMap<>(); 
		
	@Override
	public void recibirJugador(Jugador unJugador) {
		if (!this.jugadores.containsKey(unJugador)){
			jugadores.put(unJugador, 1);
			unJugador.cobrar(50000);
		}else if (this.jugadores.containsValue(1)){
			this.jugadores.put(unJugador, 2);
			unJugador.cobrar(30000);
		}else if (this.jugadores.containsValue(2)){
			unJugador.cobrar(0);
		}
	}

}
