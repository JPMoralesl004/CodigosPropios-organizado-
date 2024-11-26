import java.util.Random;
import java.util.Scanner;

public class Escondite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] posiciones = new int[6];
        boolean[] nervioso = new boolean[3];
        int intentos = 0;
        int encontrados = 0;
        int maxIntentos = 12;
        int turnoCambio = 7;

        for (int i = 0; i < 3; i++) {
            int posicion;
            do {
                posicion = random.nextInt(6);
            } while (posiciones[posicion] != 0);
            posiciones[posicion] = i + 1;
        }

        System.out.println("¡Los niños se han escondido!");
        System.out.println("1-Árbol 2-Banco 3-Arbusto 4-Columpio 5-Caseta 6-Tobogán");

        while (intentos < maxIntentos && encontrados < 3) {
            if (intentos % 2 == 0) {
                delatarPosicion(random, nervioso, posiciones);
            }
            if (intentos == turnoCambio) {
                intercambiarUbicacion(random, posiciones);
            }

            System.out.print("¿Dónde quieres buscar? ");
            int busqueda = scanner.nextInt() - 1;
            intentos++;

            if (posiciones[busqueda] != 0) {
                double chance = random.nextDouble();
                if (chance > 0.1) {
                    System.out.println("Has mirado en el " + getLugar(busqueda) + "... ¡Has encontrado al niño " + posiciones[busqueda] + "!");
                    encontrados++;
                    posiciones[busqueda] = 0;
                } else {
                    System.out.println("Has mirado en el " + getLugar(busqueda) + "... ¡No hay nadie!");
                }
            } else {
                System.out.println("Has mirado en el " + getLugar(busqueda) + "... ¡No hay nadie!");
            }

            System.out.println("Llevas " + intentos + " intento(s) y has encontrado " + encontrados + " niño(s).");
        }

        if (encontrados == 3) {
            System.out.println("¡Has encontrado a todos los niños!");
        } else {
            System.out.println("¡Se acabaron los intentos! No has encontrado a todos los niños.");
        }

        scanner.close();
    }

    private static void delatarPosicion(Random random, boolean[] nervioso, int[] posiciones) {
        for (int i = 0; i < nervioso.length; i++) {
            double chance = random.nextDouble();
            if (chance <= 0.05) {
                nervioso[i] = true;
                System.out.println("El niño " + (i + 1) + " ha hecho un ruido en la posición " + getLugar(posiciones[i] - 1) + "!");
            } else {
                nervioso[i] = false;
            }
        }
    }

    private static void intercambiarUbicacion(Random random, int[] posiciones) {
        double chance = random.nextDouble();
        if (chance <= 0.3) {
            int primeraPos, segundaPos;
            do {
                primeraPos = random.nextInt(6);
            } while (posiciones[primeraPos] == 0);
            do {
                segundaPos = random.nextInt(6);
            } while (posiciones[segundaPos] == 0 || primeraPos == segundaPos);

            int temp = posiciones[primeraPos];
            posiciones[primeraPos] = posiciones[segundaPos];
            posiciones[segundaPos] = temp;

            System.out.println("Los niños se han intercambiado de posición sigilosamente.");
        }
    }

    private static String getLugar(int index) {
        String[] lugares = {"Árbol", "Banco", "Arbusto", "Columpio", "Caseta", "Tobogán"};
        return lugares[index];
    }
}
