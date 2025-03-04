package org.example.comunicadorInterplanetario;

public class ComunicadorInterplanetario {

    /**
     * Cuenta la cantidad de vocales en un mensaje.
     * Se consideran las vocales: a, e, i, o, u (sin diferenciar mayúsculas y minúsculas).
     *
     * @param mensaje El mensaje a analizar.
     * @return La cantidad de vocales encontradas.
     * @throws IllegalArgumentException si el mensaje es null.
     */
    public int contarVocales(String mensaje) {
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser null.");
        }
        int contador = 0;
        String mensajeMinusculas = mensaje.toLowerCase();
        for (int i = 0; i < mensajeMinusculas.length(); i++) {
            char c = mensajeMinusculas.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Invierte el mensaje recibido.
     *
     * @param mensaje El mensaje a invertir.
     * @return El mensaje invertido.
     * @throws IllegalArgumentException si el mensaje es null.
     */
    public String invertirMensaje(String mensaje) {
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser null.");
        }
        return new StringBuilder(mensaje).reverse().toString();
    }

    /**
     * Verifica si el mensaje es un palíndromo.
     * Se ignoran espacios y diferencias de mayúsculas/minúsculas.
     *
     * @param mensaje El mensaje a evaluar.
     * @return true si el mensaje es un palíndromo; false en caso contrario.
     * @throws IllegalArgumentException si el mensaje es null.
     */
    public boolean esPalindromo(String mensaje) {
        if (mensaje == null) {
            throw new IllegalArgumentException("El mensaje no puede ser null.");
        }
        // Eliminar espacios y convertir a minúsculas
        String limpio = mensaje.replaceAll("\\s+", "").toLowerCase();
        String invertido = invertirMensaje(limpio);
        return limpio.equals(invertido);
    }
}
