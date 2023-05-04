package com.tienda.musica.writers;

import com.tienda.musica.model.*;

public class Persistencia {

    /**
     * Ruta del archivo serializado binario del modelo
     */
    public static final String RUTA_ARCHIVO_MODELO_TIENDA_BINARIO = "C:\\td\\persistencia\\model.dat";

    /**
     * Ruta del archivo serializado XML del modelo
     */
    public static final String RUTA_ARCHIVO_MODELO_CASA_XML = "C:\\td\\persistencia\\model.xml";

    /**
     * Metodo para cargar la arbolBinario del archivo binario
     * 
     * @return arbolBinario
     */
    public static ArbolBinario cargarRecursoArbolBinarioBinario() {
        ArbolBinario arbolBinario = null;
        try {
            arbolBinario = (ArbolBinario) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arbolBinario;
    }

    /**
     * Metodo para guardar la arbolBinario en binario
     * 
     * @param arbolBinario arbolBinario a guardar
     */
    public static void guardarRecursoArbolBinarioBinario(ArbolBinario arbolBinario) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO, arbolBinario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cargar la arbolBinario del archivo XML
     * 
     * @return arbolBinario
     */
    public static ArbolBinario cargarRecursoCasaXML() {
        ArbolBinario arbolBinario = null;
        try {
            arbolBinario = (ArbolBinario) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_CASA_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arbolBinario;
    }

    /**
     * Metodo para guardar la arbolBinario en XML
     * 
     * @param subastasQuindio arbolBinario a guardar
     */
    public static void guardarRecursoCasaXML(ArbolBinario arbolBinario) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_CASA_XML, arbolBinario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
