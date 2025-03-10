package org.example.planificadorTareas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class DistribucionTareasTest {

    @Test
    public void testToString() {
        Map<String, List<Integer>> asignaciones = new HashMap<>();
        asignaciones.put("Alice", Arrays.asList(3, 5));
        asignaciones.put("Bob", Arrays.asList(7, 2));
        DistribucionTareas distribucion = new DistribucionTareas(asignaciones);
        String output = distribucion.toString();
        // Verify that the output contains the crew member names and some assigned task values.
        assertTrue(output.contains("Alice"));
        assertTrue(output.contains("Bob"));
        assertTrue(output.contains("3"));
        assertTrue(output.contains("7"));
    }
}
