package org.example.cronometroCosmico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    @Test
    public void testToString() {
        Model model = new Model();

        // Manually set fields for testing.
        model.earthSeconds = 100;
        model.earthMinutes = 100.0 / 60.0;
        model.earthHours   = model.earthMinutes / 60.0;
        model.earthDays    = model.earthHours / 24.0;
        model.earthYears   = model.earthDays / 365.0;

        model.planetSeconds = 100;
        model.planetMinutes = 100.0 / 60.0;
        model.planetHours   = 100 / 3600.0;
        model.planetDays    = model.planetHours / 30.0;
        model.planetYears   = model.planetDays / 400.0;

        String output = model.toString();
        // Check that the output contains key labels and the manually-set values.
        assertTrue(output.contains("Tiempo en la Tierra:"));
        assertTrue(output.contains("Tiempo en el nuevo planeta:"));
        assertTrue(output.contains("Segundos: 100"));
    }
}
