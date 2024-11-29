### (a) Intervalos de crecimiento y decrecimiento

1. **Derivada de \( F(x) \)**:
   \[
   F(x) = x \sqrt{6 - x}
   \]
   Usamos la regla del producto y la regla de la cadena:
   \[
   F'(x) = \frac{d}{dx} \left( x \sqrt{6 - x} \right) = \sqrt{6 - x} + x \left( \frac{-1}{2 \sqrt{6 - x}} \right)
   \]
   Simplificando:
   \[
   F'(x) = \sqrt{6 - x} - \frac{x}{2 \sqrt{6 - x}}
   \]
   \[
   F'(x) = \frac{2(6 - x) - x}{2 \sqrt{6 - x}} = \frac{12 - 3x}{2 \sqrt{6 - x}}
   \]

2. **Encontrar los puntos críticos**:
   \[
   F'(x) = 0 \implies \frac{12 - 3x}{2 \sqrt{6 - x}} = 0 \implies 12 - 3x = 0 \implies x = 4
   \]

3. **Intervalos de crecimiento y decrecimiento**:
   - Para \( x \in (0, 4) \), \( F'(x) > 0 \), la función crece.
   - Para \( x \in (4, 6) \), \( F'(x) < 0 \), la función decrece.

### (b) Valores máximos y mínimos locales

El valor crítico encontrado es \( x = 4 \). Evaluamos la función en este punto:
\[
F(4) = 4 \sqrt{6 - 4} = 4 \sqrt{2}
\]
Entonces, \( (4, 4 \sqrt{2}) \) es un máximo local porque la derivada cambia de positiva a negativa en \( x = 4 \).

### (c) Intervalos de concavidad y puntos de inflexión

1. **Segunda derivada de \( F(x) \)**:
   \[
   F''(x) = \frac{d}{dx} \left( \frac{12 - 3x}{2 \sqrt{6 - x}} \right)
   \]
   Aplicamos la regla del cociente y simplificamos:
   \[
   F''(x) = \frac{(3 (6 - x)^{1/2} - (12 - 3x)(-1/2)(6 - x)^{-1/2})}{4 (6 - x)}
   \]
   \[
   F''(x) = \frac{36 - 6x + 18 - 9x}{4(6 - x)^{3/2}} = \frac{18 - 15x}{4 (6 - x)^{3/2}}
   \]

2. **Concavidad y puntos de inflexión**:
   - \( F''(x) = 0 \implies 18 - 15x = 0 \implies x = 6/5 \)
   - Intervalos de concavidad:
     - Para \( x \in (0, 6/5) \), \( F''(x) > 0 \), la función es cóncava hacia arriba.
     - Para \( x \in (6/5, 6) \), \( F''(x) < 0 \), la función es cóncava hacia abajo.

### (d) Graficar la función

Usando la información:
- Crece en \( (0, 4) \)
- Decrece en \( (4, 6) \)
- Máximo local en \( x = 4 \)
- Cóncava hacia arriba en \( (0, 6/5) \)
- Cóncava hacia abajo en \( (6/5, 6) \)

Podemos esbozar la gráfica aproximada. Aquí tienes un bosquejo:

```
  y
  |        ______
  |       /      \
  |      /        \
  |     /          \
  |    /            \
  |___/______________\___________ x
     0   6/5    4     6
```