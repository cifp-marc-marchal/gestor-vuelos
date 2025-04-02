package org.gestorvuelos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestorReservasTest {

    @Test
    void validarDisponibilitat() {
        GestorReservas gestor = new GestorReservas();
        assertTrue(gestor.validarDisponibilitat(101));
        assertFalse(gestor.validarDisponibilitat(999));
    }

    @Test
    void ferReserva() {
        GestorReservas gestor = new GestorReservas();
        boolean primeraReserva = gestor.ferReserva(1, 101, 202);
        assertTrue(primeraReserva);
        boolean segundaReserva = gestor.ferReserva(2, 101, 203);
        boolean terceraReserva = gestor.ferReserva(3, 101, 204); // Puede fallar si no hay más plazas
        if (!segundaReserva) {
            assertFalse(terceraReserva);
        }
    }
}