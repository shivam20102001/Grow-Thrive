    package com.example.growthrive.manager;

    import com.example.growthrive.services.UserAuthentication;
    import com.example.growthrive.utils.AppConfig;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.io.IOException;

    @Service
    @Slf4j
    public class AuthenticationManager {


        public Text actiontarget;
        public ImageView appIconView;

        @FXML
        private TextField usernameField;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Button loginButton;

        @Autowired
        public UserAuthentication userAuthentication;




        @FXML
        private void initialize() {
            userAuthentication= new UserAuthentication();
            loginButton.setOnAction(event -> handleLogin());

            AppConfig appConfig = new AppConfig();

            //set app icon
            appIconView.setImage(new Image(getClass().getResourceAsStream(appConfig.getAppIcon())));
        }

        private void handleLogin() {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (isAuthenticated(username, password)) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/growthrive/Dashboard.fxml"));
                    Parent root = loader.load();

                    // Get the current stage
                    Stage stage = (Stage) usernameField.getScene().getWindow();

                    // Set the new scene
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private void showAlert(Alert.AlertType alertType, String title, String content) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setContentText(content);
            alert.showAndWait();
        }

        private boolean isAuthenticated(String username, String password) {

            // Placeholder logic for authentication
            return userAuthentication.authenticateUser(username,password);

        }

    }
