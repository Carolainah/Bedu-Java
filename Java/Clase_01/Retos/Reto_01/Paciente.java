package Reto_01;

import java.util.Scanner;

public class Paciente {
    String nombre;
    int edad;
    String numeroExpediente;

    // Método para imprimir
    void mostrarInformacion() {
        System.out.println("\n📋 Información del paciente:");
        System.out.println("📝 Paciente: " + nombre);
        System.out.println("🧮 Edad: " + edad);
        System.out.println("📁 Expediente: " + numeroExpediente);
    }
}