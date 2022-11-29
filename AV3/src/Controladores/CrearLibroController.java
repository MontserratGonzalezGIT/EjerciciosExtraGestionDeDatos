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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class CrearLibroController implements Initializable {

    @FXML
    private TextField inputTitulo;
    @FXML
    private TextField inputAutor;
    @FXML
    private TextField inputAnyo;
    @FXML
    private TextField inputEditorial;
    @FXML
    private TextField inputNumPaginas;
    @FXML
    private Button botonCrear;
    @FXML
    private Label outputID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionBotonCrear(ActionEvent event) throws IOException {
        
         //objeto a parsear a XML
        List<Libro> libreria = BibliotecaModel.obtenerLibreria();
        
        Libro libro = new Libro();
        
        libro.setID(libreria.get(libreria.size() - 1).getID() + 1);
        libro.setTitulo(inputTitulo.getText());
        libro.setAutor(inputAutor.getText());
        libro.setAnyo(inputAnyo.getText());
        libro.setEditorial(inputEditorial.getText());
        libro.setNumPagines(inputNumPaginas.getText());
        BibliotecaModel.anyadirLibro(libro);
        
        outputID.setText(String.valueOf(libro.getID()));

        
    }
    
}
