package comunicador;

public class Comunicador {

    /**
     * Cuenta las vocales en el mensaje.
     * @param mensaje Cadena de texto a analizar.
     * @return Número de vocales encontradas.
     * @throws MensajeInvalidoException si el mensaje es nulo.
     */
    public static int contarVocales(String mensaje) throws MensajeInvalidoException {
        if (mensaje == null) {
            throw new MensajeInvalidoException("El mensaje no puede ser nulo.");
        }
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (char c : mensaje.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Invierte el mensaje recibido.
     * @param mensaje Cadena de texto a invertir.
     * @return Mensaje invertido.
     * @throws MensajeInvalidoException si el mensaje es nulo.
     */
    public static String invertirMensaje(String mensaje) throws MensajeInvalidoException {
        if (mensaje == null) {
            throw new MensajeInvalidoException("El mensaje no puede ser nulo.");
        }
        return new StringBuilder(mensaje).reverse().toString();
    }

    /**
     * Verifica si el mensaje es palíndromo.
     * Se ignoran espacios, signos de puntuación y diferencias de mayúsculas/minúsculas.
     * @param mensaje Cadena de texto a verificar.
     * @return true si el mensaje es palíndromo, false en caso contrario.
     * @throws MensajeInvalidoException si el mensaje es nulo.
     */
    public static boolean esPalindromo(String mensaje) throws MensajeInvalidoException {
        if (mensaje == null) {
            throw new MensajeInvalidoException("El mensaje no puede ser nulo.");
        }
        // Normalizar el mensaje: eliminar caracteres no alfanuméricos y convertir a minúsculas.
        String limpio = mensaje.replaceAll("[\\W_]+", "").toLowerCase();
        String invertido = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }
}
