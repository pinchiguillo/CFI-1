# Planificador de Tareas

El módulo **Planificador de Tareas** es una parte clave del proyecto **Misión Espacial Cronos**. Su función es organizar y distribuir las tareas diarias de la tripulación de manera eficiente, garantizando un balance óptimo en la carga de trabajo. Para lograrlo, se emplea un algoritmo greedy que asigna cada tarea al miembro con menor carga acumulada.

## Funcionalidades Principales

- **Cálculo de Carga Total de Trabajo:**  
  El método `calcularCargaTrabajo` suma los valores de las tareas para determinar la carga total, lo que permite tener una visión global del trabajo a distribuir.

- **Distribución de Tareas:**  
  El método `distribuirTareas` toma un arreglo de tareas (representado por enteros que indican la carga de cada tarea) y una lista de nombres de tripulantes. Utilizando un algoritmo greedy, asigna cada tarea al tripulante que, en ese momento, tenga la menor carga acumulada.

- **Cálculo de Carga por Tripulante:**  
  Con el método `calcularCargaPorTripulante`, se genera un mapa que muestra la carga total asignada a cada tripulante, facilitando el análisis y balanceo de las tareas.

## Descripción de los Métodos

### `calcularCargaTrabajo(int[] tareas)`

- **Propósito:**  
  Sumar todos los valores del arreglo `tareas` para obtener la carga total de trabajo.
- **Parámetros:**
    - `tareas`: Un arreglo de enteros que representa la carga de cada tarea.
- **Retorno:**
    - La suma total de las cargas de trabajo (tipo `int`).

### `distribuirTareas(int[] tareas, List<String> nombresTripulantes)`

- **Propósito:**  
  Distribuir de forma equitativa las tareas entre los tripulantes utilizando un algoritmo greedy. Cada tarea se asigna al tripulante con la menor carga acumulada.
- **Parámetros:**
    - `tareas`: Arreglo de enteros que representa la carga de cada tarea.
    - `nombresTripulantes`: Lista de nombres de los tripulantes.
- **Retorno:**
    - Un mapa (`Map<String, List<Integer>>`) donde cada llave es el nombre de un tripulante y el valor es la lista de tareas asignadas.
- **Excepción:**
    - Lanza `IllegalArgumentException` si la lista de tripulantes es nula o está vacía.

### `calcularCargaPorTripulante(Map<String, List<Integer>> asignaciones)`

- **Propósito:**  
  Calcular la carga total asignada a cada tripulante a partir de las asignaciones generadas.
- **Parámetros:**
    - `asignaciones`: Mapa con la distribución de tareas por tripulante.
- **Retorno:**
    - Un mapa (`Map<String, Integer>`) que asocia a cada tripulante la suma total de las cargas de las tareas asignadas.

## Ejemplo de Uso

```java
PlanificadorTareas planificador = new PlanificadorTareas();

// Supongamos que tenemos un arreglo de tareas con cargas específicas.
int[] tareas = {10, 20, 5, 15};

// Lista de nombres de tripulantes
List<String> tripulantes = Arrays.asList("Alice", "Bob", "Carlos");

// Distribuir tareas entre los tripulantes
Map<String, List<Integer>> asignaciones = planificador.distribuirTareas(tareas, tripulantes);

// Calcular la carga total por tripulante
Map<String, Integer> cargas = planificador.calcularCargaPorTripulante(asignaciones);

// Imprimir resultados
System.out.println("Asignaciones de tareas: " + asignaciones);
System.out.println("Carga total por tripulante: " + cargas);
