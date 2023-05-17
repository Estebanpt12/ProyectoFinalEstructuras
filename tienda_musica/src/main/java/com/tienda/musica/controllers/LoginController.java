package com.tienda.musica.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txtPasswor;

    @FXML
    private TextField txtUsuario;

    @FXML
    void iniciarSecion(ActionEvent event) {
        String usuario  = txtUsuario.getText();
        String passwor = txtPasswor.getText();
        try {
            if (usuario.equals("admin") && passwor.equals("admin123")) {

                URL url = new File("src/main/resources/com/tienda/musica/MainView.fxml")
                        .toURI().toURL();
                Parent root1 = FXMLLoader.load(url);
                Scene scene1 = new Scene(root1);
                Stage stage1 = new Stage();
                stage1.setTitle("Storify");
                stage1.setScene(scene1);
                stage1.show();
                Stage stage = (Stage) btnIngresar.getScene().getWindow();
                stage.close();

            }else{
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }
        } catch (IOException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtPasswor != null : "fx:id=\"txtPasswor\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'Login.fxml'.";

    }

}

