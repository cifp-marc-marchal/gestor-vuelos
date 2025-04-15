package org.gestorvuelos;

import java.time.LocalDate;

public class Vuelo {
    private String flightIdentifier;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private String hora;
    private Integer asientos;
    private Integer asientos_disponibles;

    public Vuelo(String flightIdentifier, String origen, String destino, LocalDate fecha, String hora, Integer asientos, Integer asientos_disponibles) {
        this.flightIdentifier = flightIdentifier;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.asientos = asientos;
        this.asientos_disponibles = asientos_disponibles;
    }

    public String getFlightIdentifier() {
        return flightIdentifier;
    }

    public void setFlightIdentifier(String flightIdentifier) {
        this.flightIdentifier = flightIdentifier;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getAsientos() {
        return asientos;
    }

    public void setAsientos(Integer asientos) {
        this.asientos = asientos;
    }


    public Integer getAsientos_disponibles() {
        return asientos_disponibles;
    }

    public void setAsientos_disponibles(Integer asientos_disponibles) {
        this.asientos_disponibles = asientos_disponibles;
    }
}
