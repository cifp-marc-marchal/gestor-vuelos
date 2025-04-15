package org.gestorvuelos;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    @Test
    void getIdReserva() {
        Reserva reserva = new Reserva(1, "ID123", 202, LocalDate.of(2023, 10, 1), 2);
        assertEquals(1, reserva.getIdReserva());
    }

    @Test
    void getIdVol() {
        Reserva reserva = new Reserva(1, "ID123", 202, LocalDate.of(2023, 10, 1), 2);
        assertEquals("ID123", reserva.getIdVol());
    }

    @Test
    void getIdUsuari() {
        Reserva reserva = new Reserva(1, "ID123", 202, LocalDate.of(2023, 10, 1), 2);
        assertEquals(202, reserva.getIdUsuari());
    }

    @Test
    void getDataReserva() {
        Reserva reserva = new Reserva(1, "ID123", 202, LocalDate.of(2023, 10, 1), 2);
        assertEquals(LocalDate.of(2023, 10, 1), reserva.getDataReserva());
    }

    @Test
    void getNumPasajeros() {
        Reserva reserva = new Reserva(1, "ID123", 202, LocalDate.of(2023, 10, 1), 2);
        assertEquals(2, reserva.getNumPasajeros());
    }


    @Test
    void testConstructorAndGetters() {
        LocalDate fecha = LocalDate.of(2023, 10, 1);
        Reserva reserva = new Reserva(1, "ID123", 202, fecha, 3);

        assertEquals(1, reserva.getIdReserva());
        assertEquals("ID123", reserva.getIdVol());
        assertEquals(202, reserva.getIdUsuari());
        assertEquals(fecha, reserva.getDataReserva());
        assertEquals(3, reserva.getNumPasajeros());
    }

    @Test
    void testToString() {
        LocalDate fecha = LocalDate.of(2023, 10, 1);
        Reserva reserva = new Reserva(1, "ID123", 202, fecha, 3);

        String expected = "Reserva [idReserva=1, idVol=ID123, idUsuari=202, dataReserva=2023-10-01, numPasajeros=3]";
        assertEquals(expected, reserva.toString());
    }
}
