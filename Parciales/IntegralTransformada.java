import java.util.Scanner;

public class IntegralTransformada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Introduce el valor de b: ");
        double b = scanner.nextDouble();

        System.out.print("Introduce el número de rectángulos para la aproximación: ");
        int numRectangulos = scanner.nextInt();

        double integral = calcularIntegral(a, b, numRectangulos);

        System.out.println("La integral aproximada es: " + integral);

        scanner.close();
    }

    public static double calcularIntegral(double a, double b, int numRectangulos) {
        double ancho = (b - a) / numRectangulos;
        double suma = 0.0;

        for (int i = 0; i < numRectangulos; i++) {
            double x = a + (i + 0.5) * ancho;
            double altura = funcion(x);
            suma += altura * ancho;
        }

        return suma;
    }

    public static double funcion(double x) {
        return 5 * (Math.sin(x / 1.59) + 0.33 * Math.sin(3 * x / 1.59) + 0.2 * Math.sin(5 * x / 1.59));
    }
}
