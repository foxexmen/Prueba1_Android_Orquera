package com.example.prueba1orquera.model;

public class usuario {


    public String Gamertag;
    public String Nombre;
    public String Apellido;
    public String Correo;

    public usuario() {
    }

    public String getGamertag() {
        return Gamertag;
    }

    public void setGamertag(String gamertag) {
        Gamertag = gamertag;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
