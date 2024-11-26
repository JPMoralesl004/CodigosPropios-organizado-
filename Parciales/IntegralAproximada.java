import java.util.Scanner;

public class IntegralAproximada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir;

        do {
            double a, b;
            boolean datosValidos;

            do {
                System.out.println("Introduce el valor del límite inferior (a): ");
                a = scanner.nextDouble();
                System.out.println("Introduce el valor del límite superior (b): ");
                b = scanner.nextDouble();

                if (a >= b) {
                    System.out.println("Datos inválidos. Asegúrate de que a < b.\n");
                    datosValidos = false;
                } else {
                    datosValidos = true;
                }

            } while (!datosValidos);

            int n = 1000;
            double ancho = (b - a) / n;
            double suma = 0.0;

            for (int i = 0; i < n; i++) {
                double x = a + i * ancho;
                double altura = calcularFuncion(x);
                suma += altura * ancho;
            }

            System.out.println("La integral aproximada entre " + a + " y " + b + " es: " + suma);

            System.out.println("\n¿Quieres realizar otro cálculo? (sí (S) / no (N)): ");
            String respuesta = scanner.next();
            repetir = respuesta.equalsIgnoreCase("S");

        } while (repetir);

        System.out.println("¡Gracias por usar el programa!");
        scanner.close();
    }

    public static double calcularFuncion(double x) {
        double parte1 = 5 * Math.sin(x / 1.59);
        double parte2 = 0.33 * Math.sin(3 * x / 1.59);
        double parte3 = 0.2 * Math.sin(5 * x / 1.59);
        return parte1 + parte2 + parte3;
    }
}