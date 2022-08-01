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
import java.sql.*;

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
    private TableColumn<Items, ?> cItem;

    @FXML
    private TableColumn<Items, ?> cAmount;

    @FXML
    private TableColumn<Items, ?> cPrice;

    @FXML
    private TableColumn<Items, ?> cPicture;

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



}


