package ec.edu.epn.poo.lab6;

public class PruebaPerecible {
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
        int antes = Producto.getCreados();
        ProductoPerecible y = new ProductoPerecible("Yogur", 1.20, 8, 2);
        ProductoPerecible q = new ProductoPerecible("Queso", 4.50, 5, 10);

        verificar("1. el yogur hereda vender(3)", y.vender(3));
        verificar("2. el stock del yogur baja a 5", y.getStock() == 5);
        verificar("3. vender(99) devuelve false (regla del padre)",
                !y.vender(99));

        // TODO 1: casos 4 y 5
        verificar("4. el yogur está por vencer", y.estaPorVencer());
        verificar("5. el queso no está por vencer", !q.estaPorVencer());

        // TODO 2: casos 6 y 7
        verificar("6. 2 yogures con descuento = 1.68",
                Math.abs(y.calcularSubtotalConDescuento(2) - 1.68) < 1e-9);
        verificar("7. 2 quesos sin descuento = 9.00",
                Math.abs(q.calcularSubtotalConDescuento(2) - 9.00) < 1e-9);

        // TODO 3: caso 8
        boolean lanzo = false;
        try {
            new ProductoPerecible("Leche", 0.90, 10, -1);
        } catch (IllegalArgumentException e) {
            lanzo = true;
        }
        verificar("8. días negativos lanzan excepción", lanzo);

        // TODO 4: caso 9
        boolean lanzoPadre = false;
        try {
            new ProductoPerecible("Leche", 0.90, -5, 3);
        } catch (IllegalArgumentException e) {
            lanzoPadre = true;
        }
        verificar("9. stock negativo lanza excepción (valida Producto)",
                lanzoPadre);

        verificar("10. getCreados() sumó 3 (yogur, queso y la leche del caso 8)",
                Producto.getCreados() == antes + 3);

        System.out.printf("%n%d OK · %d FALLA%n", ok, fallas);
    }
}