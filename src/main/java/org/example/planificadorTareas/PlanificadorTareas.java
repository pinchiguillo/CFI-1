package org.example.planificadorTareas;

import java.util.*;

public class PlanificadorTareas {
    /**
     * Calcula la carga de trabajo total sumando los valores de las tareas.
     * @param tareas Array de cargas de trabajo de cada tarea.
     * @return La suma total de las cargas.
     */
    public int calcularCargaTrabajo(int[] tareas) {
        int suma = 0;
        for (int t : tareas) {
            suma += t;
        }
        return suma;
    }

    /**
     * Distribuye las tareas entre los miembros de la tripulación usando un algoritmo greedy.
     * Se asigna cada tarea al tripulante con menor carga acumulada.
     * @param tareas Array de cargas de las tareas.
     * @param nombresTripulantes Lista con los nombres de los tripulantes.
     * @return Un mapa donde la llave es el nombre del tripulante y el valor es la lista de tareas asignadas.
     * @throws IllegalArgumentException si nombresTripulantes está vacío.
     */
    public Map<String, List<Integer>> distribuirTareas(int[] tareas, List<String> nombresTripulantes) {
        if (nombresTripulantes == null || nombresTripulantes.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un tripulante.");
        }

        // Inicializar mapa de asignaciones y carga total por tripulante.
        Map<String, List<Integer>> asignaciones = new HashMap<>();
        Map<String, Integer> cargas = new HashMap<>();
        for (String nombre : nombresTripulantes) {
            asignaciones.put(nombre, new ArrayList<>());
            cargas.put(nombre, 0);
        }

        // Ordenar las tareas de mayor a menor (para asignar primero las tareas más pesadas)
        Integer[] tareasOrdenadas = Arrays.stream(tareas).boxed().toArray(Integer[]::new);
        Arrays.sort(tareasOrdenadas, Collections.reverseOrder());

        // Asignar cada tarea al tripulante con menor carga acumulada
        for (int tarea : tareasOrdenadas) {
            String mejorTripulante = null;
            int cargaMinima = Integer.MAX_VALUE;
            for (String nombre : nombresTripulantes) {
                int cargaActual = cargas.get(nombre);
                if (cargaActual < cargaMinima) {
                    cargaMinima = cargaActual;
                    mejorTripulante = nombre;
                }
            }
            asignaciones.get(mejorTripulante).add(tarea);
            cargas.put(mejorTripulante, cargas.get(mejorTripulante) + tarea);
        }
        return asignaciones;
    }

    /**
     * Calcula la carga total de trabajo asignada a cada tripulante.
     * @param asignaciones Mapa con las asignaciones de tareas por tripulante.
     * @return Un mapa con la carga total de cada tripulante.
     */
    public Map<String, Integer> calcularCargaPorTripulante(Map<String, List<Integer>> asignaciones) {
        Map<String, Integer> cargaTotal = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : asignaciones.entrySet()) {
            int suma = 0;
            for (int tarea : entry.getValue()) {
                suma += tarea;
            }
            cargaTotal.put(entry.getKey(), suma);
        }
        return cargaTotal;
    }
}
