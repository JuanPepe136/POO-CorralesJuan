package ec.edu.epn.poo.lab6;

import java.util.Locale;
import java.util.Scanner;

public class CajaRegistradora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto[] catalogo = {
            new Producto("Cuaderno", 2.50, 10),
            new Producto("Esfero", 0.75, 50),
            new Producto("Borrador", 0.40, 30),
            new Producto("Regla", 1.20),
            new Producto("Carpeta", 3.10, 8),
            new ProductoPerecible("Yogur", 1.20, 8, 2)
        };

        int[] carrito = new int[catalogo.length];
        System.out.println("Catálogo cargado: " + Producto.getCreados()
                + " productos");

        int opcion;
        do {
            System.out.println("\n=== CAJA REGISTRADORA ===");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar producto");
            System.out.println("3. Ver recibo");
            System.out.println("0. Salir");
            opcion = leerEntero(sc, "Opción: ");

            switch (opcion) {
                case 1:
                    mostrarCatalogo(catalogo);
                    break;

                case 2:
                    int codigo = leerEntero(sc,
                            "Código (1 a " + catalogo.length + "): ");
                    if (codigo < 1 || codigo > catalogo.length) {
                        System.out.println("Código inválido.");
                        break;
                    }
                    int k = codigo - 1;
                    Producto p = catalogo[k];
                    int cantidad = leerEntero(sc, "Cantidad: ");

                    if (p.vender(cantidad)) {
                        carrito[k] += cantidad;
                        System.out.println("Agregado: " + cantidad
                                + " x " + p.getNombre());
                    } else {
                        System.out.println("Stock insuficiente (disponible: "
                                + p.getStock() + ")");
                    }
                    break;

                case 3:
                    System.out.println("------------ RECIBO ------------");
                    double subtotal = 0;
                    for (int i = 0; i < catalogo.length; i++) {
                        if (carrito[i] > 0) {
                            Producto prod = catalogo[i];
                            double linea;
                            if (prod instanceof ProductoPerecible pp) {
                                linea = pp.calcularSubtotalConDescuento(carrito[i]);
                            } else {
                                linea = prod.calcularSubtotal(carrito[i]);
                            }
                            subtotal += linea;
                            System.out.printf(Locale.US,
                                    "%-12s %2d x %5.2f %10.2f%n",
                                    prod.getNombre(), carrito[i],
                                    prod.getPrecio(), linea);
                        }
                    }
                    double descuento = 0.0;
                    double iva = subtotal * Producto.IVA;
                    double total = subtotal + iva;
                    System.out.println("--------------------------------");
                    System.out.printf(Locale.US, "%-20s %11.2f%n",
                            "Subtotal", subtotal);
                    System.out.printf(Locale.US, "%-20s %11.2f%n",
                            "Descuento", descuento);
                    System.out.printf(Locale.US, "%-20s %11.2f%n",
                            String.format(Locale.US, "IVA %.0f %%",
                                    Producto.IVA * 100),
                            iva);
                    System.out.printf(Locale.US, "%-20s %11.2f%n",
                            "TOTAL", total);
                    break;

                case 0:
                    System.out.println("Gracias por su compra.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("No es un entero. " + mensaje);
        }
        return sc.nextInt();
    }

    private static void mostrarCatalogo(Producto[] catalogo) {
        System.out.printf("%-4s %-12s %6s %7s%n",
                "Cód", "Producto", "Precio", "Stock");
        for (int i = 0; i < catalogo.length; i++) {
            Producto p = catalogo[i];
            System.out.printf(Locale.US, "%-4d %-12s %6.2f %7d%n",
                    i + 1, p.getNombre(), p.getPrecio(), p.getStock());
        }
    }
}