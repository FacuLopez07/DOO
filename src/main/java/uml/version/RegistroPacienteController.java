package uml.version;

import DAO.PacienteDao;
import DTO.PacienteDto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javafx.stage.Stage;

public class RegistroPacienteController {

    // Campos del formulario
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
    private DatePicker fechaNacimientoField;
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
    private TextField contactoEmergenciaTelefonoField;
    @FXML
    private TextField contactoEmergenciaRelacionField;
    @FXML
    private TextField historialCirugiasField;
    @FXML
    private TextField historialHospitalizacionesField;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    // DAO para manejar la base de datos
    private PacienteDao pacienteDao = new PacienteDao();

    @FXML
    private void handleSave() {
        // Validar y obtener datos del formulario
        String nro_paciente = nroPacienteField.getText();
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String tipo_dni = tipoDniField.getText();
        String nro_dni = nroDniField.getText();
        String direccion = direccionField.getText();
        String barrio = barrioField.getText();
        LocalDate fecha_nacimiento = fechaNacimientoField.getValue();

        // Validar datos obligatorios
        if (nro_paciente.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || tipo_dni.isEmpty() || nro_dni.isEmpty() || direccion.isEmpty() || barrio.isEmpty() || fecha_nacimiento == null) {
            showAlert(AlertType.ERROR, "Error de Validación", "Por favor, complete todos los campos obligatorios.");
            return;
        }

        // Convertir nroPaciente a entero
        int nroPaciente;
        try {
            nroPaciente = Integer.parseInt(nro_paciente);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Error de Validación", "El número de paciente debe ser un número válido.");
            return;
        }

        // Procesar datos opcionales
        String alergias = alergiasField.getText();
        String medicamentosActuales = medicamentosActualesField.getText();
        String enfermedadesCronicas = enfermedadesCronicasField.getText();
        String contactoEmergenciaNombre = contactoEmergenciaNombreField.getText();
        String contactoEmergenciaTelefono = contactoEmergenciaTelefonoField.getText();
        String contactoEmergenciaRelacion = contactoEmergenciaRelacionField.getText();
        String historialCirugias = historialCirugiasField.getText();
        String historialHospitalizaciones = historialHospitalizacionesField.getText();

        // Crear el objeto PacienteDto usando el Builder
        PacienteDto pacienteDto = new PacienteDto.PacienteBuilder(
            nombre, apellido, tipo_dni, nro_dni, direccion, barrio, fecha_nacimiento.toString(), nroPaciente
        )
            .setJefeFamilia(jefeFamiliaField.getText().equalsIgnoreCase("sí") || jefeFamiliaField.getText().equalsIgnoreCase("jefe"))
            .setObraSocial(obraSocialField.getText())
            .setAlergias(alergias)
            .setMedicamentosActuales(medicamentosActuales)
            .setEnfermedadesCronicas(enfermedadesCronicas)
            .setContactoEmergenciaNombre(contactoEmergenciaNombre)
            .setContactoEmergenciaTelefono(contactoEmergenciaTelefono)
            .setContactoEmergenciaRelacion(contactoEmergenciaRelacion)
            .setHistorialCirugias(historialCirugias)
            .setHistorialHospitalizaciones(historialHospitalizaciones)
            .build();

        // Guardar el paciente en la base de datos
        boolean guardado = pacienteDao.insertar(pacienteDto);

        if (guardado) {
            showAlert(AlertType.INFORMATION, "Registro exitoso", "Se registró al paciente exitosamente.");
            ((Stage) saveButton.getScene().getWindow()).close();
        } else {
            showAlert(AlertType.ERROR, "Error al registrar", "No se pudo registrar al paciente.");
        }
    }

    // Muestra un mensaje de alerta
    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleCancel() {
        showAlert(AlertType.INFORMATION, "Operación Cancelada", "Operación cancelada.");
        ((Stage) saveButton.getScene().getWindow()).close();
    }
}
