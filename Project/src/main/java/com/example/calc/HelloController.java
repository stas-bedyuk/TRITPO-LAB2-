package com.example.calc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;



public class HelloController {

    ObservableList<String> choose = FXCollections.observableArrayList("USD","EUR","BYN","RUB");
    @FXML
    private TextField byn;

    @FXML
    private ChoiceBox<String> choos;

    @FXML
    private Button clc;

    @FXML
    private TextField rub;

    @FXML
    private TextField ur;

    @FXML
    private TextField usd;
    @FXML

    private TextField total;
    @FXML
    public void initialize (){
        choos.setItems(choose);
        choos.setValue("Currencies:");
    }
    @FXML
    protected void onHelloButtonClick() throws IOException {


        ParseCur a = new ParseCur();
        BYN AmountOfByn = new BYN();
        Dollar AmountOfDol = new Dollar();
        Euro AmountOfEuro = new Euro();
        Rub AmountOfRub = new Rub();       

        CalcCur Calc = new CalcCur();
try {
    AmountOfByn.setByn(Double.parseDouble(byn.getText()));
    AmountOfDol.setDol(Double.parseDouble(usd.getText()));
    AmountOfEuro.setEur(Double.parseDouble(ur.getText()));
    AmountOfRub.setRub(Double.parseDouble(rub.getText()));
}
catch(NumberFormatException e){
    JOptionPane.showMessageDialog(new JFrame(), "INCORRECT INPUT", "Dialog",
            JOptionPane.ERROR_MESSAGE);
        }
        a.Parse();

        Calc.Sum(choos, AmountOfByn, AmountOfDol, AmountOfEuro, AmountOfRub,a);

total.setText(Double.toString(Calc.getSum()));



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
