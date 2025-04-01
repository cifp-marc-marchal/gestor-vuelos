package org.gestorvuelos;

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
}
