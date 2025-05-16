package Reto_01;

public class Principal {
    public static void main(String[] args) {
        // Crear un pasajero
        Pasajero pasajero = new Pasajero("Ana Carolina", "A9384893");

        // Crear un vuelo
        Vuelo vuelo = new Vuelo("UX123", "Los Ángeles", "7:50");

        // Reservar asiento
        boolean reservado = vuelo.reservarAsiento(pasajero);
        if (reservado) {
            System.out.println("✅ Reserva realizada con éxito.\n");
        } else {
            System.out.println("❌ Error, no se realizó la reserva.\n");
        }

        // Imprimir itinerario
        System.out.println(vuelo.obtenerItinerario());

        // Cancelar reserva
        System.out.println("❌ Cancelando reserva...\n");
        vuelo.cancelarReserva();

        // Imprimir itinerario actualizado
        System.out.println(vuelo.obtenerItinerario());

        // Realizamos una nueva reservacion
        vuelo.reservarAsiento("Bang Chan", "P743827");
        System.out.println(vuelo.obtenerItinerario());
    }
}