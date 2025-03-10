package org.example;

import org.example.cronometroCosmico.Controller as CronoController;
import org.example.cronometroCosmico.Model as CronoModel;
import org.example.navegadorEstelar.Controller as NavegadorController;
import org.example.navegadorEstelar.Mapa;
import org.example.planificadorTareas.Controller as TareasController;
import org.example.planificadorTareas.DistribucionTareas;
import org.example.recursos.RecursosController;
import org.example.recursos.Stats;
import org.example.sistemaAlerta.SistemaAlertaController;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Instantiate controllers for each module
        CronoController cronoController = new CronoController();
        NavegadorController navegadorController = new NavegadorController();
        TareasController tareasController = new TareasController();
        RecursosController recursosController = new RecursosController();
        SistemaAlertaController alertaController = new SistemaAlertaController();

        while (!exit) {
            System.out.println("\n=== Module Hub ===");
            System.out.println("1. CronometroCosmico (Time Conversion)");
            System.out.println("2. NavegadorEstelar (Terrain Simulation & Route Optimization)");
            System.out.println("3. PlanificadorTareas (Task Distribution)");
            System.out.println("4. Recursos (Resource Consumption & Stats)");
            System.out.println("5. SistemaAlerta (Environmental Alerts & Prime Analysis)");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(option) {
                case 1:
                    // CronometroCosmico
                    System.out.print("Enter the number of seconds to convert: ");
                    long seconds = scanner.nextLong();
                    scanner.nextLine();
                    CronoModel timeModel = cronoController.convertirTiempo(seconds);
                    System.out.println("Time conversion result:");
                    System.out.println(timeModel);
                    break;

                case 2:
                    // NavegadorEstelar
                    System.out.print("Enter number of rows for the terrain: ");
                    int rows = scanner.nextInt();
                    System.out.print("Enter number of columns for the terrain: ");
                    int cols = scanner.nextInt();
                    scanner.nextLine();
                    Mapa terrain = navegadorController.simularTerreno(rows, cols);
                    System.out.println("Simulated Terrain:");
                    System.out.println(terrain);

                    // Optimize route (using identity factors for simplicity)
                    int[][] identity = new int[cols][cols];
                    for (int i = 0; i < cols; i++) {
                        identity[i][i] = 1;
                    }
                    Mapa optimized = navegadorController.optimizarRuta(terrain, identity);
                    System.out.println("Optimized Route (using identity matrix):");
                    System.out.println(optimized);
                    break;

                case 3:
                    // PlanificadorTareas
                    System.out.print("Enter tasks as comma-separated integers (e.g., 5,3,7,2): ");
                    String tareasInput = scanner.nextLine();
                    String[] tareaTokens = tareasInput.split(",");
                    int[] tareas = new int[tareaTokens.length];
                    for (int i = 0; i < tareaTokens.length; i++) {
                        tareas[i] = Integer.parseInt(tareaTokens[i].trim());
                    }

                    System.out.print("Enter crew names as comma-separated values (e.g., Alice,Bob,Charlie): ");
                    String crewInput = scanner.nextLine();
                    String[] crewTokens = crewInput.split(",");
                    List<String> crew = new ArrayList<>();
                    for (String name : crewTokens) {
                        crew.add(name.trim());
                    }

                    DistribucionTareas distribucion = tareasController.distribuirTareas(tareas, crew);
                    System.out.println("Task Distribution:");
                    System.out.println(distribucion);
                    Map<String, Integer> cargas = tareasController.calcularCargaPorTripulante(distribucion);
                    System.out.println("Workload per Crew Member:");
                    System.out.println(cargas);
                    break;

                case 4:
                    // Recursos
                    System.out.print("Enter daily consumption value: ");
                    double consumoDiario = scanner.nextDouble();
                    System.out.print("Enter number of days: ");
                    int dias = scanner.nextInt();
                    scanner.nextLine();
                    double consumoTotal = recursosController.calcularConsumo(consumoDiario, dias);
                    System.out.println("Total Consumption: " + consumoTotal);

                    System.out.print("Enter current consumption, days to predict, and growth rate (comma-separated, e.g., 100,5,0.05): ");
                    String predInput = scanner.nextLine();
                    String[] predTokens = predInput.split(",");
                    double consumoActual = Double.parseDouble(predTokens[0].trim());
                    int diasFuturos = Integer.parseInt(predTokens[1].trim());
                    double tasaCrecimiento = Double.parseDouble(predTokens[2].trim());
                    double consumoFuturo = recursosController.predecirConsumoFuturo(consumoActual, diasFuturos, tasaCrecimiento);
                    System.out.println("Predicted Future Consumption: " + consumoFuturo);

                    System.out.print("Enter current resource level and safe threshold (comma-separated, e.g., 80,90): ");
                    String alertaInput = scanner.nextLine();
                    String[] alertaTokens = alertaInput.split(",");
                    double nivelActual = Double.parseDouble(alertaTokens[0].trim());
                    double umbralSeguro = Double.parseDouble(alertaTokens[1].trim());
                    boolean alertaRecurso = recursosController.alertaNivelCritico(nivelActual, umbralSeguro);
                    System.out.println("Critical Level Alert: " + alertaRecurso);

                    System.out.print("Enter consumptions as comma-separated values for statistics (e.g., 10,20,30): ");
                    String statsInput = scanner.nextLine();
                    String[] statsTokens = statsInput.split(",");
                    double[] consumos = new double[statsTokens.length];
                    for (int i = 0; i < statsTokens.length; i++) {
                        consumos[i] = Double.parseDouble(statsTokens[i].trim());
                    }
                    Stats stats = recursosController.calcularEstadisticas(consumos);
                    System.out.println("Statistics: " + stats);
                    break;

                case 5:
                    // SistemaAlerta
                    System.out.print("Enter radiation level: ");
                    double radLevel = scanner.nextDouble();
                    System.out.println("Radiation Alert: " + alertaController.revisarRadiacion(radLevel));

                    System.out.print("Enter temperature: ");
                    double temperatura = scanner.nextDouble();
                    System.out.println("Temperature Alert: " + alertaController.revisarTemperatura(temperatura));

                    System.out.print("Enter pressure: ");
                    double presion = scanner.nextDouble();
                    System.out.println("Pressure Alert: " + alertaController.revisarPresion(presion));
                    scanner.nextLine();

                    System.out.print("Enter number of rare events (prime numbers) to generate: ");
                    int numEventos = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        List<Integer> eventos = alertaController.obtenerEventosRaros(numEventos);
                        System.out.println("Rare Events: " + eventos);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    System.out.print("Enter a number to factorize into primes: ");
                    int numFactorizar = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        List<Integer> factores = alertaController.descomponerEnFactoresPrimos(numFactorizar);
                        System.out.println("Prime Factors: " + factores);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
