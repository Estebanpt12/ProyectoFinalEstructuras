package com.tienda.musica.model;

import java.io.Serializable;

import java.util.Objects;

import com.tienda.musica.model.lists.ListaCircularSimple;

public class User implements Serializable {

    private String username;
    private String password;
    private String email;
    private ListaCircularSimple listaCanciones;

    public User() {
    }

    public User(String username, String password, String email, ListaCircularSimple listaCanciones) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.listaCanciones = listaCanciones;
    }

    public String getusername() {
        return this.username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ListaCircularSimple getListaCanciones() {
        return this.listaCanciones;
    }

    public void setListaCanciones(ListaCircularSimple listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User listaCanciones(ListaCircularSimple listaCanciones) {
        setListaCanciones(listaCanciones);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password)
                && Objects.equals(email, user.email) && Objects.equals(listaCanciones, user.listaCanciones);
    }
}
