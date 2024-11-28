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
  - **MI código:** Declara e inicializa variables dentro de los métodos correspondientes, asegurando que cada variable tenga un alcance limitado a su contexto.

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

### Diferencias Detalladas

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

Ambos códigos calculan la integral de manera efectiva, pero utilizan enfoques diferentes:

- **Código de Masias:** Es más directo y simple, pero menos modular y flexible. Utiliza una aproximación fija con `PASO`, lo cual puede ser limitante en términos de precisión ajustable.
- **Tu código:** Es más modular y flexible, permitiendo al usuario ajustar la precisión de la aproximación a través del número de rectángulos. Además, sigue principios de diseño más limpios y eficaces.

## Comparación de los códigos del Escondite

### Código de Masias:

```java
import java.util.Scanner;

class Escondite {
    public static void main(String[] args) {

        final int PLACES = 6;
        final int VISIBLE = 0;
        int boyOne = VISIBLE, boyTwo = VISIBLE, boyThree = VISIBLE;

        boyOne = definePlace(PLACES, boyTwo, boyThree);
        boyTwo = definePlace(PLACES, boyOne, boyThree);
        boyThree = definePlace(PLACES, boyTwo, boyTwo);
        boolean arePlaying = true;
        boolean allFound = false;
        int turn = 0;

        while (arePlaying) {
            turn++;
            nervous(boyOne, boyTwo, boyThree, turn);
            System.out.print("TURNO [" + turn + "] Dónde mirar? [" + boyOne + ":" + boyTwo + ":" + boyThree + "] ");
            int guess = new Scanner(System.in).nextInt();

            boyOne = lookAt(boyOne, guess);
            boyTwo = lookAt(boyTwo, guess);
            boyThree = lookAt(boyThree, guess);

            allFound = boyOne == VISIBLE && boyTwo == VISIBLE && boyThree == VISIBLE;
            arePlaying = turn < 12 && !allFound;
            countHistory(turn, boyOne, boyTwo, boyThree);
        }
    }

    static void nervous(int boyOne, int boyTwo, int boyThree, int turn) {
        if (turn % 2 == 0) {
            final int VISIBLE = 0;
            String sound = "Aguzando el oido...";
            sound = sound + (boyOne != VISIBLE && Math.random() < 0.7 ? boyOne + ", " : "");
            sound = sound + (boyTwo != VISIBLE && Math.random() < 0.7 ? boyTwo + ", " : "");
            sound = sound + (boyThree != VISIBLE && Math.random() < 0.7 ? boyThree : "");
            System.out.println(sound);
        }
    }

    static int definePlace(int numberOfPlaces, int forbiddenPlaceOne, int forbiddenPlacetwo) {
        int place;
        do {
            place = (int) (Math.random() * numberOfPlaces + 1);
        } while (place == forbiddenPlaceOne || place == forbiddenPlacetwo);
        return place;
    }

    static int lookAt(int boy, int guess) {
        return boy == guess && Math.random() > 0.1 ? 0 : boy;
    }

    static void countHistory(int turn, int boyOne, int boyTwo, int boyThree) {
        final int VISIBLE = 0;
        System.out.println("Turno " + turn);
        System.out.println("Niño 1 " + (boyOne == VISIBLE ? "ENCONTRADO!" : "escondido"));
        System.out.println("Niño 2 " + (boyTwo == VISIBLE ? "ENCONTRADO!" : "escondido"));
        System.out.println("Niño 3 " + (boyThree == VISIBLE ? "ENCONTRADO!" : "escondido"));
    }
}
```

### Mi código

```java
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
#### Similitudes

- **Estructura de Bucles:** Ambos códigos usan ciclos `while` para iterar hasta que se cumplan ciertas condiciones.
- **Aleatorización:** Implementan aleatorización para determinar las posiciones de los niños.
- **Métodos para Actualizar Estado:** Ambos incluyen métodos para actualizar y mostrar el estado del juego.

#### Diferencias

- **Enfoque Modular:**
  - **Código de Masias:** Modularizado con funciones dedicadas a cada parte del proceso (nerviosismo, definición de posiciones, etc.).
  - **Mi código:** También modular, pero integra algunas funciones de manera más compacta.

- **Manejo de Estado:**
  - **Código de Masias:** Usa variables individuales (`boyOne`, `boyTwo`, `boyThree`).
  - **Mi código:** Usa arrays (`posiciones`, `nervioso`) para manejar el estado de los niños.

- **Calculo de Posiciones y Nerviosismo:**
  - **Código de Masias:** Define las posiciones con `definePlace` y maneja el nerviosismo con `nervous`, añadiendo mensajes aleatorios.
  - **Mi código:** Usa la función `delatarPosicion` para determinar el nerviosismo y `intercambiarUbicacion` para mezclar posiciones, añadiendo variabilidad.

- **Interacción con el Usuario:**
  - **Código de Masias:** Pregunta al usuario dónde buscar en cada turno y actualiza el estado de los niños.
  - **Mi código:** Similarmente, solicita al usuario ingresar una posición y maneja las respuestas, pero también incluye cambios de posiciones en ciertos turnos.

### Diferencias Detalladas

#### Enfoque Modular

- **Código de Masias:**
  - **Modularidad:** El código del profesor tiene una estructura muy modular, dividiendo claramente las responsabilidades en funciones como `definePlace`, `lookAt`, `nervous` y `countHistory`.
  - **Funciones Específicas:** Cada función tiene una tarea clara y específica: `definePlace` asigna posiciones aleatorias, `lookAt` verifica si un niño fue encontrado, `nervous` simula nerviosismo de los niños, y `countHistory` imprime el estado del juego.

- **Mi código:**
  - **Modularidad Simplificada:** Aunque tu código también es modular, las funciones están integradas más directamente en el flujo principal del programa.
  - **Funciones Compactas:** Funciones como `delatarPosicion` y `intercambiarUbicacion` manejan varias responsabilidades, como determinar el nerviosismo de los niños y su reubicación.

#### Manejo de Estado

- **Código de Masias:**
  - **Variables Individuales:** Usa variables individuales (`boyOne`, `boyTwo`, `boyThree`) para mantener el estado de los niños.
  - **Estado Simples:** El uso de variables simples facilita el seguimiento del estado de cada niño por separado.

- **Mi código:**
  - **Arrays para el Estado:** Usa arrays (`posiciones`, `nervioso`) para manejar el estado de los niños, lo que permite escalar fácilmente si se añaden más niños.
  - **Estado Complejo:** Maneja estados más complejos con arrays, haciendo posible la integración de características adicionales como la reubicación de los niños.

#### Calculo de Posiciones y Nerviosismo

- **Código de Masias:**
  - **Definición de Posiciones:** Usa la función `definePlace` para asignar posiciones aleatorias a los niños, asegurando que no se repitan.
  - **Manejo del Nerviosismo:** Usa la función `nervous` para imprimir mensajes de nerviosismo con una probabilidad fija cuando los turnos son pares.

- **Mi código:**
  - **Definición de Posiciones:** Asigna posiciones aleatorias a los niños dentro de un bucle `for`, usando la clase `Random` y evitando repeticiones.
  - **Manejo del Nerviosismo:** Usa la función `delatarPosicion` para determinar el nerviosismo de los niños con una probabilidad fija, y la función `intercambiarUbicacion` para mezclar posiciones en ciertos turnos, añadiendo una capa extra de variabilidad.

#### Interacción con el Usuario

- **Código de Masias:**
  - **Interacción Directa:** Solicita al usuario una entrada de posición en cada turno y actualiza el estado de los niños en función de esa entrada.
  - **Feedback del Juego:** Proporciona mensajes detallados sobre el estado del juego y los niños encontrados después de cada turno.

- **Mi código:**
  - **Interacción Directa:** Similarmente, solicita al usuario que ingrese una posición para buscar a los niños.
  - **Cambio de Posiciones:** Además de la entrada directa del usuario, tu código incluye la función `intercambiarUbicacion` que cambia las posiciones de los niños en un turno específico, lo que introduce una capa adicional de desafío.

#### Detalles de Implementación

- **Código de Masias:**
  - **Métodos Claros y Concisos:** Cada método en el código del profesor tiene una responsabilidad específica y clara, lo que facilita la comprensión y el mantenimiento del código.
  - **Impresión del Estado del Juego:** Usa la función `countHistory` para imprimir el estado del juego después de cada turno, proporcionando un seguimiento claro del progreso del juego.

- **Mi código:**
  - **Métodos Integrados:** Aunque tus métodos también tienen responsabilidades claras, están más integrados en el flujo del programa principal, lo que puede hacer que el código sea más compacto pero menos modular.
  - **Mensajes de Estado:** Tu código imprime mensajes sobre el estado del juego y los niños encontrados después de cada turno, pero también incluye mensajes sobre el nerviosismo y la reubicación de los niños, añadiendo más dinamismo al juego.

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
