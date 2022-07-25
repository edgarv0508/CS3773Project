package com.example.cs3773project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button item, order, user;

    @FXML
    void goItems(MouseEvent event) throws IOException{
        Stage stage = (Stage) item.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-view.fxml"));
        stage.setTitle("Items");
        stage.setScene(new Scene(root));
    }

    @FXML
    void goOrders(MouseEvent event) throws IOException {
        Stage stage = (Stage) order.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("order-view.fxml"));
        stage.setTitle("Orders");
        stage.setScene(new Scene(root));
    }

    @FXML
    void goUser(MouseEvent event) throws IOException{
        Stage stage = (Stage) user.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("user-view.fxml"));
        stage.setTitle("Users");
        stage.setScene(new Scene(root));
    }

}