/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_system.controllers;

import inventory_system.models.Item;
import inventory_system.readers.CSV_Reader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ricky Jr
 */
public class FXMLOfflineInventoryFirstSceneController implements Initializable {
    
    private CSV_Reader reader;
    
    @FXML
    Label lblFirstDate;
    
    @FXML
    Button btnAnalysis;
    
    @FXML
    Label lblFirst;
    
    @FXML
    Label lblSecond;
    
    @FXML
    ListView lvFirst;
    
    @FXML
    ListView lvRevised;
    
    @FXML
    Label lblSecondDate;
    
    public void setFirstDate(File file){
        long fileTime = file.lastModified();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
        lblFirstDate.setText(dateFormat.format(fileTime));
    }
    public void setSecondDate(File file){
        long fileTime = file.lastModified();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
        lblSecondDate.setText(dateFormat.format(fileTime));
    }
    
    public void setFirstList (CSV_Reader reader){
        this.reader = reader;
        List<Item> list = reader.getInventory();
        for(int i = 0; i < list.size(); i++){
            lvFirst.getItems().add(list.get(i).getEPCCode());
        }
        lblFirst.setText("Unique Tags: " + reader.uniqueACodes(reader).size());
    }
    
    public void setRevisedList (CSV_Reader reader){
        this.reader = reader;
        List<Item> list = reader.getSecondInventory();
        for(int i = 0; i < list.size(); i++){
            lvRevised.getItems().add(list.get(i).getEPCCode());
        }
        lblSecond.setText("Unique Tags: " + reader.uniqueBCodes(reader).size());
    }
    @FXML
    private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLOfflineInventory.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void goToAnalysis(ActionEvent event) throws IOException{
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../ui/FXMLOfflineResultsScene.fxml"));
            Parent root = loader1.load();
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLOfflineResultsSceneController controller = loader1.getController();
            controller.UniqueACodes(reader);
            controller.UniqueBCodes(reader);
            controller.similarCodes(reader);
            controller.setReader(reader);
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/CSS/OfflineResultsScene.css");
            window.setScene(scene);
            window.show();
    }
    
    @FXML
    private void openHelp(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLOfflineAnalysisHelp.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
}