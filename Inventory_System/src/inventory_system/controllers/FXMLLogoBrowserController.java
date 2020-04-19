package inventory_system.controllers;

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
 * @since 19/02/2020
 */
public class FXMLLogoBrowserController implements Initializable {

    private File file1;
    private File file2;
    private File file3;
    private File file4;
    private File file5;
    
    private String imageOnePath;
    private String imageTwoPath;
    private String imageThreePath;
    private String imageFourPath;
    private String imageFivePath;
    
    @FXML
    private Label lbOne;
    @FXML
    private Label lbTwo;
    @FXML
    private Label lbThree;
    @FXML
    private Label lbFour;
    @FXML
    private Label lbFive;
    
    @FXML
    private void setImageOne(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Image");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPEG image", "*.jpg")
        );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        file1 = fc.showOpenDialog(window);
        if (file1 != null){
            imageOnePath = file1.getAbsolutePath();
            lbOne.setText("First Image Selected");
        }    
    }
    
    @FXML
    private void setImageTwo(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Image");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPEG image", "*.jpg")
        );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        file2 = fc.showOpenDialog(window);
        if (file2 != null){
            imageTwoPath = file2.getAbsolutePath();
            lbTwo.setText("Second Image Selected");
        }    
    }
    
    @FXML
    private void setImageThree(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Image");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPEG image", "*.jpg")
        );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        file3 = fc.showOpenDialog(window);
        if (file3 != null){
            imageThreePath = file3.getAbsolutePath();
            lbThree.setText("Third Image Selected");
        }    
    }
    
    @FXML
    private void setImageFour(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Image");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPEG image", "*.jpg")
        );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        file4 = fc.showOpenDialog(window);
        if (file4 != null){
            imageFourPath = file4.getAbsolutePath();
            lbFour.setText("Fourth Image Selected");
        }    
    }
    
    @FXML
    private void setImageFive(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an Image");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPEG image", "*.jpg")
        );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        file5 = fc.showOpenDialog(window);
        if (file5 != null){
            imageFivePath = file5.getAbsolutePath();
            lbFive.setText("Fifth Image Selected");
        }    
    }
    
    @FXML
    private void backToScene(ActionEvent event) throws IOException{
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../ui/FXMLOnlineInventory.fxml"));
        Parent root = loader1.load();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLOnlineInventoryController controller1 = loader1.getController();
        
        if(file1 != null){
            controller1.setImageOne(imageOnePath);
        }
        if(file2 != null){
            controller1.setImageTwo(imageTwoPath);
        }
        if(file3 != null){
            controller1.setImageThree(imageThreePath);
        }
        if(file4 != null){
            controller1.setImageFour(imageFourPath);
        }
        if(file5 != null){
            controller1.setImageFive(imageFivePath);
        }
        
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}