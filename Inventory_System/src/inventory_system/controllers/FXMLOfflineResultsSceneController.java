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
public class FXMLOfflineResultsSceneController implements Initializable {
    
    @FXML
    ListView lvAdded;
    
    @FXML
    ListView lvRemoved;
    
    @FXML
    Button btnMenu;
    
    public void UniqueACodes(CSV_Reader reader){
        List<Item> added = reader.uniqueACodes(reader);
        for(int i = 0; i < added.size(); i++)
            lvAdded.getItems().add(added.get(i));
        System.out.println(added.size());
    }
    
    public void UniqueBCodes(CSV_Reader reader){
        List<Item> removed = reader.uniqueBCodes(reader);
        for(int i = 0; i < removed.size();i++)
            lvRemoved.getItems().add(removed.get(i));
        System.out.println(removed.size());
    }
    @FXML
    private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLOfflineInventory.fxml"));
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
