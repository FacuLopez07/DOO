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

import DTO.PacienteDto;
import DAO.Dao;
import DAO.DaoFactory;

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
    private TableView<Paciente> tableViewPacientes;
    @FXML
    private TableColumn<Paciente, Integer> columnOrden;
    @FXML
    private TableColumn<Paciente, String> columnNombre;
    @FXML
    private TableColumn<Paciente, String> columnApellido;
    @FXML
    private TableColumn<Paciente, String> columnDni;
    @FXML
    private TableColumn<Paciente, String> columnEstado;

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
        Dao<PacienteDto> pacienteDao = DaoFactory.getDao(PacienteDto.class);

        // Llamar al método de listado desde el DAO
        List<PacienteDto> pacientes = pacienteDao.listarTodos();

        // Convertir Dto a modelo (si es necesario) y cargar en la tabla
        tableViewPacientes.getItems().clear();
        for (PacienteDto dto : pacientes) {
            tableViewPacientes.getItems().add(
                new Paciente(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getDni(), "Estado")
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegistroPaciente.fxml"));
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
        Paciente selectedPaciente = tableViewPacientes.getSelectionModel().getSelectedItem();
        if (selectedPaciente != null) {
            try {
                // Usar el Factory para obtener el DAO
                Dao<PacienteDto> pacienteDao = DaoFactory.getDao(PacienteDto.class);

                // Obtener los detalles del paciente desde el DAO
                PacienteDto pacienteDto = pacienteDao.obtenerPorOrden(selectedPaciente.getOrden());

                // Convertir el DTO en un modelo Paciente
                Paciente paciente = new Paciente(
                    pacienteDto.getId(),
                    pacienteDto.getNombre(),
                    pacienteDto.getApellido(),
                    pacienteDto.getDni(),
                    pacienteDto.getEstado() 
                );

                // Cargar la vista de DetallePaciente
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DetallePaciente.fxml"));
                Parent root = loader.load();

                // Obtener el controlador de la vista de detalle
                DetallePacienteController detalleController = loader.getController();
                detalleController.cargarDatosPaciente(paciente); // Pasar el modelo al controlador

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
