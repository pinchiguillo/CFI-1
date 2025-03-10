package org.example.sistemaAlerta;

public class SistemaAlertaModel {

    private final double umbralRadiacion;
    private final double umbralTemperaturaMin;
    private final double umbralTemperaturaMax;
    private final double umbralPresionMin;
    private final double umbralPresionMax;

    public SistemaAlertaModel() {
        // Default threshold values
        this.umbralRadiacion = 100.0;
        this.umbralTemperaturaMin = -20.0;
        this.umbralTemperaturaMax = 50.0;
        this.umbralPresionMin = 90.0;
        this.umbralPresionMax = 110.0;
    }

    public double getUmbralRadiacion() {
        return umbralRadiacion;
    }

    public double getUmbralTemperaturaMin() {
        return umbralTemperaturaMin;
    }

    public double getUmbralTemperaturaMax() {
        return umbralTemperaturaMax;
    }

    public double getUmbralPresionMin() {
        return umbralPresionMin;
    }

    public double getUmbralPresionMax() {
        return umbralPresionMax;
    }
}
