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
    
    public static String EPCcode;
    
    public static String fileOne;
    public static String fileTwo;
    public static String fileThree;
    public static String fileFour;
    public static String fileFive;
    
    public static String primePath;
    
    private final CheckItems ci = new CheckItems();

    @FXML private void readTagsOne(){
        if(textOne.getText() != null && !textOne.getText().isEmpty() && fileOne != null){
            String epcCode = textOne.getText();
            setEPC(epcCode);
            setPrimePath(fileOne);
            System.out.println(primePath);
            ci.startReading();
        }
    }
    
    @FXML private void readTagsTwo(){
        if(textTwo.getText() != null && !textTwo.getText().isEmpty() && fileTwo != null){
            String epcCode = textTwo.getText();
            setEPC(epcCode);
            setPrimePath(fileTwo);
            System.out.println(fileTwo);
            ci.startReading();
        }
    }
    @FXML private void readTagsThree(){
        if(textThree.getText() != null && !textThree.getText().isEmpty() && fileThree != null){
            String epcCode = textThree.getText();
            setEPC(epcCode);
            setPrimePath(fileThree);
            System.out.println(primePath);
            ci.startReading();
        }
    }
    @FXML private void readTagsFour(){
        if(textFour.getText() != null && !textFour.getText().isEmpty() && fileFour != null){
            String epcCode = textFour.getText();
            setEPC(epcCode);
            setPrimePath(fileFour);
            System.out.println(primePath);
            ci.startReading();
        }
    }
    @FXML private void readTagsFive(){
        if(textFive.getText() != null && !textFive.getText().isEmpty() && fileFive != null){
            String epcCode = textFive.getText();
            setEPC(epcCode);
            setPrimePath(fileFive);
            System.out.println(primePath);
            ci.startReading();
        }
    }
    
    public String getEPC(){
        return EPCcode;
    }
    
    public void setEPC(String EPC){
        this.EPCcode = EPC;
    }
    
    public void setPrimePath(String path){
        this.primePath = path;
    }
    
    @FXML private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLSelectionPage.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void openHelp(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLHelpOnline.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void logoBrowser(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLLogoBrowser.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    public void setImageOne(String imageOne){
        this.fileOne = imageOne;
    }
    
    public void setImageTwo(String imageTwo){
        this.fileTwo = imageTwo;
    }
    
    public void setImageThree(String imageThree){
        this.fileThree = imageThree;
    }
    
    public void setImageFour(String imageFour){
        this.fileFour = imageFour;
    }
    
    public void setImageFive(String imageFive){
        this.fileFive = imageFive;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
}