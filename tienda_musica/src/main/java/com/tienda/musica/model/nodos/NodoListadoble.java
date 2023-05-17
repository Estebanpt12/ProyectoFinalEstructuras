package com.tienda.musica.model.nodos;

import java.io.Serializable;

import com.tienda.musica.model.Cancion;
import java.util.Objects;

public class NodoListadoble implements Serializable {
    public Cancion info;
    public NodoListadoble ant, sig;

    public NodoListadoble() {
    }

    public NodoListadoble(Cancion info, NodoListadoble ant, NodoListadoble sig) {
        this.info = info;
        this.ant = ant;
        this.sig = sig;
    }

    public Cancion getInfo() {
        return this.info;
    }

    public void setInfo(Cancion info) {
        this.info = info;
    }

    public NodoListadoble getAnt() {
        return this.ant;
    }

    public void setAnt(NodoListadoble ant) {
        this.ant = ant;
    }

    public NodoListadoble getSig() {
        return this.sig;
    }

    public void setSig(NodoListadoble sig) {
        this.sig = sig;
    }

    public NodoListadoble info(Cancion info) {
        setInfo(info);
        return this;
    }

    public NodoListadoble ant(NodoListadoble ant) {
        setAnt(ant);
        return this;
    }

    public NodoListadoble sig(NodoListadoble sig) {
        setSig(sig);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NodoListadoble)) {
            return false;
        }
        NodoListadoble nodoListadoble = (NodoListadoble) o;
        return Objects.equals(info, nodoListadoble.info) && Objects.equals(ant, nodoListadoble.ant)
                && Objects.equals(sig, nodoListadoble.sig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, ant, sig);
    }

    @Override
    public String toString() {
        return "{" +
                " info='" + getInfo() + "'" +
                ", ant='" + getAnt() + "'" +
                ", sig='" + getSig() + "'" +
                "}";
    }

}
