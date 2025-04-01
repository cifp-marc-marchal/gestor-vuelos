package org.gestorvuelos;

import static org.junit.jupiter.api.Assertions.*;

class GestorVuelosTest {

    @org.junit.jupiter.api.Test
    void addVuelo() {
        GestorVuelos gestorVuelos = new GestorVuelos();
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        gestorVuelos.addVuelo(vuelo);
        assertEquals(1, gestorVuelos.getVuelos().length);
        assertEquals("ID123", gestorVuelos.getVuelos()[0].getFlightIdentifier());
    }

    @org.junit.jupiter.api.Test
    void getVuelos() {
        GestorVuelos gestorVuelos = new GestorVuelos();
        Vuelo vuelo1 = new Vuelo("ID123", "Origin1", "Destination1", "2023-10-01", "10:00", 100, 100);
        Vuelo vuelo2 = new Vuelo("ID124", "Origin2", "Destination2", "2023-10-02", "11:00", 150, 150);
        gestorVuelos.addVuelo(vuelo1);
        gestorVuelos.addVuelo(vuelo2);
        Vuelo[] vuelos = gestorVuelos.getVuelos();
        assertEquals(2, vuelos.length);
        assertEquals("ID123", vuelos[0].getFlightIdentifier());
        assertEquals("ID124", vuelos[1].getFlightIdentifier());
    }

    @org.junit.jupiter.api.Test
    void deleteVuelo() {
        GestorVuelos gestorVuelos = new GestorVuelos();
        Vuelo vuelo1 = new Vuelo("ID123", "Origin1", "Destination1", "2023-10-01", "10:00", 100, 100);
        Vuelo vuelo2 = new Vuelo("ID124", "Origin2", "Destination2", "2023-10-02", "11:00", 150, 150);
        gestorVuelos.addVuelo(vuelo1);
        gestorVuelos.addVuelo(vuelo2);
        gestorVuelos.deleteVuelo("ID123");
        assertEquals(1, gestorVuelos.getVuelos().length);
        assertEquals("ID124", gestorVuelos.getVuelos()[0].getFlightIdentifier());
    }
}