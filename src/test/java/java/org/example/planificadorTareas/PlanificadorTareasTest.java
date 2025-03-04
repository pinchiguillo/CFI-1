package org.example.planificadorTareas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class PlanificadorTareasTest {

    @Test
    public void testCalcularCargaTrabajo() {
        PlanificadorTareas planificador = new PlanificadorTareas();
        int[] tareas = {3, 5, 2, 8};
        int carga = planificador.calcularCargaTrabajo(tareas);
        assertEquals(18, carga);
    }

    @Test
    public void testDistribuirTareas() {
        PlanificadorTareas planificador = new PlanificadorTareas();
        int[] tareas = {10, 20, 5, 15};
        List<String> tripulantes = Arrays.asList("Alice", "Bob");

        Map<String, List<Integer>> asignaciones = planificador.distribuirTareas(tareas, tripulantes);
        // Con asignación greedy y tareas ordenadas (20, 15, 10, 5):
        // - Alice recibe 20
        // - Bob recibe 15
        // - Bob (15) < Alice (20) → Bob recibe 10 (total 25)
        // - Luego, Alice recibe 5 (total 25)
        Map<String, Integer> cargas = planificador.calcularCargaPorTripulante(asignaciones);
        assertEquals(25, cargas.get("Alice"));
        assertEquals(25, cargas.get("Bob"));
    }

    @Test
    public void testDistribuirTareasSinTripulantes() {
        PlanificadorTareas planificador = new PlanificadorTareas();
        int[] tareas = {10, 20, 5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            planificador.distribuirTareas(tareas, new ArrayList<>());
        });
        String expectedMessage = "Debe haber al menos un tripulante.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
