/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cstuser
 */
public class FXMLOfflineResults2Controller implements Initializable {
    
    @FXML
    ListView lvA;
    
    @FXML
    ListView lvB;
    
    @FXML
    Button btnBack;
    
    
    public void ACodes(CSV_Reader reader){
        List<Item> fileA = reader.getInventory();
        for(int i = 0; i < fileA.size(); i++)
            lvA.getItems().add(fileA.get(i));
    }
    
    public void BCodes(CSV_Reader reader){
        List<Item> fileB = reader.getSecondInventory();
        for(int i = 0; i < fileB.size(); i++)
            lvB.getItems().add(fileB.get(i));
    }
    
    @FXML
    private void GoBack(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/FXMLOfflineResultsScene.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLOfflineResultsSceneController controller = loader.getController();
        controller.UniqueACodes(controller.getReader());
        controller.UniqueBCodes(controller.getReader());
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
