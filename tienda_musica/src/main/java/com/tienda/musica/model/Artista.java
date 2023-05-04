package com.tienda.musica.model;

import java.io.Serializable;
import java.util.Objects;

import com.tienda.musica.exceptions.DataNotFoundException;
import com.tienda.musica.model.lists.ListaDoblementeEnlazadaCanciones;
import com.tienda.musica.utils.Formatter;

public class Artista implements Serializable {

    private int codigo;
    private String nombre;
    private String nacionalidad;
    private boolean esArtista;
    private ListaDoblementeEnlazadaCanciones listaCanciones;
    private int sizeCanciones;

    public Artista() {
    }

    public Artista(int codigo, String nombre, String nacionalidad, boolean esArtista) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.esArtista = esArtista;
        this.listaCanciones = new ListaDoblementeEnlazadaCanciones();
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isEsArtista() {
        return this.esArtista;
    }

    public boolean getEsArtista() {
        return this.esArtista;
    }

    public int getSizeCanciones() {
        return this.sizeCanciones;
    }

    public void setSizeCanciones(int sizeCanciones) {
        this.sizeCanciones = sizeCanciones;
    }

    public void setEsArtista(boolean esArtista) {
        this.esArtista = esArtista;
    }

    public Artista codigo(int codigo) {
        setCodigo(codigo);
        return this;
    }

    public Artista nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Artista nacionalidad(String nacionalidad) {
        setNacionalidad(nacionalidad);
        return this;
    }

    public ListaDoblementeEnlazadaCanciones getListaCanciones() {
        return this.listaCanciones;
    }

    public void setListaCanciones(ListaDoblementeEnlazadaCanciones listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public Artista esArtista(boolean esArtista) {
        setEsArtista(esArtista);
        return this;
    }

    public void agregarCancion(String nombre, String nombreAlbum, String caratula, int anio, String duracion,
            String genero, String url) {
        listaCanciones.add(sizeCanciones, new Cancion(String.valueOf(sizeCanciones), nombre, nombreAlbum, caratula,
                anio, Formatter.formatTime(duracion), genero, url));
        sizeCanciones += 1;
    }

    public Cancion borrarCancion(String nombre) throws DataNotFoundException {
        return listaCanciones.delete(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Artista)) {
            return false;
        }
        Artista artista = (Artista) o;
        return Objects.equals(codigo, artista.codigo) && Objects.equals(nombre, artista.nombre)
                && Objects.equals(nacionalidad, artista.nacionalidad) && esArtista == artista.esArtista;
    }

    @Override
    public String toString() {
        return "{" +
                " codigo='" + getCodigo() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", nacionalidad='" + getNacionalidad() + "'" +
                ", esArtista='" + isEsArtista() + "'" +
                ", listaCanciones='" + getListaCanciones() + "'" +
                "}";
    }

}
