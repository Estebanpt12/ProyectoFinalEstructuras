package com.tienda.musica.model.lists;

import com.tienda.musica.model.Cancion;

public class ListaCircularSimple {

    class Nodo {
        Cancion info;
        Nodo ant, sig;
    }

    private Nodo raiz;

    public ListaCircularSimple() {
        raiz = null;
    }

    public void add(Cancion x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null) {
            nuevo.sig = nuevo;
            nuevo.ant = nuevo;
            raiz = nuevo;
        } else {
            Nodo ultimo = raiz.ant;
            nuevo.sig = raiz;
            nuevo.ant = ultimo;
            raiz.ant = nuevo;
            ultimo.sig = nuevo;
            raiz = nuevo;
        }
    }

    public void addLast(Cancion x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null) {
            nuevo.sig = nuevo;
            nuevo.ant = nuevo;
            raiz = nuevo;
        } else {
            Nodo ultimo = raiz.ant;
            nuevo.sig = raiz;
            nuevo.ant = ultimo;
            raiz.ant = nuevo;
            ultimo.sig = nuevo;
        }
    }

    public boolean isEmpty() {
        if (raiz == null)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            Nodo reco = raiz;
            String aux = "";
            while (reco != null) {
                aux += reco.info.toString();
                reco = reco.sig;
            }
            return aux;
        }
        return null;
    }

    /* Reco se usa para el recorrido */
    public int lenght() {
        int cant = 0;
        if (!isEmpty()) {
            Nodo reco = raiz;
            do {
                cant++;
                reco = reco.sig;
            } while (reco != raiz);
        }
        return cant;
    }

    public void borrar(int pos) {
        if (pos <= lenght()) {
            if (pos == 1) {
                if (lenght() == 1) {
                    raiz = null;
                } else {
                    Nodo ultimo = raiz.ant;
                    raiz = raiz.sig;
                    ultimo.sig = raiz;
                    raiz.ant = ultimo;
                }
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 1; f++)
                    reco = reco.sig;
                Nodo anterior = reco.ant;
                reco = reco.sig;
                anterior.sig = reco;
                reco.ant = anterior;
            }
        }
    }
}
