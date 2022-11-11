package com.example.apppreguntasfb;

public class Usuarios {
    String Id;
    String Nombre;
    String Correo;
    String Contraseña;
    Boolean tipo;

    public Usuarios(String id, String nombre, String correo, String contraseña, Boolean tipo) {
        Id = id;
        Nombre = nombre;
        Correo = correo;
        Contraseña = contraseña;
        this.tipo = tipo;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
}
