package com.example.cs3773project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

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


    ObservableList<Items> oblist = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle rb) {

        final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
        final String USERNAME = "root";
        final String PASSWORD = "cs3773";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from myshop.itemList");

            while (rs.next()){
                oblist.add(new Items(rs.getString("item"), rs.getString("amount"), rs.getString("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        cItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        cAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        itemTable.setItems(oblist);
    }

}



