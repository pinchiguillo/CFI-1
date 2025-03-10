package org.example.navegadorEstelar;

public class Controller {

    /**
     * Multiplica dos matrices para optimizar rutas y recursos.
     *
     * @param a Primera matriz.
     * @param b Segunda matriz.
     * @return La matriz resultante de la multiplicación.
     * @throws IllegalArgumentException si las matrices no se pueden multiplicar.
     */
    public int[][] multiplicarMatrices(int[][] a, int[][] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas.");
        }
        int filasA = a.length;
        int columnasA = a[0].length;
        int filasB = b.length;
        int columnasB = b[0].length;

        if (columnasA != filasB) {
            throw new IllegalArgumentException("Las matrices no se pueden multiplicar: columnas de A (" + columnasA +
                    ") deben ser iguales a filas de B (" + filasB + ").");
        }

        int[][] resultado = new int[filasA][columnasB];
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return resultado;
    }

    /**
     * Simula un terreno generando una matriz de enteros y encapsulándola en un objeto Mapa.
     * Cada celda representa el "costo" o dificultad de desplazarse por esa zona.
     * Los valores se generan aleatoriamente entre 1 y 10, donde valores altos indican mayor dificultad.
     *
     * @param filas Número de filas de la matriz.
     * @param columnas Número de columnas de la matriz.
     * @return Objeto Mapa que representa el terreno.
     */
    public Mapa simularTerreno(int filas, int columnas) {
        int[][] terreno = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                terreno[i][j] = (int)(Math.random() * 10) + 1;
            }
        }
        return new Mapa(terreno);
    }

    /**
     * Optimiza la ruta de exploración multiplicando la matriz del terreno por una matriz de factores.
     * La matriz de factores puede representar la influencia de variables como consumo de recursos o tiempo.
     *
     * @param terreno Objeto Mapa que representa el terreno.
     * @param factores Matriz de factores de influencia.
     * @return Objeto Mapa resultante que representa la ruta optimizada.
     */
    public Mapa optimizarRuta(Mapa terreno, int[][] factores) {
        int[][] terrenoMatriz = terreno.getMatriz();
        int[][] resultado = multiplicarMatrices(terrenoMatriz, factores);
        return new Mapa(resultado);
    }
}
