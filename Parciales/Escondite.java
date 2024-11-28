import java.util.Random;
import java.util.Scanner;

public class Escondite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int posNino1 = obtenerPosicionAleatoria(random, -1, -1, -1);
        int posNino2 = obtenerPosicionAleatoria(random, posNino1, -1, -1);
        int posNino3 = obtenerPosicionAleatoria(random, posNino1, posNino2, -1);

        int intentos = 0;
        int encontrados = 0;
        final int MAX_INTENTOS = 12;
        final int TURNO_CAMBIO = 7;
        
        boolean nervioso1 = false;
        boolean nervioso2 = false;
        boolean nervioso3 = false;

        System.out.println("¡Los niños se han escondido!");
        System.out.println("1-Árbol 2-Banco 3-Arbusto 4-Columpio 5-Caseta 6-Tobogán");

        while (intentos < MAX_INTENTOS && encontrados < 3) {
            if (intentos % 2 == 0) {
                delatarPosicion(random, posNino1, posNino2, posNino3, nervioso1, nervioso2, nervioso3);
            }

            if (intentos == TURNO_CAMBIO) {
                int[] posiciones = intercambiarUbicacion(random, posNino1, posNino2, posNino3);
                posNino1 = posiciones[0];
                posNino2 = posiciones[1];
                posNino3 = posiciones[2];
            }

            System.out.print("¿Dónde quieres buscar? ");
            int busqueda = scanner.nextInt();
            
            if (busqueda < 1 || busqueda > 6) {
                System.out.println("Número inválido. Reiniciando el programa...");
                main(args);
                return;
            }

            busqueda -= 1;
            intentos++;

            encontrados += buscarNino(busqueda, random, posNino1, posNino2, posNino3);

            System.out.println("Llevas " + intentos + " intento(s) y has encontrado " + encontrados + " niño(s).");
        }

        if (encontrados == 3) {
            System.out.println("¡Has encontrado a todos los niños!");
        } else {
            System.out.println("¡Se acabaron los intentos! No has encontrado a todos los niños.");
        }

        scanner.close();
    }

    private static int obtenerPosicionAleatoria(Random random, int excl1, int excl2, int excl3) {
        int posicion;
        do {
            posicion = random.nextInt(6);
        } while (posicion == excl1 || posicion == excl2 || posicion == excl3);
        return posicion;
    }

    private static void delatarPosicion(Random random, int posNino1, int posNino2, int posNino3, boolean nervioso1, boolean nervioso2, boolean nervioso3) {
        if (random.nextDouble() <= 0.05) {
            nervioso1 = true;
            System.out.println("El niño 1 ha hecho un ruido en la posición " + getLugar(posNino1) + "!");
        }
        if (random.nextDouble() <= 0.05) {
            nervioso2 = true;
            System.out.println("El niño 2 ha hecho un ruido en la posición " + getLugar(posNino2) + "!");
        }
        if (random.nextDouble() <= 0.05) {
            nervioso3 = true;
            System.out.println("El niño 3 ha hecho un ruido en la posición " + getLugar(posNino3) + "!");
        }
    }

    private static int[] intercambiarUbicacion(Random random, int posNino1, int posNino2, int posNino3) {
        int[] posiciones = {posNino1, posNino2, posNino3};
        if (random.nextDouble() <= 0.3) {
            int temp = posiciones[0];
            posiciones[0] = posiciones[1];
            posiciones[1] = temp;
            System.out.println("Los niños se han intercambiado de posición sigilosamente.");
        }
        return posiciones;
    }

    private static int buscarNino(int busqueda, Random random, int posNino1, int posNino2, int posNino3) {
        if (busqueda == posNino1) {
            return checkBusqueda(random, 1, busqueda, posNino1);
        } else if (busqueda == posNino2) {
            return checkBusqueda(random, 2, busqueda, posNino2);
        } else if (busqueda == posNino3) {
            return checkBusqueda(random, 3, busqueda, posNino3);
        } else {
            System.out.println("Has mirado en el " + getLugar(busqueda) + "... ¡No hay nadie!");
            return 0;
        }
    }

    private static int checkBusqueda(Random random, int nino, int busqueda, int posicion) {
        if (random.nextDouble() > 0.1) {
            System.out.println("Has mirado en el " + getLugar(busqueda) + "... ¡Has encontrado al niño " + nino + "!");
            return 1;
        } else {
            System.out.println("Has mirado en el " + getLugar(busqueda) + "... ¡No hay nadie!");
            return 0;
        }
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
