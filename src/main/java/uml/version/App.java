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
import DTO.OrdenDto;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Dao<OrdenDto> ordenDao;

    @Override
    public void start(Stage stage) throws IOException {
        
        // Inicializa la fábrica de Daos
        DaoFactory factory = new OrdenDaoFactory();
        ordenDao = factory.createDao(); // Creamos el Dao usando el patrón Factory
        
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