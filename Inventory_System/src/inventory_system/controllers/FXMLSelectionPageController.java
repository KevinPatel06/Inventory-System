package inventory_system.controllers;
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
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ricky Mungcal
 * @version 1.0
 * @since 20/02/2020
 */
public class FXMLSelectionPageController implements Initializable {
    
    @FXML
    MenuBar menuBar;

    //if 0 = dark, if 1 = default
    int theme = 0;
    @FXML
    private void offlineInventoryScene(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLOfflineInventory.fxml"));
        Scene scene = new Scene(root);
        if(theme == 0)
            scene.getStylesheets().add("/CSS/dark-theme.css");
        if(theme == 1)
            scene.getStylesheets().add("CSS/default-theme.css");
        window.setScene(scene);
        window.show();
    }
    
    @FXML 
    private void onlineInventoryScene(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLOnlineInventory.fxml"));
        Scene scene = new Scene(root);
        if(theme == 0)
            scene.getStylesheets().add("/CSS/dark-theme.css");
        if(theme == 1)
            scene.getStylesheets().add("CSS/default-theme.css");
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void backToMenu(ActionEvent event) throws IOException{
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLWelcomePage.fxml"));
        Scene scene = new Scene(root);
        if(theme == 0)
            scene.getStylesheets().add("/CSS/dark-theme.css");
        if(theme == 1)
            scene.getStylesheets().add("CSS/default-theme.css");
        window.setScene(scene);
        window.show();
    }
    @FXML
    private void changeDarkTheme(ActionEvent event) throws IOException{
        theme = 0;
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLSelectionPage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().remove("/CSS/default-theme.css");
        scene.getStylesheets().add("/CSS/dark-theme.css");
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void changeDefaultTheme(ActionEvent event) throws IOException{
        theme = 1;
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../ui/FXMLSelectionPage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().remove("/CSS/dark-theme.css");
        scene.getStylesheets().add("/CSS/default-theme.css");
        window.setScene(scene);
        window.show();
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}