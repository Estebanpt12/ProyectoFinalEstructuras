package com.tienda.musica.model;

import java.io.Serializable;

import com.tienda.musica.exceptions.DataNotFoundException;
import com.tienda.musica.exceptions.DuplicatedDataException;
import com.tienda.musica.model.nodos.NodoArbol;

public class ArbolBinario implements Serializable {
    private NodoArbol nodo;
    private int size;

    public static void main(String[] args) {

    }

    public ArbolBinario() {
        nodo = null;
    }

    public void imprimir() {
        imprimir(this.nodo);
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void imprimir(NodoArbol n) {
        if (n != null) {
            System.out.println(n.artista.toString());
            imprimir(n.nodoIzquierdo);
            imprimir(n.nodoDerecho);
        }
    }

    public NodoArbol getNodo() {
        return this.nodo;
    }

    public void setNodo(NodoArbol nodo) {
        this.nodo = nodo;
    }

    public Artista buscarArtista(String nombre) {
        return buscarArtista(nodo, nombre);
    }

    public Artista buscarArtista(NodoArbol nodo, String nombre) {
        if (nodo.artista.getNombre().equals(nombre)) {
            return nodo.artista;
        } else {
            if (nodo.nodoIzquierdo != null) {
                buscarArtista(nodo.nodoIzquierdo, nombre);
            } else if (nodo.nodoDerecho != null) {
                buscarArtista(nodo.nodoDerecho, nombre);
            }
        }
        return null;
    }

    public void agregarArtista(String nombre, String nacionalidad, boolean esArtista) throws DuplicatedDataException {
        Artista artista = new Artista(size, nombre, nacionalidad, esArtista);
        if (this.nodo == null) {
            this.nodo = new NodoArbol();
            this.nodo.artista = artista;
        } else {
            agregarArtista(artista, this.nodo);
        }
        size += 1;
    }

    private void agregarArtista(Artista artista, NodoArbol nodo) throws DuplicatedDataException {
        if (nodo.artista.getNombre().equals(artista.getNombre())) {
            throw new DuplicatedDataException("El artista ya existe");
        }
        if (artista.getCodigo() > nodo.artista.getCodigo()) {
            if (nodo.nodoDerecho == null) {
                nodo.nodoDerecho = new NodoArbol();
                nodo.nodoDerecho.artista = artista;
            } else {
                agregarArtista(artista, nodo.nodoDerecho);
            }
        } else {
            if (nodo.nodoIzquierdo == null) {
                nodo.nodoIzquierdo = new NodoArbol();
                nodo.nodoIzquierdo.artista = artista;
            } else {
                agregarArtista(artista, nodo.nodoIzquierdo);
            }
        }
    }

    public void agregarCancion(String nombreArtista, String nombre, String nombreAlbum, String caratula, int anio,
            String duracion,
            String genero, String url) {
        agregarCancion(nodo, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion, genero, url);
    }

    private void agregarCancion(NodoArbol nodo, String nombreArtista, String nombre, String nombreAlbum,
            String caratula,
            int anio,
            String duracion,
            String genero, String url) {
        if (nodo.artista.getNombre().equals(nombreArtista)) {
            nodo.artista.agregarCancion(nombre, nombreAlbum, caratula, anio, duracion, genero, url);
        } else {
            if (nodo.nodoIzquierdo != null) {
                agregarCancion(nodo.nodoIzquierdo, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion, genero,
                        url);
            } else if (nodo.nodoDerecho != null) {
                agregarCancion(nodo.nodoDerecho, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion, genero,
                        url);
            }
        }
    }

    public Cancion eliminarCancion(String nombreArtista, String nombre) throws DataNotFoundException {
        return eliminarCancion(nodo, nombreArtista, nombre);
    }

    private Cancion eliminarCancion(NodoArbol nodo, String nombreArtista, String nombre) throws DataNotFoundException {
        if (nodo.artista.getNombre().equals(nombreArtista)) {
            return nodo.artista.borrarCancion(nombre);
        } else {
            if (nodo.nodoIzquierdo != null) {
                eliminarCancion(nodo.nodoIzquierdo, nombreArtista, nombre);
            } else if (nodo.nodoDerecho != null) {
                eliminarCancion(nodo.nodoDerecho, nombreArtista, nombre);
            }
        }
        return null;
    }

}
