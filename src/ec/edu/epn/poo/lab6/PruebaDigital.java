package ec.edu.epn.poo.lab6;

public class PruebaDigital {
    public static void main(String[] args) {
        ProductoDigital tarjeta = new ProductoDigital("Tarjeta de regalo", 10.00, "REGALO10");
        System.out.println(tarjeta);
        System.out.println("isAgotado() = " + tarjeta.isAgotado());
        System.out.println("vender(1) = " + tarjeta.vender(1));
        System.out.println("reponer(1000) = " + tarjeta.reponer(1000));
        System.out.println("vender(1) = " + tarjeta.vender(1));
        System.out.println(tarjeta);
    }
}
