package org.example.demo6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            URL fxmlLocation = HelloApplication.class.getResource("hello-view.fxml");
            if (fxmlLocation == null) {
                throw new IOException("FXML dosyası bulunamadı!");
            }

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Öğrenci Ders Yönetimi");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("FXML yükleme hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
