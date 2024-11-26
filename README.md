### Aqui pondre las explicaciones a todas las soluciones que haga de los problemas del parcial.

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

### Explicación del Código:
1. **Variables**:
   - `posiciones`: Arreglo para almacenar las posiciones de los niños.
   - `intentos`: Contador de los intentos del usuario.
   - `encontrados`: Contador de los niños encontrados.
   - `maxIntentos`: Número máximo de intentos permitidos.

2. **Inicializar posiciones**:
   - Tres niños se esconden en posiciones aleatorias distintas.

3. **Bucle de juego**:
   - El usuario busca en una posición ingresada por consola.
   - Si hay un niño en esa posición, hay un 10% de probabilidades de que no sea encontrado.
   - Se actualizan los contadores de intentos y niños encontrados.
   - El juego termina cuando el usuario ha encontrado a los tres niños o ha agotado los intentos.

4. **Funciones auxiliares**:
   - `getLugar(int index)`: Devuelve el nombre del lugar en función del índice.
