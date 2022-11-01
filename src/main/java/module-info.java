module com.example.fx_memorygame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fx_memorygame to javafx.fxml;
    exports com.example.fx_memorygame;
}