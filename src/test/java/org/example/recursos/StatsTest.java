package org.example.recursos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StatsTest {

    @Test
    public void testGetters() {
        double promedio = 50.0;
        double min = 10.0;
        double max = 90.0;
        Stats stats = new Stats(promedio, min, max);

        assertEquals(promedio, stats.getPromedio(), 0.0001);
        assertEquals(min, stats.getMin(), 0.0001);
        assertEquals(max, stats.getMax(), 0.0001);
    }

    @Test
    public void testToStringFormat() {
        Stats stats = new Stats(55.5, 5.0, 100.0);
        String output = stats.toString();
        // Verify that the output contains the expected keys and values.
        assertTrue(output.contains("promedio="));
        assertTrue(output.contains("min="));
        assertTrue(output.contains("max="));
        assertTrue(output.contains("55.5"));
        assertTrue(output.contains("5.0"));
        assertTrue(output.contains("100.0"));
    }
}
