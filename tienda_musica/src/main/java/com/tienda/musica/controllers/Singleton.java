package com.tienda.musica.controllers;

import com.tienda.musica.model.ArbolBinario;
import com.tienda.musica.model.Artista;
import com.tienda.musica.model.Cancion;
import com.tienda.musica.writers.Persistencia;

public class Singleton {

    ArbolBinario arbolBinario;
    Cancion cancionAccion;
    Artista artistaAccion;
    String accion;

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
            Persistencia.guardarRecursoArbolBinarioBinario(arbolBinario);
            Persistencia.guardarRecursoCasaXML(arbolBinario);
        }
    }

    public ArbolBinario getArbolBinario() {
        return this.arbolBinario;
    }

    public void setArbolBinario(ArbolBinario arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

}
