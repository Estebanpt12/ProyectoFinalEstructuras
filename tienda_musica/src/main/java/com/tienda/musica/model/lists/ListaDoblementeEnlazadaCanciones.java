package com.tienda.musica.model.lists;

import java.io.Serializable;

import com.tienda.musica.exceptions.DataNotFoundException;
import com.tienda.musica.model.Cancion;
import com.tienda.musica.model.nodos.NodoListadoble;

public class ListaDoblementeEnlazadaCanciones implements Serializable {

    private NodoListadoble raiz;

    public ListaDoblementeEnlazadaCanciones() {
        raiz = null;
    }

    public void add(int pos, Cancion x) {
        if (pos <= cantidad() + 1) {
            NodoListadoble nuevo = new NodoListadoble();
            nuevo.info = x;
            if (pos == 1) {
                nuevo.sig = raiz;
                if (raiz != null)
                    raiz.ant = nuevo;
                raiz = nuevo;
            } else if (pos == cantidad() + 1) {
                NodoListadoble reco = raiz;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = null;
            } else {
                NodoListadoble reco = raiz;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                NodoListadoble siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = siguiente;
                siguiente.ant = nuevo;
            }
        }
    }

    public Cancion get(int pos) {
        if (pos <= cantidad()) {
            Cancion informacion;
            if (pos == 1) {
                informacion = raiz.info;
                raiz = raiz.sig;
                if (raiz != null)
                    raiz.ant = null;
            } else {
                NodoListadoble reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                NodoListadoble prox = reco.sig;
                reco.sig = prox.sig;
                NodoListadoble siguiente = prox.sig;
                if (siguiente != null)
                    siguiente.ant = reco;
                informacion = prox.info;
            }
            return informacion;
        } else
            return null;
    }

    public Cancion delete(String nombre) throws DataNotFoundException {
        NodoListadoble reco = raiz;
        int i = 1;
        while (reco != null) {
            if (reco.info.getNombre().equals(nombre)) {
                delete(i);
                return reco.info;
            }
            i += 1;
            reco = reco.sig;
        }
        throw new DataNotFoundException("Cancion no encontrada");

    }

    public NodoListadoble getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NodoListadoble raiz) {
        this.raiz = raiz;
    }

    private void delete(int pos) {
        if (pos <= cantidad()) {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz != null)
                    raiz.ant = null;
            } else {
                NodoListadoble reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                NodoListadoble prox = reco.sig;
                prox = prox.sig;
                reco.sig = prox;
                if (prox != null)
                    prox.ant = reco;
            }
        }
    }

    public void switchPositions(int pos1, int pos2) {
        if (pos1 <= cantidad() && pos2 <= cantidad()) {
            NodoListadoble reco1 = raiz;
            for (int f = 1; f < pos1; f++)
                reco1 = reco1.sig;
            NodoListadoble reco2 = raiz;
            for (int f = 1; f < pos2; f++)
                reco2 = reco2.sig;
            Cancion aux = reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }

    public int cantidad() {
        int cant = 0;
        NodoListadoble reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }

    public boolean exists(Cancion x) {
        NodoListadoble reco = raiz;
        while (reco != null) {
            if (reco.info == x)
                return true;
            reco = reco.sig;
        }
        return false;
    }

    public boolean isEmpty() {
        if (raiz == null)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        NodoListadoble reco = raiz;
        String aux = "";
        while (reco != null) {
            aux += reco.info.toString();
            reco = reco.sig;
        }
        return aux;
    }
}
