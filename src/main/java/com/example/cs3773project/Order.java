package com.example.cs3773project;

import javafx.beans.property.SimpleStringProperty;

/*
 * Isaac Nguyen rrg053
 * CS 3773 Software Engineering
 * August 3, 2022
 */

//The Order class control get the data from database and stores it in a variable to be used
public class Order {
    //SimpleStringProperty variable for order details
    private SimpleStringProperty orderNumber, orderDate, customerName, amount, view;

    //Order method that stores data to variables
    public Order(String oNumber, String oDate, String cName, String amt, String view){
        this.orderNumber = new SimpleStringProperty(oNumber);
        this.orderDate = new SimpleStringProperty(oDate);
        this.customerName = new SimpleStringProperty(cName);
        this.amount = new SimpleStringProperty(amt);
        this.view = new SimpleStringProperty(view);

    }

    /*
    * Getters and Setters for each variable
     */
    public String getOrderNumber() {
        return orderNumber.get();
    }

    public SimpleStringProperty orderNumberProperty() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber.set(orderNumber);
    }

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

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getView() {
        return view.get();
    }

    public SimpleStringProperty viewProperty() {
        return view;
    }

    public void setView(String view) {
        this.view.set(view);
    }






}
