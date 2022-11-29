/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package examen3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class Examen3Controller implements Initializable {

    @FXML
    private TextField inputId;
    @FXML
    private TextField inputNombre;
    @FXML
    private TextField inputApellidos;
    @FXML
    private TextField inputIncidencia;

    /**
     * Initializes the controller class.
     */
    
    int contador = 0;
    
    String inputIdTemporal;
    String inputNombreTemporal;
    String inputApellidosTemporal;
    String inputIncidenciaTemporal;
    
    
    modelIncidencias modelIncidencias = new modelIncidencias();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Incidencia> incidencias = modelIncidencias.obtenerIncidencias();
        
        Incidencia incidencia = incidencias.get(0);
        
        
        inputId.setText(String.valueOf(incidencia.getId()));
        inputNombre.setText(incidencia.getNombre());
        inputApellidos.setText(incidencia.getApellidos());
        inputIncidencia.setText(incidencia.getInci());
        
    }    

    @FXML
    private void accionButtonConf(ActionEvent event) {
        
        
    }

    @FXML
    private void accionButtonAtras(ActionEvent event) {
       List<Incidencia> incidencias = modelIncidencias.obtenerIncidencias();
        
        if(contador - 1 >= 0)
        contador --;
        
        
        Incidencia incidencia = incidencias.get(contador);
        
        inputId.setText(String.valueOf(incidencia.getId()));
        inputNombre.setText(incidencia.getNombre());
        inputApellidos.setText(incidencia.getApellidos());
        inputIncidencia.setText(incidencia.getInci());
        
    }

    @FXML
    private void accionButtonAdelante(ActionEvent event) {
        
        List<Incidencia> incidencias = modelIncidencias.obtenerIncidencias();
        boolean existe = false;
        contador ++;
        if(contador < incidencias.size() + 1){
        
            if(inputId.getText().equals("")){
                incidencias.remove(contador);
                try {
                    modelIncidencias.actualizarIncidencias(incidencias);
                } catch (IOException ex) {
                    Logger.getLogger(Examen3Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                for(Incidencia i : incidencias){
                    
                    if(inputId.getText().equals(i.getId())){
                        existe = true;
                        if(!inputNombre.getText().equals(inputNombreTemporal) || !inputApellidos.getText().equals(inputApellidosTemporal) || !inputIncidencia.getText().equals(inputIncidenciaTemporal)){

                        i.setNombre(inputNombre.getText());
                        i.setApellidos(inputApellidos.getText());
                        i.setInci(inputIncidencia.getText());

                        try {
                            modelIncidencias.actualizarIncidencias(incidencias);
                        } catch (IOException ex) {
                            Logger.getLogger(Examen3Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        }
                    }
                    
                }
                
                if(!existe){
                    Incidencia iA = new Incidencia();
                    
                    iA.setId(Integer.parseInt(inputId.getText()));
                    iA.setNombre(inputNombre.getText());
                    iA.setApellidos(inputApellidos.getText());
                    iA.setInci(inputIncidencia.getText());
                    
                    try {
                        modelIncidencias.anyadirIncidencia(iA);
                    } catch (IOException ex) {
                        Logger.getLogger(Examen3Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            Incidencia incidencia = incidencias.get(contador);

            inputId.setText(String.valueOf(incidencia.getId()));
            inputNombre.setText(incidencia.getNombre());
            inputApellidos.setText(incidencia.getApellidos());
            inputIncidencia.setText(incidencia.getInci());
        }
    }
    
}
