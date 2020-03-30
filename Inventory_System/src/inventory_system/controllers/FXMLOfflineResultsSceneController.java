package inventory_system.controllers;

import inventory_system.models.Item;
import inventory_system.readers.CSV_Reader;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cstuser
 */
public class FXMLOfflineResultsSceneController implements Initializable {
    
    @FXML
    ListView lvAdded;
    
    @FXML
    ListView lvRemoved;
    
    @FXML
    ListView lvRemain;
    
    @FXML
    Label lblSearch;
    
    @FXML
    TextField txtSearch;
    
    @FXML
    Button btnMenu;
    
    @FXML
    Button btnLists;
    
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
    
    public void setReader(CSV_Reader reader){
        this.reader = reader;
    }
    public CSV_Reader getReader(){
        return reader;
    }
    
    public void UniqueACodes(CSV_Reader reader){
        List<Item> added = reader.uniqueACodes(reader);
        for(int i = 0; i < added.size(); i++)
            lvAdded.getItems().add(added.get(i).getEPCCode());
        System.out.println("Added: " + added.size());
    }
    
    public void UniqueBCodes(CSV_Reader reader){
        List<Item> removed = reader.uniqueBCodes(reader);
        for(int i = 0; i < removed.size();i++)
            lvRemoved.getItems().add(removed.get(i).getEPCCode());
        System.out.println("Removed: " + removed.size());
    }
    
    public void similarCodes(CSV_Reader reader){
        List<Item> similar = reader.similarCodes(reader);
        for(int i = 0; i < similar.size(); i++)
            lvRemain.getItems().add(similar.get(i).getEPCCode());
        System.out.println("Remain: " + similar.size());
    }
    
    @FXML
    private void search(ActionEvent event){
        if(lvAdded.getItems().contains(txtSearch.getText()))
            lblSearch.setText("In Removed List");
        else if(lvRemoved.getItems().contains(txtSearch.getText()))
            lblSearch.setText("In Added List");
        else if(lvRemain.getItems().contains(txtSearch.getText()))
            lblSearch.setText("In Remain List");
        else
            lblSearch.setText("Code Not Found");
    }
    
    @FXML
    private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLOfflineInventory.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/dark-theme.css");
        window.setScene(scene);
        window.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
