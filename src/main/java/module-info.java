module uml.version {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;  // Agrega esta línea para acceder a java.sql

    opens uml.version to javafx.fxml;
    exports uml.version;
}
