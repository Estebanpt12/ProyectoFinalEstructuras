package com.tienda.musica.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Cancion implements Serializable {

    private String codigo;
    private String nombre;
    private String nombreAlbum;
    private String caratula;
    private int anio;
    private LocalTime duracion;
    private String genero;
    private String url;

    public Cancion() {
    }

    public Cancion(String codigo, String nombre, String nombreAlbum, String caratula, int anio, LocalTime duracion,
            String genero, String url) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreAlbum = nombreAlbum;
        this.caratula = caratula;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
        this.url = url;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAlbum() {
        return this.nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getCaratula() {
        return this.caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public LocalTime getDuracion() {
        return this.duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "\nNombre: " + nombre + "\nNombre album: " + nombreAlbum +
                "\nAño: " + anio + "\nDuracion: " + duracion.toString() + "\nGenero: " + genero + "\nUrl: " + url
                + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cancion)) {
            return false;
        }
        Cancion cancion = (Cancion) o;
        return Objects.equals(codigo, cancion.codigo) && Objects.equals(nombre, cancion.nombre)
                && Objects.equals(nombreAlbum, cancion.nombreAlbum) && Objects.equals(caratula, cancion.caratula)
                && anio == cancion.anio && Objects.equals(duracion, cancion.duracion)
                && Objects.equals(genero, cancion.genero) && Objects.equals(url, cancion.url);
    }
}
