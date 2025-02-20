### Tablas de verdad de operadores lógicos

1. **Negación:**
    ```markdown
    | p | ¬p |
    |---|----|
    | 1 |  0 |
    | 0 |  1 |
    ```

2. **Conjunción:**
    ```markdown
    | p | q | p ∧ q |
    |---|---|-------|
    | 1 | 1 |   1   |
    | 1 | 0 |   0   |
    | 0 | 1 |   0   |
    | 0 | 0 |   0   |
    ```

3. **Disyunción:**
    ```markdown
    | p | q | p ∨ q |
    |---|---|-------|
    | 1 | 1 |   1   |
    | 1 | 0 |   1   |
    | 0 | 1 |   1   |
    | 0 | 0 |   0   |
    ```

4. **Disyunción exclusiva:**
    ```markdown
    | p | q | p ⊕ q |
    |---|---|-------|
    | 1 | 1 |   0   |
    | 1 | 0 |   1   |
    | 0 | 1 |   1   |
    | 0 | 0 |   0   |
    ```

5. **Condicional:**
    ```markdown
    | p | q | p → q |
    |---|---|-------|
    | 1 | 1 |   1   |
    | 1 | 0 |   0   |
    | 0 | 1 |   1   |
    | 0 | 0 |   1   |
    ```

6. **Bicondicional:**
    ```markdown
    | p | q | p ↔ q |
    |---|---|-------|
    | 1 | 1 |   1   |
    | 1 | 0 |   0   |
    | 0 | 1 |   0   |
    | 0 | 0 |   1   |
    ```

### Reglas de inferencia

1. **Modus Ponens:**
    ```markdown
    | p → q, p |
    |--------|
    |  ∴ q  |
    ```

2. **Modus Tollens:**
    ```markdown
    | p → q, ¬q |
    |--------|
    |  ∴ ¬p |
    ```

3. **Silogismo Disyuntivo:**
    ```markdown
    | p ∨ q, ¬p |
    |--------|
    |  ∴ q  |
    ```

4. **Introducción de la conjunción:**
    ```markdown
    | p, q |
    |------|
    | ∴ p ∧ q |
    ```

5. **Introducción de la disyunción:**
    ```markdown
    | p |
    |---|
    | ∴ p ∨ q |
    ```