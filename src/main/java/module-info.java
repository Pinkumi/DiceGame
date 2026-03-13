module com.remonado.dicegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.remonado.dicegame to javafx.fxml;
    exports com.remonado.dicegame;
}