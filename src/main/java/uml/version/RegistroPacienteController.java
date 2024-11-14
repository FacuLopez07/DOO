package uml.version;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class RegistroPacienteController {
    
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField estadoField;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    @FXML
    private void handleSave() {
        // Lógica para guardar el paciente
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String dni = dniField.getText();
        String estado = estadoField.getText();
        
        // Aquí podrías guardar los datos en la tabla de pacientes o en una base de datos
        System.out.println("Paciente registrado: " + nombre + " " + apellido + ", DNI: " + dni + ", Estado: " + estado);
        
        // Crear un diálogo de alerta
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registro exitoso");
        alert.setHeaderText(null);
        alert.setContentText("Se registro paciente");

        // Mostrar el diálogo y esperar a que el usuario lo cierre
        alert.showAndWait().ifPresent(response -> {
            // Aquí puedes cerrar la ventana o limpiar los campos
            // Asumiendo que quieres cerrar la ventana
            // (debes tener acceso al Stage)
            ((Stage) saveButton.getScene().getWindow()).close();
        });
    }
    
    @FXML
    private void handleCancel() {
        // Crear un diálogo de alerta
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Operación Cancelada");
        alert.setHeaderText(null);
        alert.setContentText("Operación cancelada");

        // Mostrar el diálogo y esperar a que el usuario lo cierre
        alert.showAndWait().ifPresent(response -> {
            // Aquí puedes cerrar la ventana o limpiar los campos
            // Asumiendo que quieres cerrar la ventana
            // (debes tener acceso al Stage)
            ((Stage) saveButton.getScene().getWindow()).close();
        });
    }
}
