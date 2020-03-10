package inventory_system.controllers;
import inventory_system.readers.CSV_Reader;
import java.io.File;
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
    @FXML
    Label fileNameLabel;
    @FXML
    Label lblFileNameTwo;
    
    private String csvFile1;
    private String csvFile2;
    private CSV_Reader reader;

    public String getCsvFile1() {
        return csvFile1;
    }

    public void setCsvFile1(String csvFile1) {
        this.csvFile1 = csvFile1;
    }

    public String getCsvFile2() {
        return csvFile2;
    }

    public void setCsvFile2(String csvFile2) {
        this.csvFile2 = csvFile2;
    }

    public CSV_Reader getReader() {
        return reader;
    }

    public void setReader(CSV_Reader reader) {
        this.reader = reader;
    }
    
    
    /**
     * 
     * @param event
     * @return 
     */
    @FXML
    private void fileSelect(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Inventory Sheet");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV File", "*.csv")
        );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        File f = fc.showOpenDialog(window);
        if (f != null){
            String fileTitle = f.getName();
            csvFile1 = f.getAbsolutePath();
            fileNameLabel.setText(fileTitle);
        }    
    }
    
    /**
     * 
     * @param event
     * @return 
     */
    @FXML
    private void fileSelectTwo(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Inventory Sheet");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV File", "*.csv")
        );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        File f = fc.showOpenDialog(window);
        if (f != null){
            String fileTitle = f.getName();
            csvFile2 = f.getAbsolutePath();
            lblFileNameTwo.setText(fileTitle);
        }    
    }
    
    /**
     * 
     * @param event
     * @return 
     */
    @FXML
    private void compare(ActionEvent event) throws IOException{
        if(csvFile1 == null){
            System.err.println("\nError: First file is missing. Please select a file.");
        }
        if(csvFile2 == null)
            System.err.println("\nError: Second file is missing. Please select a file.");
        else{
//        String firstFile = csvFile1;
//        String secondFile = csvFile2;
        this.reader = new CSV_Reader(csvFile1, csvFile2);
        if(reader.equivalency(reader))
                System.err.println("The files contain the same EPC Codes.");
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/FXMLOfflineResultsScene.fxml"));
            Parent root = loader.load();
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLOfflineResultsSceneController controller = loader.getController();
            controller.UniqueACodes(reader);
            controller.UniqueBCodes(reader);
            controller.setReader(reader);
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
            }
        }
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
