package org.gestorvuelos;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private String idVol;
    private String idUsuari;
    private LocalDate dataReserva;
    private int numPasajeros;

    public Reserva(int idReserva, String idVol, String idUsuari, LocalDate dataReserva, int numPasajeros) {
        this.idReserva = idReserva;
        this.idVol = idVol;
        this.idUsuari = idUsuari;
        this.dataReserva = dataReserva;
        this.numPasajeros = numPasajeros;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public String getIdVol() {
        return idVol;
    }

    public String getIdUsuari() {
        return idUsuari;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }


    @Override
    public String toString() {
        return "Reserva [idReserva=" + idReserva + ", idVol=" + idVol + ", idUsuari=" + idUsuari +
                ", dataReserva=" + dataReserva + ", numPasajeros=" + numPasajeros + "]";
    }
}
