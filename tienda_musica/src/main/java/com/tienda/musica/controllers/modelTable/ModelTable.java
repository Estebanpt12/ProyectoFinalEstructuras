package com.tienda.musica.controllers.modelTable;

import javafx.scene.image.ImageView;
import java.util.Objects;

public class ModelTable {
    private ImageView caratula;
    private String nombre;
    private String nombreAlbum;
    private int anio;
    private String duracion;
    private String genero;
    private String autor;

    public ModelTable() {
    }

    public ModelTable(ImageView caratula, String nombre, String nombreAlbum, int anio, String duracion,
            String genero, String autor) {
        this.caratula = caratula;
        this.nombre = nombre;
        this.nombreAlbum = nombreAlbum;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
        this.autor = autor;
    }

    public ImageView getCaratula() {
        return this.caratula;
    }

    public void setCaratula(ImageView caratula) {
        this.caratula = caratula;
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

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ModelTable caratula(ImageView caratula) {
        setCaratula(caratula);
        return this;
    }

    public ModelTable nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public ModelTable nombreAlbum(String nombreAlbum) {
        setNombreAlbum(nombreAlbum);
        return this;
    }

    public ModelTable anio(int anio) {
        setAnio(anio);
        return this;
    }

    public ModelTable duracion(String duracion) {
        setDuracion(duracion);
        return this;
    }

    public ModelTable genero(String genero) {
        setGenero(genero);
        return this;
    }

    public ModelTable autor(String autor) {
        setAutor(autor);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ModelTable)) {
            return false;
        }
        ModelTable modelTable = (ModelTable) o;
        return Objects.equals(caratula, modelTable.caratula) && Objects.equals(nombre, modelTable.nombre)
                && Objects.equals(nombreAlbum, modelTable.nombreAlbum) && anio == modelTable.anio
                && Objects.equals(duracion, modelTable.duracion) && Objects.equals(genero, modelTable.genero)
                && Objects.equals(autor, modelTable.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caratula, nombre, nombreAlbum, anio, duracion, genero, autor);
    }

    @Override
    public String toString() {
        return "{" +
                " caratula='" + getCaratula() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", nombreAlbum='" + getNombreAlbum() + "'" +
                ", anio='" + getAnio() + "'" +
                ", duracion='" + getDuracion() + "'" +
                ", genero='" + getGenero() + "'" +
                ", autor='" + getAutor() + "'" +
                "}";
    }

}
