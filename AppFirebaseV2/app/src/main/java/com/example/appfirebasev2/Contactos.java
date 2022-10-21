package com.example.appfirebasev2;

import java.util.UUID;

public class Contactos {
    String ID;
    String Nombre;
    String Telefono;
    int Edad;

    public Contactos(String id, String nombre, String telefono, int edad) {
        ID = id;
        Nombre = nombre;
        Telefono = telefono;
        Edad = edad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = UUID.randomUUID().toString();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return "Contactos{" +
                "ID='" + ID + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Edad=" + Edad +
                '}';
    }
}
