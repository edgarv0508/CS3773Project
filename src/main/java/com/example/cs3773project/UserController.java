package com.example.cs3773project;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
            /*
                DATABASE CODE HERE
                ADD USERS NAME AND PASSWORD
                TO DATABASE
             */
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);  //success message
            confirmation.setTitle("Confirmation Message");
            confirmation.setHeaderText("Confirmed");
            confirmation.setContentText("Your account has been created.");
            confirmation.showAndWait();
            PassBox.clear();
            NameBox.clear();
        }
    }

        void modUser(ActionEvent event) throws IOException{




        }



    }



