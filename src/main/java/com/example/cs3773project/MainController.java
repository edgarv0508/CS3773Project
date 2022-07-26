package com.example.cs3773project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

    @FXML
    private AnchorPane Main;

    @FXML
    private Button NewUser;


    @FXML
    public void action1(ActionEvent event) throws IOException { //method to load user-view fxml on action
        Main = FXMLLoader.load(getClass().getResource("user-view.fxml"));
        Scene scene = new Scene(Main);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}