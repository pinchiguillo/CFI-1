package org.example.sistemaAlerta;

import java.util.ArrayList;
import java.util.List;

public class SistemaAlerta {

    // Umbrales seguros para cada variable ambiental
    private static final double UMBRAL_RADIACION = 100.0;
    private static final double UMBRAL_TEMPERATURA_MIN = -20.0;
    private static final double UMBRAL_TEMPERATURA_MAX = 50.0;
    private static final double UMBRAL_PRESION_MIN = 90.0;
    private static final double UMBRAL_PRESION_MAX = 110.0;

    /**
     * Revisa si el nivel de radiación excede el umbral seguro.
     * @param nivelRadiacion nivel actual de radiación.
     * @return true si el nivel es superior al umbral; false en caso contrario.
     */
    public boolean revisarRadiacion(double nivelRadiacion) {
        return nivelRadiacion > UMBRAL_RADIACION;
    }

    /**
     * Revisa si la temperatura se encuentra fuera del rango seguro.
     * @param temperatura valor de la temperatura.
     * @return true si la temperatura es inferior a UMBRAL_TEMPERATURA_MIN o superior a UMBRAL_TEMPERATURA_MAX.
     */
    public boolean revisarTemperatura(double temperatura) {
        return (temperatura < UMBRAL_TEMPERATURA_MIN || temperatura > UMBRAL_TEMPERATURA_MAX);
    }

    /**
     * Revisa si la presión se encuentra fuera del rango seguro.
     * @param presion valor de la presión.
     * @return true si la presión es inferior a UMBRAL_PRESION_MIN o superior a UMBRAL_PRESION_MAX.
     */
    public boolean revisarPresion(double presion) {
        return (presion < UMBRAL_PRESION_MIN || presion > UMBRAL_PRESION_MAX);
    }

    /**
     * Identifica y retorna los N primeros números primos, interpretados como eventos raros o críticos.
     * @param n cantidad de eventos raros a obtener.
     * @return lista de números primos.
     * @throws IllegalArgumentException si n es menor o igual a 0.
     */
    public List<Integer> obtenerEventosRaros(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El número de eventos debe ser mayor a cero.");
        }
        List<Integer> eventos = new ArrayList<>();
        int num = 2;
        while (eventos.size() < n) {
            if (esPrimo(num)) {
                eventos.add(num);
            }
            num++;
        }
        return eventos;
    }

    // Método auxiliar para determinar si un número es primo.
    private boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    /**
     * Descompone un número en sus factores primos para facilitar el análisis de problemas complejos.
     * @param numero número a descomponer.
     * @return lista de factores primos.
     * @throws IllegalArgumentException si el número es menor o igual a 1.
     */
    public List<Integer> descomponerEnFactoresPrimos(int numero) {
        if (numero <= 1) {
            throw new IllegalArgumentException("El número debe ser mayor a 1 para descomponer en factores primos.");
        }
        List<Integer> factores = new ArrayList<>();
        // Descomponer factores 2
        while (numero % 2 == 0) {
            factores.add(2);
            numero /= 2;
        }
        // Descomponer factores impares
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            while (numero % i == 0) {
                factores.add(i);
                numero /= i;
            }
        }
        if (numero > 2) {
            factores.add(numero);
        }
        return factores;
    }
}
