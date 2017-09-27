package com.victorsaico.mbrtechnology;

/**
 * Created by JARVIS on 25/09/2017.
 */

public class Usuario {
    private String username;
    private String password;
    private String nombres;
    private String rol;

    public Usuario(String username, String password, String nombres, String rol) {
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
