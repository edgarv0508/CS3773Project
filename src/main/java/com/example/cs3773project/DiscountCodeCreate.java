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

public class DiscountCodeCreate {

    @FXML
    private TextField tfCode;

    @FXML
    private TextField tfPercent;


    @FXML
    private Button home;

    @FXML
    private Button create;

    @FXML
    void create(MouseEvent event) {
        registerCode();
        tfCode.clear();
        tfPercent.clear();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-view.fxml"));
        stage.setTitle("Items");
        stage.setScene(new Scene(root));
    }

    public void registerCode(){
        String code = tfCode.getText();
        String percent = tfPercent.getText();
;

        discountCode = addCodeToDatabase(code, percent);
    }

    public DiscountCode discountCode;
    private DiscountCode addCodeToDatabase(String code, String percent){
        DiscountCode discountCode = null;
        final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
        final String USERNAME = "root";
        final String PASSWORD = "cs3773";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt= conn.createStatement();
            String sql = "REPLACE INTO discountCode (code, percent)" + "VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, percent);


            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                discountCode = new DiscountCode(code, percent);
                discountCode.code = code;
                discountCode.percent = percent;

            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return discountCode;
    }

}
