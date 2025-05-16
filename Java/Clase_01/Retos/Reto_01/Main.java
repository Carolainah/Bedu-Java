package Reto_01;

package Reto_01;
import java.util.Scanner;

public class Principal {

    // Main donde pedimos la información al usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Se crea objeto paciente
        Paciente paciente1 = new Paciente();

        // Solicitamos datos y asifnamos
        System.out.print("📝 Ingresa el nombre del paciente: ");
        paciente1.nombre = scanner.nextLine();

        System.out.print("🧮 Ingresa la edad: ");
        paciente1.edad = scanner.nextInt();
        // Limpiar el buffer
        scanner.nextLine();

        System.out.print("📁 Ingresa el número de expediente: ");
        paciente1.numeroExpediente = scanner.nextLine();

        // Imprimos los datos
        paciente1.mostrarInformacion();

        // Cerramos
        scanner.close();
    }

}
