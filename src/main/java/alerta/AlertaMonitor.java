package alerta;

import java.util.ArrayList;
import java.util.List;

public class AlertaMonitor {

    // Método para verificar si un número es primo (identificación de eventos raros)
    public static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para factorizar un número en sus factores primos (descomposición de problemas)
    public static List<Integer> factorizacionPrimos(int numero) {
        List<Integer> factores = new ArrayList<>();
        int n = numero;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factores.add(i);
                n /= i;
            }
        }
        return factores;
    }

    // Método para verificar si un valor supera un umbral crítico
    public static void verificarNivelCritico(double valor, double umbral) throws NivelCriticoException {
        if (valor > umbral) {
            throw new NivelCriticoException("Nivel crítico superado: " + valor);
        }
    }
}
