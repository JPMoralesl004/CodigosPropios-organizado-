### Explicaciones de mis soluciones de codigo del Parical II de progra 1.

### Pregunta 2:
#### Clase `IntegralTransformada`

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

### Descripción del Código

1. **Importación y Clase Principal**
   - **Importación:** Importa la clase `Scanner` para la entrada de datos por consola.
   - **Clase Principal:** La clase se llama `IntegralTransformada`.

2. **Método `main`**
   - **Entrada del Usuario:** Usa el `Scanner` para pedir al usuario los valores de `a` y `b`, y el número de rectángulos (`numRectangulos`) para la aproximación de la integral.
   - **Cálculo de la Integral:** Llama al método `calcularIntegral` con los valores ingresados por el usuario.
   - **Mostrar Resultado:** Imprime el resultado de la integral calculada.
   - **Cerrar `Scanner`:** Cierra el objeto `Scanner` para liberar los recursos.

3. **Método `calcularIntegral`**
   - **Parámetros:** Recibe los valores de `a`, `b` y `numRectangulos`.
   - **Calculo del Ancho:** Calcula el ancho de cada rectángulo como `(b - a) / numRectangulos`.
   - **Suma de Riemann:**
     - Usa un bucle `for` para iterar a través de cada rectángulo.
     - Calcula el punto medio `x` de cada rectángulo.
     - Calcula la altura de la función en `x` usando el método `funcion`.
     - Suma el área de cada rectángulo (`altura * ancho`) a la suma total.

4. **Método `funcion`**
   - **Parámetro:** Recibe un valor `x`.
   - **Cálculo:** Calcula el valor de la función en `x` usando la fórmula `5 * (Math.sin(x / 1.59) + 0.33 * Math.sin(3 * x / 1.59) + 0.2 * Math.sin(5 * x / 1.59))`.

### Pregunta 3:

### Impedir que dos niños puedan esconderse en el mismo sitio

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
```

- **Importaciones**:
  ```java
  import java.util.Random;
  import java.util.Scanner;
  ```
  - Se importan las clases `Random` y `Scanner` para generar números aleatorios y leer la entrada del usuario desde la consola.

- **Clase Principal y Declaraciones Iniciales**:
  ```java
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
  ```
  - Se declara la clase principal `Escondite` y el método `main`.
  - Se crean objetos `Scanner` y `Random`.
  - Se inicializan los arreglos `posiciones` y `nervioso` y las variables de control `intentos`, `encontrados`, `maxIntentos` y `turnoCambio`.

- **Inicialización de Posiciones**:
  ```java
          for (int i = 0; i < 3; i++) {
              int posicion;
              do {
                  posicion = random.nextInt(6);
              } while (posiciones[posicion] != 0);
              posiciones[posicion] = i + 1;
          }
  ```
  - Se asignan posiciones aleatorias únicas a los tres niños utilizando un bucle `do-while`.

- **Mensajes de Inicio**:
  ```java
          System.out.println("¡Los niños se han escondido!");
          System.out.println("1-Árbol 2-Banco 3-Arbusto 4-Columpio 5-Caseta 6-Tobogán");
  ```
  - Se imprimen mensajes indicando que los niños se han escondido y mostrando las posibles ubicaciones.

### Pregunta 4:

### Agregar la probabilidad de que un niño se ponga nervioso y haga un ruido que delate su posición antes de cada turno par (5%)

```java
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
```

- **Bucle Principal del Juego**:
  ```java
          while (intentos < maxIntentos && encontrados < 3) {
              if (intentos % 2 == 0) {
                  delatarPosicion(random, nervioso, posiciones);
              }
              if (intentos == turnoCambio) {
                  intercambiarUbicacion(random, posiciones);
              }
  ```
  - Se ejecuta un bucle `while` mientras el jugador tenga intentos disponibles y no haya encontrado a todos los niños.
  - Cada dos turnos, se verifica si un niño hace un ruido con la función `delatarPosicion`.
  - En el turno 7, los niños pueden cambiar de ubicación con la función `intercambiarUbicacion`.

- **Entrada del Usuario y Búsqueda**:
  ```java
              System.out.print("¿Dónde quieres buscar? ");
              int busqueda = scanner.nextInt() - 1;
              intentos++;
  ```
  - Se solicita al usuario que ingrese una posición para buscar a los niños.
  - Se incrementa el contador de intentos.

- **Verificación de la Búsqueda**:
  ```java
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
  ```
  - Se verifica si el niño está en la posición buscada. Si el niño está presente y no se oculta nuevamente, se incrementa el contador de niños encontrados y se vacía la posición.

- **Estado Actual del Juego**:
  ```java
              System.out.println("Llevas " + intentos + " intento(s) y has encontrado " + encontrados + " niño(s).");
          }
  ```
  - Se imprime el estado actual del juego después de cada búsqueda.

### Pregunta 5:

### Permitir que en el turno 7 los niños cambien su ubicación con una probabilidad del 30%

```java
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
```
- **Fin del Juego**:
  ```java
          if (encontrados == 3) {
              System.out.println("¡Has encontrado a todos los niños!");
          } else {
              System.out.println("¡Se acabaron los intentos! No has encontrado a todos los niños.");
          }

          scanner.close();
      }
  ```
  - Se verifica si el jugador ha encontrado a todos los niños o ha agotado los intentos, y se imprimen los mensajes correspondientes.
  - Se cierra el objeto `Scanner`.

- **Métodos Auxiliares**:
  - **delatarPosicion**:
    ```java
      private static void delatarPosicion(Random random, boolean[] nervioso, int[] posiciones) {
          for (int i = 

### Pregunta 6:

### Explicación del Código

1. **Entrada del Usuario y Control del Flujo**:
   - El programa inicia con el montacargas en la planta 0.
   - Se solicita al usuario que ingrese una planta de destino.
   - Se valida que la planta de destino esté entre 0 y 9.

2. **Mostrar la Planta Actual**:
   - La función `mostrarPlanta` muestra la planta actual del montacargas de manera visual.
   - Se imprime un diagrama del edificio mostrando la ubicación del montacargas.

3. **Mover el Montacargas**:
   - La función `moverMontacargas` simula el movimiento del montacargas entre la planta de origen y la planta de destino.
   - Se imprime si el montacargas está subiendo o bajando.
   - Se simula una pausa (opcional) para representar el movimiento del montacargas.

4. **Repetir la Operación**:
   - Después de cada viaje, se pregunta al usuario si desea hacer otro viaje.
   - El bucle continúa hasta que el usuario decida terminar la simulación.

### Pregunta 7:

### Explicación de las Modificaciones:

1. **Conocer la carga que sube en el montacargas con cada llamada**:
   - Se ha añadido una línea que genera una carga aleatoria entre 30 y 75 kilos cada vez que se encuentra un niño:
     ```java
     double carga = 30 + (75 - 30) * random.nextDouble();
     ```

2. **Saber la carga total transportada en el montacargas durante la simulación**:
   - Se ha añadido una variable `cargaTotal` para acumular la carga transportada durante la simulación:
     ```java
     double cargaTotal = 0.0;
     ```
   - Se actualiza `cargaTotal` cada vez que se encuentra un niño:
     ```java
     cargaTotal += carga;
     ```
   - Se muestra la carga total transportada después de cada intento y al final de la simulación:
     ```java
     System.out.println("Carga total transportada: " + cargaTotal + " kilos.");
     ```
