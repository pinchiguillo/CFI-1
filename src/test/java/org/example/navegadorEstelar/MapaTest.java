package org.example.navegadorEstelar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MapaTest {

    @Test
    public void testToString() {
        int[][] matriz = {
                {1, 2},
                {3, 4}
        };
        Mapa mapa = new Mapa(matriz);
        String mapaStr = mapa.toString();
        // Verifica que la representación contenga los valores esperados.
        assertTrue(mapaStr.contains("1 2"));
        assertTrue(mapaStr.contains("3 4"));
    }
}
