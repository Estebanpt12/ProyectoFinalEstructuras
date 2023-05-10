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
    private Cancion cancionEliminada = null;
    private Cancion cancionAgregada = null;
    private ArrayList<ModelTable> cancionesEncontradas = new ArrayList<>();

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

    public ArrayList<ModelTable> tomarCanciones() {
        ArrayList<ModelTable> datos = new ArrayList<>();
        return tomarCanciones(nodo, datos);
    }

    private ArrayList<ModelTable> tomarCanciones(NodoArbol nodo, ArrayList<ModelTable> datos) {
        datos.addAll(nodo.artista.tomarListaCanciones());
        if (nodo.nodoIzquierdo != null) {
            tomarCanciones(nodo.nodoIzquierdo, datos);
        }
        if (nodo.nodoDerecho != null) {
            tomarCanciones(nodo.nodoDerecho, datos);
        }
        return datos;
    }

    public ArrayList<ModelTable> buscarArtista(String nombre) {
        cancionesEncontradas = null;
        cancionesEncontradas = new ArrayList<>();
        buscarArtista(nodo, nombre);
        return cancionesEncontradas;
    }

    private void buscarArtista(NodoArbol nodo, String nombre) {
        if (nodo.artista.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
            cancionesEncontradas.addAll(nodo.artista.tomarListaCanciones());
        } else {
            if (nodo.nodoIzquierdo != null) {
                buscarArtista(nodo.nodoIzquierdo, nombre);
            }
            if (nodo.nodoDerecho != null) {
                buscarArtista(nodo.nodoDerecho, nombre);
            }
        }
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
        if (artista.hashCode() >= nodo.artista.hashCode()) {
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
        agregarCancion(nodo, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion, genero, url);
        if (cancionAgregada == null)
            throw new DataNotFoundException("Artista no encontrado");
        return cancionAgregada;
    }

    private void agregarCancion(NodoArbol nodo, String nombreArtista, String nombre, String nombreAlbum,
            String caratula,
            int anio,
            String duracion,
            String genero, String url) {
        if (nodo.artista.getNombre().equals(nombreArtista)) {
            cancionAgregada = nodo.artista.agregarCancion(nombre, nombreAlbum, caratula, anio, duracion, genero, url);
        } else {
            if (nodo.nodoIzquierdo != null) {
                agregarCancion(nodo.nodoIzquierdo, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion,
                        genero,
                        url);
            }
            if (nodo.nodoDerecho != null) {
                agregarCancion(nodo.nodoDerecho, nombreArtista, nombre, nombreAlbum, caratula, anio, duracion,
                        genero,
                        url);
            }
        }
    }

    public Cancion eliminarCancion(String nombreArtista, String nombre) throws DataNotFoundException {
        eliminarCancion(nodo, nombreArtista, nombre);
        return cancionEliminada;
    }

    private void eliminarCancion(NodoArbol nodo, String nombreArtista, String nombre) throws DataNotFoundException {
        if (nodo.artista.getNombre().equals(nombreArtista)) {
            cancionEliminada = nodo.artista.borrarCancion(nombre);
        } else {
            if (nodo.nodoIzquierdo != null) {
                eliminarCancion(nodo.nodoIzquierdo, nombreArtista, nombre);
            }
            if (nodo.nodoDerecho != null) {
                eliminarCancion(nodo.nodoDerecho, nombreArtista, nombre);
            }
        }
    }

    public ArrayList<ModelTable> busquedaO(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) {
        return busquedaO(this.nodo, nombre, nombreAlbum, anio, duracion, genero, url, new ArrayList<ModelTable>());
    }

    private ArrayList<ModelTable> busquedaO(NodoArbol nodo, String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) {
        if (nodo.nodoIzquierdo != null) {
            resultado.addAll(nodo.artista.busquedaO(nombre, nombreAlbum, anio, duracion, genero, url, resultado));
            busquedaO(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        } else if (nodo.nodoDerecho != null) {
            resultado.addAll(nodo.artista.busquedaO(nombre, nombreAlbum, anio, duracion, genero, url, resultado));
            busquedaO(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        }
        return resultado;
    }

    public ArrayList<ModelTable> busquedaOPrimer(String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) {
        return nodo.artista.busquedaO(nombre, nombreAlbum, anio, duracion, genero, url, resultado);
    }

    public ArrayList<ModelTable> busquedaYPrimer(String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) {
        return nodo.artista.busquedaY(nombre, nombreAlbum, anio, duracion, genero, url, resultado);
    }

    public ArrayList<ModelTable> busquedaY(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) {
        return busquedaY(this.nodo, nombre, nombreAlbum, anio, duracion, genero, url, new ArrayList<ModelTable>());
    }

    private ArrayList<ModelTable> busquedaY(NodoArbol nodo, String nombre, String nombreAlbum, String anio,
            String duracion,
            String genero, String url, ArrayList<ModelTable> resultado) {
        if (nodo.nodoIzquierdo != null) {
            resultado.addAll(nodo.artista.busquedaY(nombre, nombreAlbum, anio, duracion, genero, url, resultado));
            busquedaY(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        } else if (nodo.nodoDerecho != null) {
            resultado.addAll(nodo.artista.busquedaY(nombre, nombreAlbum, anio, duracion, genero, url, resultado));
            busquedaY(nodo.nodoIzquierdo, nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        }
        return resultado;
    }

}
