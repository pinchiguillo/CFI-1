package org.example.cronometroCosmico;

public class Model {
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
