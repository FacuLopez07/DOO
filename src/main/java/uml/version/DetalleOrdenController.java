/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml.version;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author facundito
 */
public class DetalleOrdenController {
    @FXML
    private TextField nroOrdenField;
    @FXML
    private DatePicker fechaTurnoField;
    @FXML
    private TextField turnoField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField servicioField;
    @FXML
    private TextField estadoField;
    @FXML
    private TextField diagnosticoField;
    @FXML
    private Button closeButton;

    // Método para cargar los datos del paciente en los campos de texto
    public void cargarDatosPaciente(Orden orden) {
        nroOrdenField.setText(String.valueOf(orden.getNroOrden()));
        turnoField.setText(orden.getTurno());
        
        // Procesamiento de la fecha
        if (orden.getFechaConsulta() != null) {
        LocalDate localDate = orden.getFechaConsulta()
                                   .toInstant()
                                   .atZone(ZoneId.systemDefault())
                                   .toLocalDate();
        fechaTurnoField.setValue(localDate); // Asignar al DatePicker
        }
        
        nombreField.setText(orden.getNombre());
        apellidoField.setText(orden.getApellido());
        dniField.setText(orden.getDni());
        servicioField.setText(orden.getServicio());
        estadoField.setText(orden.getEstado());
        diagnosticoField.setText(orden.getDiagnostico());
    }
    
    @FXML
    private void handleClose() {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }
}
