package org.example.cronometroCosmico;

public class CronometroCosmico {

    // Constantes para la conversión de tiempo en la Tierra
    public static final double EARTH_SECONDS_PER_MINUTE = 60.0;
    public static final double EARTH_MINUTES_PER_HOUR = 60.0;
    public static final double EARTH_HOURS_PER_DAY = 24.0;
    public static final double EARTH_DAYS_PER_YEAR = 365.0;

    // Constantes para la conversión en el nuevo planeta (valores asumidos)
    public static final double NEW_PLANET_HOURS_PER_DAY = 30.0;
    public static final double NEW_PLANET_DAYS_PER_YEAR = 400.0;

    /**
     * Clase interna para representar la conversión de tiempo tanto en la Tierra
     * como en el nuevo planeta.
     */
    public static class TimeRepresentation {
        // Representación en la Tierra
        public long earthSeconds;
        public double earthMinutes;
        public double earthHours;
        public double earthDays;
        public double earthYears;

        // Representación en el nuevo planeta
        public long planetSeconds;
        public double planetMinutes;
        public double planetHours;
        public double planetDays;
        public double planetYears;

        @Override
        public String toString() {
            return "Tiempo en la Tierra:\n" +
                    "  Segundos: " + earthSeconds + "\n" +
                    "  Minutos: " + earthMinutes + "\n" +
                    "  Horas: " + earthHours + "\n" +
                    "  Días: " + earthDays + "\n" +
                    "  Años: " + earthYears + "\n" +
                    "Tiempo en el nuevo planeta:\n" +
                    "  Segundos: " + planetSeconds + "\n" +
                    "  Minutos: " + planetMinutes + "\n" +
                    "  Horas: " + planetHours + "\n" +
                    "  Días: " + planetDays + "\n" +
                    "  Años: " + planetYears;
        }
    }

    /**
     * Convierte un número de segundos en una representación completa
     * tanto para el tiempo terrestre como para el del nuevo planeta.
     *
     * @param segundos Cantidad de segundos a convertir. Debe ser no negativo.
     * @return Objeto TimeRepresentation con las conversiones correspondientes.
     * @throws IllegalArgumentException si segundos es negativo.
     */
    public TimeRepresentation convertirTiempo(long segundos) {
        if (segundos < 0) {
            throw new IllegalArgumentException("El número de segundos no puede ser negativo.");
        }

        TimeRepresentation tr = new TimeRepresentation();

        // Conversión para la Tierra
        tr.earthSeconds = segundos;
        tr.earthMinutes = segundos / EARTH_SECONDS_PER_MINUTE;
        tr.earthHours   = tr.earthMinutes / EARTH_MINUTES_PER_HOUR;
        tr.earthDays    = tr.earthHours / EARTH_HOURS_PER_DAY;
        tr.earthYears   = tr.earthDays / EARTH_DAYS_PER_YEAR;

        // Conversión para el nuevo planeta
        // Se asume que segundos y minutos se mantienen iguales
        tr.planetSeconds = segundos;
        tr.planetMinutes = segundos / EARTH_SECONDS_PER_MINUTE;
        // Para las horas se usa la conversión base (3600 segundos por hora),
        // pero luego se redefinen el día y el año según las características del planeta.
        tr.planetHours = segundos / 3600.0;
        tr.planetDays  = tr.planetHours / NEW_PLANET_HOURS_PER_DAY;
        tr.planetYears = tr.planetDays / NEW_PLANET_DAYS_PER_YEAR;

        return tr;
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
