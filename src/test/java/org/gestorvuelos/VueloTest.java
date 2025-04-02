package org.gestorvuelos;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VueloTest {

    @Test
    void getFlightIdentifier() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        assertNotNull(vuelo.getFlightIdentifier());
        assertEquals("ID123", vuelo.getFlightIdentifier());
    }

    @Test
    void setFlightIdentifier() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        vuelo.setFlightIdentifier("ID124");
        assertEquals("ID124", vuelo.getFlightIdentifier());
    }

    @Test
    void getOrigen() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        assertNotNull(vuelo.getOrigen());
        assertEquals("Origin", vuelo.getOrigen());
    }

    @Test
    void setOrigen() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        vuelo.setOrigen("Origin2");
        assertEquals("Origin2", vuelo.getOrigen());
    }

    @Test
    void getDestino() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        assertNotNull(vuelo.getDestino());
        assertEquals("Destination", vuelo.getDestino());
    }

    @Test
    void setDestino() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        vuelo.setDestino("Destination2");
        assertEquals("Destination2", vuelo.getDestino());
    }

    @Test
    void getFecha() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        assertNotNull(vuelo.getFecha());
        assertEquals("2023-10-01", vuelo.getFecha());
    }

    @Test
    void setFecha() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        vuelo.setFecha("2023-10-02");
        assertEquals("2023-10-02", vuelo.getFecha());
    }

    @Test
    void getHora() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        assertNotNull(vuelo.getHora());
        assertEquals("10:00", vuelo.getHora());
    }

    @Test
    void setHora() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        vuelo.setHora("11:00");
        assertEquals("11:00", vuelo.getHora());
    }

    @Test
    void getAsientos() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        assertNotNull(vuelo.getAsientos());
        assertEquals(100, vuelo.getAsientos());
    }

    @Test
    void setAsientos() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        vuelo.setAsientos(150);
        assertEquals(150, vuelo.getAsientos());
    }

    @Test
    void getAsientos_disponibles() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        assertNotNull(vuelo.getAsientos_disponibles());
        assertEquals(100, vuelo.getAsientos_disponibles());
    }

    @Test
    void setAsientos_disponibles() {
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", "2023-10-01", "10:00", 100, 100);
        vuelo.setAsientos_disponibles(150);
        assertEquals(150, vuelo.getAsientos_disponibles());
    }

}