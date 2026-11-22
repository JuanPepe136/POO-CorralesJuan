package ec.edu.epn.poo.lab6;

public class ProductoDigital extends Producto {
    private final String codigoCanje;

    public ProductoDigital(String nombre, double precio, String codigoCanje) {
        super(nombre, precio, 0);
        this.codigoCanje = codigoCanje;
    }

    public String getCodigoCanje() {
        return codigoCanje;
    }
}
