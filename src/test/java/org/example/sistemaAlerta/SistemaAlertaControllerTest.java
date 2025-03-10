package org.example.sistemaAlerta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SistemaAlertaControllerTest {

    private final SistemaAlertaController controller = new SistemaAlertaController();

    @Test
    public void testRevisarRadiacion() {
        // Levels above the threshold should trigger an alert.
        assertTrue(controller.revisarRadiacion(150.0));
        // Levels at or below the threshold should not trigger an alert.
        assertFalse(controller.revisarRadiacion(100.0));
        assertFalse(controller.revisarRadiacion(80.0));
    }

    @Test
    public void testRevisarTemperatura() {
        // Temperature below minimum should trigger an alert.
        assertTrue(controller.revisarTemperatura(-30.0));
        // Temperature above maximum should trigger an alert.
        assertTrue(controller.revisarTemperatura(60.0));
        // Temperature within safe range should not trigger an alert.
        assertFalse(controller.revisarTemperatura(25.0));
        // Boundary values should be considered safe.
        assertFalse(controller.revisarTemperatura(-20.0));
        assertFalse(controller.revisarTemperatura(50.0));
    }

    @Test
    public void testRevisarPresion() {
        // Pressures below the safe minimum should trigger an alert.
        assertTrue(controller.revisarPresion(80.0));
        // Pressures above the safe maximum should trigger an alert.
        assertTrue(controller.revisarPresion(120.0));
        // Pressures within safe range should not trigger an alert.
        assertFalse(controller.revisarPresion(100.0));
        // Boundary values are safe.
        assertFalse(controller.revisarPresion(90.0));
        assertFalse(controller.revisarPresion(110.0));
    }

    @Test
    public void testObtenerEventosRaros() {
        // When requesting the first 5 prime numbers, we expect: 2, 3, 5, 7, 11.
        List<Integer> eventos = controller.obtenerEventosRaros(5);
        assertEquals(5, eventos.size());
        assertEquals(2, eventos.get(0));
        assertEquals(3, eventos.get(1));
        assertEquals(5, eventos.get(2));
        assertEquals(7, eventos.get(3));
        assertEquals(11, eventos.get(4));
    }

    @Test
    public void testObtenerEventosRarosInvalid() {
        // Requesting 0 events should throw an exception.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.obtenerEventosRaros(0);
        });
        assertTrue(exception.getMessage().contains("El número de eventos debe ser mayor a cero."));
    }

    @Test
    public void testDescomponerEnFactoresPrimos() {
        // For 28, expected factors: [2, 2, 7]
        List<Integer> factores28 = controller.descomponerEnFactoresPrimos(28);
        assertEquals(3, factores28.size());
        assertEquals(2, factores28.get(0));
        assertEquals(2, factores28.get(1));
        assertEquals(7, factores28.get(2));

        // For a prime number such as 13, expected factors: [13]
        List<Integer> factores13 = controller.descomponerEnFactoresPrimos(13);
        assertEquals(1, factores13.size());
        assertEquals(13, factores13.get(0));
    }

    @Test
    public void testDescomponerEnFactoresPrimosInvalid() {
        // Numbers <= 1 should throw an exception.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.descomponerEnFactoresPrimos(1);
        });
        assertTrue(exception.getMessage().contains("El número debe ser mayor a 1 para descomponer en factores primos."));
    }
}
