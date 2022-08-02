package com.example.cs3773project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    @FXML
    private Button create;

    @FXML
    private Button home;

    @FXML
    private Button discount;


    @FXML
    private TableView<Items> itemTable;

    @FXML
    private TableColumn<Items, String> cItem;

    @FXML
    private TableColumn<Items, String> cAmount;

    @FXML
    private TableColumn<Items, String> cPrice;

    @FXML
    private static TextField itemSearch;

    @FXML
    void createCode(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("discountCode-create.fxml"));
        stage.setTitle("Main View");
        stage.setScene(new Scene(root));
    }

    @FXML
    void returnHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage.setTitle("Main View");
        stage.setScene(new Scene(root));
    }

    @FXML
    void createItem(MouseEvent event) throws IOException {
        Stage stage = (Stage) create.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("item-create.fxml"));
        stage.setTitle("Create");
        stage.setScene(new Scene(root));
    }

    public void changeItemCellEvent(TableColumn.CellEditEvent editedCell){
        Items itemSelected = itemTable.getSelectionModel().getSelectedItem();
        itemSelected.setItem(editedCell.getNewValue().toString());
        String item = cItem.getText();
        String amount = cAmount.getText();
        String price = cPrice.getText();

        items = modifyItem(item, amount, price);

    }

    public void changeAmountCellEvent(TableColumn.CellEditEvent editedCell){
        Items itemSelected = itemTable.getSelectionModel().getSelectedItem();
        itemSelected.setAmount(editedCell.getNewValue().toString());
        String item = cItem.getText();
        String amount = cAmount.getText();
        String price = cPrice.getText();

        items = modifyAmount(item, amount, price);

    }

    public void changePriceCellEvent(TableColumn.CellEditEvent editedCell){
        Items itemSelected = itemTable.getSelectionModel().getSelectedItem();
        itemSelected.setPrice(editedCell.getNewValue().toString());
        String item = cItem.getText();
        String amount = cAmount.getText();
        String price = cPrice.getText();

        items = modifyPrice(item, amount, price);

    }

    public Items items;
    private Items modifyItem(String item, String amount, String price){
        Items items = null;
        final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
        final String USERNAME = "root";
        final String PASSWORD = "cs3773";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt= conn.createStatement();
            String sql = "UPDATE itemList SET item = ? WHERE item = '" +item+ "'" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, item);


            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                items = new Items(item, price, amount);
                items.item = item;
                items.amount = amount;
                items.price = price;

            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return items;
    }

    private Items modifyAmount(String item, String amount, String price){
        Items items = null;
        final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
        final String USERNAME = "root";
        final String PASSWORD = "cs3773";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt= conn.createStatement();
            String sql = "UPDATE itemList SET amount = ? WHERE item = '" +item+ "'" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, amount);


            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                items = new Items(item, price, amount);
                items.item = item;
                items.amount = amount;
                items.price = price;

            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return items;
    }

    private Items modifyPrice(String item, String amount, String price){
        Items items = null;
        final String DB_URL = "jdbc:mysql://34.174.229.178/myshop";
        final String USERNAME = "root";
        final String PASSWORD = "cs3773";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt= conn.createStatement();
            String sql = "UPDATE itemList SET price = ? WHERE item = '" +item+ "'" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, price);


            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                items = new Items(item, price, amount);
                items.item = item;
                items.amount = amount;
                items.price = price;

            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return items;
    }

    ObservableList<Items> oblist = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle rb) {

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
            ResultSet rs = conn.createStatement().executeQuery("select * from myshop.itemList");

            while (rs.next()) {
                oblist.add(new Items(rs.getString("item"), rs.getString("amount"), rs.getString("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        cItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        cAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        itemTable.setItems(oblist);

        itemTable.setEditable(true);
        cItem.setCellFactory(TextFieldTableCell.forTableColumn());
        cAmount.setCellFactory(TextFieldTableCell.forTableColumn());
        cPrice.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}



