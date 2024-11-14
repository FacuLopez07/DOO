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
        // Aquí deberías agregar lógica para cargar la lista de pacientes.
        tableViewPacientes.getItems().addAll(
            new Paciente(1,"Juan", "Pérez", "1111111", "Pendiente"),
            new Paciente(2,"Maria", "Gonzalez", "2222222", "Finalizado")
            // Agrega más pacientes según sea necesario
        );
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
        Paciente selectedPaciente = tableViewPacientes.getSelectionModel().getSelectedItem();
        if (selectedPaciente != null) {
            try {
                // Cargar la vista de DetallePaciente
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DetallePaciente.fxml"));
                Parent root = loader.load();

                // Obtener el controlador y cargar los datos del paciente
                DetallePacienteController detalleController = loader.getController();
                detalleController.cargarDatosPaciente(selectedPaciente);

                // Crear y mostrar la nueva ventana
                Stage stage = new Stage();
                stage.setTitle("Detalles del Paciente");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Mostrar alerta si no se ha seleccionado un paciente
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione un paciente para ver los detalles.");
            alert.showAndWait();
        }
    }

}
