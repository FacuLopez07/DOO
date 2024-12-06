/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml.version;

import DAO.Dao;
import DAO.DaoFactory;
import DTO.PacienteDto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author facundito
 */
public class ConsultaPacientesController implements Initializable {
    
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Button detailsButton;
    @FXML
    private Button generarButton;
    @FXML
    private Button registerButton;
    @FXML
    private TableView<Object> tableViewPacientes;
    @FXML
    private TableColumn<Object, Integer> nroPaciente;
    @FXML
    private TableColumn<Object, String> columnDni;
    @FXML
    private TableColumn<Object, String> columnApellido;
    @FXML
    private TableColumn<Object, String> columnNombre;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializa las columnas de la tabla
        nroPaciente.setCellValueFactory(new PropertyValueFactory<>("NroPaciente"));
        columnDni.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        columnApellido.setCellValueFactory(new PropertyValueFactory<>("NroDni"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));

        // Cargar los datos de pacientes
        cargarPaciente();
    }
    
    private void cargarPaciente() {
        
        Dao<PacienteDto> pacienteDao = DaoFactory.getPacienteDao(PacienteDto.class);
        List<PacienteDto> pacientes = pacienteDao.listarTodos();
        
        for (PacienteDto dto : pacientes) {
            // Usar el PacienteBuilder para construir el objeto Paciente
            Paciente.PacienteBuilder builder = new Paciente.PacienteBuilder(
                dto.getNombre(),
                dto.getApellido(),
                dto.getTipoDni(),
                dto.getNroDni(),
                dto.getDireccion(),
                dto.getBarrio(),
                dto.getFechaNacimiento(),
                dto.getNroPaciente()
            );

            // Construir el objeto Paciente
            Paciente paciente = builder.build();

            // Agregar el paciente a la tabla
            tableViewPacientes.getItems().add(paciente);
        }
    }
    
    
    @FXML
    private void handleSearch() {
        
    }
    
    @FXML
    private void handleViewDetails() {
        // Obtener el paciente seleccionado en la tabla
        Paciente selectedPaciente = tableViewPacientes.getSelectionModel().getSelectedItem();
        
        if (selectedPaciente != null) {
            try {
                // Usar el Factory para obtener el DAO
                Dao<PacienteDto> pacienteDao = DaoFactory.getDao(PacienteDto.class);

                // Obtener los detalles del paciente desde el DAO
                PacienteDto pacienteDto = pacienteDao.obtenerPorOrden(selectedPaciente.getNroOrden());

                // Convertir el DTO en un modelo Paciente
                Orden orden = new Orden(
                    pacienteDto.getNroOrden(),
                    pacienteDto.getServicio(),
                    pacienteDto.getTurno(),
                    pacienteDto.getDiagnostico(),
                    pacienteDto.getFechaConsulta(),
                    pacienteDto.getEstado(),
                    pacienteDto.getPaciente()
                );

                // Cargar la vista de DetallePaciente
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DetallePaciente.fxml"));
                Parent root = loader.load();

                // Obtener el controlador de la vista de detalle
                DetallePacienteController detalleController = loader.getController();
                detalleController.cargarDatosPaciente(orden); // Pasar el modelo al controlador

                // Crear y mostrar la nueva ventana
                Stage stage = new Stage();
                stage.setTitle("Detalles del Paciente");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                // Manejo de errores si no se puede obtener el paciente
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al cargar los detalles");
                alert.setContentText("Ocurrió un error al intentar cargar los detalles del paciente: " + e.getMessage());
                alert.showAndWait();
            }
        } else {
            // Mostrar alerta si no se ha seleccionado un paciente
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione un paciente para ver los detalles.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleOrderGeneration() {
        try {
            // Cargar el archivo FXML de ConsultaPrincipal
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GenerarOrden.fxml"));

            // Crear una nueva escena con el contenido cargado
            Scene scene = new Scene(root);

            // Crear una nueva ventana
            Stage newStage = new Stage();
            newStage.setTitle("Nueva Orden");
            newStage.setScene(scene);

            // Mostrar la nueva ventana
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores si no se puede cargar la vista
        }
    }
    
    @FXML
    private void handleRegister() {
        try {
            // Cargar el archivo FXML de RegistroPaciente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegistroNuevoPaciente.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el contenido cargado
            Scene scene = new Scene(root);

            // Crear una nueva ventana
            Stage newStage = new Stage();
            newStage.setTitle("Registro de Paciente");
            newStage.setScene(scene);

            // Establecer la ventana como modal si es necesario
            // newStage.initModality(Modality.APPLICATION_MODAL); // Descomentar si deseas que sea modal

            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores si no se puede cargar la vista
        }
    }
}
