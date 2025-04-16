package org.gestorvuelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void getIdUsuario() {
        Usuario usuario = new Usuario("12345678A", "Pepito", "P rez", "pepito@gmail.com", "1234", "123456789");
        assertEquals("12345678A", usuario.getIdUsuario());
    }

    @Test
    void getNombre() {
        Usuario usuario = new Usuario("12345678A", "Pepito", "P rez", "pepito@gmail.com", "1234", "123456789");
        assertEquals("Pepito", usuario.getNombre());
    }

    @Test
    void getApellido1() {
        Usuario usuario = new Usuario("12345678A", "Pepito", "P rez", "pepito@gmail.com", "1234", "123456789");
        assertEquals("P rez", usuario.getApellido1());
    }

    @Test
    void getApellido2() {
        Usuario usuario = new Usuario("12345678A", "Pepito", "P rez", "pepito@gmail.com", "1234", "123456789");
        assertNull(usuario.getApellido2());
    }

    @Test
    void getEmail() {
        Usuario usuario = new Usuario("12345678A", "Pepito", "P rez", "pepito@gmail.com", "1234", "123456789");
        assertEquals("pepito@gmail.com", usuario.getEmail());
    }

    @Test
    void getPassword() {
        Usuario usuario = new Usuario("12345678A", "Pepito", "P rez", "pepito@gmail.com", "1234", "123456789");
        assertEquals("1234", usuario.getPassword());
    }

    @Test
    void getTelefono() {
        Usuario usuario = new Usuario("12345678A", "Pepito", "P rez", "pepito@gmail.com", "1234", "123456789");
        assertEquals("123456789", usuario.getTelefono());
    }
}