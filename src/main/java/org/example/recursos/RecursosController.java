package org.example.recursos;

public class RecursosController {

    /**
     * Calcula el consumo total de un recurso dado un consumo diario y una cantidad de días.
     *
     * @param consumoDiario consumo diario del recurso.
     * @param dias número de días.
     * @return consumo total.
     */
    public double calcularConsumo(double consumoDiario, int dias) {
        return consumoDiario * dias;
    }

    /**
     * Predice el consumo futuro usando un modelo de crecimiento compuesto.
     *
     * @param consumoActual consumo actual del recurso.
     * @param diasFuturos cantidad de días futuros a predecir.
     * @param tasaCrecimiento tasa de crecimiento diaria (por ejemplo, 0.05 para un 5%).
     * @return consumo futuro predicho.
     */
    public double predecirConsumoFuturo(double consumoActual, int diasFuturos, double tasaCrecimiento) {
        return consumoActual * Math.pow(1 + tasaCrecimiento, diasFuturos);
    }

    /**
     * Verifica si el nivel actual de recurso está por debajo de un umbral seguro.
     *
     * @param nivelActual nivel actual del recurso.
     * @param umbralSeguro nivel mínimo seguro.
     * @return true si el nivel actual es inferior al umbral seguro; false en caso contrario.
     */
    public boolean alertaNivelCritico(double nivelActual, double umbralSeguro) {
        return nivelActual < umbralSeguro;
    }

    /**
     * Calcula estadísticas básicas (promedio, mínimo y máximo) sobre un arreglo de consumos.
     *
     * @param consumos arreglo de consumos.
     * @return objeto Stats con los valores calculados.
     */
    public Stats calcularEstadisticas(double[] consumos) {
        double suma = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double consumo : consumos) {
            suma += consumo;
            if (consumo < min) min = consumo;
            if (consumo > max) max = consumo;
        }

        double promedio = consumos.length > 0 ? suma / consumos.length : 0;
        return new Stats(promedio, min, max);
    }
}
