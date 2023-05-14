package com.tienda.musica.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

import javax.swing.JOptionPane;

import com.tienda.musica.controllers.modelTable.ModelTable;
import com.tienda.musica.exceptions.DataNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainViewController {

    Singleton singleton = new Singleton();

    ArrayList<ModelTable> datos = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarArtistaButton;

    @FXML
    private Button agregarCancionButton;

    @FXML
    private TableColumn<ModelTable, String> albumColumn;

    @FXML
    private TableColumn<ModelTable, Integer> anioColumn;

    @FXML
    private TableColumn<ModelTable, String> autorColumn;

    @FXML
    private Button deshacerButton;

    @FXML
    private TableColumn<ModelTable, String> duracionColumn;

    @FXML
    private Button eliminarButton;

    @FXML
    private TableColumn<ModelTable, String> generoColumn;

    @FXML
    private Button limpiarButton;

    @FXML
    private TableColumn<ModelTable, String> nombreColumn;

    @FXML
    private Button rehacerButton;

    @FXML
    private TableView<ModelTable> tableCanciones;

    @FXML
    private TextField textFieldBuscar;

    @FXML
    private TableColumn<ModelTable, String> urlColumn;

    @FXML
    private Button busquedaButton;

    private ObservableList<ModelTable> datosLista = FXCollections.observableArrayList();

    @FXML
    void actionDeshacer(ActionEvent event) {

    }

    @FXML
    void actionLimpiar(ActionEvent event) {
        actualizarDatos();
    }

    @FXML
    void actionRehacer(ActionEvent event) {

    }

    @FXML
    void onActionBusqueda(ActionEvent event) {
        try {
            URL url = new File("src/main/resources/com/tienda/musica/SearchView.fxml")
                    .toURI().toURL();
            Parent root1 = FXMLLoader.load(url);
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.setTitle("Agregar Artista");
            stage1.setScene(scene1);
            stage1.show();
            Stage stage = (Stage) textFieldBuscar.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    @FXML
    void onActionAgregarArtista(ActionEvent event) {
        try {
            URL url = new File("src/main/resources/com/tienda/musica/CrearArtistaView.fxml")
                    .toURI().toURL();
            Parent root1 = FXMLLoader.load(url);
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.setTitle("Agregar Artista");
            stage1.setScene(scene1);
            stage1.show();
            Stage stage = (Stage) textFieldBuscar.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @FXML
    void onActionAgregarCancion(ActionEvent event) {
        try {
            URL url = new File("src/main/resources/com/tienda/musica/CancionView.fxml")
                    .toURI().toURL();
            Parent root1 = FXMLLoader.load(url);
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.setTitle("Agregar Cancion");
            stage1.setScene(scene1);
            stage1.show();
            Stage stage = (Stage) textFieldBuscar.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            mostrarMensaje(e.getMessage());
        }
        actualizarDatos();
    }

    @FXML
    void onActionEliminar(ActionEvent event) {
        try {
            validarTabla();
            singleton.eliminarCancion(tableCanciones.getSelectionModel().getSelectedItem().getAutor(),
                    tableCanciones.getSelectionModel().getSelectedItem().getNombre());
            actualizarDatos();
        } catch (DataFormatException e) {
            mostrarMensaje(e.getMessage());
        } catch (DataNotFoundException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    @FXML
    void onKeyTypedFiltro(KeyEvent event) {
        if (textFieldBuscar.getText().equals("")) {
            actualizarDatos();
        } else {
            try {
                datos = singleton.buscarArtista(textFieldBuscar.getText());
                datosLista.clear();
                datosLista.addAll(datos);
                tableCanciones.setItems(datosLista);
            } catch (Exception e) {
            }
        }

    }

    @FXML
    void initialize() {
        assert agregarArtistaButton != null
                : "fx:id=\"agregarArtistaButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert agregarCancionButton != null
                : "fx:id=\"agregarCancionButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert albumColumn != null
                : "fx:id=\"albumColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert anioColumn != null
                : "fx:id=\"anioColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert autorColumn != null
                : "fx:id=\"autorColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert deshacerButton != null
                : "fx:id=\"deshacerButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert duracionColumn != null
                : "fx:id=\"duracionColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert eliminarButton != null
                : "fx:id=\"eliminarButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert generoColumn != null
                : "fx:id=\"generoColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert nombreColumn != null
                : "fx:id=\"nombreColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert rehacerButton != null
                : "fx:id=\"rehacerButton\" was not injected: check your FXML file 'MainView.fxml'.";
        assert limpiarButton != null
                : "fx:id=\"rehacerButton1\" was not injected: check your FXML file 'MainView.fxml'.";
        assert tableCanciones != null
                : "fx:id=\"tableCanciones\" was not injected: check your FXML file 'MainView.fxml'.";
        assert textFieldBuscar != null
                : "fx:id=\"textFieldBuscar\" was not injected: check your FXML file 'MainView.fxml'.";
        assert urlColumn != null
                : "fx:id=\"urlColumn\" was not injected: check your FXML file 'MainView.fxml'.";
        assert busquedaButton != null
                : "fx:id=\"busquedaButton\" was not injected: check your FXML file 'MainView.fxml'.";
        deshacerButton.setDisable(true);
        rehacerButton.setDisable(true);
        if (!singleton.isFiltered()) {
            limpiarButton.setDisable(true);
        }
        loadTable();
        singleton = Singleton.getInstance();
    }

    private void actualizarDatos() {
        if (singleton.isFiltered()) {
            try {
                datos = this.singleton.getResultado();
                datosLista.clear();
                datosLista.addAll(datos);
                tableCanciones.setItems(datosLista);
            } catch (Exception e) {

            }
        } else {
            try {
                datos = this.singleton.tomarCanciones();
                datosLista.clear();
                datosLista.addAll(datos);
                tableCanciones.setItems(datosLista);
            } catch (Exception e) {

            }
        }
    }

    private void validarTabla() throws DataFormatException {
        if (tableCanciones.getSelectionModel().getSelectedItem() == null) {
            throw new DataFormatException("No hay cancion seleccionada");
        }
    }

    private void loadTable() {
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("NombreAlbum"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        anioColumn.setCellValueFactory(new PropertyValueFactory<>("Anio"));
        duracionColumn.setCellValueFactory(new PropertyValueFactory<>("Duracion"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("Genero"));
        autorColumn.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        urlColumn.setCellValueFactory(new PropertyValueFactory<>("Url"));
        try {
            datos = this.singleton.tomarCanciones();
            datosLista.clear();
            datosLista.addAll(datos);
            tableCanciones.setItems(datosLista);
        } catch (Exception e) {

        }
    }

}