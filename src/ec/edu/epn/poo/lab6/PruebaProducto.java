package ec.edu.epn.poo.lab6;

public class PruebaProducto {
    static int ok = 0;
    static int fallas = 0;

    static void verificar(String caso, boolean condicion) {
        if (condicion) {
            ok++;
            System.out.println("OK     " + caso);
        } else {
            fallas++;
            System.out.println("FALLA  " + caso);
        }
    }

    public static void main(String[] args) {
        Producto c = new Producto("Cuaderno", 2.50, 10);

        verificar("1. vender(3) devuelve true", c.vender(3));
        verificar("2. el stock baja a 7", c.getStock() == 7);
        verificar("3. vender(99) devuelve false", !c.vender(99));
        verificar("4. un pedido rechazado no cambia el stock",
                c.getStock() == 7);

        verificar("5. vender(0) devuelve false", !c.vender(0));
        verificar("6. vender(-2) devuelve false", !c.vender(-2));

        verificar("7. setPrecio(-1) devuelve false", !c.setPrecio(-1));
        verificar("8. el precio sigue en 2.50",
                Math.abs(c.getPrecio() - 2.50) < 1e-9);

        Producto r = new Producto("Regla", 1.20);
        verificar("9. la regla nace con stock 0", r.getStock() == 0);
        verificar("10. la regla está agotada", r.isAgotado());

        boolean lanzo = false;
        try {
            new Producto("Lápiz", 0.30, -5);
        } catch (IllegalArgumentException e) {
            lanzo = true;
        }
        verificar("11. stock negativo en el constructor lanza excepción",
                lanzo);

        System.out.printf("%n%d OK · %d FALLA%n", ok, fallas);
    }
}