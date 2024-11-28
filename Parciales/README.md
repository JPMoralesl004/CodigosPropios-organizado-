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

## Explicación del Código

#### Variables Principales:
- `Scanner scanner`: Para la entrada de datos del usuario.
- `Random random`: Para generar posiciones y decisiones aleatorias.
- `int posNino1, posNino2, posNino3`: Posiciones de los tres niños.
- `int intentos`: Contador de intentos realizados.
- `int encontrados`: Contador de niños encontrados.
- `boolean nervioso1, nervioso2, nervioso3`: Estado de nerviosismo de cada niño.

#### Función Principal (`main`):
1. **Inicialización de Posiciones**: Se generan posiciones aleatorias para los niños, sin repetir.
2. **Introducción**: Se muestran los posibles lugares donde pueden estar escondidos los niños.
3. **Bucle de Búsqueda**: Mientras queden intentos y no se hayan encontrado a todos los niños:
   - **Delatar Posición**: Si el intento es par, se delata la posición de algún niño nervioso.
   - **Cambio de Posición**: En el turno correspondiente, los niños intercambian posiciones.
   - **Búsqueda**: El jugador busca en una ubicación ingresada:
     - Si encuentra a un niño, se incrementa el contador de encontrados.
     - Si no, se muestra un mensaje de que no hay nadie.
   - Se muestran los intentos y niños encontrados hasta el momento.
4. **Resultado Final**: Se muestra el resultado del juego.

#### Funciones Auxiliares:
- **`obtenerPosicionAleatoria`**: Genera una posición aleatoria distinta de las ya asignadas.
- **`delatarPosicion`**: Determina si algún niño se pone nervioso y delata su posición.
- **`intercambiarUbicacion`**: Intercambia las posiciones de los niños aleatoriamente.
- **`buscarNino`**: Verifica si el niño está en la posición buscada.
- **`checkBusqueda`**: Realiza la comprobación final de la búsqueda.

### Pregunta 4:

### Agregar la probabilidad de que un niño se ponga nervioso y haga un ruido que delate su posición antes de cada turno par (5%)

- Impedir que el usuario ingrese un número mayor a 6 o menor que 1, y reiniciar el programa en caso de ingreso incorrecto.
- Extensiones mencionadas previamente en el enunciado del examen.

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
            int busqueda = scanner.nextInt();
            
            // Validación de entrada
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
```

### Explicación de las Extensiones

1. **Validación de Entrada**:
   - Se verifica que el número ingresado por el usuario esté entre 1 y 6. En caso contrario, el programa se reinicia.

2. **Extensiones Previamente Solicitadas**:
   - **Delatar Posiciones**: Si el intento es par, y con una probabilidad del 5%, se delata la posición de los niños nerviosos.
   - **Intercambio de Posiciones**: En el turno 7, los niños pueden intercambiar posiciones con una probabilidad del 30%.

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
