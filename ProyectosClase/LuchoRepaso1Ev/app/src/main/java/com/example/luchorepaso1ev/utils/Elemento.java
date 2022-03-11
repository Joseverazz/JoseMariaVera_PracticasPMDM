package com.example.luchorepaso1ev.utils;

public class Elemento {
    private String nombre, caracteristica, categoria;
    private int foto;

    public Elemento(String nombre, String pais, int foto, String categoria) {
        this.nombre = nombre;
        this.caracteristica = pais;
        this.categoria = categoria;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
