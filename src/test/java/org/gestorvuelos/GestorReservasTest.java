package org.gestorvuelos;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestorReservasTest {

    @Test
    void validarDisponibilitat() {
        GestorReservas gestorReservas = new GestorReservas();
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", LocalDate.of(2023, 10, 1), "10:00", 100, 50);
        assertTrue(gestorReservas.validarDisponibilitat(vuelo, 50));
        assertFalse(gestorReservas.validarDisponibilitat(vuelo, 51));
    }

    @Test
    void ferReserva() {
        GestorReservas gestorReservas = new GestorReservas();
        Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", LocalDate.of(2023, 10, 1), "10:00", 100, 50);
        assertTrue(gestorReservas.ferReserva(vuelo, 25));
        assertEquals(25, vuelo.getAsientos_disponibles());
        assertFalse(gestorReservas.ferReserva(vuelo, 30));
    }
}