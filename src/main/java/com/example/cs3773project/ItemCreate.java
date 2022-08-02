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
        String amount = tfAmount.getText();
        String price = tfPrice.getText();

        items = addItemToDatabase(item, amount, price);
    }

    public Items items;
    private Items addItemToDatabase(String item, String amount, String price){
        Items items = null;
        final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
        final String USERNAME = "root";
        final String PASSWORD = "cs3773";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt= conn.createStatement();
            String sql = "REPLACE INTO itemList (item, amount, price)" + "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, item);
            preparedStatement.setString(2, amount);
            preparedStatement.setString(3, price);

            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                items = new Items(item, price, amount);
                items.item = item;
                items.amount = amount;
                items.price = price;

            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return items;
    }

}

