package org.gestorvuelos;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestorReservasTest {
        @Test
        void validarDisponibilitat() {
            GestorReservas gestorReservas = new GestorReservas();
            Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", LocalDate.of(2023, 10, 1), "10:00", 100, 50);
            Usuario usuario = new Usuario("Pepito", "Pérez", "pepito@gmail.com");

            // Caso válido
            assertTrue(gestorReservas.validarDisponibilitat(vuelo, 50));

            // Caso inválido (más pasajeros que asientos disponibles)
            assertFalse(gestorReservas.validarDisponibilitat(vuelo, 51));
        }

        @Test
        void ferReserva() {
            GestorReservas gestorReservas = new GestorReservas();
            Vuelo vuelo = new Vuelo("ID123", "Origin", "Destination", LocalDate.of(2023, 10, 1), "10:00", 100, 50);
            Usuario usuario = new Usuario("Pepito", "Pérez", "pepito@gmail.com");

            // Reserva válida
            assertTrue(gestorReservas.ferReserva(vuelo, usuario, 25));
            assertEquals(25, vuelo.getAsientos_disponibles());

            // Reserva inválida (no hay suficientes asientos)
            assertFalse(gestorReservas.ferReserva(vuelo, usuario, 30));
            assertEquals(25, vuelo.getAsientos_disponibles()); // sin cambios
        }

        @Test
        void cancelarReservaCorrecta() {
            GestorReservas gestorReservas = new GestorReservas();
            GestorVuelos gestorVuelos = new GestorVuelos();
            Vuelo vuelo = new Vuelo("V100", "Madrid", "Sevilla", LocalDate.of(2025, 5, 10), "08:00", 100, 100);
            Usuario usuario = new Usuario("Pepito", "Pérez", "pepito@gmail.com");
            gestorVuelos.addVuelo(vuelo);

            // Reservamos 3 asientos
            assertTrue(gestorReservas.ferReserva(vuelo, usuario, 3));
            assertEquals(97, vuelo.getAsientos_disponibles());

            // Cancelamos la reserva (ID 1)
            boolean cancelada = gestorReservas.cancelarReserva(1, gestorVuelos);
            assertTrue(cancelada);
            assertEquals(100, vuelo.getAsientos_disponibles());
        }

        @Test
        void cancelarReservaInexistente() {
            GestorReservas gestorReservas = new GestorReservas();
            GestorVuelos gestorVuelos = new GestorVuelos();
            Vuelo vuelo = new Vuelo("V100", "Madrid", "Sevilla", LocalDate.of(2025, 5, 10), "08:00", 100, 100);
            Usuario usuario = new Usuario("Pepito", "Pérez", "pepito@gmail.com");
            gestorVuelos.addVuelo(vuelo);

            // Intentamos cancelar reserva inexistente
            boolean resultado = gestorReservas.cancelarReserva(99, gestorVuelos);
            assertFalse(resultado);
        }

        @Test
        void cancelarReservaVueloNoEncontrado() {
            GestorReservas gestorReservas = new GestorReservas();
            GestorVuelos gestorVuelos = new GestorVuelos();
            Vuelo vuelo = new Vuelo("V101", "Madrid", "Valencia", LocalDate.of(2025, 5, 12), "09:00", 150, 150);
            Usuario usuario = new Usuario("Pepito", "Pérez", "pepito@gmail.com");
            gestorVuelos.addVuelo(vuelo);

            // Creamos reserva
            assertTrue(gestorReservas.ferReserva(vuelo, usuario, 2));
            assertEquals(148, vuelo.getAsientos_disponibles());

            // Simulamos que el vuelo ya no existe
            gestorVuelos = new GestorVuelos(); // vacío

            boolean resultado = gestorReservas.cancelarReserva(1, gestorVuelos);
            assertFalse(resultado);
        }
    }