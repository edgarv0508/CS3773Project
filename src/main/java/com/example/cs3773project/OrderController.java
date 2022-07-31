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


public class OrderController implements Initializable {
    @FXML
    private TableColumn<Order, String> customerNameCol;

    @FXML
    private TableColumn<Order, String> amountCol;

    @FXML
    private TableColumn<Order, String> orderDateCol;

    @FXML
    private TableColumn<Order, String> viewCol;

    @FXML
    private TableColumn<Order, String> orderNumCol;

    @FXML
    private TableView<Order> tableView;

    @FXML
    private ScrollPane currentOrderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //tableView = new TableView<Order>();
        //Order od = new Order(null,null,null,null,null);
        //tableView.getColumns().addAll(orderNumCol, orderDateCol, customerNameCol, amountCol, viewCol);
        final ObservableList<Order> info = FXCollections.observableArrayList(
            new Order("1", "July 26, 2022", "Isaac Nguyen", "$1.11", "view"),
                new Order("2", "July 26, 2022", "Isaac Nguyen", "$1.11", "view")
        );
        orderNumCol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderNumber"));
        orderDateCol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderDate"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerName"));
        amountCol.setCellValueFactory(new PropertyValueFactory<Order, String>("amount"));
        viewCol.setCellValueFactory(new PropertyValueFactory<Order, String>("view"));

        tableView.setItems(info);
        tableView.setSelectionModel(null);
        orderNumCol.setSortable(false);
        orderDateCol.setSortable(false);
        customerNameCol.setSortable(false);
        amountCol.setSortable(false);
        viewCol.setSortable(false);
        //System.out.println(orderNumCol);
        //tableView.getColumns().addAll(orderNumCol, orderDateCol, customerNameCol, amountCol, viewCol);
    }


}