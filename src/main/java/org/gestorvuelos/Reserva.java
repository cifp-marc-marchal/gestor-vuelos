package org.gestorvuelos;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private String idVol;
    private int idUsuari;
    private LocalDate dataReserva;

    public Reserva(int idReserva, String idVol, int idUsuari, LocalDate dataReserva) {
        this.idReserva = idReserva;
        this.idVol = idVol;
        this.idUsuari = idUsuari;
        this.dataReserva = dataReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public String getIdVol() {
        return idVol;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    @Override
    public String toString() {
        return "Reserva [idReserva=" + idReserva + ", idVol=" + idVol + ", idUsuari=" + idUsuari + ", dataReserva=" + dataReserva + "]";
    }
}
