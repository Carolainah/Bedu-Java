import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

// Excepción personalizada (checked)
class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}

public class MonitorCPU {

    public static void main(String[] args) {
        System.out.println("🔧 Iniciando monitoreo de CPU con datos simulados...\n");

        // Datos simulados (puedes cambiarlos para probar)
        List<String> consumosSimulados = Arrays.asList("30", "85", "95", "97", "85", "abc", "-5", "105");

        HashSet<Integer> registros = new HashSet<>();

        for (String entrada : consumosSimulados) {
            System.out.println("📥 Procesando entrada: " + entrada);

            try {
                int valor = Integer.parseInt(entrada);

                if (valor < 0 || valor > 100) {
                    System.out.println("⚠️ Valor fuera de rango: " + valor + "%. Solo se permiten valores entre 0 y 100.");
                    continue;
                }

                if (!registros.add(valor)) {
                    System.out.println("⚠️ Valor duplicado detectado: " + valor + "%. Se ignorará.");
                    continue;
                }

                if (valor > 95) {
                    throw new ConsumoCriticoException("🔥 Consumo crítico en servidor. CPU al " + valor + "%");
                }

                System.out.println("✅ Consumo registrado correctamente: " + valor + "%");

            } catch (NumberFormatException e) {
                System.out.println("❌ Error de formato: '" + entrada + "' no es un número válido.");
            } catch (ConsumoCriticoException e) {
                System.out.println("🚨 EXCEPCIÓN CRÍTICA: " + e.getMessage());
            } finally {
                System.out.println("📌 Entrada procesada.\n");
            }
        }

        System.out.println("✅ Finalizó el monitoreo. Registros válidos: " + registros);
    }
}
