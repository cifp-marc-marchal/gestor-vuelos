package org.gestorvuelos;

import java.time.LocalDate;

public class GestorReservas {
    private Reserva[] reservas = new Reserva[0];

    public boolean validarDisponibilitat(Vuelo vuelo, Integer pasajeros) {
        Integer asientosDisp = vuelo.getAsientos_disponibles();
        if (pasajeros <= asientosDisp){
            return true;
        }
        return false;
    }

    public boolean ferReserva(Vuelo vuelo, Usuario usuari, Integer pasajeros) {
        if (validarDisponibilitat(vuelo,pasajeros)){
            Reserva reserva = new Reserva(reservas.length + 1, vuelo.getFlightIdentifier(), usuari.getIdUsuario(), vuelo.getFecha(), pasajeros);
            reservas = Utils.addElementToArray(reservas,reserva);
            vuelo.setAsientos_disponibles(vuelo.getAsientos_disponibles() - pasajeros);
            return true;
        }
        return false;
    }

    public Reserva[] getReservesPerUsuari(Usuario usuari) {
        Reserva[] temp = new Reserva[0];
        for (Reserva r : reservas) {
            if (r.getIdUsuari() == usuari.getIdUsuario()) {
                temp = Utils.addElementToArray(temp, r);
            }
        }
        return temp;
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
