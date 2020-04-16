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
import javafx.scene.image.ImageView;
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
    private ImageView imageWindow;
    
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
    
    private final CheckItems ci = new CheckItems();
    
    public void setImage(Image image){
        imageWindow.setImage(image);
    }

    @FXML private void readTagsOne(){
        if(textOne.getText() != null && !textOne.getText().isEmpty()){
            //ci.startReading();
            String EPCcode = textOne.getText();
            System.out.println("One Working!" + EPCcode);
        }
    }
    @FXML private void readTagsTwo(){
        if(textTwo.getText() != null && !textTwo.getText().isEmpty()){
            //ci.startReading();
            String EPCcode = textTwo.getText();
            System.out.println("Two Working!" + EPCcode);
        }
    }
    @FXML private void readTagsThree(){
        if(textThree.getText() != null && !textThree.getText().isEmpty()){
            //ci.startReading();
            String EPCcode = textThree.getText();
            System.out.println("Three Working!" + EPCcode);
        }
    }
    @FXML private void readTagsFour(){
        if(textFour.getText() != null && !textFour.getText().isEmpty()){
            //ci.startReading();
            String EPCcode = textFour.getText();
            System.out.println("Four Working!" + EPCcode);
        }
    }
    @FXML private void readTagsFive(){
        if(textFive.getText() != null && !textFive.getText().isEmpty()){
            //ci.startReading();
            String EPCcode = textFive.getText();
            System.out.println("Five Working!" + EPCcode);
        }
    }
    
    
    @FXML private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLSelectionPage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/dark-theme.css");
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
