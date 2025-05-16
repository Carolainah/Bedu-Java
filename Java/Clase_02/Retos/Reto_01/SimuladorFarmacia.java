package Reto_01;
import java.util.Scanner;


public class SimuladorFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitamos datos al usuario
        System.out.print("Nombre del medicamento: ");
        String medicamento = scanner.nextLine();

        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        System.out.print("Cantidad de piezas: ");
        int cantidad = scanner.nextInt();

        // Total
        double totalSinDescuento = precioUnitario * cantidad;

        // Evaluamos el descuento usando operador ternario
        var aplicaDescuento = totalSinDescuento > 500; // Al menos una implementacion de var
        double descuento = aplicaDescuento ? totalSinDescuento * 0.15 : 0;

        // Total a pagar
        double totalConDescuento = totalSinDescuento - descuento;

        // Mostrar ticket
        System.out.println("\n🧾 Resumen de compra:");
        System.out.println("Medicamento: " + medicamento);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        System.out.println("Descuento: $" + descuento);
        System.out.println("🌸Total a pagar: $" + totalConDescuento);

        // Cerramos el scanner
        scanner.close();
    }
}