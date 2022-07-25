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
    private Button button;

    @FXML
    void createItem(MouseEvent event) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-create.fxml"));
        stage.setTitle("Create Item");
        stage.setScene(new Scene(root));
    }

    @FXML
    void modifyItem(MouseEvent event) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-modify.fxml"));
        stage.setTitle("Modify Item");
        stage.setScene(new Scene(root));
    }

    @FXML
    void reutrnHome(MouseEvent event) {

    }

}