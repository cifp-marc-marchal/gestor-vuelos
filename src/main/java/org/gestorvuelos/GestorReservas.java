package org.gestorvuelos;

import java.time.LocalDate;

public class GestorReservas {

    private Reserva[] reservas = new Reserva[0];
    public static void main(String[] args) {
        GestorReservas gr = new GestorReservas();
        GestorVuelos gv = new GestorVuelos();

        gv.addVuelo(new Vuelo("Vuelo1", "Madrid", "Barcelona", LocalDate.of(2022, 12, 1), "10:00", 100, 100));
        gv.addVuelo(new Vuelo("Vuelo2", "Barcelona", "Madrid", LocalDate.of(2022, 12, 2), "11:00", 150, 150));
        gv.addVuelo(new Vuelo("Vuelo3", "Madrid", "Valencia", LocalDate.of(2022, 12, 03), "12:00", 200, 200));

        Vuelo[] idVols = gv.getVuelos();
        String idVol2 = "Vuelo2";
        Integer personas = 4;
        for (int i = 0; i < idVols.length; i++) {
            if (idVols[i].getFlightIdentifier().equals(idVol2)) {
                gr.ferReserva(idVols[i],personas);

                System.out.println(idVols[i].getAsientos_disponibles());
                //gr.validarDisponibilitat(idVols[i],personas);
            }
        }


    }


    public boolean validarDisponibilitat(Vuelo vuelo, Integer pasajeros) {
        Integer asientosDisp = vuelo.getAsientos_disponibles();
        if (pasajeros <= asientosDisp){
            return true;
        }
        return false;
    }

    public boolean ferReserva(Vuelo vuelo, Integer pasajeros) {
        if (validarDisponibilitat(vuelo,pasajeros)){
            Reserva reserva = new Reserva(reservas.length + 1, vuelo.getFlightIdentifier(), 22, vuelo.getFecha(), pasajeros);
            reservas = Utils.addElementToArray(reservas,reserva);
            vuelo.setAsientos_disponibles(vuelo.getAsientos_disponibles() - pasajeros);
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(int idReserva, GestorVuelos gestorVuelos) {
        int index = -1;
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i].getIdReserva() == idReserva) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Reserva no encontrada.");
            return false;
        }

        Reserva reservaCancelada = reservas[index];

        // Buscar el vuelo correspondiente
        Vuelo vuelo = null;
        for (Vuelo v : gestorVuelos.getVuelos()) {
            if (v.getFlightIdentifier().equals(reservaCancelada.getIdVol())) {
                vuelo = v;
                break;
            }
        }

        if (vuelo == null) {
            System.out.println("Vuelo no encontrado para la reserva.");
            return false;
        }

        // Actualizar asientos disponibles
        vuelo.setAsientos_disponibles(vuelo.getAsientos_disponibles() + reservaCancelada.getNumPasajeros());

        // Eliminar reserva del array
        reservas = Utils.removeElementFromArray(reservas, index);

        System.out.println("Reserva cancelada correctamente.");
        return true;
    }

}
