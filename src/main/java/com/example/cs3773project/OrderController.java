package com.example.cs3773project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static String SORT_BY_ORDER_DATE = "ORDER_DATE";
    public static String SORT_BY_CUSTOMER = "CUSTOMER";
    public static String SORT_BY_AMOUNT = "AMOUNT";

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

    private void sortHistoryOrders(ObservableList<Order> orders, String sortColumn, boolean isAsc) {
        if (SORT_BY_ORDER_DATE.equals(sortColumn)) {
            Collections.sort(orders, new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    String orderDate1 = o1.getOrderDate();
                    String orderDate2 = o2.getOrderDate();
                    int sign = 1;
                    if (!isAsc) {
                        sign = -1;
                    }
                    if (orderDate1 == null) {
                        return 1 * sign;
                    }
                    if (orderDate2 == null) {
                        return -1 * sign;
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
                    try {
                        Date date1 = sdf.parse(orderDate1);
                        Date date2 = sdf.parse(orderDate2);
                        return (date1.compareTo(date2)) * sign;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return (orderDate1.compareTo(orderDate2)) * sign;
                }
            });
        } else if (SORT_BY_CUSTOMER.equals(sortColumn)) {
            Collections.sort(orders, new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    String customerName1 = o1.getCustomerName();
                    String customerName2 = o2.getCustomerName();
                    int sign = 1;
                    if (!isAsc) {
                        sign = -1;
                    }
                    if (customerName1 == null) {
                        return 1 * sign;
                    }
                    if (customerName2 == null) {
                        return -1 * sign;
                    }

                    return (customerName1.compareTo(customerName2)) * sign;
                }
            });
        }else if (SORT_BY_AMOUNT.equals(sortColumn)) {
            Collections.sort(orders, new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    String amount1 = o1.getAmount();
                    String amount2 = o2.getAmount();
                    int sign = 1;
                    if (!isAsc) {
                        sign = -1;
                    }
                    if (amount1 == null) {
                        return 1 * sign;
                    }
                    if (amount2 == null) {
                        return -1 * sign;
                    }
                    try {
                        Double amount1Val = Double.parseDouble(amount1.replace("$",""));
                        Double amount2Val = Double.parseDouble(amount2.replace("$",""));
                        return (amount1Val.compareTo(amount2Val)) * sign;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return (amount1.compareTo(amount2)) * sign;
                }
            });
        }
    }

    public static void main(String[] args) {
        ObservableList<Order> info = FXCollections.observableArrayList(
                new Order("1", "July 25, 2022", "Isaac Nguyen", "$3.11", "view"),
                new Order("2", "May 26, 2022", "Isaac Neo", "$1.11", "view"),
                new Order("2", "August 26, 2022", "Feirie Juno", "$2.11", "view")
        );
        OrderController orderController = new OrderController();
        System.out.println("=============SORT_BY_ORDER_DATE");
        orderController.sortHistoryOrders(info, SORT_BY_ORDER_DATE, false);
        System.out.println(info);
        orderController.sortHistoryOrders(info, SORT_BY_ORDER_DATE, true);
        System.out.println(info);
        System.out.println("=============SORT_BY_CUSTOMER");
        orderController.sortHistoryOrders(info, SORT_BY_CUSTOMER, false);
        System.out.println(info);
        orderController.sortHistoryOrders(info, SORT_BY_CUSTOMER, true);
        System.out.println(info);
        System.out.println("=============SORT_BY_AMOUNT");
        orderController.sortHistoryOrders(info, SORT_BY_AMOUNT, false);
        System.out.println(info);
        orderController.sortHistoryOrders(info, SORT_BY_AMOUNT, true);
        System.out.println(info);
    }
}