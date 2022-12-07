package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MenuController {


    private static String IMAGE_DESTINATION_FOLDER = "C:/iii";
    @FXML
    private Button calc;

    @FXML
    private Button cur;


    private Button graphs;

    @FXML
    void ToCalc(ActionEvent event) throws IOException {


        //Close current
        Stage stage = (Stage) calc.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    void ToCur(ActionEvent event) throws IOException {
        //Close current
        Stage stage = (Stage) calc.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rates.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    void ToGra(ActionEvent event) throws IOException {
        //Close current
        Stage stage = (Stage) calc.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("graphs.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }
    private static void downloadImage(String strImageURL){

        //get file name from image path
        String strImageName =
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );

        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

        try {

            //open the stream from URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os =
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + strImageName );

            //write bytes to the output stream
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

            System.out.println("Image saved");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


