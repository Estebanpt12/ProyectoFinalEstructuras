package com.tienda.musica.model.nodos;

import java.io.Serializable;

import com.tienda.musica.model.Artista;
import java.util.Objects;

public class NodoArbol implements Serializable {
    public Artista artista;
    public NodoArbol nodoIzquierdo;
    public NodoArbol nodoDerecho;

    public NodoArbol() {
        this.artista = null;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
    }

    public NodoArbol(Artista artista, NodoArbol nodoIzquierdo, NodoArbol nodoDerecho) {
        this.artista = artista;
        this.nodoIzquierdo = nodoIzquierdo;
        this.nodoDerecho = nodoDerecho;
    }

    public Artista getArtista() {
        return this.artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public NodoArbol getNodoIzquierdo() {
        return this.nodoIzquierdo;
    }

    public void setNodoIzquierdo(NodoArbol nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public NodoArbol getNodoDerecho() {
        return this.nodoDerecho;
    }

    public void setNodoDerecho(NodoArbol nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public NodoArbol artista(Artista artista) {
        setArtista(artista);
        return this;
    }

    public NodoArbol nodoIzquierdo(NodoArbol nodoIzquierdo) {
        setNodoIzquierdo(nodoIzquierdo);
        return this;
    }

    public NodoArbol nodoDerecho(NodoArbol nodoDerecho) {
        setNodoDerecho(nodoDerecho);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NodoArbol)) {
            return false;
        }
        NodoArbol nodoArbol = (NodoArbol) o;
        return Objects.equals(artista, nodoArbol.artista) && Objects.equals(nodoIzquierdo, nodoArbol.nodoIzquierdo)
                && Objects.equals(nodoDerecho, nodoArbol.nodoDerecho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artista, nodoIzquierdo, nodoDerecho);
    }

    @Override
    public String toString() {
        return "{" +
                " artista='" + getArtista() + "'" +
                ", nodoIzquierdo='" + getNodoIzquierdo() + "'" +
                ", nodoDerecho='" + getNodoDerecho() + "'" +
                "}";
    }

}
