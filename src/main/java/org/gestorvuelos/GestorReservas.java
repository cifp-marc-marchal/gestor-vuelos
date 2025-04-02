package org.gestorvuelos;

import java.time.LocalDate;

public class GestorReservas {
    private int[] idVols = {101, 102, 103}; // Lista de vuelos
    private int[] placesDisponibles = {2, 1, 3}; // Plazas disponibles para cada vuelo

    public boolean validarDisponibilitat(int idVol) {
        for (int i = 0; i < idVols.length; i++) {
            if (idVols[i] == idVol) {
                return placesDisponibles[i] > 0;
            }
        }
        return false;
    }

    public boolean ferReserva(int idReserva, int idVol, int idUsuari) {
        for (int i = 0; i < idVols.length; i++) {
            if (idVols[i] == idVol && placesDisponibles[i] > 0) {
                placesDisponibles[i]--; // Restamos una plaza
                System.out.println("Reserva confirmada: " + new Reserva(idReserva, idVol, idUsuari, LocalDate.now()));
                return true;
            }
        }
        System.out.println("No hay plazas disponibles para el vuelo " + idVol);
        return false;
    }
}
