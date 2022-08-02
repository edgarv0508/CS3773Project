package com.example.cs3773project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
/*
* Isaac Nguyen rrg053
* CS 3773 Software Engineering
* August 3, 2022
*/

//The OrderController class control the current order placed
public class currentOrderController implements Initializable {
    //Table column variables to set values to table
    @FXML
    private TableColumn<currentOrders, String>  orDateCol, custNameCol, orStatusCol;
    @FXML
    private TableColumn<currentOrders, Double> orAmountCol;
    //TableView to hold order data
    @FXML
    private TableView<currentOrders> tableView;
    //Scroll Pane to allow for scrolling if number of order exceeds page limit
    @FXML
    private ScrollPane currentOrderPane;

    @FXML
    private Button orderHistory, home;


    @FXML
    void goOrderHistory(ActionEvent event) throws IOException {
        Stage stage = (Stage) orderHistory.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("orderHistory-view.fxml"));
        stage.setTitle("Orders");
        stage.setScene(new Scene(root));
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage.setTitle("Orders");
        stage.setScene(new Scene(root));
    }

    //Initialize function that displays table view data when scene opens up
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Observable List for order information
        ObservableList<currentOrders> cList = FXCollections.observableArrayList();

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
            ResultSet rs = conn.createStatement().executeQuery("select * from myshop.ordersList");

            while (rs.next()) {
                System.out.println(rs.getString("DeliveryStatus"));
                if(!rs.getString("DeliveryStatus").equals("Delivered")) {
                    cList.add(new currentOrders(rs.getString("orderDate"), rs.getString("Customer"), rs.getDouble("orderAmount"), rs.getString("DeliveryStatus")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Value from database are set to their respective table columns
        orDateCol.setCellValueFactory(new PropertyValueFactory<currentOrders, String>("orderDate"));
        custNameCol.setCellValueFactory(new PropertyValueFactory<currentOrders, String>("customerName"));
        orAmountCol.setCellValueFactory(new PropertyValueFactory<currentOrders, Double>("amount"));
        orStatusCol.setCellValueFactory(new PropertyValueFactory<currentOrders, String>("status"));
        //oList = orderImport.getDataOrders();

        // data information on table view
        tableView.setItems(cList);
        //disable editing the table
        tableView.setSelectionModel(null);
        orDateCol.setSortable(false);
        custNameCol.setSortable(false);
        orAmountCol.setSortable(false);
    }

}