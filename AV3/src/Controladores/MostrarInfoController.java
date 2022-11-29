/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import av3.Libro;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class MostrarInfoController implements Initializable {

    @FXML
    private TextArea outputDetallesLibro;
    @FXML
    private TextField inputID;
    @FXML
    private Button botonDetalles;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionBotonDetalles(ActionEvent event) {
        
        List<Libro> libreria = av3.BibliotecaModel.obtenerLibreria();
        
        for(Libro libro : libreria){
            
            if(Integer.parseInt(inputID.getText()) == libro.getID()){
                outputDetallesLibro.setText("");
                outputDetallesLibro.setText(outputDetallesLibro.getText() + "ID: " + Integer.toString(libro.getID()) + "\n\r");
                outputDetallesLibro.setText(outputDetallesLibro.getText() + "Título: " + libro.getTitulo() + "\n\r");
                outputDetallesLibro.setText(outputDetallesLibro.getText() + "Autor: " + libro.getAutor() + "\n\r");
                outputDetallesLibro.setText(outputDetallesLibro.getText() + "Años: " + libro.getAnyo() + "\n\r");
                outputDetallesLibro.setText(outputDetallesLibro.getText() + "Editorial: " + libro.getEditorial() + "\n\r");
                outputDetallesLibro.setText(outputDetallesLibro.getText() + "Numero de paginas: " + libro.getNumPagines() + "\n\r"); 
            }
            
        }                
    }
    
}
