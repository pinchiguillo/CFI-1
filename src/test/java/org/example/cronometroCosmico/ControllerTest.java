package org.example.cronometroCosmico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    @Test
    public void testConversionTimeZero() {
        Controller controller = new Controller();
        Model model = controller.convertirTiempo(0);

        // Verify conversion for Earth
        assertEquals(0, model.earthSeconds);
        assertEquals(0.0, model.earthMinutes, 0.0001);
        assertEquals(0.0, model.earthHours, 0.0001);
        assertEquals(0.0, model.earthDays, 0.0001);
        assertEquals(0.0, model.earthYears, 0.0001);

        // Verify conversion for the new planet
        assertEquals(0, model.planetSeconds);
        assertEquals(0.0, model.planetMinutes, 0.0001);
        assertEquals(0.0, model.planetHours, 0.0001);
        assertEquals(0.0, model.planetDays, 0.0001);
        assertEquals(0.0, model.planetYears, 0.0001);
    }

    @Test
    public void testConversionTimePositive() {
        Controller controller = new Controller();
        Model model = controller.convertirTiempo(3600);

        // Conversion for Earth
        assertEquals(3600, model.earthSeconds);
        assertEquals(60.0, model.earthMinutes, 0.0001);
        assertEquals(1.0, model.earthHours, 0.0001);
        // Calculate expected Earth days and years:
        double expectedEarthDays = 1.0 / 24.0;
        double expectedEarthYears = expectedEarthDays / 365.0;
        assertEquals(expectedEarthDays, model.earthDays, 0.0001);
        assertEquals(expectedEarthYears, model.earthYears, 0.0001);

        // Conversion for the new planet
        // planetHours: 3600 / 3600 = 1.0 hour;
        // planetDays: 1.0 / 30.0;
        // planetYears: (1.0 / 30.0) / 400.0;
        assertEquals(3600, model.planetSeconds);
        assertEquals(60.0, model.planetMinutes, 0.0001);
        assertEquals(1.0, model.planetHours, 0.0001);
        assertEquals(1.0 / 30.0, model.planetDays, 0.0001);
        assertEquals((1.0 / 30.0) / 400.0, model.planetYears, 0.0001);
    }

    @Test
    public void testNegativeSecondsException() {
        Controller controller = new Controller();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.convertirTiempo(-100);
        });
        String expectedMessage = "El número de segundos no puede ser negativo.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testObtenerLimites() {
        Controller controller = new Controller();
        String limites = controller.obtenerLimites();
        assertNotNull(limites);
        assertTrue(limites.contains("Integer"));
        assertTrue(limites.contains("Long"));
        assertTrue(limites.contains("Float"));
        assertTrue(limites.contains("Double"));
    }
}
