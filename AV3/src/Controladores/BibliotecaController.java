/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controladores;

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
public class BibliotecaController implements Initializable {
    
    @FXML
    private Button botonMostrarTitulos;
    @FXML
    private Button botonMostrarInfo;
    @FXML
    private Button botonCrearLibro;
    @FXML
    private Button botonActualizarLibro;
    @FXML
    private Button botonBorrarLibro;
    @FXML
    private Button botonExit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionBotonMostrarTitulos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/MostrarTitulos.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accionBotonMostrarInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/MostrarInfo.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accionBotonCrearLibro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/CrearLibro.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accionBotonActualizarLibro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/ActualizarLibro.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accionBotonBorrarLibro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/BorrarLibro.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accionBotonExit(ActionEvent event) {
        System.exit(0);
    }
    
}
