package com.tienda.musica.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CrearArtistaController {

    @FXML
    private Button AgregarButton;

    @FXML
    private ComboBox<?> comboTipoArtista;

    @FXML
    private ComboBox<?> generoTipoArtista;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private TextField txtNombreArt;

    @FXML
    void GuardarArtista(ActionEvent event) {

    }

}
