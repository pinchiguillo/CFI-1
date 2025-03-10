package org.example.recursos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecursosControllerTest {

    private final RecursosController controller = new RecursosController();

    @Test
    public void testCalcularConsumo() {
        double consumoDiario = 10.0;
        int dias = 5;
        double consumoTotal = controller.calcularConsumo(consumoDiario, dias);
        assertEquals(50.0, consumoTotal, 0.0001);
    }

    @Test
    public void testPredecirConsumoFuturo() {
        double consumoActual = 100.0;
        int diasFuturos = 3;
        double tasaCrecimiento = 0.05; // 5% diaria
        double consumoFuturo = controller.predecirConsumoFuturo(consumoActual, diasFuturos, tasaCrecimiento);

        // Expected: 100 * (1 + 0.05)^3
        double expected = 100.0 * Math.pow(1.05, 3);
        assertEquals(expected, consumoFuturo, 0.0001);
    }

    @Test
    public void testAlertaNivelCriticoWhenBelowThreshold() {
        double nivelActual = 20.0;
        double umbralSeguro = 25.0;
        boolean alerta = controller.alertaNivelCritico(nivelActual, umbralSeguro);
        assertTrue(alerta);
    }

    @Test
    public void testAlertaNivelCriticoWhenAboveThreshold() {
        double nivelActual = 30.0;
        double umbralSeguro = 25.0;
        boolean alerta = controller.alertaNivelCritico(nivelActual, umbralSeguro);
        assertFalse(alerta);
    }

    @Test
    public void testCalcularEstadisticas() {
        double[] consumos = {10.0, 20.0, 30.0, 40.0};
        Stats stats = controller.calcularEstadisticas(consumos);
        double expectedPromedio = (10.0 + 20.0 + 30.0 + 40.0) / 4;
        double expectedMin = 10.0;
        double expectedMax = 40.0;

        assertEquals(expectedPromedio, stats.getPromedio(), 0.0001);
        assertEquals(expectedMin, stats.getMin(), 0.0001);
        assertEquals(expectedMax, stats.getMax(), 0.0001);
    }
}
