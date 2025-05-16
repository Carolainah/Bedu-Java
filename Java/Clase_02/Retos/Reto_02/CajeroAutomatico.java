package Reto_02;
// Importamos scanner para poder recibir la información del usuario
import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {

        // Creamos objeto scanner
        Scanner scanner = new Scanner(System.in);
        // Saldo inicial
        var saldo = 1000.0;
        int opcion; // Variable para almacenar la opción del menú

        // Repetir el menú mientras la opción no sea salir (4)
        do {
            // Mostramos menú de opciones
            System.out.println("\n💳 Bienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt(); // Leer la opción elegida por el usuario

            switch (opcion) {
                case 1 -> {
                    // Consultamos saldo
                    System.out.println("🔎 Tu saldo actual es: $" + saldo);
                }
                case 2 -> {
                    // Depositamos dinero
                    System.out.print("💰 Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("⚠️ El monto debe ser mayor a 0.");
                        // Volver al menú sin modificar el saldo
                        continue;
                    }

                    // Aumentar el saldo
                    saldo += deposito;
                    System.out.println("✅ Depósito realizado. Saldo actualizado: $" + saldo);
                }
                case 3 -> {
                    // Retirar dinero
                    System.out.print("💸 Ingresa el monto a retirar: ");
                    double retiro = scanner.nextDouble();

                    if (retiro <= 0) {
                        System.out.println("⚠️ El monto debe ser mayor a 0.");
                        // Volver al menú sin hacer nada
                        continue;
                    }

                    // Si el saldo es insuficiente
                    if (retiro > saldo) {
                        System.out.println("❌ Saldo insuficiente. Tu saldo es: $" + saldo);
                    } else {
                        // Restar el monto del saldo
                        saldo -= retiro;
                        System.out.println("✅ Retiro exitoso. Saldo restante: $" + saldo);
                    }
                }
                case 4 -> {
                    // Salir del programa
                    System.out.println("👋 Gracias por usar el cajero. ¡Hasta pronto!");
                }
                default -> {
                    // Opción no válida
                    System.out.println("🚫 Opción inválida. Intenta nuevamente.");
                }
            }

            // Salir cuando el usuario elija la opción 4
        } while (opcion != 4);

        scanner.close();
    }
}