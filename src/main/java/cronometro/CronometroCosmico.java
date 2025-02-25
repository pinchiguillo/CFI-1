package cronometro;

public class CronometroCosmico {

    /**
     * Muestra el tiempo transcurrido en formato terrestre y lo convierte al tiempo del nuevo planeta.
     *
     * @param earthSeconds Tiempo en segundos según el sistema terrestre.
     */
    public static void mostrarConversionTiempo(long earthSeconds) {
        // Cálculo del tiempo en Tierra
        long segundos = earthSeconds % 60;
        long minutos = (earthSeconds / 60) % 60;
        long horas = (earthSeconds / 3600) % 24;
        long dias = earthSeconds / 86400;
        long años = dias / 365;
        long diasRestantes = dias % 365;

        System.out.println("Tiempo en Tierra: "
                + años + " años, "
                + diasRestantes + " días, "
                + horas + " horas, "
                + minutos + " minutos, "
                + segundos + " segundos.");

        // Conversión al tiempo del nuevo planeta:
        // Asumimos que:
        // - Un día en el nuevo planeta dura 30 horas terrestres.
        // - Un año en el nuevo planeta tiene 400 días.
        double segundosDiaPlaneta = 30 * 3600; // 30 horas * 3600 segundos/hora
        double diasPlaneta = earthSeconds / segundosDiaPlaneta;
        int añosPlaneta = (int) (diasPlaneta / 400);
        int diasPlanetaRestantes = (int) (diasPlaneta % 400);
        double resto = earthSeconds % segundosDiaPlaneta;
        int horasPlaneta = (int) (resto / 3600);
        resto %= 3600;
        int minutosPlaneta = (int) (resto / 60);
        int segundosPlaneta = (int) (resto % 60);

        System.out.println("Tiempo en Nuevo Planeta: "
                + añosPlaneta + " años, "
                + diasPlanetaRestantes + " días, "
                + horasPlaneta + " horas, "
                + minutosPlaneta + " minutos, "
                + segundosPlaneta + " segundos.");
    }

    /**
     * Muestra los límites máximos y mínimos de los tipos de datos primitivos.
     */
    public static void mostrarLimitesDatos() {
        System.out.println("Límites de representación de datos:");
        System.out.println("Byte: " + Byte.MIN_VALUE + " a " + Byte.MAX_VALUE);
        System.out.println("Short: " + Short.MIN_VALUE + " a " + Short.MAX_VALUE);
        System.out.println("Integer: " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);
        System.out.println("Long: " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);
        System.out.println("Float: " + Float.MIN_VALUE + " a " + Float.MAX_VALUE);
        System.out.println("Double: " + Double.MIN_VALUE + " a " + Double.MAX_VALUE);
    }
}
