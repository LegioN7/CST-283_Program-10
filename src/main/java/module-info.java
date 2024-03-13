module org.example.program10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.program10 to javafx.fxml;
    exports org.example.program10;
}