package com.ragnar.lab3_tp1_molina.model;

import androidx.annotation.NonNull;

public class Usuario {
    private long dni;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;

    public Usuario(long dni, String nombre, String apellido, String email, String contraseña) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @NonNull
    @Override
    public String toString() {
        return "Usuario{"+
                " Dni: " + dni + "" +
                " ,Nombre: "+ nombre +"" +
                " ,Apellido: "+ apellido +"" +
                " ,Email: "+ email +"" +
                " ,Contraseña: "+ contraseña +
                "}";
    }
}
