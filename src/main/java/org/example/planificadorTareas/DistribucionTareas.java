package org.example.planificadorTareas;

import java.util.List;
import java.util.Map;

public class DistribucionTareas {
    private Map<String, List<Integer>> asignaciones;

    public DistribucionTareas(Map<String, List<Integer>> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public Map<String, List<Integer>> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(Map<String, List<Integer>> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Integer>> entry : asignaciones.entrySet()) {
            sb.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
