package org.example.cronometroCosmico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CronometroCosmicoTest {

    @Test
    public void testConversionTimeZero() {
        CronometroCosmico cc = new CronometroCosmico();
        CronometroCosmico.TimeRepresentation tr = cc.convertirTiempo(0);

        // Verificar conversión en la Tierra
        assertEquals(0, tr.earthSeconds);
        assertEquals(0.0, tr.earthMinutes, 0.0001);
        assertEquals(0.0, tr.earthHours, 0.0001);
        assertEquals(0.0, tr.earthDays, 0.0001);
        assertEquals(0.0, tr.earthYears, 0.0001);

        // Verificar conversión en el nuevo planeta
        assertEquals(0, tr.planetSeconds);
        assertEquals(0.0, tr.planetMinutes, 0.0001);
        assertEquals(0.0, tr.planetHours, 0.0001);
        assertEquals(0.0, tr.planetDays, 0.0001);
        assertEquals(0.0, tr.planetYears, 0.0001);
    }

    @Test
    public void testConversionTimePositive() {
        CronometroCosmico cc = new CronometroCosmico();
        CronometroCosmico.TimeRepresentation tr = cc.convertirTiempo(3600);

        // Conversión para la Tierra
        assertEquals(3600, tr.earthSeconds);
        assertEquals(60.0, tr.earthMinutes, 0.0001);
        assertEquals(1.0, tr.earthHours, 0.0001);

        // etc. (resto de los asserts)
    }

    @Test
    public void testNegativeSecondsException() {
        CronometroCosmico cc = new CronometroCosmico();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cc.convertirTiempo(-100);
        });
        String expectedMessage = "El número de segundos no puede ser negativo.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testObtenerLimites() {
        CronometroCosmico cc = new CronometroCosmico();
        String limites = cc.obtenerLimites();
        assertNotNull(limites);
        assertTrue(limites.contains("Integer"));
        assertTrue(limites.contains("Long"));
        assertTrue(limites.contains("Float"));
        assertTrue(limites.contains("Double"));
    }
}
