package org.gestorvuelos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestorUsuariosTest {

    @Test
    void addUsuario() {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        Usuario usuario = new Usuario("Pepito", "P rez", "pepito@gmail.com");
        gestorUsuarios.addUsuario(usuario);
        assertEquals(usuario, gestorUsuarios.getUsuario("Pepito"));
    }

    @Test
    void getUsuarios() {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        Usuario usuario1 = new Usuario("Pepito", "P rez", "pepito@gmail.com");
        Usuario usuario2 = new Usuario("Manuel", "L pez", "manuel@gmail.com");
        gestorUsuarios.addUsuario(usuario1);
        gestorUsuarios.addUsuario(usuario2);
        ArrayList<Usuario> usuarios = gestorUsuarios.getUsuarios();
        assertEquals(usuario1, usuarios.get(0));
        assertEquals(usuario2, usuarios.get(1));
    }

    @Test
    void getUsuario() {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        Usuario usuario = new Usuario("Pepito", "P rez", "pepito@gmail.com");
        gestorUsuarios.addUsuario(usuario);
        assertEquals(usuario, gestorUsuarios.getUsuario("Pepito"));
    }

    @Test
    void deleteUsuario() {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        Usuario usuario = new Usuario("Pepito", "P rez", "pepito@gmail.com");
        gestorUsuarios.addUsuario(usuario);
        assertTrue(gestorUsuarios.deleteUsuario("Pepito"));
        assertNull(gestorUsuarios.getUsuario("Pepito"));
    }
}