package ec.edu.epn.poo.lab6;
 
public class ProductoPerecible extends Producto {
    private int diasParaVencer;
    public static final int DIAS_ALERTA = 3;
    public static final double DESCUENTO_POR_VENCER = 0.30;   // 30 %

    public ProductoPerecible(String nombre, double precio, int diasParaVencer) {
        this(nombre, precio, 0, diasParaVencer);
    }

    public ProductoPerecible(String nombre, double precio, int stock,
            int diasParaVencer) {
    	super(nombre, precio, stock);        // el padre valida lo suyo
if (diasParaVencer < 0) {            // el hijo valida lo suyo
	
	throw new IllegalArgumentException(
   "Días inválidos: " + diasParaVencer);
}
this.diasParaVencer = diasParaVencer;

}

public void descartar() {
	vender(getStock());
}

public int getDiasParaVencer() {
    return diasParaVencer;
}

public boolean estaPorVencer() {
    return diasParaVencer <= DIAS_ALERTA;
}

public double calcularSubtotalConDescuento(int cantidad) {
    double subtotal = calcularSubtotal(cantidad);    // heredado
    if (estaPorVencer()) {
        return subtotal * (1 - DESCUENTO_POR_VENCER);
    }
    return subtotal;
}



}

