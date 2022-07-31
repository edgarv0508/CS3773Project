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
    private TableColumn<Items, ?> item;

    @FXML
    private TableColumn<Items, ?> amount;

    @FXML
    private TableColumn<Items, ?> price;

    @FXML
    private TableColumn<Items, ?> picture;

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


    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    String connectQuery = "";

    try {
        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(connectQuery);

        while (queryOutput.next()) {
            itemTable.(queryOutput.getString("item"));
        }

    } catch (Exception e){
        e.printStackTrace();
    }


}


