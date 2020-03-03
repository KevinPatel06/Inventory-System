package inventory_system.controllers;
import inventory_system.models.Item;
import inventory_system.readers.CSV_Reader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    CSV_Reader instance;
    @FXML
    Label fileNameLabel;
    @FXML
    Label lblFileNameTwo;
    
    /**
     * 
     * @param event
     * @return 
     */
    @FXML
    private String fileSelect(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Inventory Sheet");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV File", "*.csv")
        );
        //String fileTitle = fc.getTitle();
        File f = fc.showOpenDialog(null);
        String fileTitle = f.getName();
        
        String filePath = f.getAbsolutePath();
        System.out.println(fileTitle);
        fileNameLabel.setText(fileTitle);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        fc.showOpenDialog(window);
        
        return filePath;
    }
    /**
     * 
     * @param event
     * @return 
     */
    @FXML
    private String fileSelectTwo(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Inventory Sheet");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV File", "*.csv")
        );
        //String fileTitle = fc.getTitle();
        File f = fc.showOpenDialog(null);
        String fileTitle = f.getName();
        
        String filePath2 = f.getAbsolutePath();
        System.out.println(fileTitle);
        lblFileNameTwo.setText(fileTitle);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        fc.showOpenDialog(window);
        
        return filePath2;
    }
    
    /**
     * 
     * @param event
     * @return 
     */
    @FXML
    private void compare(ActionEvent event){
        CSV_Reader reader = null;
        String firstFile = fileSelect(event);
        String secondFile = fileSelectTwo(event);
        
        List<Item> newList;
        newList = instance.parse(firstFile, secondFile);
        
        List<Item> addedList = instance.addedCodes(reader, firstFile, secondFile);
        List<Item> removedList = instance.removedCodes(reader, firstFile, secondFile);

    }
    
    /**
     * 
     * @param event
     * @throws IOException 
     */
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