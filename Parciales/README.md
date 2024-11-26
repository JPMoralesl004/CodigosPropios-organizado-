### Aqui estan mis explicaciones de los codigos de las preguntas 2 a la 7 del parcial de progra 1.

### Pregunta 2:

### Código Explicado: `IntegralAproximada.java`

#### Importaciones
```java
import java.util.Scanner;
```
- Se importa la clase `Scanner` para leer la entrada del usuario desde la consola.

#### Clase Principal
```java
public class IntegralAproximada {
    public static void main(String[] args) {
```
- `public class IntegralAproximada`: Define una clase pública llamada `IntegralAproximada`.
- `public static void main(String[] args)`: Define el método principal que ejecuta el programa.

#### Declaraciones Iniciales
```java
        Scanner scanner = new Scanner(System.in);
        boolean repetir;
```
- Se crea un objeto `Scanner` para leer la entrada del usuario.
- Se declara una variable booleana `repetir` que controla si el usuario desea realizar otra aproximación.

#### Bucle Principal
```java
        do {
            double a, b;
            boolean datosValidos;
```
- Se inicia un bucle `do-while` que permite repetir el cálculo de la integral.
- Se declaran las variables `a` y `b` para los límites inferior y superior de la integral, y `datosValidos` para verificar la validez de los datos de entrada.

#### Entrada de Datos del Usuario
```java
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
```
- Un bucle `do-while` anidado que solicita al usuario que ingrese los límites de integración `a` y `b`.
- Verifica que `a` sea menor que `b`. Si no, muestra un mensaje de error y solicita nuevamente los datos.

#### Cálculo de la Integral
```java
            int n = 1000;
            double ancho = (b - a) / n;
            double suma = 0.0;

            for (int i = 0; i < n; i++) {
                double x = a + i * ancho;
                double altura = calcularFuncion(x);
                suma += altura * ancho;
            }

            System.out.println("La integral aproximada entre " + a + " y " + b + " es: " + suma);
```
- `int n = 1000`: Número de rectángulos utilizados para la aproximación.
- `double ancho = (b - a) / n`: Ancho de cada rectángulo.
- `double suma = 0.0`: Variable para acumular la suma de las áreas de los rectángulos.
- Un bucle `for` que recorre cada rectángulo, calcula su altura y suma su área a la variable `suma`.
- `System.out.println`: Imprime el resultado de la integral aproximada.

#### Repetición del Cálculo
```java
            System.out.println("\n¿Quieres realizar otro cálculo? (sí (S) / no (N)): ");
            String respuesta = scanner.next();
            repetir = respuesta.equalsIgnoreCase("S");
        } while (repetir);
```
- Pregunta al usuario si desea realizar otro cálculo.
- Lee la respuesta del usuario y actualiza la variable `repetir`.

#### Cierre del Programa
```java
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
```
- Muestra un mensaje de agradecimiento y cierra el objeto `Scanner`.
- `calcularFuncion`: Método que define la función a integrar. Calcula y devuelve el valor de la función para un valor dado de `x`.

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
