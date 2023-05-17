package com.tienda.musica.controllers;

import java.io.File;
import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

import javax.swing.JFileChooser;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AgregarCancionController {

        Singleton singleton = new Singleton();

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button agregarButton;

        @FXML
        private TextField fieldAlbum;

        @FXML
        private TextField fieldAnio;

        @FXML
        private TextField fieldArtista;

        @FXML
        private TextField fieldCancion;

        @FXML
        private TextField fieldDuracion;

        @FXML
        private TextField fieldUrl;

        @FXML
        private Button seleccionarCaratulaButton;

        @FXML
        private Text textCaratula;

        @FXML
        private ComboBox<String> comboGenero;

        @FXML
        void onActionAgregar(ActionEvent event) {
                try {
                        validateFields();
                        int anio = Integer.parseInt(fieldAnio.getText());
                        singleton.agregarCancion(fieldArtista.getText(), fieldCancion.getText(), fieldAlbum.getText(),
                                        textCaratula.getText(), anio, fieldDuracion.getText(),
                                        comboGenero.getSelectionModel().getSelectedItem(),
                                        fieldUrl.getText());
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
                        Stage stage = (Stage) agregarButton.getScene().getWindow();
                        stage.close();
                } catch (NumberFormatException e) {
                        mostrarMensaje("Formato del año erroneo");
                } catch (DateTimeParseException e) {
                        mostrarMensaje("Formato de duracion erroneo");
                } catch (DataNotFoundException e) {
                        mostrarMensaje(e.getMessage());
                } catch (DataFormatException e) {
                        mostrarMensaje(e.getMessage());
                }
        }

        private void mostrarMensaje(String mensaje) {
                JOptionPane.showMessageDialog(null, mensaje);
        }

        private void validateFields() throws DataFormatException {
                if (fieldArtista.getText().equals("") || fieldAlbum.getText().equals("")
                                || fieldAnio.getText().equals("") || fieldCancion.getText().equals("")
                                || fieldDuracion.getText().equals("")
                                || comboGenero.getSelectionModel().getSelectedIndex() == -1
                                || fieldUrl.getText().equals("")
                                || textCaratula.getText().equals("")) {
                        throw new DataFormatException("Campos vacios");
                }
                Formatter.formatTime(fieldDuracion.getText());
        }

        @FXML
        void onActionSeleccionarCaratula(ActionEvent event) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(fileChooser);
                textCaratula.setText(fileChooser.getSelectedFile().getPath());
        }

        @FXML
        void initialize() {
                assert agregarButton != null
                                : "fx:id=\"agregarButton\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert fieldAlbum != null
                                : "fx:id=\"fieldAlbum\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert fieldAnio != null
                                : "fx:id=\"fieldAnio\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert fieldArtista != null
                                : "fx:id=\"fieldArtista\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert fieldCancion != null
                                : "fx:id=\"fieldCancion\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert fieldDuracion != null
                                : "fx:id=\"fieldDuracion\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert comboGenero != null
                                : "fx:id=\"fieldGenero\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert fieldUrl != null
                                : "fx:id=\"fieldUrl\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert seleccionarCaratulaButton != null
                                : "fx:id=\"seleccionarCaratulaButton\" was not injected: check your FXML file 'CancionView.fxml'.";
                assert textCaratula != null
                                : "fx:id=\"textCaratula\" was not injected: check your FXML file 'CancionView.fxml'.";
                singleton = Singleton.getInstance();
                initializeCombo();
        }

        private void initializeCombo() {
                comboGenero.getItems().add("Rock");
                comboGenero.getItems().add("Pop");
                comboGenero.getItems().add("Punk");
                comboGenero.getItems().add("Reggaeton");
                comboGenero.getItems().add("Electronica");
        }
}