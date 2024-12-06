/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml.version;

import DAO.Dao;
import DAO.DaoFactory;
import DAO.PacienteDao;
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
        columnDni.setCellValueFactory(new PropertyValueFactory<>("NroDni"));
        columnApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));

        // Cargar los datos de pacientes
        cargarPaciente();
    }
    
    private void cargarPaciente() {
    // Obtener el DAO para pacientes
    Dao<PacienteDto> pacienteDao = DaoFactory.getPacienteDao(PacienteDto.class);

    // Obtener la lista de pacientes
    List<PacienteDto> pacientes = pacienteDao.listarTodos();

    // Crear una lista para almacenar los datos procesados
    List<VistaPaciente> vistaPacientes = new ArrayList<>();

    for (PacienteDto paciente : pacientes) {
        if (paciente != null) {
            // Imprimir información de depuración
            System.out.println("Paciente encontrado: " + paciente.getNroPaciente() + 
                ", Nombre: " + paciente.getNombre() + ", Apellido: " + paciente.getApellido());

            // Agregar los datos del paciente a la lista de vista
            vistaPacientes.add(new VistaPaciente(
                paciente.getNroPaciente(),
                paciente.getTipoDni(),
                paciente.getNroDni(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getDireccion(),
                paciente.getBarrio(),
                paciente.isJefeFamilia(),
                paciente.getFechaNacimiento(),
                paciente.getObraSocial(),
                paciente.getAlergias() != null ? paciente.getAlergias() : "Sin información",
                paciente.getMedicamentosActuales() != null ? paciente.getMedicamentosActuales() : "Sin información",
                paciente.getEnfermedadesCronicas() != null ? paciente.getEnfermedadesCronicas() : "Sin información",
                paciente.getContactoEmergenciaNombre() != null ? paciente.getContactoEmergenciaNombre() : "Sin información",
                paciente.getContactoEmergenciaTelefono() != null ? paciente.getContactoEmergenciaTelefono() : "Sin información",
                paciente.getContactoEmergenciaRelacion() != null ? paciente.getContactoEmergenciaRelacion() : "Sin información",
                paciente.getHistorialCirugias() != null ? paciente.getHistorialCirugias() : "Sin información",
                paciente.getHistorialHospitalizaciones() != null ? paciente.getHistorialHospitalizaciones() : "Sin información"
            ));
        } else {
            System.out.println("Paciente nulo encontrado en la lista.");
        }
    }

    // Limpiar y actualizar el TableView con los datos procesados
    tableViewPacientes.getItems().clear();
    tableViewPacientes.getItems().addAll(vistaPacientes);
}

    
    
    @FXML
    private void handleSearch() {
        // Obtener el valor del campo de búsqueda
        String dniBusqueda = searchField.getText().trim();

        try {
            if (dniBusqueda.isEmpty()) {
                // Si el campo está vacío, cargar todos los pacientes
                cargarPaciente();
            } else {
                // Obtener el DAO para pacientes
                PacienteDao pacienteDao = new PacienteDao();

                // Buscar el paciente por DNI
                List<PacienteDto> resultados = pacienteDao.buscarPorDni(dniBusqueda);

                // Verificar si se encontraron resultados
                if (resultados.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sin resultados");
                    alert.setHeaderText(null);
                    alert.setContentText("No se encontraron pacientes con el DNI ingresado.");
                    alert.showAndWait();
                } else {
                    // Convertir los resultados a objetos VistaPaciente
                    List<VistaPaciente> vistaPacientes = new ArrayList<>();
                    for (PacienteDto paciente : resultados) {
                        vistaPacientes.add(new VistaPaciente(
                            paciente.getNroPaciente(),
                            paciente.getTipoDni(),
                            paciente.getNroDni(),
                            paciente.getNombre(),
                            paciente.getApellido(),
                            paciente.getDireccion(),
                            paciente.getBarrio(),
                            paciente.isJefeFamilia(),
                            paciente.getFechaNacimiento(),
                            paciente.getObraSocial(),
                            paciente.getAlergias() != null ? paciente.getAlergias() : "Sin información",
                            paciente.getMedicamentosActuales() != null ? paciente.getMedicamentosActuales() : "Sin información",
                            paciente.getEnfermedadesCronicas() != null ? paciente.getEnfermedadesCronicas() : "Sin información",
                            paciente.getContactoEmergenciaNombre() != null ? paciente.getContactoEmergenciaNombre() : "Sin información",
                            paciente.getContactoEmergenciaTelefono() != null ? paciente.getContactoEmergenciaTelefono() : "Sin información",
                            paciente.getContactoEmergenciaRelacion() != null ? paciente.getContactoEmergenciaRelacion() : "Sin información",
                            paciente.getHistorialCirugias() != null ? paciente.getHistorialCirugias() : "Sin información",
                            paciente.getHistorialHospitalizaciones() != null ? paciente.getHistorialHospitalizaciones() : "Sin información"
                        ));
                    }

                    // Actualizar el TableView con los resultados de la búsqueda
                    tableViewPacientes.getItems().clear();
                    tableViewPacientes.getItems().addAll(vistaPacientes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en la búsqueda");
            alert.setHeaderText("Ocurrió un error al buscar los datos.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    
    @FXML
    private void handleViewDetails() {
       VistaPaciente selectedPaciente = (VistaPaciente) tableViewPacientes.getSelectionModel().getSelectedItem();

        if (selectedPaciente != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DetallePaciente.fxml"));
                Parent root = loader.load();

                DetallePacienteController pacienteController = loader.getController();

                // Cargar los detalles directamente desde VistaOrdenPaciente
                pacienteController.cargarPaciente(selectedPaciente);

                Stage stage = new Stage();
                stage.setTitle("Detalles de la Orden");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al cargar la vista de detalle");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona una orden para ver los detalles.");
            alert.showAndWait();
        }
    }

    
    @FXML
    private void handleOrderGeneration() {
        VistaPaciente selectedPaciente = (VistaPaciente) tableViewPacientes.getSelectionModel().getSelectedItem();

        if (selectedPaciente != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GenerarOrden.fxml"));
                Parent root = loader.load();

                GenerarOrdenController ordenController = loader.getController();

                // Pasa la información del paciente seleccionado al controlador de la vista de generación de órdenes
                ordenController.cargarDatosPaciente(selectedPaciente);

                Stage stage = new Stage();
                stage.setTitle("Generar Orden");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al cargar la vista de generación de órdenes");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un paciente para generar una orden.");
            alert.showAndWait();
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
