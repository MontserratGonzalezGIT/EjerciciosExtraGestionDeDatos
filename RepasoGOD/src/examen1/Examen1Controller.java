/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package examen1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfas
 */
public class Examen1Controller implements Initializable {

    @FXML
    private TextField inputRutaCrear;
    @FXML
    private TextField inputDirectorios;
    @FXML
    private TextField inputArchivos;
    @FXML
    private TextField inputRutaListar;
    @FXML
    private TextArea textAreaListado;
    @FXML
    private TextField inputRutaBorrar;
    @FXML
    private Button buttonListar;
    @FXML
    private Button buttonBorrar;
    @FXML
    private Button buttonCrear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionButtonListar(ActionEvent event) {
        
        File path = new File(inputRutaListar.getText());
        
        if(path.exists()){
            
            File[] files = path.listFiles();
            textAreaListado.setText("");
            
            for(File f : files){
                
                textAreaListado.setText(textAreaListado.getText() + f.getName() + "\n");
                textAreaListado.setText(textAreaListado.getText() + f.getAbsolutePath() + "\n");
                
                if(f.isDirectory()){
                    
                    textAreaListado.setText(textAreaListado.getText() + "Es un directorio" + "\n");
                    
                }else{
                    
                    textAreaListado.setText(textAreaListado.getText() + "Es un archivo" + "\n");
                    
                }
                
                if(f.isHidden()){
                    
                    textAreaListado.setText(textAreaListado.getText() + "Esta oculto" + "\n");
                    
                }else{
                    
                    textAreaListado.setText(textAreaListado.getText() + "No esta oculto" + "\n");
                    
                }
                
                textAreaListado.setText(textAreaListado.getText() + "\n");
            }
            
        }else{
            
            textAreaListado.setText("La ruta no existe");
            
        }
        
    }

    @FXML
    private void accionButtonBorrar(ActionEvent event) {
        
        File path = new File(inputRutaBorrar.getText());
        
        if(path.exists()){
            
            borrarMucho(path);
            path.delete();
            
        }else{
            
            System.out.println("No se puede borrar, no se encuentra la ruta. ERROR********");
                    
        }
        
    }

    @FXML
    private void accionButtonCrear(ActionEvent event) {
        
        File path = new File(inputRutaCrear.getText());
        Boolean limpio = false;
        
        int numDirectorios = Integer.parseInt(inputDirectorios.getText());
        int numArchivos = Integer.parseInt(inputArchivos.getText());
        
           do{
            if(path.delete()){
                
                System.out.println("El directorio ha sido borrado. ");
                
            }else{
                
                System.out.println("Borrando directorio....");
                borrarMucho(path); 
                
            }
            }while(path.exists());

            if(path.mkdirs()){
                
                for(int i = 0; i < numDirectorios;i++){
                    
                    File directorio =  new File(path.getAbsolutePath(),"Alex" + i);
                    directorio.mkdir();
                    
                }
                
                for(int i = 0; i < numArchivos;i++){
                    
                    File directorio =  new File(path.getAbsolutePath(),"Pastor" + i);
                    directorio.mkdir();
                    
                }
                
            }else{
                
                System.out.println("El directorio no ha podido ser creado. ERROR******");
                
            }
            
        
        
        
        
    }
    
    public void borrarMucho(File path){
        
        File[] files = path.listFiles();
        
        for(File f : files){
            
            if(!f.delete()){
                 borrarMucho(f);
            }
            f.delete();
        }
        
        
    }
    
}
