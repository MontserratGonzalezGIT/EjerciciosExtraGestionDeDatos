/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package seccion4;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class ActualizarDatosController implements Initializable {

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
    @FXML
    private TextField buscarID;
    @FXML
    private Button botonMostrar;
    
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
        Alert libroActualizar = new Alert(Alert.AlertType.CONFIRMATION);
        libroActualizar.setHeaderText("¿Estás seguro que quieres actualizar este libro?");
        Optional<ButtonType> action = libroActualizar.showAndWait();
        if (action.get() == ButtonType.OK) {
            l.setID(Integer.parseInt(buscarID.getText()));
            l.setTitulo(cambioTitulo.getText());
            l.setAutor(cambioAutor.getText());
            l.setAnyo(Integer.parseInt(cambioAnyo.getText()));
            l.setEditorial(cambioEditorial.getText());
            l.setNumPagines(Integer.parseInt(cambioNumPag.getText()));
        
            model.actualizarLibro(l);
            
            Alert buttonOk = new Alert(Alert.AlertType.CONFIRMATION);
            buttonOk.setHeaderText("¡PERFECTO!");
            buttonOk.setContentText("Libro Actualizado Correctamente.");
            buttonOk.showAndWait();
            
            
        } else {
            Alert buttonCancel = new Alert(Alert.AlertType.ERROR);
            buttonCancel.setHeaderText("Ha ocurrido algo...");
            buttonCancel.setContentText("No Se Ha Podido Actualizar el Libro Correctamente.");
            buttonCancel.showAndWait();
        }
        
    }

    @FXML
    private void accionMostrar(ActionEvent event) {
        
        Libro l = model.leerFila(Integer.parseInt(buscarID.getText()));
        cambioTitulo.setText(l.getTitulo());
        cambioAutor.setText(l.getAutor());
        cambioAnyo.setText(String.valueOf(l.getAnyo()));
        cambioEditorial.setText(l.getEditorial());
        cambioNumPag.setText(String.valueOf(l.getNumPagines()));
        
    }
    
}
