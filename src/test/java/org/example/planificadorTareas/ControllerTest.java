package org.example.planificadorTareas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ControllerTest {

    @Test
    public void testCalcularCargaTrabajo() {
        Controller controller = new Controller();
        int[] tareas = {3, 5, 7};
        int cargaTotal = controller.calcularCargaTrabajo(tareas);
        assertEquals(15, cargaTotal);
    }

    @Test
    public void testDistribuirTareasCorrecto() {
        Controller controller = new Controller();
        int[] tareas = {3, 5, 7, 2};
        List<String> nombres = Arrays.asList("Alice", "Bob");
        DistribucionTareas distribucion = controller.distribuirTareas(tareas, nombres);
        Map<String, List<Integer>> asignaciones = distribucion.getAsignaciones();

        // Verify that both crew members have tasks assigned.
        assertTrue(asignaciones.containsKey("Alice"));
        assertTrue(asignaciones.containsKey("Bob"));

        // Verify that all tasks are assigned.
        int totalTareasAsignadas = asignaciones.values().stream().mapToInt(List::size).sum();
        assertEquals(tareas.length, totalTareasAsignadas);
    }

    @Test
    public void testDistribuirTareasSinTripulante() {
        Controller controller = new Controller();
        int[] tareas = {3, 5, 7};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.distribuirTareas(tareas, new ArrayList<>());
        });
        String mensajeEsperado = "Debe haber al menos un tripulante.";
        assertTrue(exception.getMessage().contains(mensajeEsperado));
    }

    @Test
    public void testCalcularCargaPorTripulante() {
        Controller controller = new Controller();
        // Manually create a map of assignments.
        Map<String, List<Integer>> asignaciones = new HashMap<>();
        asignaciones.put("Alice", Arrays.asList(3, 5));
        asignaciones.put("Bob", Arrays.asList(7, 2));
        // Wrap the map in a DistribucionTareas instance.
        DistribucionTareas distribucion = new DistribucionTareas(asignaciones);
        Map<String, Integer> cargas = controller.calcularCargaPorTripulante(distribucion);
        assertEquals(8, cargas.get("Alice"));
        assertEquals(9, cargas.get("Bob"));
    }
}
