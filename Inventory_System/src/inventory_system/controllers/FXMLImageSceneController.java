package inventory_system.controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @@author Gianni Coladonato
 * @version 1.0
 * @since 19/04/2020
 */
public class FXMLImageSceneController implements Initializable {

    @FXML 
    private Label lbAddress;
    @FXML
    private Label ibDate; 
    @FXML
    private ImageView imageWindow;

    public void setData(String ipAddress, String date){
        this.ibDate.setText(date);
        this.lbAddress.setText(ipAddress);
    }
    
    public void setImage(String path){
        Image image = new Image(path);
        this.imageWindow.setImage(image);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }     
}