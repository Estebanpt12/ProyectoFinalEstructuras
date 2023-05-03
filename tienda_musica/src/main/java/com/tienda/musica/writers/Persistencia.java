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
     * Metodo para cargar la tienda del archivo binario
     * 
     * @return tienda
     */
    public static Tienda cargarRecursoTiendaBinario() {
        Tienda tienda = null;
        try {
            tienda = (Tienda) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienda;
    }

    /**
     * Metodo para guardar la tienda en binario
     * 
     * @param tienda tienda a guardar
     */
    public static void guardarRecursoTiendaBinario(Tienda tienda) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_TIENDA_BINARIO, tienda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cargar la tienda del archivo XML
     * 
     * @return tienda
     */
    public static Tienda cargarRecursoCasaXML() {
        Tienda tienda = null;
        try {
            tienda = (Tienda) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_CASA_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienda;
    }

    /**
     * Metodo para guardar la tienda en XML
     * 
     * @param subastasQuindio tienda a guardar
     */
    public static void guardarRecursoCasaXML(Tienda tienda) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_CASA_XML, tienda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
