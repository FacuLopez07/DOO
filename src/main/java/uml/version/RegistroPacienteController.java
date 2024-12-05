package uml.version;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;



public class RegistroPacienteController {
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
    private TextField alergiasField; // Campo adicional para alergias (separadas por comas)
    @FXML
    private TextField medicamentosActualesField; // Campo adicional para medicamentos actuales
    @FXML
    private TextField enfermedadesCronicasField; // Campo adicional para enfermedades crónicas
    @FXML
    private TextField contactoEmergenciaNombreField;
    @FXML
    private TextField contactoEmergenciaTelefonoField;
    @FXML
    private TextField contactoEmergenciaRelacionField;
    @FXML
    private TextField historialCirugiasField; // Campo adicional para historial de cirugías
    @FXML
    private TextField historialHospitalizacionesField; // Campo adicional para historial de hospitalizaciones
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    

    @FXML
    private void handleSave() {
        // Obtener datos de los campos obligatorios
        String nro_paciente = nroPacienteField.getText();
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String tipo_dni = tipoDniField.getText();
        String dni = nroDniField.getText();
        String direccion = direccionField.getText();
        String barrio = barrioField.getText();
        LocalDate fecha_nacimiento = fechaNacimientoField.getValue();
        String jefe_familia = jefeFamiliaField.getText();
        String obra_social = obraSocialField.getText();

        // Validar datos obligatorios
        if (nro_paciente.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || tipo_dni.isEmpty() || dni.isEmpty() || direccion.isEmpty() || barrio.isEmpty() || fecha_nacimiento == null) {
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
        List<String> alergias = processListInput(alergiasField.getText());
        List<String> medicamentosActuales = processListInput(medicamentosActualesField.getText());
        List<String> enfermedadesCronicas = processListInput(enfermedadesCronicasField.getText());
        String contactoEmergenciaNombre = contactoEmergenciaNombreField.getText();
        String contactoEmergenciaTelefono = contactoEmergenciaTelefonoField.getText();
        String contactoEmergenciaRelacion = contactoEmergenciaRelacionField.getText();
        List<String> historialCirugias = processListInput(historialCirugiasField.getText());
        List<String> historialHospitalizaciones = processListInput(historialHospitalizacionesField.getText());

        // Crear el objeto Paciente usando el Builder
        Paciente paciente = new Paciente.PacienteBuilder(nombre, apellido, "DNI", dni, direccion, barrio, fecha_nacimiento.toString(), nroPaciente)
            .setObraSocial(obra_social) // Opcional
            .setJefeFamilia(jefe_familia.equalsIgnoreCase("sí") || jefe_familia.equalsIgnoreCase("jefe")) // Opcional
            .setAlergias(alergias) // Opcional
            .setMedicamentosActuales(medicamentosActuales) // Opcional
            .setEnfermedadesCronicas(enfermedadesCronicas) // Opcional
            .setContactoEmergenciaNombre(contactoEmergenciaNombre) // Opcional
            .setContactoEmergenciaTelefono(contactoEmergenciaTelefono) // Opcional
            .setContactoEmergenciaRelacion(contactoEmergenciaRelacion) // Opcional
            .setHistorialCirugias(historialCirugias) // Opcional
            .setHistorialHospitalizaciones(historialHospitalizaciones) // Opcional
            .build();

        // Lógica adicional: guardar en la base de datos o registrar en logs
        System.out.println("Paciente registrado:");
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Apellido: " + paciente.getApellido());
        System.out.println("DNI: " + paciente.getTipoDni() + " " + paciente.getNroDni());
        System.out.println("Número de paciente: " + paciente.getNroPaciente());
        System.out.println("Obra social: " + paciente.getObraSocial());
        System.out.println("Es jefe de familia: " + paciente.isJefeFamilia());
        System.out.println("Alergias: " + paciente.getAlergias());
        System.out.println("Medicamentos actuales: " + paciente.getMedicamentosActuales());
        System.out.println("Enfermedades crónicas: " + paciente.getEnfermedadesCronicas());
        System.out.println("Historial de cirugías: " + paciente.getHistorialCirugias());
        System.out.println("Historial de hospitalizaciones: " + paciente.getHistorialHospitalizaciones());

        // Mostrar alerta de éxito
        showAlert(AlertType.INFORMATION, "Registro exitoso", "Se registró al paciente exitosamente.");
        ((Stage) saveButton.getScene().getWindow()).close();
    }

    private List<String> processListInput(String input) {
        return input.isEmpty() ? List.of() : Arrays.asList(input.split(","));
    }

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
