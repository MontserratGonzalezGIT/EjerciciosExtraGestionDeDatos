/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import av3.BibliotecaModel;
import av3.Libro;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class BorrarLibroController implements Initializable {

    @FXML
    private Button botonBorrar;
    @FXML
    private TextField inputID;
    @FXML
    private Label labelEstado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionBotonBorrar(ActionEvent event) throws IOException {
        
        List<Libro> libreria = BibliotecaModel.obtenerLibreria();
        
        for(Libro l : libreria){
            if(Integer.parseInt(inputID.getText()) == l.getID()){
                libreria.remove(l);
                BibliotecaModel.actualizarLibreria(libreria);
                labelEstado.setText("Estado: Libro Eliminado");
            }
        }
        
    }
    
}
