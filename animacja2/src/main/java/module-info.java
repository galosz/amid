module com.example.animacja2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animacja2 to javafx.fxml;
    exports com.example.animacja2;
}