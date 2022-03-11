package com.example.masterdetail.utils;

import java.io.Serializable;

public class Jugador implements Serializable {
    private int foto;
    private String nombre, habilidad, nacionalidad;

    public Jugador(int foto, String nombre, String habilidad, String nacionalidad) {
        this.foto = foto;
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.nacionalidad = nacionalidad;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
