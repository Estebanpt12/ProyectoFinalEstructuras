package com.tienda.musica.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BuscarCancionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarButton;

    @FXML
    private ComboBox<?> comboTipoBusqueda;

    @FXML
    private TextField fieldAlbum;

    @FXML
    private TextField fieldAnio;

    @FXML
    private TextField fieldCancion;

    @FXML
    private TextField fieldDuracion;

    @FXML
    private TextField fieldGenero;

    @FXML
    private TextField fieldUrl;

    @FXML
    void onActionAgregar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert agregarButton != null
                : "fx:id=\"agregarButton\" was not injected: check your FXML file 'SearchView.fxml'.";
        assert comboTipoBusqueda != null
                : "fx:id=\"comboTipoBusqueda\" was not injected: check your FXML file 'SearchView.fxml'.";
        assert fieldAlbum != null : "fx:id=\"fieldAlbum\" was not injected: check your FXML file 'SearchView.fxml'.";
        assert fieldAnio != null : "fx:id=\"fieldAnio\" was not injected: check your FXML file 'SearchView.fxml'.";
        assert fieldCancion != null
                : "fx:id=\"fieldCancion\" was not injected: check your FXML file 'SearchView.fxml'.";
        assert fieldDuracion != null
                : "fx:id=\"fieldDuracion\" was not injected: check your FXML file 'SearchView.fxml'.";
        assert fieldGenero != null : "fx:id=\"fieldGenero\" was not injected: check your FXML file 'SearchView.fxml'.";
        assert fieldUrl != null : "fx:id=\"fieldUrl\" was not injected: check your FXML file 'SearchView.fxml'.";

    }

}
