package com.tienda.musica.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.tienda.musica.controllers.modelTable.ModelTable;
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

    public ArbolBinario(NodoArbol nodo) {
        this.nodo = nodo;
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

    public ArrayList<ModelTable> buscarArtista(String nombre) {
        return buscarArtista(nodo, nombre);
    }

    private ArrayList<ModelTable> buscarArtista(NodoArbol nodo, String nombre) {
        if (nodo.artista.getNombre().equals(nombre)) {
            return nodo.artista.tomarListaCanciones();
        } else {
            if (nodo.nodoIzquierdo != null) {
                buscarArtista(nodo.nodoIzquierdo, nombre);
            } else if (nodo.nodoDerecho != null) {
                buscarArtista(nodo.nodoDerecho, nombre);
            }
        }
        return null;
    }

    public Artista agregarArtista(String nombre, String nacionalidad, boolean esArtista)
            throws DuplicatedDataException {
        Artista artista = new Artista(size, nombre, nacionalidad, esArtista);
        if (this.nodo == null) {
            this.nodo = new NodoArbol();
            this.nodo.artista = artista;
        } else {
            agregarArtista(artista, this.nodo);
        }
        size += 1;
        return artista;
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

    public Cancion agregarCancion(String nombreArtista, String nombre, String nombreAlbum, String caratula, int anio,
            String duracion,
            String genero, String url) throws DataNotFoundException {
        Cancion cancion = agregarCancion(nodo, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion, genero,
                url);
        if (cancion == null)
            throw new DataNotFoundException("Artista no encontrado");
        return cancion;
    }

    private Cancion agregarCancion(NodoArbol nodo, String nombreArtista, String nombre, String nombreAlbum,
            String caratula,
            int anio,
            String duracion,
            String genero, String url) {
        if (nodo.artista.getNombre().equals(nombreArtista)) {
            return nodo.artista.agregarCancion(nombre, nombreAlbum, caratula, anio, duracion, genero, url);
        } else {
            if (nodo.nodoIzquierdo != null) {
                return agregarCancion(nodo.nodoIzquierdo, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion,
                        genero,
                        url);
            } else if (nodo.nodoDerecho != null) {
                return agregarCancion(nodo.nodoDerecho, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion,
                        genero,
                        url);
            }
        }
        return null;
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

    public ArrayList<ModelTable> busquedaO(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) throws DataNotFoundException {
        return busquedaO(this.nodo, nombre, nombreAlbum, anio, duracion, genero, url, new ArrayList<ModelTable>());
    }

    private ArrayList<ModelTable> busquedaO(NodoArbol nodo, String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) throws DataNotFoundException {
        if (nodo.nodoIzquierdo != null) {
            resultado.addAll(nodo.artista.busquedaO(nombre, nombreAlbum, anio, duracion, genero, url));
            busquedaO(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        } else if (nodo.nodoDerecho != null) {
            resultado.addAll(nodo.artista.busquedaO(nombre, nombreAlbum, anio, duracion, genero, url));
            busquedaO(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        }
        return resultado;
    }

    public ArrayList<ModelTable> busquedaOPrimer(String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) throws DataNotFoundException {
        return nodo.artista.busquedaO(nombre, nombreAlbum, anio, duracion, genero, url);
    }

    public ArrayList<ModelTable> busquedaYPrimer(String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) throws DataNotFoundException {
        return nodo.artista.busquedaY(nombre, nombreAlbum, anio, duracion, genero, url);
    }

    public ArrayList<ModelTable> busquedaY(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) throws DataNotFoundException {
        return busquedaY(this.nodo, nombre, nombreAlbum, anio, duracion, genero, url, new ArrayList<ModelTable>());
    }

    private ArrayList<ModelTable> busquedaY(NodoArbol nodo, String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) throws DataNotFoundException {
        if (nodo.nodoIzquierdo != null) {
            resultado.addAll(nodo.artista.busquedaY(nombre, nombreAlbum, anio, duracion, genero, url));
            busquedaY(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        } else if (nodo.nodoDerecho != null) {
            resultado.addAll(nodo.artista.busquedaY(nombre, nombreAlbum, anio, duracion, genero, url));
            busquedaY(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        }
        return resultado;
    }

}
