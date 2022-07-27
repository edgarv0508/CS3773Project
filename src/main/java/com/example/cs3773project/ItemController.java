package com.example.cs3773project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemController {

    @FXML
    private Button modify;

    @FXML
    private Button create;

    @FXML
    private Button home;

    @FXML
    void createItem(MouseEvent event) throws IOException {

    }

    @FXML
    void modifyItem(MouseEvent event) throws IOException {

    }

    @FXML
    void reutrnHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage.setTitle("Create Item");
        stage.setScene(new Scene(root));
    }

}