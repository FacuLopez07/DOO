module uml.version {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens uml.version to javafx.fxml;
    exports uml.version;
}
