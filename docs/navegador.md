# Navegador Estelar

El módulo **Navegador Estelar** es responsable de la planificación y optimización de rutas para la exploración y expansión de la base en el nuevo planeta. Para ello, utiliza el concepto de matrices para simular terrenos y calcular rutas óptimas a partir de diferentes factores (como consumo de recursos o tiempo).

## Funcionalidades Principales

### Multiplicación de Matrices

- **`multiplicarMatrices(int[][] a, int[][] b)`**
    - **Propósito:**  
      Multiplica dos matrices y retorna la matriz resultante. Esta operación es fundamental para combinar la información del terreno con factores de influencia y, de esta forma, optimizar las rutas.
    - **Validaciones:**
        - Verifica que ninguna de las matrices sea `null`.
        - Comprueba que el número de columnas de la primera matriz coincida con el número de filas de la segunda matriz, lanzando una excepción si no se cumple.
    - **Uso:**  
      Este método es la base para la optimización de rutas y se utiliza internamente en el método `optimizarRuta`.

### Simulación de Terreno

- **`simularTerreno(int filas, int columnas)`**
    - **Propósito:**  
      Genera una matriz que representa un terreno, donde cada celda contiene un valor aleatorio entre 1 y 10. Este valor simboliza el "costo" o dificultad de desplazarse por esa zona.
    - **Uso:**  
      Permite simular diferentes escenarios del terreno, facilitando la planificación de rutas según las dificultades de cada área.

### Optimización de Rutas

- **`optimizarRuta(int[][] terreno, int[][] factores)`**
    - **Propósito:**  
      Combina la matriz que representa el terreno con una matriz de factores (que puede incluir variables como consumo de recursos o tiempo) a través de la multiplicación de matrices. El resultado es una matriz que representa la ruta optimizada.
    - **Uso:**  
      Facilita la toma de decisiones sobre la mejor ruta de exploración y expansión, ayudando a conservar recursos y tiempo.

## Ejemplo de Uso

```java
NavegadorEstelar navegador = new NavegadorEstelar();

// Simular un terreno de 5 filas y 5 columnas
int[][] terreno = navegador.simularTerreno(5, 5);
System.out.println("Terreno simulado:");
for (int[] fila : terreno) {
    System.out.println(Arrays.toString(fila));
}

// Definir una matriz de factores (por ejemplo, matriz identidad para no alterar los valores)
int[][] factores = {
    {1, 0, 0, 0, 0},
    {0, 1, 0, 0, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 0, 1, 0},
    {0, 0, 0, 0, 1}
};

// Optimizar la ruta multiplicando el terreno por la matriz de factores
int[][] rutaOptima = navegador.optimizarRuta(terreno, factores);
System.out.println("Ruta optimizada:");
for (int[] fila : rutaOptima) {
    System.out.println(Arrays.toString(fila));
}
