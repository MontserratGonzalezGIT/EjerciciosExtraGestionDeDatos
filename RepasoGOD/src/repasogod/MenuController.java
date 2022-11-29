/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package repasogod;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author alfas
 */
public class MenuController implements Initializable {
    
    @FXML
    private Button buttonFile1;
    @FXML
    private Button buttonFile2;
    @FXML
    private Button buttonXML;
    @FXML
    private Button buttonMYSQL;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void actionButtonFile1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/examen1/Examen1.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionButtonFile2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/examen2/Examen2.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionButtonXML(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/examen3/Examen3.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionButtonMYSQL(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/examen4/Examen4.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();   
    }
    
}
