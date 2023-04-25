module com.tienda.musica {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tienda.musica to javafx.fxml;
    exports com.tienda.musica;
}
