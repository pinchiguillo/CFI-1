package org.example.recursos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecursosSuministrosTest {

    @Test
    public void testCalcularConsumo() {
        RecursosSuministros recursos = new RecursosSuministros();
        double consumo = recursos.calcularConsumo(10.5, 5);
        // Se espera que 10.5 * 5 = 52.5
        assertEquals(52.5, consumo, 0.001);
    }

    @Test
    public void testPredecirConsumoFuturo() {
        RecursosSuministros recursos = new RecursosSuministros();
        double consumoActual = 100;
        int diasFuturos = 7;
        double tasaCrecimiento = 0.05; // 5% de crecimiento diario
        double consumoFuturo = recursos.predecirConsumoFuturo(consumoActual, diasFuturos, tasaCrecimiento);
        double esperado = 100 * Math.pow(1.05, 7);
        assertEquals(esperado, consumoFuturo, 0.001);
    }

    @Test
    public void testAlertaNivelCritico() {
        RecursosSuministros recursos = new RecursosSuministros();
        // Se espera alerta si el nivel actual (50) es menor que el umbral seguro (100)
        assertTrue(recursos.alertaNivelCritico(50, 100));
        // No debe haber alerta si el nivel actual (150) es mayor que el umbral seguro (100)
        assertFalse(recursos.alertaNivelCritico(150, 100));
    }

    @Test
    public void testCalcularEstadisticas() {
        RecursosSuministros recursos = new RecursosSuministros();
        double[] consumos = {50, 70, 90, 100, 80};
        RecursosSuministros.Stats stats = recursos.calcularEstadisticas(consumos);
        // Promedio esperado: (50+70+90+100+80) / 5 = 78
        assertEquals(78, stats.getPromedio(), 0.001);
        assertEquals(50, stats.getMin(), 0.001);
        assertEquals(100, stats.getMax(), 0.001);
    }
}
