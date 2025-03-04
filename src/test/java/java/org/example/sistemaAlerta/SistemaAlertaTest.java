package org.example.sistemaAlerta;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaAlertaTest {

    @Test
    public void testRevisarRadiacion() {
        SistemaAlerta alerta = new SistemaAlerta();
        // Caso: radiación superior al umbral (debe alertar)
        assertTrue(alerta.revisarRadiacion(150.0));
        // Caso: radiación dentro del rango seguro (no debe alertar)
        assertFalse(alerta.revisarRadiacion(80.0));
    }

    @Test
    public void testRevisarTemperatura() {
        SistemaAlerta alerta = new SistemaAlerta();
        // Caso: temperatura por debajo del rango seguro
        assertTrue(alerta.revisarTemperatura(-25.0));
        // Caso: temperatura por encima del rango seguro
        assertTrue(alerta.revisarTemperatura(55.0));
        // Caso: temperatura dentro del rango seguro
        assertFalse(alerta.revisarTemperatura(25.0));
    }

    @Test
    public void testRevisarPresion() {
        SistemaAlerta alerta = new SistemaAlerta();
        // Caso: presión por debajo del rango seguro
        assertTrue(alerta.revisarPresion(85.0));
        // Caso: presión por encima del rango seguro
        assertTrue(alerta.revisarPresion(115.0));
        // Caso: presión dentro del rango seguro
        assertFalse(alerta.revisarPresion(100.0));
    }

    @Test
    public void testObtenerEventosRaros() {
        SistemaAlerta alerta = new SistemaAlerta();
        List<Integer> eventos = alerta.obtenerEventosRaros(5);
        // Se espera la lista: [2, 3, 5, 7, 11]
        assertEquals(5, eventos.size());
        assertEquals(2, eventos.get(0));
        assertEquals(3, eventos.get(1));
        assertEquals(5, eventos.get(2));
        assertEquals(7, eventos.get(3));
        assertEquals(11, eventos.get(4));
    }

    @Test
    public void testObtenerEventosRarosArgumentoInvalido() {
        SistemaAlerta alerta = new SistemaAlerta();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            alerta.obtenerEventosRaros(0);
        });
        String expectedMessage = "El número de eventos debe ser mayor a cero.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testDescomponerEnFactoresPrimos() {
        SistemaAlerta alerta = new SistemaAlerta();
        // Ejemplo: 84 se descompone en [2, 2, 3, 7]
        List<Integer> factores = alerta.descomponerEnFactoresPrimos(84);
        assertEquals(4, factores.size());
        assertEquals(2, factores.get(0));
        assertEquals(2, factores.get(1));
        assertEquals(3, factores.get(2));
        assertEquals(7, factores.get(3));
    }

    @Test
    public void testDescomponerEnFactoresPrimosArgumentoInvalido() {
        SistemaAlerta alerta = new SistemaAlerta();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            alerta.descomponerEnFactoresPrimos(1);
        });
        String expectedMessage = "El número debe ser mayor a 1 para descomponer en factores primos.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
