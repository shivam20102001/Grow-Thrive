module com.example.growthrive {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    // requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires lombok;

    // Open the 'manager' package to JavaFX for reflective access
    opens com.example.growthrive to javafx.fxml;
    opens com.example.growthrive.manager to javafx.fxml;
    opens com.example.growthrive.ui to javafx.fxml;
    opens com.example.growthrive.controllers to javafx.fxml;

    exports com.example.growthrive;
    exports com.example.growthrive.manager;
}
