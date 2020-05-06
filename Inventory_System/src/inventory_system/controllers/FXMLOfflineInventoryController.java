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
import javafx.scene.image.ImageView;
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
    @FXML
    ImageView ivCross;
    
    private String csvFile1;
    private File file1;
    private File file2;
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
        file1 = fc.showOpenDialog(window);
        if (file1 != null){
            csvFile1 = file1.getAbsolutePath();
            fileNameLabel.setText("First List Selected");
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
        file2 = fc.showOpenDialog(window);
        if (file2 != null){
            csvFile2 = file2.getAbsolutePath();
            lblFileNameTwo.setText("Revised List Selected");
        }    
    }
    
    /**
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
        this.reader = new CSV_Reader(csvFile1, csvFile2);
        if(reader.equivalency(reader))
                System.err.println("The files contain the same EPC Codes.");
        else{
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("FXMLOfflineInventoryFirstScene.fxml"));
            Parent root = loader1.load();
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLOfflineInventoryFirstSceneController controller1 = loader1.getController();
            controller1.setFirstDate(file1);
            controller1.setSecondDate(file2);
            controller1.setFirstList(reader);
            controller1.setRevisedList(reader);
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
        Parent root = FXMLLoader.load(getClass().getResource("FXMLWelcomePage.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void openHelp(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLHelpOffline.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}