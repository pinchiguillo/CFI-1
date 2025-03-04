package org.example.comunicadorInterplanetario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ComunicadorInterplanetarioTest {

    @Test
    public void testContarVocales() {
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        String mensaje = "Hola, Mision Espacial";
        // En "Hola, Misión Espacial" las vocales son: o, a, i, i, o, e, a, i, a (9 vocales)
        assertEquals(9, comunicador.contarVocales(mensaje));
    }

    @Test
    public void testContarVocalesMensajeNull() {
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            comunicador.contarVocales(null);
        });
        String expectedMessage = "El mensaje no puede ser null.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testInvertirMensaje() {
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        String mensaje = "Cronos";
        assertEquals("sonorC", comunicador.invertirMensaje(mensaje));
    }

    @Test
    public void testInvertirMensajeMensajeNull() {
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            comunicador.invertirMensaje(null);
        });
        String expectedMessage = "El mensaje no puede ser null.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testEsPalindromoVerdadero() {
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        // "Anita lava la tina" es un palíndromo ignorando espacios y mayúsculas.
        assertTrue(comunicador.esPalindromo("Anita lava la tina"));
    }

    @Test
    public void testEsPalindromoFalso() {
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        // "Misión Espacial" no es palíndromo.
        assertFalse(comunicador.esPalindromo("Misión Espacial"));
    }

    @Test
    public void testEsPalindromoMensajeNull() {
        ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            comunicador.esPalindromo(null);
        });
        String expectedMessage = "El mensaje no puede ser null.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}
