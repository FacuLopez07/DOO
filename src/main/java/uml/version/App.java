package uml.version;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import DAO.Dao;
import DAO.DaoFactory; 
import DAO.OrdenDaoFactory;
import DAO.PacienteDaoFactory;
import DTO.OrdenDto;
import DTO.PacienteDto;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Dao<OrdenDto> ordenDao;
    private static Dao<PacienteDto> pacienteDao;

    @Override
    public void start(Stage stage) throws IOException {
        
        DaoFactory factoryOrden = new OrdenDaoFactory();
        ordenDao = factoryOrden.createDao();
        
        DaoFactory factoryPaciente = new PacienteDaoFactory();
        pacienteDao = factoryPaciente.createPacienteDao();
        
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}