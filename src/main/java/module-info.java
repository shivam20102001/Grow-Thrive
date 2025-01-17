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
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires spring.beans;
    requires spring.tx;
    requires com.h2database;

    // Open the 'manager' package to JavaFX for reflective access
    opens com.example.growthrive to javafx.fxml;
    opens com.example.growthrive.manager to javafx.fxml;
    opens com.example.growthrive.ui to javafx.fxml;
    opens com.example.growthrive.controllers to javafx.fxml;

    exports com.example.growthrive;
    exports com.example.growthrive.manager;
    exports com.example.growthrive.services;
    exports com.example.growthrive.repository;
    exports com.example.growthrive.domain;


    opens com.example.growthrive.domain to spring.core, spring.beans, spring.data.jpa;
    opens com.example.growthrive.repository to spring.core, spring.beans, spring.data.jpa;


}
