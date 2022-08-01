package com.example.cs3773project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemModify {

    @FXML
    private TextField tfAmount;

    @FXML
    private TextField tfItem;

    @FXML
    private TextField tfPrice;

    @FXML
    private Button goBack;

    @FXML
    private Button modify;

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) goBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-view.fxml"));
        stage.setTitle("Items");
        stage.setScene(new Scene(root));
    }

    @FXML
    void modify(MouseEvent event) {

    }
}
