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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class ActualizarLibroController implements Initializable {

    @FXML
    private TextField inputID;
    @FXML
    private TextField inputTitulo;
    @FXML
    private Button botonBuscarID;
    @FXML
    private Button botonActualizar;
    @FXML
    private TextField inputAutor;
    @FXML
    private TextField inputAnyo;
    @FXML
    private TextField inputEditorial;
    @FXML
    private TextField inputNumPagines;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionBotonBuscarID(ActionEvent event) {
        
        List<Libro> libreria = BibliotecaModel.obtenerLibreria();
        
        for(Libro l : libreria){
            if(Integer.parseInt(inputID.getText()) == l.getID()){
                
                inputTitulo.setText(l.getTitulo());
                inputAutor.setText(l.getAutor());
                inputAnyo.setText(l.getAnyo());
                inputEditorial.setText(l.getEditorial());
                inputNumPagines.setText(l.getNumPagines());
                
            }
        }
        
    }

    @FXML
    private void accionBotonActualizar(ActionEvent event) throws IOException {
        
        List<Libro> libreria = BibliotecaModel.obtenerLibreria();
        
        for(Libro l : libreria){
            if(Integer.parseInt(inputID.getText()) == l.getID()){
                
                l.setID(Integer.parseInt(inputID.getText()));
                l.setTitulo(inputTitulo.getText());
                l.setAutor(inputAutor.getText());
                l.setAnyo(inputAnyo.getText());
                l.setEditorial(inputEditorial.getText());
                l.setNumPagines(inputNumPagines.getText());
                BibliotecaModel.actualizarLibreria(libreria);
            }
        }

       
        
    }
    
}
