package fiuba.algo3;

public class Propiedad {

    private String nombre;

    private int precio;

    private int precioCasa;

    private int casas = 0;

    private int precioAlquiler;

    public Propiedad(String nombre, int precio, int precioCasa, int precioAlquiler) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioCasa = precioCasa;
        this.precioAlquiler = precioAlquiler;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPrecioCasa() {
        return precioCasa;
    }

    public int getCasas() {
        return casas;
    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }
}
