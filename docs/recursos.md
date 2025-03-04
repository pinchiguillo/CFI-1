# Recursos y Suministros

El módulo **Recursos y Suministros** es esencial en el proyecto **Misión Espacial Cronos**, ya que se encarga de gestionar y analizar el consumo de recursos vitales (como agua, comida y oxígeno). Este módulo permite calcular el consumo total, predecir el consumo futuro mediante un modelo de crecimiento compuesto, verificar si el nivel actual del recurso está por debajo de un umbral seguro y calcular estadísticas (promedio, mínimo y máximo) a partir de datos de consumo.

## Funcionalidades Principales

- **Calcular Consumo Total:**  
  Permite obtener el consumo total multiplicando el consumo diario por el número de días transcurridos.

- **Predicción del Consumo Futuro:**  
  Proyecta el consumo futuro utilizando una tasa de crecimiento diaria. Esto es útil para planificar y prever las necesidades de recursos en periodos futuros.

- **Alertas de Nivel Crítico:**  
  Verifica si el nivel actual de un recurso es inferior a un umbral seguro, permitiendo activar alertas para evitar situaciones críticas.

- **Cálculo de Estadísticas:**  
  A partir de un conjunto de consumos, se calculan estadísticas básicas como el promedio, el consumo mínimo y el máximo, lo que ayuda a obtener una visión global del uso de recursos.

## Descripción de Métodos

### `calcularConsumo(double consumoDiario, int dias)`

- **Propósito:**  
  Calcula el consumo total de un recurso en función de un consumo diario y la cantidad de días.
- **Parámetros:**
    - `consumoDiario`: Consumo diario del recurso.
    - `dias`: Número de días.
- **Retorno:**
    - El consumo total (tipo `double`).

### `predecirConsumoFuturo(double consumoActual, int diasFuturos, double tasaCrecimiento)`

- **Propósito:**  
  Predice el consumo futuro aplicando un modelo de crecimiento compuesto.
- **Parámetros:**
    - `consumoActual`: Consumo actual del recurso.
    - `diasFuturos`: Número de días para los que se desea predecir el consumo.
    - `tasaCrecimiento`: Tasa de crecimiento diaria (por ejemplo, 0.05 para un 5%).
- **Retorno:**
    - El consumo futuro predicho (tipo `double`).

### `alertaNivelCritico(double nivelActual, double umbralSeguro)`

- **Propósito:**  
  Determina si el nivel actual de un recurso está por debajo de un umbral seguro.
- **Parámetros:**
    - `nivelActual`: Nivel actual del recurso.
    - `umbralSeguro`: Nivel mínimo seguro.
- **Retorno:**
    - `true` si el nivel es inferior al umbral seguro; `false` en caso contrario.

### `calcularEstadisticas(double[] consumos)`

- **Propósito:**  
  Calcula estadísticas básicas (promedio, mínimo y máximo) a partir de un arreglo de consumos.
- **Parámetros:**
    - `consumos`: Arreglo de consumos.
- **Retorno:**
    - Un objeto de la clase interna `Stats` que contiene el promedio, el valor mínimo y el valor máximo.

## Clase Interna `Stats`

La clase `Stats` se utiliza para almacenar y representar las estadísticas calculadas:
- **Atributos:**
    - `promedio`: Promedio de los consumos.
    - `min`: Valor mínimo encontrado.
    - `max`: Valor máximo encontrado.
- **Métodos:**
    - Getters para cada atributo.
    - `toString()`: Retorna una cadena formateada con las estadísticas.

## Ejemplo de Uso

```java
RecursosSuministros recursos = new RecursosSuministros();

// Calcular consumo total para un recurso con 10 unidades diarias durante 7 días
double consumoTotal = recursos.calcularConsumo(10, 7);
System.out.println("Consumo Total: " + consumoTotal);

// Predecir consumo futuro con una tasa de crecimiento del 5% para 10 días
double consumoFuturo = recursos.predecirConsumoFuturo(100, 10, 0.05);
System.out.println("Consumo Futuro: " + consumoFuturo);

// Verificar alerta si el nivel actual es inferior al umbral seguro
boolean alerta = recursos.alertaNivelCritico(50, 100);
System.out.println("Alerta de Nivel Crítico: " + alerta);

// Calcular estadísticas a partir de un conjunto de consumos
double[] consumos = {50, 70, 90, 100, 80};
RecursosSuministros.Stats stats = recursos.calcularEstadisticas(consumos);
System.out.println("Estadísticas: " + stats.toString());
