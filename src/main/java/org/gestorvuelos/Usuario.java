package org.gestorvuelos;

public class Usuario {
    private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String password;
    private String telefono;

    public Usuario(String DNI, String nombre, String apellido1, String apellido2, String email, String password, String telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public Usuario(String DNI, String nombre, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario(String s, String pepito, String pRez, String mail, String number, String number1) {
    }

    public String getIdUsuario() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }
}
