package com.example.cs3773project;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;

public class UserController {

    @FXML
    private AnchorPane UserApane;

    @FXML
    private TextField PassBox;

    @FXML
    private TextField NameBox;

    @FXML
    private Button CreateButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField IDBox;

    @FXML
    private Label label;

    private static final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
    private static final String USERNAME = "root";
    private final String PASSWORD = "cs3773";

    Connection conn = null;
    PreparedStatement pst = null;


    @FXML
    void goHome(ActionEvent event) throws IOException {  //method to return to main screen
        Stage stage = (Stage) BackButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage.setTitle("Main");
        stage.setScene(new Scene(root));
    }


    @FXML
    void addUserInfo(ActionEvent event) throws IOException {  //Method to add user info to database
        String userName = NameBox.getText().toString();
        String pass = PassBox.getText().toString();


        if (userName.isEmpty()) {
            Alert err = new Alert(Alert.AlertType.ERROR);       //fail message - name field is empty
            err.setTitle("Error");
            err.setHeaderText("Name field is empty");
            err.setContentText("Please enter your name.");
            err.showAndWait();
        } else if (pass.isEmpty()) {
            Alert err = new Alert(Alert.AlertType.ERROR);       //fail message - no password entered
            err.setTitle("Error");
            err.setHeaderText("Password field is empty");
            err.setContentText("Please enter desired password.");
            err.showAndWait();
        } else {
            try {
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);  //Database connection
                String userData = "INSERT INTO userList(userName, userPassword) VALUES(?,?)";
                pst = conn.prepareStatement(userData);
                pst.setString(1, NameBox.getText());
                pst.setString(2, PassBox.getText());

                pst.execute();

                pst.close();

            } catch (Exception e1) {
                label.setText("SQL ERROR");
                System.err.println(e1);
            }
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);  //success message
            confirmation.setTitle("Success");
            confirmation.setHeaderText("Your account has been successfully created.");
            confirmation.setContentText("Return to main screen.");
            confirmation.showAndWait();
            PassBox.clear();
            NameBox.clear();
        }
    }

    @FXML
    void modUser(ActionEvent event) throws IOException { //method to update user info based on ID number
        String ID = IDBox.getText().toString();
        if (ID.isEmpty()) {
            Alert err = new Alert(Alert.AlertType.ERROR);       //fail message - no ID entered
            err.setTitle("Error");
            err.setHeaderText("Must enter ID number");
            err.setContentText("Please enter which ID to update.");
            err.showAndWait();
        } else {

            try {
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                String userData = "UPDATE userList set userName=?, userPassword=? where userID=?";
                pst = conn.prepareStatement(userData);

                pst.setString(1, NameBox.getText());
                pst.setString(2, PassBox.getText());
                pst.setString(3, IDBox.getText());


                pst.executeUpdate();

                pst.close();

            } catch (Exception e1) {
                label.setText("SQL ERROR");
                System.err.println(e1);
            }
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);  //success message
            confirmation.setTitle("Confirmed");
            confirmation.setHeaderText("Your account has been updated.");
            confirmation.setContentText("Return to main screen.");
            confirmation.showAndWait();
            PassBox.clear();
            NameBox.clear();

        }
    }










}



