### Aqui pondre las explicaciones a todas las soluciones que haga de los problemas del parcial

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
