package com.example.growthrive;

import com.example.growthrive.utils.AppConfig;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GrowThriveApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        AppConfig appConfig = new AppConfig();

        // Load application properties
        Properties properties = loadProperties();

        // Get dynamic values
        String appName = appConfig.getAppName();
        String appIconPath = appConfig.getAppIcon();


        // Load image from resources
        Image appIcon = new Image(getClass().getResourceAsStream(appIconPath));

        // Create ImageView to scale the image
        ImageView iconView = new ImageView(appIcon);

        // Set desired size for the icon (e.g., 32x32)
//        iconView.setFitWidth(64);  // Width
//        iconView.setFitHeight(64); // Height

        // Set stage icon using scaled image
        primaryStage.getIcons().add(iconView.getImage());

        // Set desired size for the application window
//        primaryStage.setWidth(400);
//        primaryStage.setHeight(400);

        // Your UI logic here
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AuthenticationManager.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        // Add the CSS file to the Scene
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle(appName);
        primaryStage.show();



    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getResourceAsStream("/config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return properties;
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void main(String[] args) {
        launch();
    }
}
