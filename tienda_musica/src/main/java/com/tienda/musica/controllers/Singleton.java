package com.tienda.musica.controllers;

import java.util.ArrayList;

import com.tienda.musica.controllers.modelTable.ModelTable;
import com.tienda.musica.exceptions.DataNotFoundException;
import com.tienda.musica.exceptions.DuplicatedDataException;
import com.tienda.musica.hilosBusqueda.Busqueda;
import com.tienda.musica.model.ArbolBinario;
import com.tienda.musica.model.Cancion;
import com.tienda.musica.writers.Persistencia;

public class Singleton {

    ArbolBinario arbolBinario;
    Cancion cancionAccion;
    String accion = "";
    String nombreArtista = "";
    char accionO = '|';
    char accionY = '&';

    private static class SingletonHolder {
        private final static Singleton eINSTANCE = new Singleton();
    }

    /**
     * Metodo para obtener la instancia de la clase
     */
    public static Singleton getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public Singleton() {
        arbolBinario = Persistencia.cargarRecursoCasaXML();
        if (arbolBinario == null) {
            arbolBinario = new ArbolBinario();
            guardarArbol();
        }
        cancionAccion = null;
    }

    private void guardarArbol() {
        Persistencia.guardarRecursoCasaXML(arbolBinario);
        Persistencia.guardarRecursoArbolBinarioBinario(arbolBinario);
    }

    public ArbolBinario getArbolBinario() {
        return this.arbolBinario;
    }

    public void setArbolBinario(ArbolBinario arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public ArrayList<ModelTable> busquedaO(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) throws DataNotFoundException {
        ArrayList<ModelTable> resultado = new ArrayList<>();
        resultado = arbolBinario.busquedaOPrimer(nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        Busqueda busquedaDerecha = new Busqueda(new ArbolBinario(arbolBinario.getNodo().nodoDerecho), accionO, nombre,
                nombreAlbum, anio, duracion, genero, url);
        Busqueda busquedaIzquierda = new Busqueda(new ArbolBinario(arbolBinario.getNodo().nodoIzquierdo), accionO,
                nombre,
                nombreAlbum, anio, duracion, genero, url);
        busquedaDerecha.start();
        busquedaIzquierda.start();
        try {
            busquedaDerecha.join();
            busquedaIzquierda.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (busquedaDerecha.isErrorFiltros() || busquedaIzquierda.isErrorFiltros())
            throw new DataNotFoundException("Filtros no encontrados");
        resultado.addAll(busquedaDerecha.getResultado());
        resultado.addAll(busquedaIzquierda.getResultado());
        return resultado;
    }

    public ArrayList<ModelTable> busquedaY(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) throws DataNotFoundException {
        ArrayList<ModelTable> resultado = new ArrayList<>();
        resultado = arbolBinario.busquedaOPrimer(nombre, nombreAlbum, anio, duracion, genero, url, resultado);
        Busqueda busquedaDerecha = new Busqueda(new ArbolBinario(arbolBinario.getNodo().nodoDerecho), accionY, nombre,
                nombreAlbum, anio, duracion, genero, url);
        Busqueda busquedaIzquierda = new Busqueda(new ArbolBinario(arbolBinario.getNodo().nodoIzquierdo), accionY,
                nombre,
                nombreAlbum, anio, duracion, genero, url);
        busquedaDerecha.start();
        busquedaIzquierda.start();
        try {
            busquedaDerecha.join();
            busquedaIzquierda.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (busquedaDerecha.isErrorFiltros() || busquedaIzquierda.isErrorFiltros())
            throw new DataNotFoundException("Filtros no encontrados");
        resultado.addAll(busquedaDerecha.getResultado());
        resultado.addAll(busquedaIzquierda.getResultado());
        return resultado;
    }

    public ArrayList<ModelTable> buscarArtista(String nombre) {
        return this.arbolBinario.buscarArtista(nombre);
    }

    public void agregarArtista(String nombre, String nacionalidad, boolean esArtista) throws DuplicatedDataException {
        this.arbolBinario.agregarArtista(nombre, nacionalidad, esArtista);
        guardarArbol();
    }

    public void agregarCancion(String nombreArtista, String nombre, String nombreAlbum, String caratula, int anio,
            String duracion,
            String genero, String url) throws DataNotFoundException {
        this.cancionAccion = this.arbolBinario.agregarCancion(nombreArtista, nombre, nombreAlbum, caratula, anio,
                duracion, genero, url);
        this.nombreArtista = nombreArtista;
        this.accion = "Agregar";
        guardarArbol();
    }

    public void eliminarCancion(String nombreArtista, String nombre) throws DataNotFoundException {
        this.cancionAccion = this.arbolBinario.eliminarCancion(nombreArtista, nombre);
        this.nombreArtista = nombreArtista;
        this.accion = "Eliminar";
        guardarArbol();
    }

    public void deshacer() throws DataNotFoundException {
        if (accion.equals("Agregar")) {
            this.arbolBinario.eliminarCancion(nombreArtista, cancionAccion.getNombre());
            this.accion = "Eliminar";
        }
        if (accion.equals("Eliminar")) {
            this.arbolBinario.agregarCancion(nombreArtista, cancionAccion.getNombre(), cancionAccion.getNombreAlbum(),
                    cancionAccion.getCaratula(), cancionAccion.getAnio(), cancionAccion.getDuracion().toString(),
                    cancionAccion.getGenero(), cancionAccion.getUrl());
            this.accion = "Agregar";
        }
        guardarArbol();
    }

}
