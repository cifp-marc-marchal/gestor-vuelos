package org.gestorvuelos;

import java.time.LocalDate;

public class GestorVuelos {
    private Vuelo[] vuelos = new Vuelo[0];

    public void addVuelo(Vuelo vuelo) {
        Vuelo[] temp = new Vuelo[vuelos.length + 1];
        for (int i = 0; i < vuelos.length; i++) {
            temp[i] = vuelos[i];
        }
        temp[temp.length - 1] = vuelo;
        vuelos = temp;
    }

    public Vuelo[] getVuelos() {
        return vuelos;
    }

    public void deleteVuelo(String flightIdentifier) {
        Vuelo[] temp = new Vuelo[vuelos.length - 1];
        int index = 0;
        for (int i = 0; i < vuelos.length; i++) {
            if (!vuelos[i].getFlightIdentifier().equals(flightIdentifier)) {
                temp[index] = vuelos[i];
                index++;
            }
        }
        vuelos = temp;
    }

    public static Vuelo[] consultarVolsPerDia(Vuelo [] vuelos, LocalDate fecha) {

        Vuelo[] temp = new Vuelo[vuelos.length];
        int contador = 0;

        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i].getFecha().equals(fecha)) {
                temp[contador] = vuelos[i];
                contador++;
            }
        }

        Vuelo[] resultadoFinal = new Vuelo[contador];
        for (int i = 0; i < contador; i++) {
            resultadoFinal[i] = temp[i];
        }

        return resultadoFinal;
    }

    public static Vuelo[] consultarVolsPerSetmana(Vuelo[] vuelos, LocalDate fechaInicioSemana) {
        Vuelo[] temp = new Vuelo[vuelos.length];
        int contador = 0;

        int diaInicio = fechaInicioSemana.getDayOfMonth();
        int mesInicio = fechaInicioSemana.getMonthValue();
        int anioInicio = fechaInicioSemana.getYear();

        for (int i = 0; i < vuelos.length; i++) {
            LocalDate fechaVuelo = vuelos[i].getFecha();

            int diaVuelo = fechaVuelo.getDayOfMonth();
            int mesVuelo = fechaVuelo.getMonthValue();
            int anioVuelo = fechaVuelo.getYear();

            if (anioVuelo == anioInicio && mesVuelo == mesInicio) {
                if (diaVuelo >= diaInicio && diaVuelo <= diaInicio + 6) {
                    temp[contador] = vuelos[i];
                    contador++;
                }
            }
        }

        Vuelo[] resultadoFinal = new Vuelo[contador];
        for (int i = 0; i < contador; i++) {
            resultadoFinal[i] = temp[i];
        }

        return resultadoFinal;
    }




}





