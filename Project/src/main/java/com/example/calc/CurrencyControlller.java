package com.example.calc;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class CurrencyControlller {

    @FXML
    private Button clc;

    @FXML
    private TextField rub;

    @FXML
    private TextField total;

    @FXML
    private TextField total1;

    @FXML
    private TextField total11;

    @FXML
    private TextField ur;

    @FXML
    private TextField usd;
    @FXML
    public void initialize () throws IOException {
        ParseCur a = new ParseCur();
        DecimalFormat df = new DecimalFormat("#.00");
        a.Parse();
        total.setText(df.format(a.getRub()));
        total1.setText(df.format(a.getDol()));
        total11.setText(df.format(a.getEur()));
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        //Close current
        Stage stage = (Stage) clc.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
