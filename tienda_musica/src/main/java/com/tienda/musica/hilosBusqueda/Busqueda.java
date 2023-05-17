package com.tienda.musica.hilosBusqueda;

import java.util.ArrayList;

import com.tienda.musica.controllers.modelTable.ModelTable;
import com.tienda.musica.model.ArbolBinario;

public class Busqueda extends Thread {
    ArbolBinario arbolBinario;
    ArrayList<ModelTable> resultado;
    Character operacion;
    String nombre;
    String nombreAlbum;
    String anio;
    String duracion;
    String genero;
    String url;
    boolean errorFiltros = false;

    public Busqueda(ArbolBinario arbolBinario, Character operacion, String nombre, String nombreAlbum,
            String anio, String duracion, String genero, String url) {
        this.arbolBinario = arbolBinario;
        this.resultado = new ArrayList<>();
        this.operacion = operacion;
        this.nombre = nombre;
        this.nombreAlbum = nombreAlbum;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
        this.url = url;
    }

    public ArbolBinario getArbolBinario() {
        return this.arbolBinario;
    }

    public void setArbolBinario(ArbolBinario arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public ArrayList<ModelTable> getResultado() {
        return this.resultado;
    }

    public void setResultado(ArrayList<ModelTable> resultado) {
        this.resultado = resultado;
    }

    public Character getOperacion() {
        return this.operacion;
    }

    public void setOperacion(Character operacion) {
        this.operacion = operacion;
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

    public String getAnio() {
        return this.anio;
    }

    public void setAnio(String anio) {
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isErrorFiltros() {
        return this.errorFiltros;
    }

    public boolean getErrorFiltros() {
        return this.errorFiltros;
    }

    public void setErrorFiltros(boolean errorFiltros) {
        this.errorFiltros = errorFiltros;
    }

    @Override
    public void run() {
        realizarOperacion();
    }

    private void realizarOperacion() {
        if (operacion == '&') {
            busquedaY();
        }
        if (operacion == '|') {
            busquedaO();
        }
    }

    private void busquedaO() {
        if(arbolBinario.getNodo() != null){
            this.resultado = arbolBinario.busquedaO(nombre, nombreAlbum, anio, duracion, genero, url);
        }
    }

    private void busquedaY() {
        if(arbolBinario.getNodo() != null){
            this.resultado = arbolBinario.busquedaY(nombre, nombreAlbum, anio, duracion, genero, url);
        }
    }
}
