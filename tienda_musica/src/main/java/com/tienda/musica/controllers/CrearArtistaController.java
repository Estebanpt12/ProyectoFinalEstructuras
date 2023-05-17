package com.tienda.musica.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

import javax.swing.JOptionPane;

import com.tienda.musica.exceptions.DuplicatedDataException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrearArtistaController {

    private Singleton singleton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AgregarButton;

    @FXML
    private ComboBox<String> comboTipoArtista;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private TextField txtNombreArt;

    @FXML
    void GuardarArtista(ActionEvent event) {
        try {
            validateFields();
            singleton.agregarArtista(txtNombreArt.getText(), txtNacionalidad.getText(),
                    comboTipoArtista.getSelectionModel().getSelectedItem().equals("Solista"));
            try {
                URL url = new File("src/main/resources/com/tienda/musica/MainView.fxml")
                        .toURI().toURL();
                Parent root1 = FXMLLoader.load(url);
                Scene scene1 = new Scene(root1, 991, 578);
                Stage stage1 = new Stage();
                stage1.setTitle("Agregar Artista");
                stage1.setScene(scene1);
                stage1.show();
            } catch (Exception e) {
                // TODO: handle exception
            }
            Stage stage = (Stage) AgregarButton.getScene().getWindow();
            stage.close();
        } catch (DataFormatException | DuplicatedDataException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void validateFields() throws DataFormatException {
        if (comboTipoArtista.getSelectionModel().getSelectedIndex() == -1 || txtNacionalidad.getText().equals("") ||
                txtNombreArt.getText().equals("")) {
            throw new DataFormatException("Campos vacios");
        }
    }

    @FXML
    void initialize() {
        initializeCombo();
        assert AgregarButton != null
                : "fx:id=\"AgregarButton\" was not injected: check your FXML file 'CrearArtistaView.fxml'.";
        assert comboTipoArtista != null
                : "fx:id=\"comboTipoArtista\" was not injected: check your FXML file 'CrearArtistaView.fxml'.";
        assert txtNacionalidad != null
                : "fx:id=\"txtNacionalidad\" was not injected: check your FXML file 'CrearArtistaView.fxml'.";
        assert txtNombreArt != null
                : "fx:id=\"txtNombreArt\" was not injected: check your FXML file 'CrearArtistaView.fxml'.";
        singleton = Singleton.getInstance();
    }

    private void initializeCombo() {
        comboTipoArtista.getItems().add("Grupo");
        comboTipoArtista.getItems().add("Solista");
    }

}
