package com.example.cs3773project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ItemCreate {

    @FXML
    private TextField tfAmount;

    @FXML
    private TextField tfItem;

    @FXML
    private TextField tfPrice;

    @FXML
    private Button home;

    @FXML
    private Button create;

    @FXML
    void create(MouseEvent event) {
        registerItem();
        tfItem.clear();
        tfPrice.clear();
        tfAmount.clear();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-view.fxml"));
        stage.setTitle("Items");
        stage.setScene(new Scene(root));
    }

    public void registerItem(){
        String item = tfItem.getText();
        String price = tfPrice.getText();
        String amount = tfAmount.getText();

        items = addItemToDatabase(item, price, amount);
    }

    public Items items;
    private Items addItemToDatabase(String item, String price, String amount){
        Items items = null;
        final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
        final String USERNAME = "root";
        final String PASSWORD = "cs3773";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt= conn.createStatement();
            String sql = "REPLACE INTO itemList (item, price, amount)" + "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, item);
            preparedStatement.setString(2, price);
            preparedStatement.setString(3, amount);

            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                items = new Items(item, price, amount);
                items.item = item;
                items.price = price;
                items.amount = amount;

            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return items;
    }

}

