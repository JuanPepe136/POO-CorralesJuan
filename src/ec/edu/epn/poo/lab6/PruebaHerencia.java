package ec.edu.epn.poo.lab6;
 
public class PruebaHerencia {
    public static void main(String[] args) {
        ProductoPerecible y = new ProductoPerecible("Yogur", 1.20, 8, 2);
        ProductoPerecible y1 = new ProductoPerecible("Leche", 0.90, 5);
   
        System.out.println(y.vender(3));            // heredado
        System.out.println(y.getStock());           // heredado
        System.out.println(y);                      // toString() heredado
        System.out.println(Producto.getCreados());  // static compartido
        y.descartar(); 
        System.out.println(y.getStock());
        System.out.println(y1); 
        System.out.println(y.estaPorVencer()); 
        System.out.println(y.calcularSubtotal(2)); 
        System.out.println(y.calcularSubtotalConDescuento(2));
        
        
    }
}
