/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_system.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    public void setData(String ipAddress, String date){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
