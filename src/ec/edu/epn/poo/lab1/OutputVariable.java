/**
 * 
 */
package ec.edu.epn.poo.lab1;

/**
 * 
 */
import java.text.*;
import java.util.Locale;
import java.util.Scanner;

public class OutputVariable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long numero = 123098;
        double pi = Math.PI;
        String status = "";
        int grade = 8;

        System.out.printf("%d %n", numero);
        System.out.printf("%08d %n", numero);
        System.out.printf("%+d %n", numero);

        Locale.setDefault(Locale.US); // Use the US format to print out numbers
        DecimalFormat formato1 = new DecimalFormat("###,###.##");
        String valorFormateado1 = formato1.format(numero);
        System.out.printf("%s %n", valorFormateado1);

        
        System.out.printf("%+,d %n", numero);

        System.out.printf("%f %n", pi);

        System.out.printf("%.3f %n", pi);

        System.out.printf("%14.3f %n", pi);

        System.out.printf("%.4f %n", pi);

        System.out.printf(Locale.FRANCE, "%.4f %n", pi);
 
        // First part
        System.out.println("Manejo de operador condicional");
        
        status = (grade >= 7) ? "Passed" : "Fail";
        System.out.println("Status calculado: " + status);

        // Crear objeto para leer desde el teclado
        Scanner teclado = new Scanner(System.in);

        // Leer status desde el teclado
        System.out.print("Ingrese el estado del estudiante: ");
        status = teclado.nextLine();

        // Print status
        System.out.println(status);

        teclado.close();
    }
}
