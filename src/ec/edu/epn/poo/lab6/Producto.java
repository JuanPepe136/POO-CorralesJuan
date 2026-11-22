package ec.edu.epn.poo.lab6;

import java.util.Locale;

public class Producto {
    public static final double IVA = 0.15;
    private static int creados = 0;

    private final String nombre;
    private double precio;
    private int stock;
    
   

    public Producto(String nombre, double precio, int stock) {
        if (precio <= 0 || stock < 0) {
            throw new IllegalArgumentException(
                    "Datos inválidos: " + precio + ", " + stock);
        }
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        creados++;
        
    }

    public Producto(String nombre, double precio) {
        this(nombre, precio, 0);
    }

    public static int getCreados() {
        return creados;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean isAgotado() {
        return stock == 0;
    }

    public boolean setPrecio(double precio) {
        if (precio <= 0) {
            return false;
        }
        this.precio = precio;
        return true;
    }

    public boolean vender(int cantidad) {
        if (cantidad <= 0 || cantidad > stock) {
            return false;
        }
        stock -= cantidad;
        return true;
    }

    public boolean reponer(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        stock += cantidad;
        return true;
    }

    public double calcularSubtotal(int cantidad) {
        return precio * cantidad;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s ($%.2f, stock %d)",
                nombre, precio, stock);
    }
}