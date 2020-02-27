package inventory_system.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gianni Coladonato
 * @version 1.0
 * @since 25/02/2020
 * //http://tutorials.jenkov.com/javafx/directorychooser.html
 * //https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
 */
public class FXMLOfflineInventoryController implements Initializable {
    
    @FXML
    private void fileSelect(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Inventory Sheet");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV File", "*.csv")
        );
        String fileTitle = fc.getTitle();
        System.out.println(fileTitle);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        fc.showOpenDialog(window);
    }
    
    @FXML
    private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLSelectionPage.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}