package org.gestorvuelos;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    @Test
    void getIdReserva() {
        Reserva reserva = new Reserva(1, 101, 202, LocalDate.of(2025, 4, 2));
        assertEquals(1, reserva.getIdReserva());
    }

    @Test
    void getIdVol() {
        Reserva reserva = new Reserva(1, 101, 202, LocalDate.of(2025, 4, 2));
        assertEquals(101, reserva.getIdVol());
    }

    @Test
    void getIdUsuari() {
        Reserva reserva = new Reserva(1, 101, 202, LocalDate.of(2025, 4, 2));
        assertEquals(202, reserva.getIdUsuari());
    }

    @Test
    void getDataReserva() {
        LocalDate fecha = LocalDate.of(2025, 4, 2);
        Reserva reserva = new Reserva(1, 101, 202, fecha);
        assertEquals(fecha, reserva.getDataReserva());
    }

    @Test
    void testToString() {
        Reserva reserva = new Reserva(1, 101, 202, LocalDate.of(2025, 4, 2));
        String esperado = "Reserva [idReserva=1, idVol=101, idUsuari=202, dataReserva=2025-04-02]";
        assertEquals(esperado, reserva.toString());
    }
}