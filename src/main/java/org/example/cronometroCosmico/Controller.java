package org.example.cronometroCosmico;

public class Controller {

    // Constantes para la conversión de tiempo en la Tierra
    public static final double EARTH_SECONDS_PER_MINUTE = 60.0;
    public static final double EARTH_MINUTES_PER_HOUR = 60.0;
    public static final double EARTH_HOURS_PER_DAY = 24.0;
    public static final double EARTH_DAYS_PER_YEAR = 365.0;

    // Constantes para la conversión en el nuevo planeta (valores asumidos)
    public static final double NEW_PLANET_HOURS_PER_DAY = 30.0;
    public static final double NEW_PLANET_DAYS_PER_YEAR = 400.0;

    /**
     * Convierte un número de segundos en una representación completa
     * tanto para el tiempo terrestre como para el del nuevo planeta, utilizando la clase Model.
     *
     * @param segundos Cantidad de segundos a convertir. Debe ser no negativo.
     * @return Objeto Model con las conversiones correspondientes.
     * @throws IllegalArgumentException si segundos es negativo.
     */
    public Model convertirTiempo(long segundos) {
        if (segundos < 0) {
            throw new IllegalArgumentException("El número de segundos no puede ser negativo.");
        }

        // La Controller crea y utiliza un objeto Model para almacenar los resultados.
        Model model = new Model();

        // Conversión para la Tierra
        model.earthSeconds = segundos;
        model.earthMinutes = segundos / EARTH_SECONDS_PER_MINUTE;
        model.earthHours   = model.earthMinutes / EARTH_MINUTES_PER_HOUR;
        model.earthDays    = model.earthHours / EARTH_HOURS_PER_DAY;
        model.earthYears   = model.earthDays / EARTH_DAYS_PER_YEAR;

        // Conversión para el nuevo planeta
        // Se asume que los segundos y minutos se mantienen iguales.
        model.planetSeconds = segundos;
        model.planetMinutes = segundos / EARTH_SECONDS_PER_MINUTE;
        // Para las horas se usa la conversión base (3600 segundos por hora),
        // luego se redefine el día y el año según las características del planeta.
        model.planetHours = segundos / 3600.0;
        model.planetDays  = model.planetHours / NEW_PLANET_HOURS_PER_DAY;
        model.planetYears = model.planetDays / NEW_PLANET_DAYS_PER_YEAR;

        return model;
    }

    /**
     * Retorna una cadena con los límites de representación de algunos tipos de datos.
     *
     * @return Cadena con los límites de Integer, Long, Float y Double.
     */
    public String obtenerLimites() {
        StringBuilder sb = new StringBuilder();
        sb.append("Límites de Representación de Datos:\n");
        sb.append("  Integer: MIN = " + Integer.MIN_VALUE + ", MAX = " + Integer.MAX_VALUE + "\n");
        sb.append("  Long:    MIN = " + Long.MIN_VALUE + ", MAX = " + Long.MAX_VALUE + "\n");
        sb.append("  Float:   MIN = " + (-Float.MAX_VALUE) + ", MAX = " + Float.MAX_VALUE + "\n");
        sb.append("  Double:  MIN = " + (-Double.MAX_VALUE) + ", MAX = " + Double.MAX_VALUE + "\n");
        return sb.toString();
    }
}
