module com.example.sprawko {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sprawko to javafx.fxml;
    exports com.example.sprawko;
}