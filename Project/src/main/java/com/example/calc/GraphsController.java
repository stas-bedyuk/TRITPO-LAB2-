package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class GraphsController {

    @FXML
    private Button clc11;

    @FXML
    private Button e;

    @FXML
    private Button r;

    @FXML
    private Button u;
    @FXML
    private ImageView clc111;
    @FXML
    void back(ActionEvent event) throws IOException {
        //Close current
        Stage stage = (Stage) clc11.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void eur(ActionEvent event) {
        Image image = new Image("C:/Users/user/Desktop/java labs/Calc/src/main/resources/com/example/pictures/евро.png");
        clc111.setImage(image);
    }

    @FXML
    void rub(ActionEvent event) {
        Image image = new Image("C:/Users/user/Desktop/java labs/Calc/src/main/resources/com/example/pictures/рубль.png");
        clc111.setImage(image);
    }

    @FXML
    void usd(ActionEvent event) {
        Image image = new Image("C:/Users/user/Desktop/java labs/Calc/src/main/resources/com/example/pictures/доллар.png");
        clc111.setImage(image);
    }

}
