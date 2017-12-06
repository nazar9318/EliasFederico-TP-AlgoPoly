package fiuba.algo3.modelo.celdas.comprables;

import java.util.ArrayList;
import java.util.Optional;

import fiuba.algo3.modelo.Command.Construir;
import fiuba.algo3.modelo.Command.Respuesta;
import fiuba.algo3.modelo.Command.Vender;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.celdas.Casa;
import fiuba.algo3.modelo.celdas.Hotel;
import fiuba.algo3.modelo.celdas.Visitable;
import fiuba.algo3.modelo.excepciones.BarrioSimpleNoPuedeConstruirHotelException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneFondosParaPagarException;
import fiuba.algo3.modelo.excepciones.JugadorPerdioException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public abstract class Barrio extends Propiedad implements Visitable {
    int maxCasas;
    int maxHoteles;
    ArrayList<Casa> casas;
    ArrayList<Hotel> hoteles;
    int alquiler1;
    int alquiler2;
    int precioCasa;
    int precioHotel;
    int alquilerHotel;
    
	protected Barrio(int precioTerreno, int alquiler, String nombre, int precioCasa, int precioHotel) {
		super(precioTerreno, alquiler, nombre);
		this.precioCasa = precioCasa;
		this.precioHotel = precioHotel;
		this.casas = new ArrayList<Casa>(); 
		this.hoteles = new ArrayList<Hotel>(); 
	}

	@Override
	public void cobrarAlquiler(Jugador jugador) {
		try {
			jugador.pagar(getAlquiler() + this.getAlquilerDeEdificaciones() + this.getAlquilerHotel());
		}catch(JugadorNoTieneFondosParaPagarException e){
			if(jugador.getCantidadDePropiedades() == 0)
				throw new JugadorPerdioException();
			else
				super.hacerVenderParaCubrirAlquiler(jugador);
				this.cobrarAlquiler(jugador);
		}
		this.duenio.cobrar(getAlquiler() + this.getAlquilerDeEdificaciones() + this.getAlquilerHotel());
	}

	private int getAlquilerHotel() {
		int alquilerHotel = 0;
		for(int i = 0; i < hoteles.size(); i++)
			alquilerHotel += hoteles.get(i).getAlquiler();
		return alquilerHotel;
	}

	private int getAlquilerDeEdificaciones() {
		int alquiler = 0;
		for(int i = 0; i < casas.size(); i++)
			alquiler += casas.get(i).getAlquiler();
		return alquiler;
	}
	
	public int getAlquilerActual() {
		return alquiler + getAlquilerDeEdificaciones() + getAlquilerHotel();
	}

	public int cantidadCasas() {
		return casas.size();
	}

	public int cantidadHoteles() {
		return hoteles.size();
	}

	@Override
	public void vender() {
		duenio.cobrar(super.getPrecioDeVenta());
		casas.clear();
		hoteles.clear();
		if(this.getCeldaAsociada() != null)
			((Barrio) this.getCeldaAsociada()).hoteles.clear();
		duenio.removerPropiedad(this);
		this.duenio = null;
	}
	
	public int getPrecioCasa() {
		return precioCasa;
	}
	
	public int getPrecioHotel() {
		return precioHotel;
	}
	
	private boolean puedeConstruirCasa(){
		return (maxCasas >= casas.size() + 1) && (hoteles.size() == 0);
	}
	
	private void construirCasa(Jugador jugador){
		Casa casa = null;
		if(casas.size() == 0){
			casa = new Casa(alquiler1);
		}else {
			casa = new Casa(alquiler2);
		}
		casas.add(casa);
		jugador.pagar(precioCasa);
	}
	
	private boolean barrioAsociadoTieneTodasLasCasasConstruidas(){
		return (((Barrio) this.getCeldaAsociada()).cantidadCasas() == this.getMaxCasas());
	}
	
	private boolean barrioAsociadoTieneTodosLosHotelesConstruidos(){
		return (((Barrio) this.getCeldaAsociada()).cantidadHoteles() == maxHoteles);
	}
	
	private boolean tengoEspacioParaHotel(){
		return (maxCasas < casas.size() + 1) && (maxHoteles >= hoteles.size() + 1);
	}
	
	private int getMaxCasas() {
		return maxCasas;
	}

	private void construirHotel(Jugador jugador){
		Hotel hotel = new Hotel(alquilerHotel);
		casas.clear();
		hoteles.add(hotel);
		jugador.pagar(precioHotel);
	}

	private boolean puedeConstruirHotel() {
		return this.tengoEspacioParaHotel() && this.barrioAsociadoCumpleCondicionesParaConstruiHotel();
	}
	
	private boolean barrioAsociadoCumpleCondicionesParaConstruiHotel(){
		return this.barrioAsociadoTieneTodosLosHotelesConstruidos()||this.barrioAsociadoTieneTodasLasCasasConstruidas();
	}

	public void construir(Jugador jugador) {
		if ((jugador.poseeALaAsociadaDe(this)) ) {
			if(this.puedeConstruirHotel()){
				this.construirHotel(jugador);
			}
			else if (this.puedeConstruirCasa()){
				this.construirCasa(jugador);
			}
			else if (this.getCeldaAsociada() == null) {
				throw new BarrioSimpleNoPuedeConstruirHotelException();
			}
		}
	}

	@Override
	public Respuesta getOpciones(Jugador jugador){
		Respuesta opciones = new Respuesta();

		opciones.agregarOpcion(new Vender(this));
		if(jugador.poseeALaAsociadaDe(this))
			opciones.agregarOpcion(new Construir(this));

		return opciones;
	}	
}