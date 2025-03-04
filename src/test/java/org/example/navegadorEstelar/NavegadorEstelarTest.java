package org.example.navegadorEstelar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class NavegadorEstelarTest {

    @Test
    public void testMultiplicarMatricesCorrecto() {
        NavegadorEstelar navegador = new NavegadorEstelar();
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
        int[][] resultado = navegador.multiplicarMatrices(a, b);
        assertTrue(Arrays.deepEquals(esperado, resultado));
    }

    @Test
    public void testMultiplicarMatricesDimensionesIncorrectas() {
        NavegadorEstelar navegador = new NavegadorEstelar();
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] b = {
                {7, 8},
                {9, 10}
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            navegador.multiplicarMatrices(a, b);
        });
        String mensajeEsperado = "Las matrices no se pueden multiplicar";
        String mensajeReal = exception.getMessage();
        assertTrue(mensajeReal.contains(mensajeEsperado));
    }

    @Test
    public void testSimularTerrenoDimensiones() {
        NavegadorEstelar navegador = new NavegadorEstelar();
        int filas = 4;
        int columnas = 5;
        int[][] terreno = navegador.simularTerreno(filas, columnas);
        assertEquals(filas, terreno.length);
        for (int[] fila : terreno) {
            assertEquals(columnas, fila.length);
        }
    }

    @Test
    public void testOptimizarRuta() {
        NavegadorEstelar navegador = new NavegadorEstelar();
        // Matriz del terreno
        int[][] terreno = {
                {2, 3},
                {1, 4}
        };
        // Matriz de factores (por ejemplo, representa influencia de variables)
        int[][] factores = {
                {1, 0},
                {0, 1}
        };
        // Al multiplicar por la matriz identidad, se espera obtener la misma matriz del terreno.
        int[][] rutaOptima = navegador.optimizarRuta(terreno, factores);
        assertTrue(Arrays.deepEquals(terreno, rutaOptima));
    }
}
