package inventory_system.drivers;

import inventory_system.readers.CSV_Reader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 18/02/2020
 */
public class Driver extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Inventory Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        CSV_Reader c1 = new CSV_Reader("data/Inventory_A.csv");
        c1.parse();
        launch(args);
    }
}