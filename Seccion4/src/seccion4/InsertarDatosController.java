/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seccion4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class InsertarDatosController implements Initializable {

    @FXML
    private TextField cambioTitulo;
    @FXML
    private TextField cambioAutor;
    @FXML
    private TextField cambioAnyo;
    @FXML
    private TextField cambioEditorial;
    @FXML
    private TextField cambioNumPag;
    @FXML
    private Button botonActualizar;
    
    modelLibreria model = new modelLibreria();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionActualizar(ActionEvent event) {
       Libro l = new Libro();
       l.setTitulo(cambioTitulo.getText());
       l.setAutor(cambioAutor.getText());
       l.setAnyo(Integer.parseInt(cambioAnyo.getText()));
       l.setEditorial(cambioEditorial.getText());
       l.setNumPagines(Integer.parseInt(cambioNumPag.getText()));
       if(model.addLibro(l)){
           Alert buttonOk = new Alert(Alert.AlertType.CONFIRMATION);
            buttonOk.setHeaderText("¡PERFECTO!");
            buttonOk.setContentText("Libro Añadido Correctamente.");
            buttonOk.showAndWait();
       }else{
           Alert buttonOk = new Alert(Alert.AlertType.ERROR);
            buttonOk.setHeaderText("Uy");
            buttonOk.setContentText("Se nos perdio el libro, no se pudo agregar :c ");
            buttonOk.showAndWait();
       }
    }
    
}
