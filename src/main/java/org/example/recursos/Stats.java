package org.example.recursos;

public class Stats {
    private double promedio;
    private double min;
    private double max;

    public Stats(double promedio, double min, double max) {
        this.promedio = promedio;
        this.min = min;
        this.max = max;
    }

    public double getPromedio() {
        return promedio;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "promedio=" + promedio +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
