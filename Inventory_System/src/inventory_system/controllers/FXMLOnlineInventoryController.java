package inventory_system.controllers;
import com.example.sdksamples.*;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gianni Coladonato
 * @version 1.0
 * @since 03/03/2020
 */
public class FXMLOnlineInventoryController implements Initializable {
    
    @FXML
    private TextField textOne;
    @FXML
    private TextField textTwo;
    @FXML
    private TextField textThree;
    @FXML
    private TextField textFour;
    @FXML
    private TextField textFive;
    @FXML
    private Text ipBox;
    
    public static String EPCcode;
    
    private final CheckItems ci = new CheckItems();

    @FXML private void readTagsOne(){
        if(textOne.getText() != null && !textOne.getText().isEmpty()){
            String epcCode = textOne.getText();
            setEPC(epcCode);
            ci.startReading();
        }
    }
    @FXML private void readTagsTwo(){
        if(textTwo.getText() != null && !textTwo.getText().isEmpty()){
            String epcCode = textTwo.getText();
            setEPC(epcCode);
            ci.startReading();
        }
    }
    @FXML private void readTagsThree(){
        if(textThree.getText() != null && !textThree.getText().isEmpty()){
            String epcCode = textThree.getText();
            setEPC(epcCode);
            ci.startReading();
        }
    }
    @FXML private void readTagsFour(){
        if(textFour.getText() != null && !textFour.getText().isEmpty()){
            String epcCode = textFour.getText();
            setEPC(epcCode);
            ci.startReading();
        }
    }
    @FXML private void readTagsFive(){
        if(textFive.getText() != null && !textFive.getText().isEmpty()){
            String epcCode = textFive.getText();
            setEPC(epcCode);
            ci.startReading();
        }
    }
    
    public void displayIP(String ipAddress){
        this.ipBox.setText(ipAddress);
    }
    
    public String getEPC(){
        return EPCcode;
    }
    
    public void setEPC(String EPC){
        this.EPCcode = EPC;
    }
    
    @FXML private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLSelectionPage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/dark-theme.css");
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void openHelp(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLHelpOnline.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("../ui/dark-theme.css");
        window.setScene(scene);
        window.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("file:data/first_image.jpg");
        Image image2 = new Image("file:data/second_image.png");
        Image image3 = new Image("file:data/third_image.jpg");
    }   
}
