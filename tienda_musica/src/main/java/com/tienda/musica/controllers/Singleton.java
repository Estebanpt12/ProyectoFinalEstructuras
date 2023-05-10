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
    ArrayList<ModelTable> resultado;
    boolean filtered = false;

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
        arbolBinario = Persistencia.cargarRecursoArbolBinarioBinario();
        if (arbolBinario == null) {
            arbolBinario = new ArbolBinario();
            guardarArbol();
        }
        cancionAccion = null;
        resultado = new ArrayList<>();
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

    public Cancion getCancionAccion() {
        return this.cancionAccion;
    }

    public void setCancionAccion(Cancion cancionAccion) {
        this.cancionAccion = cancionAccion;
    }

    public String getAccion() {
        return this.accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getNombreArtista() {
        return this.nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public char getAccionO() {
        return this.accionO;
    }

    public void setAccionO(char accionO) {
        this.accionO = accionO;
    }

    public char getAccionY() {
        return this.accionY;
    }

    public void setAccionY(char accionY) {
        this.accionY = accionY;
    }

    public ArrayList<ModelTable> tomarCanciones() {
        return this.arbolBinario.tomarCanciones();
    }

    public ArrayList<ModelTable> getResultado() {
        return this.resultado;
    }

    public void setResultado(ArrayList<ModelTable> resultado) {
        this.resultado = resultado;
    }

    public boolean isFiltered() {
        return this.filtered;
    }

    public boolean getFiltered() {
        return this.filtered;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    public void busquedaO(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) throws DataNotFoundException {
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
        filtered = true;
        resultado.addAll(busquedaDerecha.getResultado());
        resultado.addAll(busquedaIzquierda.getResultado());
        if (resultado.size() == 0)
            throw new DataNotFoundException("Filtros no encontrados");
    }

    public void limpiarBusqueda(){
        this.filtered = false;
        this.resultado = null;
        this.resultado = new ArrayList<>();
    }

    public void busquedaY(String nombre, String nombreAlbum, String anio, String duracion,
            String genero, String url) throws DataNotFoundException {
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
        resultado.addAll(busquedaDerecha.getResultado());
        resultado.addAll(busquedaIzquierda.getResultado());
        filtered = true;
        if (resultado.size() == 0)
            throw new DataNotFoundException("Filtros no encontrados");
    }

    public ArrayList<ModelTable> buscarArtista(String nombre) {
        if (isFiltered()) {
            ArrayList<ModelTable> aux = new ArrayList<>();
            for (ModelTable modelTable : resultado) {
                if (modelTable.getAutor().toLowerCase().contains(nombre.toLowerCase())) {
                    aux.add(modelTable);
                }
            }
            return aux;
        } else {
            return this.arbolBinario.buscarArtista(nombre);
        }
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
