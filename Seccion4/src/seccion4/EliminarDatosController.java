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
public class EliminarDatosController implements Initializable {

    @FXML
    private Button botonEliminar;
    @FXML
    private TextField entradaID;
    
    modelLibreria model = new modelLibreria();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionEliminar(ActionEvent event) {
        
        Alert libroQuemar = new Alert(Alert.AlertType.CONFIRMATION);
        libroQuemar.setHeaderText("¿Estás seguro que quieres quemar este libro?");
        Optional<ButtonType> action = libroQuemar.showAndWait();
        try {
            if (action.get() == ButtonType.OK) {
                 if(model.quemarLibro(Integer.parseInt(entradaID.getText()))){
                    Alert buttonOk = new Alert(Alert.AlertType.CONFIRMATION);
                    buttonOk.setHeaderText("Rociando gasolina...");
                    buttonOk.setContentText("Adios libro :) ");
                    buttonOk.showAndWait();
                } else {
                    Alert buttonCancel = new Alert(Alert.AlertType.ERROR);
                    buttonCancel.setHeaderText("Vaya, no tenemos gasolina :( ");
                    buttonCancel.setContentText("Otra vez sera...");
                    buttonCancel.showAndWait();
                }

            } else {
                Alert buttonCancel = new Alert(Alert.AlertType.ERROR);
                buttonCancel.setHeaderText("OK");
                buttonCancel.setContentText("Yo que ya habia sacado la gasolina...");
                buttonCancel.showAndWait();
            }
        } catch (Exception e) {
        }
        
        
    }
    
}
