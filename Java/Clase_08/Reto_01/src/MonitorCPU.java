import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

// Excepción personalizada
class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}

public class MonitorCPU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> registros = new HashSet<>();
        boolean continuar = true;

        System.out.println("🔍 MONITOR DE CONSUMO DE CPU 🔍");
        System.out.println("Ingresa los consumos de CPU (en %). Escribe -1 para terminar.\n");

        try {
            while (continuar) {
                System.out.print("👉 Ingresa consumo de CPU: ");

                String entrada = scanner.nextLine().trim();

                if (entrada.equals("-1")) {
                    continuar = false;
                    break;
                }

                int valor;

                try {
                    valor = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Error: Debes ingresar un número entero válido.");
                    continue;
                }

                // Validaciones
                if (valor < 0 || valor > 100) {
                    System.out.println("⚠️ Valor fuera de rango. Ingresa un número entre 0 y 100.");
                    continue;
                }

                if (!registros.add(valor)) {
                    System.out.println("⚠️ Registro duplicado. Este valor ya fue ingresado.");
                    continue;
                }

                if (valor > 95) {
                    throw new ConsumoCriticoException("🔥 ¡Consumo crítico detectado! CPU al " + valor + "%");
                }

                System.out.println("✅ Consumo registrado: " + valor + "%");
            }

            System.out.println("\n✅ Todos los registros fueron procesados correctamente.");
        } catch (ConsumoCriticoException e) {
            System.out.println("🚨 EXCEPCIÓN: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("👋 Recursos cerrados. Fin del monitoreo.");
        }
    }
}