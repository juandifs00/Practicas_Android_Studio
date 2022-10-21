package com.example.firebasedb;

public class Contacto {
    String Id;
    String Nombre;
    String Apellido;
    String Telefono;

    public Contacto(String id, String nombre, String apellido, String telefono) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
