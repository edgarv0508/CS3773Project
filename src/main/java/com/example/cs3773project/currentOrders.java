package com.example.cs3773project;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * Isaac Nguyen rrg053
 * CS 3773 Software Engineering
 * August 3, 2022
 */

//The Order class control get the data from database and stores it in a variable to be used
public class currentOrders {
    //SimpleStringProperty variable for order details
    final private SimpleStringProperty  orderDate, customerName, status;
    final private SimpleDoubleProperty amount;

    //Order method that stores data to variables
    public currentOrders(String oDate, String cName, Double amt, String sts){
        this.orderDate = new SimpleStringProperty(oDate);
        this.customerName = new SimpleStringProperty(cName);
        this.amount = new SimpleDoubleProperty(amt);
        this.status = new SimpleStringProperty(sts);
        System.out.println(this.orderDate);

    }

    /*
    * Getters and Setters for each variable
     */

    public String getOrderDate() {
        return orderDate.get();
    }

    public SimpleStringProperty orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate.set(orderDate);
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    @Override
    public String toString() {
        return "Order{" +
                ", orderDate=" + orderDate +
                ", customerName=" + customerName +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }

}
