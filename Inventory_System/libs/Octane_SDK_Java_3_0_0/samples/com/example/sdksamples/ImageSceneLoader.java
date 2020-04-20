package com.example.sdksamples;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Gianni Coladonato
 * @version 1.0
 * @since 19/04/2020
 */
public class ImageSceneLoader extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/FXMLImageScene.fxml"));
        Scene scene = new Scene(root); 
        primaryStage.setScene(scene);
        primaryStage.setTitle("Results Screen");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}