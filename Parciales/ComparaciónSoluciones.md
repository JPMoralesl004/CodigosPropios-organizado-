## Comparación de los códigos de la integral transformada

### Código del Masias:

```java
import java.util.Scanner;

class Transformada {
    public static void main(String[] args) {
        double a = new Scanner(System.in).nextDouble();
        double b = new Scanner(System.in).nextDouble();
        double integral = 0;
        final double PASO = 0.001;
        for (double x = a; x <= b; x = x + PASO) {
            integral = integral + PASO * funcion(x);
        }
        System.out.println("La integral entre [" + a + "] y [" + b + "] es :" + integral);
    }

    static double funcion(double x) {
        return 5 * (Math.sin(x / 1.59) + 0.33 * Math.sin(3 * x / 1.59) + 0.2 * Math.sin(5 * x / 1.59));
    }
}
```

### Mi código:

```java
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
```

#### Similitudes

- **Función para Integrar:** Ambos códigos calculan la integral de la misma función matemática.
- **Uso de `Scanner`:** Ambos usan `Scanner` para leer la entrada del usuario desde la consola.
- **Clase `Math`:** Ambos utilizan funciones trigonométricas de la clase `Math`.

#### Diferencias

- **Método de Integración:**
  - **Código de Masias:** Utiliza una aproximación simple mediante un bucle `for` con un paso fijo (`PASO`) para calcular la integral.
  - **Mi código:** Utiliza el método de la suma de Riemann, dividiendo el rango de integración en un número definido de rectángulos (`numRectangulos`) y calculando el área de cada uno.

- **Entrada del Usuario:**
  - **Código de Masias:** Pide los valores de `a` y `b` directamente usando nuevas instancias de `Scanner` en cada lectura.
  - **Mi código:** Pide los valores de `a`, `b` y `numRectangulos` una vez y guarda estos valores para su uso posterior.

- **Estructura del Código:**
  - **Código de Masias:** Utiliza un método principal (`main`) con la lógica completa del cálculo de la integral y la función `funcion`.
  - **Mi código:** Descompone la lógica en métodos separados (`calcularIntegral` y `funcion`), siguiendo principios de diseño modular y separación de responsabilidades.

- **Declaración de Variables:**
  - **Código de Masias:** Declara e inicializa variables directamente dentro del método principal.
  - **Mi código:** Declara e inicializa variables dentro de los métodos correspondientes, asegurando que cada variable tenga un alcance limitado a su contexto.

- **Aproximación de la Integral:**
  - **Código del Masias:** Usa un paso fijo (`PASO = 0.001`) para la integración numérica.
  - **Mi código:** Calcula el ancho de cada rectángulo basado en el número total de rectángulos (`numRectangulos`) definido por el usuario.

#### Clean Code y Legibilidad

- **Código de Masias:** 
  - **Simplicidad:** Su código es simple y directo pero menos modular.
  - **Uso de `Scanner`:** Crea múltiples instancias de `Scanner`, lo cual no es necesario y puede ser ineficiente.

- **Mi código:**
  - **Modularidad:** Tu código es más modular, lo que facilita la lectura y el mantenimiento.
  - **Interacción del Usuario:** Proporciona mensajes más claros y detallados para la entrada del usuario.

## Diferencias Detalladas

#### Método de Integración

- **Código de Masias:**
  - **Aproximación Simple:** Usa una técnica de aproximación directa mediante un bucle `for` que incrementa en pasos fijos (`PASO = 0.001`) para calcular la integral.
  - **Menor Flexibilidad:** La precisión de la integral depende del valor fijo de `PASO`, lo cual no se puede ajustar dinámicamente sin modificar el código.

- **Mi código:**
  - **Suma de Riemann:** Utiliza la suma de Riemann, dividiendo el intervalo de integración en un número de rectángulos (`numRectangulos`) especificado por el usuario.
  - **Mayor Flexibilidad:** Permite al usuario definir la precisión de la aproximación especificando el número de rectángulos, lo que puede hacer la integral más o menos precisa según se requiera.

#### Entrada del Usuario

- **Código de Masias:**
  - **Múltiples Instancias de `Scanner`:** Usa nuevas instancias de `Scanner` para cada entrada, lo cual puede ser redundante e ineficiente.
  - **Entrada Directa y Simple:** Pide directamente los valores de `a` y `b` sin mucha interacción adicional.

- **Mi código:**
  - **Instancia Única de `Scanner`:** Usa una única instancia de `Scanner` para todas las entradas, lo cual es más eficiente y limpio.
  - **Interacción Detallada:** Pide al usuario no solo los límites de integración `a` y `b`, sino también el número de rectángulos para la aproximación, proporcionando más control y flexibilidad al usuario.

#### Estructura del Código

- **Código de Masias:**
  - **Método Principal con Toda la Lógica:** Contiene toda la lógica del cálculo de la integral en el método `main`, lo cual puede dificultar la lectura y el mantenimiento del código.
  - **Menos Modular:** Las responsabilidades no están claramente separadas en métodos distintos.

- **Mi código:**
  - **Diseño Modular:** Descompone la lógica en varios métodos (`calcularIntegral` y `funcion`), siguiendo principios de diseño modular y separación de responsabilidades.
  - **Claridad y Mantenimiento:** La separación en métodos hace que el código sea más claro y fácil de mantener.

#### Declaración de Variables

- **Código de Masias:**
  - **Declaración Directa:** Declara e inicializa variables dentro del método `main`, manteniendo todo el estado en el mismo lugar.
  - **Simplicidad:** Este enfoque es simple pero menos flexible y escalable.

- **Mi código:**
  - **Declaración en Métodos Correspondientes:** Declara e inicializa variables dentro de métodos específicos, lo que ayuda a limitar el alcance de las variables y mejora la claridad del código.
  - **Mejora en el Alcance:** Las variables están contenidas dentro de sus contextos específicos, lo cual mejora la legibilidad y reduce errores.

#### Aproximación de la Integral

- **Código de Masias:**
  - **Paso Fijo (`PASO`):** Usa un valor fijo para `PASO`, lo que define la precisión de la integral.
  - **Menos Control:** El usuario no puede ajustar directamente la precisión sin modificar el código.

- **Mi código:**
  - **Ancho Variable:** Calcula el ancho de cada rectángulo basado en el número total de rectángulos (`numRectangulos`), lo que permite al usuario definir la precisión.
  - **Mayor Control:** Proporciona al usuario la capacidad de ajustar la precisión a través del número de rectángulos.

### Conclusión

- **Código de Masias:** Es más directo y simple, pero menos modular y flexible. Utiliza una aproximación fija con `PASO`, lo cual puede ser limitante en términos de precisión ajustable.
- **Tu código:** Es más modular y flexible, permitiendo al usuario ajustar la precisión de la aproximación a través del número de rectángulos. Además, sigue principios de diseño más limpios y eficaces.

## Comparación de los códigos del Escondite

### Codigo de Masias:

```java
import java.util.Scanner;

class Escondite {
    public static void main(String[] args) {

        final int TOTAL_PLACES = 6;
        final int VISIBLE = 0;
        int firstPlayerPosition = VISIBLE, secondPlayerPosition = VISIBLE, thirdPlayerPosition = VISIBLE;

        firstPlayerPosition = definePlace(TOTAL_PLACES, secondPlayerPosition, thirdPlayerPosition);
        secondPlayerPosition = definePlace(TOTAL_PLACES, firstPlayerPosition, thirdPlayerPosition);
        thirdPlayerPosition = definePlace(TOTAL_PLACES, secondPlayerPosition, secondPlayerPosition);
        boolean gameInProgress = true;
        boolean allPlayersFound = false;
        int currentTurn = 0;

        while (gameInProgress) {
            currentTurn++;
            updateNervousness(firstPlayerPosition, secondPlayerPosition, thirdPlayerPosition, currentTurn);
            System.out.print("TURNO ["+currentTurn+"] Dónde mirar? [" + firstPlayerPosition + ":" + secondPlayerPosition + ":" + thirdPlayerPosition + "] ");
            int playerGuess = new Scanner(System.in).nextInt();

            firstPlayerPosition = lookAt(firstPlayerPosition, playerGuess);
            secondPlayerPosition = lookAt(secondPlayerPosition, playerGuess);
            thirdPlayerPosition = lookAt(thirdPlayerPosition, playerGuess);

            allPlayersFound = firstPlayerPosition == VISIBLE && secondPlayerPosition == VISIBLE && thirdPlayerPosition == VISIBLE;
            gameInProgress = currentTurn < 12 && !allPlayersFound;
            tellTale(currentTurn, firstPlayerPosition, secondPlayerPosition, thirdPlayerPosition);
        }
    }

    static void updateNervousness(int boyOne, int boyTwo, int boyThree, int turn) {
        if (turn%2==0) {
            final int VISIBLE = 0;
            String sound = "Aguzando el oido...";
            sound = sound + (boyOne != VISIBLE && Math.random() < 0.7 ? boyOne + ", " : "");
            sound = sound + (boyTwo != VISIBLE && Math.random() < 0.7 ? boyTwo + ", " : "");
            sound = sound + (boyThree != VISIBLE && Math.random() < 0.7 ? boyThree : "");
            System.out.println(sound);
        }
    }

    static int definePlace(int numberOfPlaces, int forbiddenPlaceOne, int forbiddenPlaceTwo) {
        int place;
        do {
            place = (int) (Math.random() * numberOfPlaces + 1);
        } while (place == forbiddenPlaceOne || place == forbiddenPlaceTwo);
        return place;
    }

    static int lookAt(int boy, int guess) {
        return boy == guess && Math.random() > 0.1 ? 0 : boy;
    }

    static void tellTale(int turn, int boyOne, int boyTwo, int boyThree) {
        final int VISIBLE = 0;
        System.out.println("Turno " + turn);
        System.out.println("Niño 1 " + (boyOne == VISIBLE ? "ENCONTRADO!" : "escondido"));
        System.out.println("Niño 2 " + (boyTwo == VISIBLE ? "ENCONTRADO!" : "escondido"));
        System.out.println("Niño 3 " + (boyThree == VISIBLE ? "ENCONTRADO!" : "escondido"));
    }
}
```


Mi codigo:
```java
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
            int busqueda = scanner.nextInt() - 1;
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
```

### **1. Organización y Modularidad**
- **Mi código**: Tiene una estructura modular más detallada, con métodos como `obtenerPosicionAleatoria`, `intercambiarUbicacion`, y `delatarPosicion`, lo que facilita el mantenimiento y la legibilidad. Sin embargo, algunas funciones tienen varias responsabilidades, lo que puede hacerlas más complejas (por ejemplo, `buscarNino` no solo busca, también maneja mensajes y actualiza el estado).
- **Código de Masias**: Es más compacto, con menos métodos. Sin embargo, sacrifica claridad y reutilización al incluir más lógica directamente en el método `main`. La modularidad es menor en comparación con tu versión.

---

### **2. Manejo de Aleatoriedad y Nerviosismo**
- **Mi código**: Usa probabilidades (como `random.nextDouble() <= 0.05`) para modelar el nerviosismo de los niños y definir si cambian de posición o hacen ruido. Esto introduce más realismo en el comportamiento, pero también hace que el juego dependa más de la suerte.
- **Código de Masias**: El comportamiento aleatorio está presente pero simplificado, como en `updateNervousness`, donde la probabilidad de sonidos es fija y más predecible. Es más directo y menos complejo, aunque menos detallado.

---

### **3. Claridad y Mensajes al Usuario**
- **Mi código**: Incluye mensajes descriptivos que hacen el juego más interactivo para el usuario (por ejemplo, describiendo los lugares y detallando acciones como intercambios o sonidos). Esto mejora la experiencia de juego, aunque puede hacer que el código parezca más cargado.
- **Código de Masias**: Los mensajes son más funcionales y menos detallados. Por ejemplo, el sistema de turnos y las posiciones de los niños se imprimen directamente como números, lo que puede ser menos amigable para el jugador.

---

### **4. Complejidad del Flujo del Juego**
- **Mi código**: Incluye más mecánicas como los intercambios de posiciones y la opción de reiniciar el juego si el jugador ingresa un número inválido. Esto agrega profundidad, pero puede hacer que el flujo sea más difícil de seguir para el programador.
- **Código de Masias**: El flujo es más sencillo y directo, con una menor cantidad de eventos aleatorios y reglas. Esto lo hace más fácil de seguir, aunque puede parecer más monótono desde el punto de vista del jugador.

---

### **5. Uso de Constantes y Manejo de Datos**
- **Mi código**: Usas constantes como `MAX_INTENTOS` y `TURNO_CAMBIO`, lo que hace que las reglas del juego sean fáciles de modificar. Además, tienes métodos como `getLugar` para traducir índices en nombres de lugares, mejorando la claridad.
- **Código de Masias**: También usa algunas constantes (como `VISIBLE`), pero los nombres son menos descriptivos y no tiene un equivalente directo a tu `getLugar`, lo que lo hace menos intuitivo para alguien que no esté familiarizado con el código.

---

### **Conclusión**
- **Ventajas de mi codigo**: Es más detallado, interactivo y modular. Es ideal si quieres priorizar la experiencia del usuario y explorar mecánicas adicionales como intercambios y probabilidades de eventos.
- **Ventajas del código de Masias**: Es más compacto y fácil de entender en un vistazo. Podría ser mejor para principiantes o si el objetivo es mantener un diseño simple y funcional.

## Comparación de los códigos del Montacargas

### Código de Masias:

```java
import java.util.Scanner;

class Montacargas {
    public static void main(String[] args) {
        final int PLANTAS = 9;
        int plantaSituacion;
        int plantaDestino;
        int carga;
        int cargaTotal = 0;

        plantaSituacion = 0;
        plantaDestino = 6;
        carga = calcularCarga();
        boolean simulando = true;

        while (simulando) {
            dibujarMontacargas(plantaSituacion, plantaDestino, carga);
            if (calcularMovimiento(plantaSituacion, plantaDestino) != 0) {
                plantaSituacion = calcularPlantaSituacion(plantaSituacion, plantaDestino);
            } else {
                plantaDestino = calcularPlantaDetino(PLANTAS);
                cargaTotal = cargaTotal + carga;
                carga = calcularCarga();
            }
            simulando = preguntarSiContinua();
        }
        System.out.println("Al final de la simulación ha transportado un total de " + cargaTotal + " kilos");
    }

    static int calcularPlantaDetino(int numeroPlantas) {
        return (int) (Math.random() * numeroPlantas);
    }

    static int calcularPlantaSituacion(int plantaSituacion, int plantaDestino) {
        return calcularMovimiento(plantaSituacion, plantaDestino) == 0 ? plantaSituacion : plantaSituacion + calcularMovimiento(plantaSituacion, plantaDestino);
    }

    static void dibujarMontacargas(int plantaSituacion, int plantaDestino, int carga) {
        final int PLANTAS = 9;
        final String BARRA = "  | |";
        final String SUBE = "^", BAJA = "v", DETENIDO = "-";
        for (int planta = PLANTAS; planta >= 0; planta--) {
            String detalleMovimiento = calcularMovimiento(plantaSituacion, plantaDestino) == 1 ? SUBE : calcularMovimiento(plantaSituacion, plantaDestino) == -1 ? BAJA : DETENIDO;
            String montacargas = "[" + detalleMovimiento + " " + plantaDestino + " " + detalleMovimiento + "]";
            System.out.println("P" + planta + " : " + (planta == plantaSituacion ? montacargas : BARRA));
        }
        System.out.println("=".repeat(12));
        System.out.println("En planta " + plantaSituacion);
        System.out.println(plantaDestino == plantaSituacion ? "Detenido" : "Yendo a planta " + plantaDestino + " mientras transporta " + carga + " kilos");
    }

    static int calcularMovimiento(int plantaSituacion, int plantaDestino) {
        return plantaSituacion < plantaDestino ? 1 : plantaSituacion > plantaDestino ? -1 : 0;
    }

    static boolean preguntarSiContinua() {
        System.out.println("Pulse x para salir");
        return !(new Scanner(System.in).nextLine().equalsIgnoreCase("x"));
    }

    static int calcularCarga() {
        final int CARGA_MAXIMA = 75;
        final int CARGA_MINIMA = 30;
        return (int) ((Math.random() * (CARGA_MAXIMA - CARGA_MINIMA)) + CARGA_MINIMA);
    }
}
```

### Mi código:

```java
import java.util.Random;
import java.util.Scanner;

public class Montacargas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int PLANTAS = 9;
        int plantaSituacion = 0;
        int plantaDestino = 6;
        double cargaTotal = 0.0;
        boolean simulando = true;

        while (simulando) {
            int carga = calcularCarga(random);
            dibujarMontacargas(plantaSituacion, plantaDestino, carga);
            if (calcularMovimiento(plantaSituacion, plantaDestino) != 0) {
                plantaSituacion = calcularPlantaSituacion(plantaSituacion, plantaDestino);
            } else {
                plantaDestino = calcularPlantaDestino(PLANTAS, random);
                cargaTotal += carga;
            }
            simulando = preguntarSiContinua(scanner);
        }
        System.out.println("Al final de la simulación ha transportado un total de " + cargaTotal + " kilos");
        scanner.close();
    }

    static int calcularPlantaDestino(int numeroPlantas, Random random) {
        return random.nextInt(numeroPlantas);
    }

    static int calcularPlantaSituacion(int plantaSituacion, int plantaDestino) {
        return calcularMovimiento(plantaSituacion, plantaDestino) == 0 ? plantaSituacion : plantaSituacion + calcularMovimiento(plantaSituacion, plantaDestino);
    }

    static void dibujarMontacargas(int plantaSituacion, int plantaDestino, int carga) {
        final int PLANTAS = 9;
        final String BARRA = "  | |";
        final String SUBE = "^", BAJA = "v", DETENIDO = "-";
        for (int planta = PLANTAS; planta >= 0; planta--) {
            String detalleMovimiento = calcularMovimiento(plantaSituacion, plantaDestino) == 1 ? SUBE : calcularMovimiento(plantaSituacion, plantaDestino) == -1 ? BAJA : DETENIDO;
            String montacargas = "[" + detalleMovimiento + " " + plantaDestino + " " + detalleMovimiento + "]";
            System.out.println("P" + planta + " : " + (planta == plantaSituacion ? montacargas : BARRA));
        }
        System.out.println("=".repeat(12));
        System.out.println("En planta " + plantaSituacion);
        System.out.println(plantaDestino == plantaSituacion ? "Detenido" : "Yendo a planta " + plantaDestino + " mientras transporta " + carga + " kilos");
    }

    static int calcularMovimiento(int plantaSituacion, int plantaDestino) {
        return plantaSituacion < plantaDestino ? 1 : plantaSituacion > plantaDestino ? -1 : 0;
    }

    static boolean preguntarSiContinua(Scanner scanner) {
        System.out.println("Pulse x para salir");
        return !scanner.nextLine().equalsIgnoreCase("x");
    }

    static int calcularCarga(Random random) {
        final int CARGA_MAXIMA = 75;
        final int CARGA_MINIMA = 30;
        return random.nextInt(CARGA_MAXIMA - CARGA_MINIMA) + CARGA_MINIMA;
    }
}
```

### Similitudes

- **Estructura de Bucles:** Ambos códigos usan ciclos `while` para iterar hasta que una condición se cumpla.
- **Aleatorización:** Implementan aleatorización para determinar posiciones y cargas.
- **Métodos para Actualizar Estado:** Incluyen métodos para actualizar y mostrar el estado del sistema.

### Diferencias

- **Enfoque Modular:**
  - **Código del profesor:** Modularizado con funciones dedicadas a cada parte del proceso (movimiento, dibujar el estado, calcular la carga, etc.).
  - **Tu código:** También modular, pero implementa algunas funciones de manera más compacta.

- **Manejo de Estado:**
  - **Código del profesor:** Usa variables individuales (`plantaSituacion`, `plantaDestino`, `carga`).
  - **Tu código:** Similar, pero incluye el uso de la clase `Random` para la aleatorización.

- **Calculo de Carga y Movimiento:**
  - **Código del profesor:** Calcula una carga aleatoria en cada ciclo y usa funciones para determinar y actualizar el movimiento (`calcularMovimiento`, `calcularPlantaSituacion`).
  - **Tu código:** Calcula la carga con la clase `Random` y realiza actualizaciones de manera similar.

- **Interacción con el Usuario:**
  - **Código del profesor:** Pregunta al usuario si desea continuar la simulación después de cada ciclo.
  - **Tu código:** Implementa una funcionalidad similar para continuar la simulación.
 
## Diferencias Detalladas

#### Enfoque Modular

- **Código de Masias:**
  - **Modularidad:** El código del profesor está altamente modularizado, con funciones dedicadas a cada parte del proceso (movimiento, dibujar el estado, calcular la carga, etc.).
  - **Funciones Específicas:** Utiliza funciones como `calcularPlantaDetino`, `calcularPlantaSituacion`, `dibujarMontacargas`, `calcularMovimiento`, `preguntarSiContinua` y `calcularCarga` para dividir claramente las tareas.

- **Mi código:**
  - **Modularidad Simplificada:** Aunque también modular, algunas funciones están implementadas de manera más compacta y algunas tareas se manejan dentro del bucle principal.
  - **Funciones Compactas:** Utiliza funciones como `calcularPlantaDestino`, `calcularPlantaSituacion`, `dibujarMontacargas`, `calcularMovimiento`, `preguntarSiContinua` y `calcularCarga`, pero con menos separación explícita de tareas comparado con el código del profesor.

#### Manejo de Estado

- **Código de Masias:**
  - **Variables Individuales:** Usa variables individuales (`plantaSituacion`, `plantaDestino`, `carga`, `cargaTotal`) para mantener el estado del montacargas y la simulación.
  - **Estado Secuencial:** El estado del montacargas se actualiza de manera secuencial y explícita en cada iteración del bucle.

- **Mi Código:**
  - **Variables Individuales:** Similar al código del profesor, usa variables individuales para mantener el estado.
  - **Estado Compacto:** Maneja la actualización del estado dentro de un contexto más compacto, integrando el uso de la clase `Random` para la aleatorización.

#### Calculo de Carga y Movimiento

- **Código de Masias:**
  - **Carga Aleatoria:** Calcula una carga aleatoria para cada viaje del montacargas utilizando la función `calcularCarga`, con valores máximos y mínimos definidos.
  - **Movimiento Determinista:** Usa funciones específicas para determinar y actualizar el movimiento (`calcularMovimiento`, `calcularPlantaSituacion`).

- **Mi código:**
  - **Carga Aleatoria con `Random`:** Usa la clase `Random` para calcular la carga transportada, asegurando variabilidad en los valores generados.
  - **Movimiento Determinista:** Similar al código del profesor, implementa funciones para determinar y actualizar el movimiento del montacargas.

#### Interacción con el Usuario

- **Código del profesor:**
  - **Interactividad Continua:** Pregunta al usuario si desea continuar la simulación después de cada ciclo mediante la función `preguntarSiContinua`.
  - **Simulación Continua:** El enfoque es en una simulación continua del proceso de carga y transporte.

- **Tu código:**
  - **Interactividad Continua:** Implementa una funcionalidad similar para preguntar al usuario si desea continuar la simulación.
  - **Simulación Continua:** También se enfoca en una simulación continua del proceso, manteniendo al usuario informado sobre el progreso de la carga transportada.
