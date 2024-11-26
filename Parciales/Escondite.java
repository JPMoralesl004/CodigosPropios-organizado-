import java.util.Random;
import java.util.Scanner;

public class Escondite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] posiciones = new int[6];
        int intentos = 0;
        int encontrados = 0;
        int maxIntentos = 12;

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

    private static String getLugar(int index) {
        switch (index) {
            case 0: return "Árbol";
            case 1: return "Banco";
            case 2: return "Arbusto";
            case 3: return "Columpio";
            case 4: return "Caseta";
            case 5: return "Tobogán";
            default: return "";
        }
    }
}