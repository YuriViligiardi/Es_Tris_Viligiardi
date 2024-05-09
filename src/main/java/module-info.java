module it.viligiardi {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.viligiardi.controller to javafx.fxml;

    exports it.viligiardi.controller;
}
