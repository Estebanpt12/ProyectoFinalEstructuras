package com.tienda.musica.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MainViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarArtistaButton;

    @FXML
    private Button agregarCancionButton;

    @FXML
    private TableColumn<?, ?> albumColumn;

    @FXML
    private TableColumn<?, ?> anioColumn;

    @FXML
    private TableColumn<?, ?> autorColumn;

    @FXML
    private TableColumn<?, ?> caratulaColumn;

    @FXML
    private TableColumn<?, ?> duracionColumn;

    @FXML
    private Button eliminarButton;

    @FXML
    private TableColumn<?, ?> generoColumn;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private TableView<?> tableCanciones;

    @FXML
    private TextField textFieldBuscar;

    @FXML
    private TableColumn<?, ?> urlColumn;

    @FXML
    void onActionAgregarArtista(ActionEvent event) {

    }

    @FXML
    void onActionAgregarCancion(ActionEvent event) {

    }

    @FXML
    void onActionEliminar(ActionEvent event) {

    }

    @FXML
    void onKeyTypedFiltro(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert agregarArtistaButton != null
                : "fx:id=\"agregarArtistaButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert agregarCancionButton != null
                : "fx:id=\"agregarCancionButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert albumColumn != null : "fx:id=\"albumColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert anioColumn != null : "fx:id=\"anioColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert autorColumn != null : "fx:id=\"autorColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert caratulaColumn != null
                : "fx:id=\"caratulaColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert duracionColumn != null
                : "fx:id=\"duracionColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert eliminarButton != null
                : "fx:id=\"eliminarButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert generoColumn != null : "fx:id=\"generoColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert nombreColumn != null : "fx:id=\"nombreColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tableCanciones != null
                : "fx:id=\"tableCanciones\" was not injected: check your FXML file 'MainView.fxml'.";
        assert textFieldBuscar != null
                : "fx:id=\"textFieldBuscar\" was not injected: check your FXML file 'MainView.fxml'.";
        assert urlColumn != null : "fx:id=\"urlColumn\" was not injected: check your FXML file 'MainView.fxml'.";

    }

}