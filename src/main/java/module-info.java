module org.example.oopweek9gui1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.oopweek9gui1 to javafx.fxml;
    exports org.example.oopweek9gui1;
}