package com.tienda.musica.model;

import java.io.Serializable;
import java.util.Objects;

public class Artista implements Serializable {

    private String codigo;
    private String nombre;
    private String nacionalidad;
    private boolean esArtista;

    public Artista() {
    }

    public Artista(String codigo, String nombre, String nacionalidad, boolean esArtista) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.esArtista = esArtista;
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

    public void setEsArtista(boolean esArtista) {
        this.esArtista = esArtista;
    }

    public Artista codigo(String codigo) {
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

    public Artista esArtista(boolean esArtista) {
        setEsArtista(esArtista);
        return this;
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
}
