package com.example.cs3773project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ScrollPane;
/*
* Isaac Nguyen rrg053
* CS 3773 Software Engineering
* August 3, 2022
*/

//The OrderController class control the current order placed
public class OrderController implements Initializable {
    //Table column variables to set values to table
    @FXML
    private TableColumn<Order, String> orderNumCol, orderDateCol, customerNameCol, amountCol, viewCol;
    //TableView to hold order data
    @FXML
    private TableView<Order> tableView;
    //Scroll Pane to allow for scrolling if number of order exceeds page limit
    @FXML
    private ScrollPane currentOrderPane;

    //Initialize function that displays table view data when scene opens up
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Observable List for order information
        final ObservableList<Order> info = FXCollections.observableArrayList(
            new Order("1", "July 26, 2022", "Isaac Nguyen", "$1.11", "view"),
                new Order("2", "July 26, 2022", "Isaac Nguyen", "$1.11", "view")
        );

        //Value from database are set to their respective table columns
        orderNumCol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderNumber"));
        orderDateCol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderDate"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerName"));
        amountCol.setCellValueFactory(new PropertyValueFactory<Order, String>("amount"));
        viewCol.setCellValueFactory(new PropertyValueFactory<Order, String>("view"));

        // data information on table view
        tableView.setItems(info);
        //disable editing the table
        tableView.setSelectionModel(null);
        orderNumCol.setSortable(false);
        orderDateCol.setSortable(false);
        customerNameCol.setSortable(false);
        amountCol.setSortable(false);
        viewCol.setSortable(false);
    }


}