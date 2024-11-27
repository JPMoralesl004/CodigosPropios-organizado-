### Escondite

### Código Masias:

1. **Inicialización y Aleatorización:**
   - Usa `definePlace` para asignar posiciones a los niños.
   - Definir el estado inicial con `VISIBLE` y `PLACES`.

2. **Ciclo principal:**
   - Usa un ciclo `while` para iterar los turnos.
   - En cada turno, los niños pueden ponerse nerviosos (`nervous`).
   - El usuario adivina la posición y se llama a `lookAt` para verificar si ha encontrado a un niño.
   - El juego continúa hasta que se encuentran todos los niños o se alcanzan 12 turnos.

3. **Métodos auxiliares:**
   - `definePlace`: Define las posiciones de los niños, asegurándose de que no se repitan.
   - `lookAt`: Verifica si la adivinanza del usuario es correcta.
   - `nervous`: Imprime mensajes si los niños se ponen nerviosos.
   - `countHistory`: Muestra el estado de los niños después de cada turno.

### Mi código:

1. **Inicialización y Aleatorización:**
   - Usa un array `posiciones` para representar las ubicaciones.
   - Aleatoriza las posiciones de los niños al inicio.

2. **Ciclo principal:**
   - Usa un ciclo `while` similar para iterar los turnos.
   - Los niños pueden hacer ruido (`delatarPosicion`) en ciertos turnos.
   - Intercambia posiciones de los niños en un turno específico (`intercambiarUbicacion`).
   - El usuario adivina la posición y se verifica si ha encontrado a un niño.

3. **Métodos auxiliares:**
   - `delatarPosicion`: Imprime mensajes si los niños hacen ruido.
   - `intercambiarUbicacion`: Intercambia las posiciones de los niños en ciertos turnos.
   - `getLugar`: Devuelve el nombre de la posición según el índice.

### Comparación

1. **Similitudes:**
   - Ambos códigos siguen una estructura similar de inicialización, ciclo principal y verificación de adivinanzas.
   - Ambos usan aleatorización para determinar las posiciones de los niños.
   - Incluyen mensajes para hacer el juego más interactivo.

2. **Diferencias:**
   - Tu código usa arrays (`posiciones` y `nervioso`), mientras que el del profesor usa variables individuales (`boyOne`, `boyTwo`, `boyThree`).
   - Tu implementación incluye una mecánica adicional de intercambio de posiciones (`intercambiarUbicacion`).
   - Los métodos auxiliares son diferentes en ambos códigos: tu código tiene métodos específicos para hacer ruido e intercambiar posiciones, mientras que el del profesor se centra en contar la historia y la visibilidad.
   - Tu código usa una probabilidad fija para determinar si los niños son encontrados o hacen ruido, mientras que el código del profesor usa condiciones basadas en turnos y la visibilidad.
