package org.gestorvuelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificacionTest {

    private Notificacion notificacion;

    @BeforeEach
    void setup() {
        notificacion = new Notificacion();
    }

    @Test
    void notificar() {
        //GIVEN
        String message = "This is a test message";

        //WHEN
        notificacion.notificar(message, 1);

        //THEN
        // If the method has side effects or outputs, you'd assert them here
        // For now, if there's no assertion, you're only verifying it doesn't throw exceptions
    }
}
