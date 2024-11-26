import java.util.Scanner;

public class Montacargas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantaActual = 0;
        boolean continuar = true;

        while (continuar) {
            mostrarPlanta(plantaActual);
            System.out.println("Elige una planta de destino (0-9): ");
            int plantaDestino = scanner.nextInt();

            while (plantaDestino < 0 || plantaDestino > 9) {
                System.out.println("Planta inválida. Elige una planta entre 0 y 9: ");
                plantaDestino = scanner.nextInt();
            }

            if (plantaDestino != plantaActual) {
                moverMontacargas(plantaActual, plantaDestino);
                plantaActual = plantaDestino;
            }

            System.out.println("¿Quieres hacer otro viaje? (sí (S) / no (N)): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("S");
        }

        System.out.println("Simulación terminada.");
        scanner.close();
    }

    private static void mostrarPlanta(int planta) {
        for (int i = 9; i >= 0; i--) {
            if (i == planta) {
                System.out.println(i + "  [ --- ]");
            } else {
                System.out.println(i + "  |   |");
            }
        }
        System.out.println("----------------");
    }

    private static void moverMontacargas(int origen, int destino) {
        if (origen < destino) {
            System.out.println("Subiendo de la planta " + origen + " a la planta " + destino + "...");
        } else {
            System.out.println("Bajando de la planta " + origen + " a la planta " + destino + "...");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("El montacargas ha llegado a la planta " + destino + ".");
    }
}