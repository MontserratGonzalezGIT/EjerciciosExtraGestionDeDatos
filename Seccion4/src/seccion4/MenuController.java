/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package seccion4;

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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author alfas
 */
public class MenuController implements Initializable {
    
    @FXML
    private Label resultadoConexion;
    @FXML
    private Button buttonLeerTabla;
    
    modelLibreria model = new modelLibreria();
    @FXML
    private TextArea salidaDatosTabla;
    @FXML
    private Button botonInsertar;
    @FXML
    private Button botonEditar;
    @FXML
    private Button botonBorrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(model.connectToDB() != null){
            resultadoConexion.setText(resultadoConexion.getText() + "Satisfactoria.");
        }else{
            resultadoConexion.setText(resultadoConexion.getText() + "Erronea.");
        }
        
        // TODO
    }    

    @FXML
    private void actionLeerTabla(ActionEvent event) {
        
        salidaDatosTabla.setText(model.leerTabla());
    }

    @FXML
    private void actionInsertarFila(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InsertarDatos.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionEditarFila(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActualizarDatos.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void actionEliminarFila(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EliminarDatos.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
