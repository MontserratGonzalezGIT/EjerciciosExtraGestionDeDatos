/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import av3.BibliotecaModel;
import av3.Libro;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
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
public class MostrarTitulosController implements Initializable {

    @FXML
    private TextArea outputLibros;
    
    List<Libro> libreria = BibliotecaModel.obtenerLibreria();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        outputLibros.setText(" ");
        for(Libro libro : libreria){
            outputLibros.setText(outputLibros.getText() + "ID: " + Integer.toString(libro.getID()) + "\n\r");
            outputLibros.setText(outputLibros.getText() + "Título: " + libro.getTitulo() + "\n\r");
            outputLibros.setText(outputLibros.getText() + "\n\r"); 
        }   
        
    }    
    
}
