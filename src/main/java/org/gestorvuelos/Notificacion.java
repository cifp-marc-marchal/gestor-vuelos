package org.gestorvuelos;

public class Notificacion {
    public void notificar(String message, int userId) {
        System.out.println("Notificación para el usuario con id " + userId + ": " + message);
    }
}