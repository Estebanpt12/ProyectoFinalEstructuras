module com.tienda.musica {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.logging;
    requires java.desktop;
    requires javafx.graphics;

    exports com.tienda.musica.controllers;
    exports com.tienda.musica.exceptions;
    exports com.tienda.musica.model;
    exports com.tienda.musica.utils;
    exports com.tienda.musica.writers;

    opens com.tienda.musica.controllers to javafx.fxml;
    opens com.tienda.musica to javafx.fxml;
    opens com.tienda.musica.controllers.modelTable to javafx.fxml;
    opens com.tienda.musica.model to javafx.fxml;
    opens com.tienda.musica.model.nodos to javafx.fxml;

    exports com.tienda.musica;
    exports com.tienda.musica.model.nodos;
    exports com.tienda.musica.model.lists;
    exports com.tienda.musica.controllers.modelTable;
}
