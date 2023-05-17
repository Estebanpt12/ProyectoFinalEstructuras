package com.tienda.musica.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

import javax.swing.JOptionPane;

import com.tienda.musica.exceptions.DataNotFoundException;
import com.tienda.musica.utils.Formatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuscarCancionController {

        Singleton singleton;
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button busquedaButton;

        @FXML
        private ComboBox<String> comboTipoBusqueda;

        @FXML
        private TextField fieldAlbum;

        @FXML
        private TextField fieldAnio;

        @FXML
        private TextField fieldCancion;

        @FXML
        private TextField fieldDuracion;

        @FXML
        private ComboBox<String> comboGenero;

        @FXML
        private TextField fieldUrl;

        private void validateFields() throws DataFormatException {
                int aux = 0;
                if (!fieldAlbum.getText().equals("")) {
                        aux += 1;
                }
                if (!fieldAnio.getText().equals("")) {
                        Integer.parseInt(fieldAnio.getText());
                        aux += 1;
                }
                if (!fieldCancion.getText().equals("")) {
                        aux += 1;
                }
                if (!fieldDuracion.getText().equals("")) {
                        Formatter.formatTime(fieldDuracion.getText());
                        aux += 1;
                }
                if (!(comboGenero.getSelectionModel().getSelectedIndex() == 1)) {
                        aux += 1;
                }
                if (!fieldUrl.getText().equals("")) {
                        aux += 1;
                }
                if (aux < 2) {
                        throw new DataFormatException("Los datos minimos son 2");
                }
                if (comboTipoBusqueda.getSelectionModel().getSelectedIndex() == -1)
                        throw new DataFormatException("Especifique el tipo de busqueda");
        }

        @FXML
        void onActionBusqueda(ActionEvent event) {
                try {
                        validateFields();
                        if (comboTipoBusqueda.getSelectionModel().getSelectedItem().equals("Y")) {
                                singleton.busquedaY(fieldCancion.getText(), fieldAlbum.getText(),
                                                fieldAnio.getText(), fieldDuracion.getText(),
                                                comboGenero.getSelectionModel().getSelectedItem(),
                                                fieldUrl.getText());
                        } else {
                                singleton.busquedaO(fieldCancion.getText(), fieldAlbum.getText(),
                                                fieldAnio.getText(), fieldDuracion.getText(),
                                                comboGenero.getSelectionModel().getSelectedItem(),
                                                fieldUrl.getText());
                        }
                        URL url = new File("src/main/resources/com/tienda/musica/MainView.fxml")
                                        .toURI().toURL();
                        Parent root1 = FXMLLoader.load(url);
                        Scene scene1 = new Scene(root1, 991, 578);
                        Stage stage1 = new Stage();
                        stage1.setTitle("Storify");
                        stage1.setScene(scene1);
                        stage1.show();
                        Stage stage = (Stage) fieldAlbum.getScene().getWindow();
                        stage.close();
                } catch (NumberFormatException e) {
                        e.printStackTrace();
                        mostrarMensaje("Formato del año erroneo");
                } catch (DataFormatException e) {
                        mostrarMensaje(e.getMessage());
                } catch (DataNotFoundException e) {
                        mostrarMensaje(e.getMessage());
                } catch (MalformedURLException e) {
                        mostrarMensaje(e.getMessage());
                } catch (IOException e) {
                        mostrarMensaje(e.getMessage());
                } catch (DateTimeParseException e) {
                        mostrarMensaje("Formato de duracion invalida");
                }
        }

        private void mostrarMensaje(String mensaje) {
                JOptionPane.showMessageDialog(null, mensaje);
        }

        @FXML
        void initialize() {
                assert busquedaButton != null
                                : "fx:id=\"busquedaButton\" was not injected: check your FXML file 'SearchView.fxml'.";
                assert comboTipoBusqueda != null
                                : "fx:id=\"comboTipoBusqueda\" was not injected: check your FXML file 'SearchView.fxml'.";
                assert fieldAlbum != null
                                : "fx:id=\"fieldAlbum\" was not injected: check your FXML file 'SearchView.fxml'.";
                assert fieldAnio != null
                                : "fx:id=\"fieldAnio\" was not injected: check your FXML file 'SearchView.fxml'.";
                assert fieldCancion != null
                                : "fx:id=\"fieldCancion\" was not injected: check your FXML file 'SearchView.fxml'.";
                assert fieldDuracion != null
                                : "fx:id=\"fieldDuracion\" was not injected: check your FXML file 'SearchView.fxml'.";
                assert comboGenero != null
                                : "fx:id=\"comboGenero\" was not injected: check your FXML file 'SearchView.fxml'.";
                assert fieldUrl != null
                                : "fx:id=\"fieldUrl\" was not injected: check your FXML file 'SearchView.fxml'.";
                initializeCombo();
                singleton = Singleton.getInstance();
        }

        private void initializeCombo() {
                comboTipoBusqueda.getItems().add("Y");
                comboTipoBusqueda.getItems().add("O");
                comboGenero.getItems().add("Rock");
                comboGenero.getItems().add("Pop");
                comboGenero.getItems().add("Punk");
                comboGenero.getItems().add("Reggaeton");
                comboGenero.getItems().add("Electronica");
        }

}
