package uml.version;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DetalleOrdenController {

    @FXML
    private TextField nroOrdenField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField fechaConsultaField;
    @FXML
    private TextField nroDniField;
    @FXML
    private TextField servicioField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField estadoField;
    @FXML
    private TextField turnoField;
    @FXML
    private TextField diagnosticoField;
    @FXML
    private Button closeButton;

    
    
    /**
     * Método para cargar los datos de una orden-paciente en los campos de la ventana.
     * 
     * @param vistaOrdenPaciente Objeto de tipo VistaOrdenPaciente que contiene los datos a mostrar.
     */
    public void cargarDatosPaciente(VistaOrdenPaciente vistaOrdenPaciente) {
        if (vistaOrdenPaciente != null) {
            nroOrdenField.setText(String.valueOf(vistaOrdenPaciente.getNroOrden()));
            nroDniField.setText(vistaOrdenPaciente.getDniPaciente());
            servicioField.setText(vistaOrdenPaciente.getServicio());
            fechaConsultaField.setText(vistaOrdenPaciente.getFechaConsulta());
            nombreField.setText(vistaOrdenPaciente.getNombre());
            apellidoField.setText(vistaOrdenPaciente.getApellido());
            estadoField.setText(vistaOrdenPaciente.getEstado());
            turnoField.setText(vistaOrdenPaciente.getTurno());
            diagnosticoField.setText(vistaOrdenPaciente.getDiagnostico());
        }
    }

    /**
     * Cierra la ventana actual al hacer clic en el botón cerrar.
     */
    @FXML
    private void handleClose() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
