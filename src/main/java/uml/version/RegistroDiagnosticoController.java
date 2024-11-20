package uml.version;

import DTO.DiagnosticoDto;
import DTO.PacienteDto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.util.Date;

public class RegistroDiagnosticoController {

    @FXML
    private TextField nombrePacienteField;
    @FXML
    private TextField diagnosticoField;
    @FXML
    private TextField observacionesField;

    @FXML
    private void handleSave() {
        // Obtener el paciente desde un método de búsqueda, por ejemplo, por ID
        PacienteDto paciente = buscarPaciente(); // Suponemos que tienes un método para obtener al paciente

        // Verificar que el paciente sea válido
        if (paciente == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Paciente no encontrado.");
            alert.showAndWait();
            return;
        }

        // Crear el objeto Diagnóstico usando el Builder
        DiagnosticoDto diagnostico = new DiagnosticoDto.Builder()
                .setPaciente(paciente)
                .setDiagnostico(diagnosticoField.getText())
                .setObservaciones(observacionesField.getText())
                .setFechaDiagnostico(new Date()) // La fecha actual
                .build();

        // Lógica para guardar el diagnóstico en la base de datos o lista
        guardarDiagnostico(diagnostico);

        // Crear un diálogo de alerta
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registro exitoso");
        alert.setHeaderText(null);
        alert.setContentText("Diagnóstico registrado correctamente.");
        alert.showAndWait();

        // Cerrar la ventana
        ((Stage) nombrePacienteField.getScene().getWindow()).close();
    }

    private PacienteDto buscarPaciente() {
        // Lógica para buscar al paciente, puede ser por ID u otro criterio
        // Por ejemplo, puedes buscar por nombre o DNI si tienes esa información
        return new PacienteDto(1, "Juan", "Pérez", "1111111"); // Simulación
    }

    private void guardarDiagnostico(DiagnosticoDto diagnostico) {
        // Aquí iría la lógica para guardar el diagnóstico, por ejemplo, en una base de datos
        System.out.println("Diagnóstico registrado para " + diagnostico.getPaciente().getNombre());
    }
}
