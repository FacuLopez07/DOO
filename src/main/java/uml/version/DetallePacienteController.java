package uml.version;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DetallePacienteController {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField estadoField;

    // Método para cargar los datos del paciente en los campos de texto
    public void cargarDatosPaciente(Paciente paciente) {
        nombreField.setText(paciente.getNombre());
        apellidoField.setText(paciente.getApellido());
        dniField.setText(paciente.getDni());
        estadoField.setText(paciente.getEstado());
    }
    
    @FXML
    private void handleClose() {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }
}
