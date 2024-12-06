package uml.version;

import DTO.PacienteDto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador para la vista de Detalles del Paciente
 */
public class DetallePacienteController {

    @FXML
    private TextField nroPacienteField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField tipoDniField;
    @FXML
    private TextField nroDniField;
    @FXML
    private TextField direccionField;
    @FXML
    private TextField barrioField;
    @FXML
    private TextField fechaNacimientoField;
    @FXML
    private TextField jefeFamiliaField;
    @FXML
    private TextField obraSocialField;
    @FXML
    private TextField alergiasField;
    @FXML
    private TextField medicamentosActualesField;
    @FXML
    private TextField enfermedadesCronicasField;
    @FXML
    private TextField contactoEmergenciaNombreField;
    @FXML
    private TextField contactoEmergenciaRelacionField;
    @FXML
    private TextField contactoEmergenciaTelefonoField;
    @FXML
    private TextField historialCirugiasField;
    @FXML
    private TextField historialHospitalizacionesField;
    @FXML
    private Button closeButton; 
    
    
    public void cargarPaciente(VistaPaciente vistaPaciente) {
      // Asignar los valores a los TextField correspondientes
      nroPacienteField.setText(String.valueOf(vistaPaciente.getNroPaciente())); // Conversión de int a String
      nombreField.setText(vistaPaciente.getNombre());
      apellidoField.setText(vistaPaciente.getApellido());
      tipoDniField.setText(vistaPaciente.getTipoDni());
      nroDniField.setText(vistaPaciente.getNroDni());
      direccionField.setText(vistaPaciente.getDireccion());
      barrioField.setText(vistaPaciente.getBarrio());
      fechaNacimientoField.setText(vistaPaciente.getFechaNacimiento());
      jefeFamiliaField.setText(vistaPaciente.getJefeFamilia() ? "Sí" : "No");
      obraSocialField.setText(vistaPaciente.getObraSocial() != null ? vistaPaciente.getObraSocial() : "");
      alergiasField.setText(vistaPaciente.getAlergias() != null ? vistaPaciente.getAlergias() : "");
      medicamentosActualesField.setText(vistaPaciente.getMedicamentosActuales() != null ? vistaPaciente.getMedicamentosActuales() : "");
      enfermedadesCronicasField.setText(vistaPaciente.getEnfermedadesCronicas() != null ? vistaPaciente.getEnfermedadesCronicas() : "");
      contactoEmergenciaNombreField.setText(vistaPaciente.getContactoEmergenciaNombre() != null ? vistaPaciente.getContactoEmergenciaNombre() : "");
      contactoEmergenciaRelacionField.setText(vistaPaciente.getContactoEmergenciaRelacion() != null ? vistaPaciente.getContactoEmergenciaRelacion() : "");
      contactoEmergenciaTelefonoField.setText(vistaPaciente.getContactoEmergenciaTelefono() != null ? vistaPaciente.getContactoEmergenciaTelefono() : "");
      historialCirugiasField.setText(vistaPaciente.getHistorialCirugias() != null ? vistaPaciente.getHistorialCirugias() : "");
      historialHospitalizacionesField.setText(vistaPaciente.getHistorialHospitalizaciones() != null ? vistaPaciente.getHistorialHospitalizaciones() : "");
    }
    
    @FXML
    private void handleCancel() {
        // Cierra la ventana actual
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
