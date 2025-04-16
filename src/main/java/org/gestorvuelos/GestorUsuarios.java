package org.gestorvuelos;

import java.util.ArrayList;
import java.util.Optional;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuario(String DNI) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(DNI)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean deleteUsuario(String DNI) {
        return usuarios.removeIf(usuario -> usuario.getIdUsuario().equals(DNI));
    }
}