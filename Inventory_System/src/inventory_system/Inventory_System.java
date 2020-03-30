package inventory_system;
import inventory_system.controllers.FXMLWelcomePageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Ricky Mungcal
 * @version 1.0
 * @since 20/02/2020
 */
public class Inventory_System extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/FXMLWelcomePage.fxml"));
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add("/CSS/dark-theme.css");
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory Manager");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}