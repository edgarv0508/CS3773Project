module com.example.cs3773project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.cs3773project to javafx.fxml;
    exports com.example.cs3773project;
}