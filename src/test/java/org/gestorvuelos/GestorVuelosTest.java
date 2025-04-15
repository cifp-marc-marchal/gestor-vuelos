package org.gestorvuelos;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class GestorVuelosTest {

    @org.junit.jupiter.api.Test
    void addVuelo() {
        GestorVuelos gestorVuelos = new GestorVuelos();
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", LocalDate.of(2023, 10, 1), "10:00", 100, 100);
        gestorVuelos.addVuelo(vuelo);
        assertEquals(1, gestorVuelos.getVuelos().length);
        assertEquals("ID123", gestorVuelos.getVuelos()[0].getFlightIdentifier());
    }

    @org.junit.jupiter.api.Test
    void getVuelos() {
        GestorVuelos gestorVuelos = new GestorVuelos();
        Vuelo vuelo1 = new Vuelo("ID123", "Origin1", "Destination1", LocalDate.of(2023, 10, 1), "10:00", 100, 100);
        Vuelo vuelo2 = new Vuelo("ID124", "Origin2", "Destination2", LocalDate.of(2023, 10, 2), "11:00", 150, 150);
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
        Vuelo vuelo1 = new Vuelo("ID123", "Origin1", "Destination1", LocalDate.of(2023, 10, 1), "10:00", 100, 100);
        Vuelo vuelo2 = new Vuelo("ID124", "Origin2", "Destination2", LocalDate.of(2023, 10, 2), "11:00", 150, 150);
        gestorVuelos.addVuelo(vuelo1);
        gestorVuelos.addVuelo(vuelo2);
        gestorVuelos.deleteVuelo("ID123");
        assertEquals(1, gestorVuelos.getVuelos().length);
        assertEquals("ID124", gestorVuelos.getVuelos()[0].getFlightIdentifier());
    }


    @org.junit.jupiter.api.Test
    void consultarVolsPerSetmana() {
        //arrange
        Vuelo[] vuelos = new Vuelo[5];
        vuelos[0] = new Vuelo("A123", "Madrid", "París", LocalDate.of(2025, 4, 12), "10:00", 180, 50);
        vuelos[1] = new Vuelo("B456", "Madrid", "Londres", LocalDate.of(2025, 4, 14), "12:00", 200, 80);
        vuelos[2] = new Vuelo("C789", "Barcelona", "Roma", LocalDate.of(2025, 4, 16), "14:00", 150, 75);
        vuelos[3] = new Vuelo("D321", "Madrid", "Berlín", LocalDate.of(2025, 4, 21), "16:00", 160, 60);
        vuelos[4] = new Vuelo("E654", "Valencia", "Lisboa", LocalDate.of(2025, 4, 18), "09:00", 140, 90);
        //add
        LocalDate fechaInicioSemana = LocalDate.of(2023, 10, 2);
        Vuelo[] vuelosSemana = GestorVuelos.consultarVolsPerSetmana(vuelos, fechaInicioSemana);
        //assert
        assertEquals(4, vuelosSemana.length, "El número de vuelos debería ser 4");

        assertEquals("A123", vuelosSemana[0].getFlightIdentifier());
        assertEquals("B456", vuelosSemana[1].getFlightIdentifier());
        assertEquals("C789", vuelosSemana[2].getFlightIdentifier());
        assertEquals("E654", vuelosSemana[3].getFlightIdentifier());

        assertNotEquals("D321", vuelosSemana[3].getFlightIdentifier(), "El vuelo D321 no debería estar en esa semana");
    }

    @Test
    public void testConsultarVuelosPorDia() {
        //arrange
        Vuelo[] vuelos = new Vuelo[5];
        vuelos[0] = new Vuelo("A123", "Madrid", "París", LocalDate.of(2025, 4, 12), "10:00", 180, 50);
        vuelos[1] = new Vuelo("B456", "Madrid", "Londres", LocalDate.of(2025, 4, 14), "12:00", 200, 80);
        vuelos[2] = new Vuelo("C789", "Barcelona", "Roma", LocalDate.of(2025, 4, 12), "14:00", 150, 75);
        vuelos[3] = new Vuelo("D321", "Madrid", "Berlín", LocalDate.of(2025, 4, 21), "16:00", 160, 60);
        vuelos[4] = new Vuelo("E654", "Valencia", "Lisboa", LocalDate.of(2025, 4, 12), "09:00", 140, 90);
        //add
        LocalDate fechaConsulta = LocalDate.of(2025, 4, 12);

        Vuelo[] vuelosDia = GestorVuelos.consultarVolsPerDia(vuelos, fechaConsulta);
        //assert
        assertEquals(3, vuelosDia.length, "El número de vuelos debería ser 3 para esa fecha");

        assertEquals("A123", vuelosDia[0].getFlightIdentifier());
        assertEquals("C789", vuelosDia[1].getFlightIdentifier());
        assertEquals("E654", vuelosDia[2].getFlightIdentifier());

        assertNotEquals("B456", vuelosDia[2].getFlightIdentifier(), "El vuelo B456 no debería estar en esa fecha");
        assertNotEquals("D321", vuelosDia[2].getFlightIdentifier(), "El vuelo D321 no debería estar en esa fecha");
    }


}





