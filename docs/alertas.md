# Sistema de Alerta y Monitoreo

El módulo **Sistema de Alerta y Monitoreo** es crucial para la misión **Cronos**, ya que se encarga de supervisar las variables ambientales críticas y detectar eventos inusuales en el entorno espacial. Este módulo permite:

- Monitorear los niveles de radiación, temperatura y presión.
- Detectar eventos raros, representados mediante la generación de números primos.
- Descomponer números en factores primos para facilitar el análisis de problemas complejos.

## Funcionalidades Principales

### Monitoreo Ambiental

- **`revisarRadiacion(double nivelRadiacion)`**  
  Verifica si el nivel de radiación supera el umbral seguro (100.0).
    - Retorna `true` si el nivel es superior; `false` en caso contrario.

- **`revisarTemperatura(double temperatura)`**  
  Comprueba si la temperatura está fuera del rango seguro (menos de -20.0 o mayor a 50.0).
    - Retorna `true` si la temperatura se encuentra fuera del rango; `false` si está dentro.

- **`revisarPresion(double presion)`**  
  Evalúa si la presión está fuera del rango seguro (menos de 90.0 o más de 110.0).
    - Retorna `true` si la presión es crítica; `false` en caso contrario.

### Detección de Eventos Raros

- **`obtenerEventosRaros(int n)`**  
  Genera y retorna una lista con los _n_ primeros números primos, que se interpretan como eventos raros o críticos.
    - Lanza una excepción si el parámetro _n_ es menor o igual a cero.

### Análisis de Factores Primos

- **`descomponerEnFactoresPrimos(int numero)`**  
  Descompone un número en sus factores primos para simplificar el análisis de problemas complejos.
    - Lanza una excepción si el número es menor o igual a 1.

## Ejemplo de Uso

```java
SistemaAlerta alerta = new SistemaAlerta();

// Verificar si la radiación es crítica
boolean radiacionCritica = alerta.revisarRadiacion(120.0);
System.out.println("Radiación Crítica: " + radiacionCritica);

// Verificar si la temperatura es crítica
boolean temperaturaCritica = alerta.revisarTemperatura(60.0);
System.out.println("Temperatura Crítica: " + temperaturaCritica);

// Verificar si la presión es crítica
boolean presionCritica = alerta.revisarPresion(85.0);
System.out.println("Presión Crítica: " + presionCritica);

// Obtener 5 eventos raros (números primos)
List<Integer> eventosRaros = alerta.obtenerEventosRaros(5);
System.out.println("Eventos Raros: " + eventosRaros);

// Descomponer el número 84 en factores primos
List<Integer> factores = alerta.descomponerEnFactoresPrimos(84);
System.out.println("Factores Primos de 84: " + factores);
