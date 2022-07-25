package com.example.cs3773project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ItemController {

    @FXML
    private Button button;

    @FXML
    void createItem(MouseEvent event) {
        Stage stage = (Stage) button.getScene().getWindow();

    }

    @FXML
    void modifyItem(MouseEvent event) {

    }

    @FXML
    void reutrnHome(MouseEvent event) {

    }

}