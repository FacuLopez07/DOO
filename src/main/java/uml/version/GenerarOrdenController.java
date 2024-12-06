package uml.version;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GenerarOrdenController {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField nroDniField;
    @FXML
    private TextField nroOrdenField;

    private VistaPaciente pacienteSeleccionado;
    
    @FXML
    private Button closeButton;
    

    public void cargarDatosPaciente(VistaPaciente paciente) {
        this.pacienteSeleccionado = paciente;

        // Prellenar los campos del formulario con los datos del paciente
        nroOrdenField.setText(String.valueOf(paciente.getNroPaciente()));
        nroDniField.setText(paciente.getNroDni());
        nombreField.setText(paciente.getNombre());
        apellidoField.setText(paciente.getApellido());
    }
    


    @FXML
    private void handleSave() {
        try {
            
            // Mostrar mensaje de éxito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Orden generada");
            alert.setContentText("La orden ha sido guardada correctamente.");
            alert.showAndWait();

            // Cierra la ventana actual
            Stage stage = (Stage) nombreField.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al guardar la orden");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }



     @FXML
    private void handleCancel() {
        // Cierra la ventana actual
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
