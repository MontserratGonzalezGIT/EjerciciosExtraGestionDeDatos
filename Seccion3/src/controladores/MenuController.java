/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import seccion3.BibliotecaModel;
import seccion3.Libro;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class MenuController implements Initializable {

    @FXML
    private TextArea outputXML;
    @FXML
    private Button botonMostrarXML;
    @FXML
    private Label outputNumNodos;
    @FXML
    private TextArea inputAnyo;
    @FXML
    private TextArea inputTitulo;
    @FXML
    private TextArea inputEditorial;
    @FXML
    private TextArea inputAutor;
    @FXML
    private TextArea inputNumPag;
    @FXML
    private Button botonAnyadir;
    @FXML
    private TextArea outputNodos;
    @FXML
    private Button botonListarNodos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionBotonMostrarXML(ActionEvent event) {
        
       File file = new File("libreria.xml");
       try(FileReader archivoReader = new FileReader(file.getAbsolutePath())){
        int caracterLeido = archivoReader.read();
        while(caracterLeido!= -1) {
            
            char caracter = (char) caracterLeido;
            outputXML.setText(outputXML.getText() + caracter);
            caracterLeido = archivoReader.read();
            
        }
        
    }catch(IOException ex){
        System.err.println("El archivo no ha podido ser leido ERROR");
        ex.printStackTrace();
    }
         
    }

    @FXML
    private void accionBotonListarNodos(ActionEvent event) {
        
         List<Libro> libreria = BibliotecaModel.obtenerLibreria();
         outputNodos.setText(" ");
         for(Libro l : libreria){
             outputNodos.setText(outputNodos.getText() + "ID: " +  l.getID() + "\n\r");
             outputNodos.setText(outputNodos.getText() + "Título: " + l.getTitulo() + "\n\r");
             outputNodos.setText(outputNodos.getText() + "Autor: " + l.getAutor() + "\n\r");
             outputNodos.setText(outputNodos.getText() + "Año: " + l.getAnyo() + "\n\r");
             outputNodos.setText(outputNodos.getText() + "Editorial: " + l.getEditorial() + "\n\r");
             outputNodos.setText(outputNodos.getText() + "Numero de Paginas: " + l.getNumPagines() + "\n\r");
             outputNodos.setText(outputNodos.getText() + "\n\r");
         }
         
         outputNumNodos.setText("Numero de Libros en el XML: " + libreria.size());
         
        
    }

    @FXML
    private void accionBotonAnyadir(ActionEvent event) throws IOException {
        
        List<Libro> libreria = BibliotecaModel.obtenerLibreria();
        
        Libro libro = new Libro();
        
        libro.setID(libreria.get(libreria.size() - 1).getID() + 1);
        libro.setTitulo(inputTitulo.getText());
        libro.setAutor(inputAutor.getText());
        libro.setAnyo(inputAnyo.getText());
        libro.setEditorial(inputEditorial.getText());
        libro.setNumPagines(inputNumPag.getText());
        BibliotecaModel.anyadirLibro(libro);
        
    }

    
}
