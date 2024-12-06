/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uml.version;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author facundito
 */
public class ConsultaPacientesController {
    private TableView<Object> tableViewPacientes;
    
    @FXML
    private void handleSearch() {
        
    }
    
    @FXML
    private void handleViewDetails() {
        // Obtener el elemento seleccionado en la tabla
        Object selectedItem = tableViewPacientes.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // Mostrar un mensaje básico indicando que se seleccionó un elemento
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Elemento seleccionado");
            alert.setHeaderText("Detalles del elemento");
            alert.setContentText("Se seleccionó un elemento en la tabla.");
            alert.showAndWait();
        } else {
            // Mostrar una advertencia si no se selecciona nada
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione un elemento para ver los detalles.");
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
