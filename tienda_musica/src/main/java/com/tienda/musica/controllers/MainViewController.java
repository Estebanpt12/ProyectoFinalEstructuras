package com.tienda.musica.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MainViewController {

    @FXML
    private Button agregarArtistaButton;

    @FXML
    private Button agregarCancionButton;

    @FXML
    private TableColumn<?, ?> albumColumn;

    @FXML
    private TableColumn<?, ?> anioColumn;

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

}
