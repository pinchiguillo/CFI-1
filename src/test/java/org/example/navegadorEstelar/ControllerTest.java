package org.example.navegadorEstelar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class ControllerTest {

    @Test
    public void testMultiplicarMatricesCorrecto() {
        Controller controller = new Controller();
        int[][] a = {
                {1, 2},
                {3, 4}
        };
        int[][] b = {
                {5, 6},
                {7, 8}
        };
        int[][] esperado = {
                {19, 22},
                {43, 50}
        };
        int[][] resultado = controller.multiplicarMatrices(a, b);
        assertTrue(Arrays.deepEquals(esperado, resultado));
    }

    @Test
    public void testMultiplicarMatricesDimensionesIncorrectas() {
        Controller controller = new Controller();
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] b = {
                {7, 8},
                {9, 10}
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.multiplicarMatrices(a, b);
        });
        String mensajeEsperado = "Las matrices no se pueden multiplicar";
        String mensajeReal = exception.getMessage();
        assertTrue(mensajeReal.contains(mensajeEsperado));
    }

    @Test
    public void testSimularTerrenoDimensiones() {
        Controller controller = new Controller();
        int filas = 4;
        int columnas = 5;
        Mapa mapaTerreno = controller.simularTerreno(filas, columnas);
        int[][] terreno = mapaTerreno.getMatriz();
        assertEquals(filas, terreno.length);
        for (int[] fila : terreno) {
            assertEquals(columnas, fila.length);
        }
    }

    @Test
    public void testOptimizarRuta() {
        Controller controller = new Controller();
        // Matriz del terreno
        int[][] terreno = {
                {2, 3},
                {1, 4}
        };
        // Matriz de factores (por ejemplo, la matriz identidad)
        int[][] factores = {
                {1, 0},
                {0, 1}
        };
        // Se encapsula el terreno en un objeto Mapa.
        Mapa mapaTerreno = new Mapa(terreno);
        Mapa rutaOptima = controller.optimizarRuta(mapaTerreno, factores);
        assertTrue(Arrays.deepEquals(terreno, rutaOptima.getMatriz()));
    }
}
