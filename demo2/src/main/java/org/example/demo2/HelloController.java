package org.example.demo2;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import javax.swing.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button sağ;
    @FXML
    private Button sol;
    @FXML
    private RadioButton radio1;
    @FXML
    private RadioButton radio2;
    @FXML
    private RadioButton radio3;
    @FXML
    private RadioButton radio4;
    @FXML
    private RadioButton radio5;
    private ToggleGroup toggleGroup = new ToggleGroup();
    public void initialize() {

        radio1.setToggleGroup(toggleGroup);
        radio2.setToggleGroup(toggleGroup);
        radio3.setToggleGroup(toggleGroup);
        radio4.setToggleGroup(toggleGroup);
        radio5.setToggleGroup(toggleGroup);
        seçilen();

    }
    @FXML
    private void seçilen(){
        toggleGroup.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle != null) {
                ToggleButton selectedButton = (ToggleButton) newToggle;
                welcomeText.setText(selectedButton.getText());
                switch (selectedButton.getText()) {
                    case "Red":
                        welcomeText.setStyle("-fx-text-fill: red;"); // Yazı rengi kırmızı
                        break;
                    case "yellow":
                        welcomeText.setStyle("-fx-text-fill: yellow;"); // Yazı rengi mavi
                        break;
                    case "black":
                        welcomeText.setStyle("-fx-text-fill: black;"); // Yazı rengi yeşil
                        break;
                    case "orange":
                        welcomeText.setStyle("-fx-text-fill: orange;"); // Yazı rengi yeşil
                        break;
                    case "green":
                        welcomeText.setStyle("-fx-text-fill: green;"); // Yazı rengi yeşil
                        break;
                    default:
                        welcomeText.setStyle("-fx-text-fill: black;"); // Varsayılan renk siyah
                        break;
                }
            }
        });

    }
    @FXML
    private void hareketsağ(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1)); // 1 saniyelik animasyon
        transition.setNode(welcomeText); // Hareket ettirilecek düğüm
        transition.setByX(100); // 100 birim sağa kaydır
        transition.play();

    }
    @FXML
    private void hareketsol(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1)); // 1 saniyelik animasyon
        transition.setNode(welcomeText); // Hareket ettirilecek düğüm
        transition.setByX(-100); // 100 birim sağa kaydır
        transition.play();

    }



}