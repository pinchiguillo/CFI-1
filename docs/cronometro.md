# Cronómetro Cósmico

El módulo **Cronómetro Cósmico** es una parte esencial del proyecto **Misión Espacial Cronos**. Su propósito es convertir una cantidad de segundos en representaciones de tiempo tanto para la Tierra como para el nuevo planeta, considerando las diferencias en la duración de minutos, horas, días y años en cada entorno. Además, proporciona información sobre los límites de representación de algunos tipos de datos en Java.

## Funcionalidades Principales

- **Conversión de Tiempo:**  
  El método `convertirTiempo(long segundos)` toma un valor en segundos y lo convierte a minutos, horas, días y años tanto para la Tierra como para el nuevo planeta.
    - **Tierra:** Se utilizan constantes clásicas como 60 segundos por minuto, 60 minutos por hora, 24 horas por día y 365 días por año.
    - **Nuevo Planeta:** Se definen valores ajustados (por ejemplo, 30 horas por día y 400 días por año) para reflejar las características del nuevo entorno.

- **Representación del Tiempo:**  
  La clase interna `TimeRepresentation` encapsula las conversiones para ambos entornos y sobreescribe el método `toString()` para presentar la información de manera legible.

- **Límites de Representación de Datos:**  
  El método `obtenerLimites()` retorna una cadena que muestra los límites mínimos y máximos de los tipos de datos `Integer`, `Long`, `Float` y `Double` en Java, lo cual es útil para evitar errores en cálculos críticos.

## Estructura del Código

- **Constantes de Conversión:**  
  Se definen constantes para la Tierra:
    - `EARTH_SECONDS_PER_MINUTE = 60.0`
    - `EARTH_MINUTES_PER_HOUR = 60.0`
    - `EARTH_HOURS_PER_DAY = 24.0`
    - `EARTH_DAYS_PER_YEAR = 365.0`

  Y para el nuevo planeta:
    - `NEW_PLANET_HOURS_PER_DAY = 30.0`
    - `NEW_PLANET_DAYS_PER_YEAR = 400.0`

- **Clase Interna `TimeRepresentation`:**  
  Esta clase almacena:
    - Tiempo en la Tierra: segundos, minutos, horas, días y años.
    - Tiempo en el nuevo planeta: segundos, minutos, horas, días y años.

  Su método `toString()` presenta toda la información formateada en una cadena.

- **Método `convertirTiempo(long segundos)`:**  
  Convierte el número de segundos a las diferentes unidades de tiempo para ambos entornos y retorna un objeto `TimeRepresentation`.
    - Se verifica que el número de segundos no sea negativo, lanzando una excepción si lo es.

- **Método `obtenerLimites()`:**  
  Retorna una cadena que detalla los límites de representación de `Integer`, `Long`, `Float` y `Double`.

## Ejemplo de Uso

```java
CronometroCosmico cronometro = new CronometroCosmico();
CronometroCosmico.TimeRepresentation tiempo = cronometro.convertirTiempo(3600);
System.out.println(tiempo.toString());
System.out.println(cronometro.obtenerLimites());
