package uml.version;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.List;

import DTO.OrdenDto;
import DAO.Dao;
import DAO.DaoFactory;
import DTO.PacienteDto;
import java.util.ArrayList;
import uml.version.Paciente;

public class ConsultaPrincipalController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Button detailsButton;
    @FXML
    private Button registerButton;
    @FXML
    private TableView<Object> tableViewPacientes;
    @FXML
    private TableColumn<Object, Integer> columnOrden;
    @FXML
    private TableColumn<Object, String> columnServicio;
    @FXML
    private TableColumn<Object, String> columnFechaConsulta;
    @FXML
    private TableColumn<Object, String> columnDni;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializa las columnas de la tabla
        columnOrden.setCellValueFactory(new PropertyValueFactory<>("NroOrden"));
        columnServicio.setCellValueFactory(new PropertyValueFactory<>("Servicio"));
        columnFechaConsulta.setCellValueFactory(new PropertyValueFactory<>("FechaConsulta"));
        columnDni.setCellValueFactory(new PropertyValueFactory<>("DniPaciente"));

        // Cargar los datos de pacientes
        cargarOrdenes();
    }

    private void cargarOrdenes() {
        Dao<OrdenDto> ordenDao = DaoFactory.getDao(OrdenDto.class);
        Dao<PacienteDto> pacienteDao = DaoFactory.getPacienteDao(PacienteDto.class);

        List<OrdenDto> ordenes = ordenDao.listarTodos();
        List<PacienteDto> pacientes = pacienteDao.listarTodos();

        List<VistaOrdenPaciente> vistaDatos = new ArrayList<>();

        for (OrdenDto orden : ordenes) {
            if (orden.getPaciente() != null) {
                // Imprimir información de depuración
                System.out.println("Orden: " + orden.getNroOrden() + 
                    ", Paciente asociado: " + orden.getPaciente());

                PacienteDto paciente = null;
                for (PacienteDto p : pacientes) {
                    if (p.getNroPaciente() == orden.getPaciente()) { // Ajustar según los tipos de datos
                        paciente = p;
                        break; // Terminar el bucle una vez encontrado
                    }
                }

                if (paciente != null) {
                    vistaDatos.add(new VistaOrdenPaciente(
                        orden.getNroOrden(),
                        paciente.getNroDni(),
                        orden.getServicio(),
                        orden.getFechaConsulta(),
                        paciente.getNombre(),
                        orden.getTurno(),
                        paciente.getApellido(),
                        orden.getEstado(),
                        orden.getDiagnostico()                        
                    ));
                } else {
                    System.out.println("Paciente no encontrado para la orden: " + orden.getNroOrden());
                }
            } else {
                System.out.println("Orden sin paciente: " + orden.getNroOrden());
                vistaDatos.add(new VistaOrdenPaciente(
                    orden.getNroOrden(),
                    "Sin DNI", // Valor predeterminado
                    orden.getServicio(),
                    orden.getFechaConsulta(),
                    "Sin Nombre",
                    "Sin Apellido",
                    orden.getTurno(),
                    orden.getEstado(),
                    orden.getDiagnostico()
                ));
            }
        }

        tableViewPacientes.getItems().clear();
        tableViewPacientes.getItems().addAll(vistaDatos);
    }



    
    @FXML
    private void handleSearch() {
        String searchTerm = searchField.getText();
        // Aquí implementa la lógica para filtrar los datos en tableViewPacientes
        System.out.println("Buscando: " + searchTerm);
        // Puedes aplicar un filtro a tu ObservableList que respete el término de búsqueda
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
    
   
    @FXML
    private void handleViewDetails() {
        VistaOrdenPaciente selectedOrder = (VistaOrdenPaciente) tableViewPacientes.getSelectionModel().getSelectedItem();

        if (selectedOrder != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DetalleOrden.fxml"));
                Parent root = loader.load();

                DetalleOrdenController detalleController = loader.getController();

                // Cargar los detalles directamente desde VistaOrdenPaciente
                detalleController.cargarDatosPaciente(selectedOrder);

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


}