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
    private TableView<Orden> tableViewPacientes;
    @FXML
    private TableColumn<Orden, Integer> columnOrden;
    @FXML
    private TableColumn<Orden, String> columnNombre;
    @FXML
    private TableColumn<Orden, String> columnApellido;
    @FXML
    private TableColumn<Orden, String> columnDni;
    @FXML
    private TableColumn<Orden, String> columnEstado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializa las columnas de la tabla
        columnOrden.setCellValueFactory(new PropertyValueFactory<>("orden"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Cargar los datos de pacientes
        cargarPacientes();
    }

    private void cargarPacientes() {
        // Usar el Factory para obtener el DAO
        Dao<OrdenDto> ordenDao = DaoFactory.getDao(OrdenDto.class);

        // Llamar al método de listado desde el DAO
        List<OrdenDto> ordenes = ordenDao.listarTodos();

        // Convertir Dto a modelo (si es necesario) y cargar en la tabla
        tableViewPacientes.getItems().clear();
        for (OrdenDto dto : ordenes) {
            tableViewPacientes.getItems().add(
                new Orden(
                            dto.getNroOrden(),          // nro_orden
                            dto.getServicio(),          // servicio
                            dto.getTurno(),             // turno
                            dto.getDiagnostico(),       // diagnostico
                            dto.getFechaConsulta(),     // fecha_consulta
                            dto.getEstado(),            // estado
                            dto.getPaciente()           // paciente
                        )
            );
        }
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
        // Obtener el paciente seleccionado en la tabla
        Orden selectedPaciente = tableViewPacientes.getSelectionModel().getSelectedItem();
        if (selectedPaciente != null) {
            try {
                // Usar el Factory para obtener el DAO
                Dao<OrdenDto> ordenDao = DaoFactory.getDao(OrdenDto.class);

                // Obtener los detalles del paciente desde el DAO
                OrdenDto ordenDto = ordenDao.obtenerPorOrden(selectedPaciente.getNroOrden());

                // Convertir el DTO en un modelo Paciente
                Orden orden = new Orden(
                    ordenDto.getNroOrden(),
                    ordenDto.getServicio(),
                    ordenDto.getTurno(),
                    ordenDto.getDiagnostico(),
                    ordenDto.getFechaConsulta(),
                    ordenDto.getEstado(),
                    ordenDto.getPaciente()
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

}
