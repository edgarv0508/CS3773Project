package com.example.cs3773project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemController {

    @FXML
    private Button modify;

    @FXML
    private Button create;

    @FXML
    private Button home;


    @FXML
    private TableView<Items> itemTable;

    @FXML
    private TableColumn<Items, String> cItem;

    @FXML
    private TableColumn<Items, String> cAmount;

    @FXML
    private TableColumn<Items, String> cPrice;


    @FXML
    void createItem(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-create.fxml"));
        stage.setTitle("Create");
        stage.setScene(new Scene(root));
    }

    @FXML
    void modifyItem(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-modify.fxml"));
        stage.setTitle("Modify");
        stage.setScene(new Scene(root));
    }

    @FXML
    void returnHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage.setTitle("Main View");
        stage.setScene(new Scene(root));
    }


    public void initialize(URL url, ResourceBundle rb) {
        //cItem.setCellValueFactory(new PropertyValue<Items, String>("item"));
    }

}



