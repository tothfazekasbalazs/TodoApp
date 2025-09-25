module edu.banki.totapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.banki.totapp to javafx.fxml;
    exports edu.banki.totapp;
}