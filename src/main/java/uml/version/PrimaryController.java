package uml.version;

import DAO.ConexionSql;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import javafx.scene.control.Label;

public class PrimaryController {
    
    @FXML
    private Label connectionStatusLabel;
    @FXML
    private Button primaryButton;
    @FXML
    private Button consultaButton;
    
    @FXML
    public void initialize() {
        verificarConexion();
    }

    private void verificarConexion() {
        ConexionSql conexionSql = new ConexionSql();
        if (conexionSql.getConnection() != null) {
            connectionStatusLabel.setText("Conexión exitosa a la base de datos");
        } else {
            connectionStatusLabel.setText("Error al conectar con la base de datos");
        }
        conexionSql.cerrar(); // Asegúrate de cerrar la conexión después de verificar
    }

    @FXML
    private void openConsultaPrincipal() {
        try {
            // Cargar el archivo FXML de ConsultaPrincipal
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ConsultaPrincipal.fxml"));

            // Crear una nueva escena con el contenido cargado
            Scene scene = new Scene(root);

            // Crear una nueva ventana
            Stage newStage = new Stage();
            newStage.setTitle("Consulta Principal");
            newStage.setScene(scene);

            // Mostrar la nueva ventana
            newStage.show();

            // Cerrar la ventana actual
            Stage currentStage = (Stage) consultaButton.getScene().getWindow();
            currentStage.close(); // Cierra la ventana primaria
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores si no se puede cargar la vista
        }
    }
}
