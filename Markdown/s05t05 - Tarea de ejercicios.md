### **1. (p → q) ∧ (q → p)**  

| p | q | p → q | q → p | (p → q) ∧ (q → p) |
|---|---|-------|-------|------------------|
| T | T |   T   |   T   |        T         |
| T | F |   F   |   T   |        F         |
| F | T |   T   |   F   |        F         |
| F | F |   T   |   T   |        T         |

**Clasificación**: **Contingencia**  

---

### **2. [p ∧ (q ∨ r)] → [(p ∧ q) ∨ (p ∧ r)]**  

| p | q | r | q ∨ r | p ∧ (q ∨ r) | p ∧ q | p ∧ r | (p ∧ q) ∨ (p ∧ r) | [p ∧ (q ∨ r)] → [(p ∧ q) ∨ (p ∧ r)] |
|---|---|---|-------|-------------|-------|-------|------------------|----------------------------------|
| T | T | T |   T   |      T      |   T   |   T   |        T         |               T                  |
| T | T | F |   T   |      T      |   T   |   F   |        T         |               T                  |
| T | F | T |   T   |      T      |   F   |   T   |        T         |               T                  |
| T | F | F |   F   |      F      |   F   |   F   |        F         |               T                  |
| F | T | T |   T   |      F      |   F   |   F   |        F         |               T                  |
| F | T | F |   T   |      F      |   F   |   F   |        F         |               T                  |
| F | F | T |   T   |      F      |   F   |   F   |        F         |               T                  |
| F | F | F |   F   |      F      |   F   |   F   |        F         |               T                  |

**Clasificación**: **Tautología**  

---

### **3. (p ∨ ¬q) → q**  

| p | q | ¬q | p ∨ ¬q | (p ∨ ¬q) → q |
|---|---|----|-------|--------------|
| T | T |  F |   T   |      T       |
| T | F |  T |   T   |      F       |
| F | T |  F |   F   |      T       |
| F | F |  T |   T   |      F       |

**Clasificación**: **Contingencia**  

---

### **4. p → (p ∨ q)**  

| p | q | p ∨ q | p → (p ∨ q) |
|---|---|-------|------------|
| T | T |   T   |     T      |
| T | F |   T   |     T      |
| F | T |   T   |     T      |
| F | F |   F   |     T      |

**Clasificación**: **Tautología**  

---

### **5. (p ∧ q) → p**  

| p | q | p ∧ q | (p ∧ q) → p |
|---|---|------|-------------|
| T | T |  T   |      T      |
| T | F |  F   |      T      |
| F | T |  F   |      T      |
| F | F |  F   |      T      |

**Clasificación**: **Tautología**  

---

### **6. (p ∧ q) → (p ∧ q)**  

| p | q | p ∧ q | (p ∧ q) → (p ∧ q) |
|---|---|------|-------------------|
| T | T |  T   |         T         |
| T | F |  F   |         T         |
| F | T |  F   |         T         |
| F | F |  F   |         T         |

**Clasificación**: **Tautología**  

---

### **7. [(p → q) ∨ (r → s)] → [(p ∨ r) → (q ∨ s)]**  

| p | q | r | s | p → q | r → s | (p → q) ∨ (r → s) | p ∨ r | q ∨ s | (p ∨ r) → (q ∨ s) | [(p → q) ∨ (r → s)] → [(p ∨ r) → (q ∨ s)] |
|---|---|---|---|-------|-------|------------------|-------|-------|------------------|----------------------------------|
| T | T | T | T |   T   |   T   |        T         |   T   |   T   |        T         |               T                  |
| T | T | T | F |   T   |   F   |        T         |   T   |   T   |        T         |               T                  |
| T | T | F | T |   T   |   T   |        T         |   T   |   T   |        T         |               T                  |
| T | T | F | F |   T   |   T   |        T         |   T   |   T   |        T         |               T                  |
| T | F | T | T |   F   |   T   |        T         |   T   |   T   |        T         |               T                  |
| T | F | T | F |   F   |   F   |        F         |   T   |   F   |        F         |               F                  |
| T | F | F | T |   F   |   T   |        T         |   T   |   T   |        T         |               T                  |
| T | F | F | F |   F   |   T   |        T         |   T   |   F   |        F         |               F                  |
| F | T | T | T |   T   |   T   |        T         |   T   |   T   |        T         |               T                  |
| F | T | T | F |   T   |   F   |        T         |   T   |   T   |        T         |               T                  |
| F | T | F | T |   T   |   T   |        T         |   F   |   T   |        T         |               T                  |
| F | T | F | F |   T   |   T   |        T         |   F   |   T   |        T         |               T                  |
| F | F | T | T |   T   |   T   |        T         |   T   |   T   |        T         |               T                  |
| F | F | T | F |   T   |   F   |        T         |   T   |   F   |        F         |               F                  |
| F | F | F | T |   T   |   T   |        T         |   F   |   T   |        T         |               T                  |
| F | F | F | F |   T   |   T   |        T         |   F   |   F   |        T         |               T                  |

**Clasificación**: **Contingencia**  

---

### Resumen de los resultados:
| Proposición | Clasificación |
|-------------|--------------|
| a) (p → q) ∧ (q → p)) | Contingencia |
| b) [p ∧ (q ∨ r)] → [(p ∧ q) ∨ (p ∧ r)] | Tautología |
| c) (p ∨ ¬q) → q | Contingencia |
| d) p → (p ∨ q) | Tautología |
| e) (p ∧ q) → p  | Tautología |
| f) (p ∧ q) → (p ∧ q) | Tautología |
| g) [(p → q) ∨ (r → s)] → [(p ∨ r) → (q ∨ s)] | Contingencia |
